package com.blog.dbblog.service.Impl;

import com.blog.dbblog.bo.ArticleBO;
import com.blog.dbblog.config.mail.MailInfo;
import com.blog.dbblog.config.mail.SendMailConfig;
import com.blog.dbblog.entity.*;
import com.blog.dbblog.mapper.ArticleMapper;
import com.blog.dbblog.service.*;
import com.github.pagehelper.PageHelper;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.PostConstruct;
import javax.annotation.Resource;
import java.text.MessageFormat;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;


/**
 * 博客文章实现类
 *
 * @author wuxi
 * @create 2023-08-18
 */

@Log4j2
@Service
public class ArticleServiceImpl implements ArticleService {

    @Autowired
    ArticleMapper articleMapper;
    @Resource
    ArticleTagService articleTagService;
    @Resource
    ArticleCategoryService articleCategoryService;
    @Resource
    UserService userService;
    @Resource
    TagService tagService;
    @Resource
    CategoryService categoryService;

    /**
     * key:文章id
     * value: 文章
     */
    Map<Integer, Article> articleMap = new LinkedHashMap<>();


    @Override
    @PostConstruct
    public void init() {
        List<Article> articleList = articleMapper.findAll();
        try {
            for(Article article : articleList) {
                // 获取关联的 ID 列的值
                List<Integer> tagIdList = article.getTagList().stream().map(Tag::getId).collect(Collectors.toList());
                List<Integer> categoryIdList = article.getCategoryList().stream().map(Category::getCategoryId).collect(Collectors.toList());

                // 设置关联的 ID 列的值到文章对象
                article.setTagIdList(tagIdList);
                article.setCategoryIdList(categoryIdList);
                System.out.println("\narticle的值：" + article.toString() + "\n");
                articleMap.put(article.getId(), article);
            }
            log.info("文章缓存数据加载完成");
        } catch (Exception e) {
            log.error("文章缓存数据加载失败！", e.getMessage());
        }
    }

    @Override
    public List<Article> getArticlePage(ArticleBO articleBO) {
        int pageNum = articleBO.getPageNum();
        int pageSize = articleBO.getPageSize();
        PageHelper.startPage(pageNum,pageSize);
        List<Article> articleList = articleMapper.getArticlePage(articleBO);
        if (articleList != null) {
            for (Article article : articleList) {
//                article.setTagList(articleMap.get(article.getId()).getTagList());
                article.setTagIdList(articleMap.get(article.getId()).getTagIdList());
//                article.setCategoryList(articleMap.get(article.getId()).getCategoryList());
                article.setCategoryIdList(articleMap.get(article.getId()).getCategoryIdList());
            }
        }
        return articleList;
    }

    @Override
    public void saveArticle(Article article) {
        System.out.println("\nTagIdList的值："+ article.getTagIdList().toString());
        System.out.println("CategoryIdList的值:"+article.getCategoryIdList().toString()+"\n");
        // 创建文章记录
        articleMapper.createArticle(article);

        articleMap.put(article.getId(), article);

        // 创建文章标签关联
        if (article.getTagIdList() != null && !article.getTagIdList().isEmpty()) {
            article.setId(article.getId()); // 设置文章ID，用于关联插入
            articleMapper.createArticleTagRelations(article);
        }

        // 创建文章分类关联
        if (article.getCategoryIdList() != null && !article.getCategoryIdList().isEmpty()) {
            article.setId(article.getId()); // 设置文章ID，用于关联插入
            articleMapper.createArticleCategoryRelations(article);
        }

        User user = userService.findByUserId(article.getUserId());
        //添加文章发送邮箱提醒
        String content = "【{0}】您好：\n" +
                "您已成功发布了标题为: {1} 的文章 \n" +
                "请注意查收！\n";
        MailInfo build = MailInfo.builder()
                .receiveMail(user.getEmail())
                .content(MessageFormat.format(content, user.getUserName(), article.getTitle()))
                .title("文章发布")
                .build();
        SendMailConfig.sendMail(build);
    }

    @Override
    @Transactional
    public void createArticleTagRelations(Article article) {
        article.setId(article.getId()); // 设置文章ID，用于关联插入
        articleMapper.createArticleTagRelations(article);
    }

    @Override
    @Transactional
    public void createArticleCategoryRelations(Article article) {
        article.setId(article.getId()); // 设置文章ID，用于关联插入
        articleMapper.createArticleCategoryRelations(article);
    }

    @Override
    public void updateArticle(Article article) {
        articleMapper.updateArticle(article);
        articleMap.put(article.getId(), article);
        //更新文章先把原来的标签和类别删除掉
        articleTagService.deleteTag(article.getId());
        articleCategoryService.deleteCategory(article.getId());
        //添加文章标签->文章标签关联表
        if (article.getTagIdList() != null) {
            List<ArticleTag> articleTagList = article.getTagIdList().stream().map(tagId -> ArticleTag.builder()
                    .tagId(tagId)
                    .articleId(article.getId())
                    .build()).collect(Collectors.toList());
            articleTagService.insertBatch(articleTagList);
        }
        //添加文章类别->文章类别关联表
        if (article.getCategoryIdList() != null) {
            List<ArticleCategory> articleTagList = article.getCategoryIdList().stream().map(categoryId -> ArticleCategory.builder()
                    .categoryId(categoryId)
                    .articleId(article.getId())
                    .build()).collect(Collectors.toList());
            articleCategoryService.insertBatch(articleTagList);
        }
    }

    @Override
    public void deleteArticle(Integer articleId) {
        articleMapper.deleteArticle(articleId);
        articleMap.remove(articleId);
        //关联标签删除掉
        articleTagService.deleteTag(articleId);
        //关联类别删除掉
        articleCategoryService.deleteCategory(articleId);
    }

    @Override
    public Article findById(Integer articleId) {
        Article article = articleMap.get(articleId);
        if (article == null) {
            Article art = articleMapper.getById(articleId);
            return art;
        }
        return article;
    }
}
