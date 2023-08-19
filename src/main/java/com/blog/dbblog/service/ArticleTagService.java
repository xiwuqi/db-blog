package com.blog.dbblog.service;

import com.blog.dbblog.entity.ArticleTag;

import java.util.List;

/**
 * 博客文章和标签关联实现接口
 *
 * @author wuxi
 * @create 2023-08-18
 */
public interface ArticleTagService {

    /**
     * 批量插入文章标签数据
     *
     * @param articleTagList
     */
    void insertBatch(List<ArticleTag> articleTagList);

    /**
     * 根据文章id删除关联表的标签数据
     *
     * @param articleId
     */
    void deleteTag(Integer articleId);

    /**
     * 根据文章id查找出所有的关联标签数据
     *
     * @param articleId
     * @return
     */
    List<ArticleTag> findArticleTagById(Integer articleId);


}

