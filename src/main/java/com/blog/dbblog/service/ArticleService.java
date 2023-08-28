package com.blog.dbblog.service;

import com.blog.dbblog.bo.ArticleBO;
import com.blog.dbblog.bo.ArticleInsertBO;
import com.blog.dbblog.entity.Article;
import com.blog.dbblog.vo.ArticleVO;
import org.springframework.web.multipart.MultipartFile;

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
     * 创建文章标签关联
     * @param article
     */
    void createArticleTagRelations(Article article);

    /**
     * 创建文章分类关联
     * @param article
     */
    void createArticleCategoryRelations(Article article);

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
    ArticleVO findById(Integer articleId);

    /**
     * 上传文件
     *
     * @param file
     * @return
     */
    String uploadFile(MultipartFile file);

    /**
     * 新建文章
     * @param bo
     * @return
     */
    void insertOrUpdateArticle(ArticleInsertBO bo) throws Exception;

    /**
     * 获取所有文章(不分页)
     * @param
     * @return
     */
    List<Article> getAll();

}

