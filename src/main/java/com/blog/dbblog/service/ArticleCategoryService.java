package com.blog.dbblog.service;

import com.blog.dbblog.entity.ArticleCategory;

import java.util.List;

/**
 * 博客文章和类别关联实现接口
 *
 * @author wuxi
 * @create 2023-08-18
 */
public interface ArticleCategoryService {
    /**
     * 批量插入文章类别数据
     *
     * @param articleCategoryList
     */
    void insertBatch(List<ArticleCategory> articleCategoryList);

    /**
     * 根据文章id删除关联表的类别数据
     *
     * @param articleId
     */
    void deleteCategory(Integer articleId);

    /**
     * 根据文章id查找出所有的关联类别数据
     *
     * @param articleId
     * @return
     */
    List<ArticleCategory> findArticleCategoryById(Integer articleId);
}
