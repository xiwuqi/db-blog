package com.blog.dbblog.service.Impl;

import com.blog.dbblog.entity.ArticleCategory;
import com.blog.dbblog.mapper.ArticleCategoryMapper;
import com.blog.dbblog.service.ArticleCategoryService;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * 博客文章和类别关联实现类
 *
 * @author wuxi
 * @create 2023-08-18
 */
@Log4j2
@Service
public class ArticleCategoryServiceImpl implements ArticleCategoryService {

    @Resource
    ArticleCategoryMapper articleCategoryMapper;

    @Override
    public void insertBatch(List<ArticleCategory> articleCategoryList) {
        try {
            articleCategoryMapper.insertBatch(articleCategoryList);
        } catch (Exception e) {
            log.error("批量添加文章标签失败！" + e.getMessage());
        }
    }

    @Override
    public void deleteCategory(Integer articleId) {
        articleCategoryMapper.deleteByArticleId(articleId);
    }

    @Override
    public List<ArticleCategory> findArticleCategoryById(Integer articleId) {
        List<ArticleCategory> articleCategoryList = articleCategoryMapper.getArticleCategoryById(articleId);
        return articleCategoryList;
    }

}
