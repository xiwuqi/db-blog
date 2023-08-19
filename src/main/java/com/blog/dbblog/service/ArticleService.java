package com.blog.dbblog.service;

import com.blog.dbblog.bo.ArticleBO;
import com.blog.dbblog.entity.Article;

import java.util.List;

/**
 * 博客文章实现接口
 *
 * @author wuxi
 * @create 2023-08-18
 */
public interface ArticleService {

    /**
     * 初始化数据
     */
    void init();

    /**
     * 获取所有的文章（分页）
     * @return
     */
    List<Article> getArticlePage(ArticleBO articleBO);

    /**
     * 新建文章
     * @param article
     * @return
     */
    void saveArticle(Article article);

    /**
     * 修改文章
     * @param article
     * @return
     */
    void updateArticle(Article article);

    /**
     * 删除文章
     * @param articleId
     */
    void deleteArticle(Integer articleId);

    /**
     * 根据文章id查找文章
     * @param articleId
     * @return
     */
    Article findById(Integer articleId);

}
