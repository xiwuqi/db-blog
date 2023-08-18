package com.blog.dbblog.service.Impl;

import com.blog.dbblog.bo.ArticleBO;
import com.blog.dbblog.config.mail.MailInfo;
import com.blog.dbblog.config.mail.SendMailConfig;
import com.blog.dbblog.entity.Article;
import com.blog.dbblog.entity.User;
import com.blog.dbblog.mapper.ArticleMapper;
import com.blog.dbblog.service.ArticleService;
import com.blog.dbblog.service.UserService;
import com.github.pagehelper.PageHelper;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import javax.annotation.Resource;
import java.text.MessageFormat;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;


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
    UserService userService;

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
        return articleList;
    }

    @Override
    public void saveArticle(Article article) {
        articleMapper.createArticle(article);
        articleMap.put(article.getId(), article);

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
    public void updateArticle(Article article) {
        articleMapper.updateArticle(article);
        articleMap.put(article.getId(), article);
    }

    @Override
    public void deleteArticle(Integer articleId) {
        articleMapper.deleteArticle(articleId);
        articleMap.remove(articleId);
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
