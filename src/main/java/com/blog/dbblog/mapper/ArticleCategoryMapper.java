package com.blog.dbblog.mapper;

import com.blog.dbblog.entity.ArticleCategory;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author wuxi
 * @create 2023-08-18
 */
@Repository
public interface ArticleCategoryMapper {

    /**
     * 批量插入
     * @param articleCategoryList
     */
    int insertBatch(@Param("articleCategoryList") List<ArticleCategory> articleCategoryList);

    /**
     * 根据文章id删除关联表的数据
     * @param articleId
     */
    void deleteByArticleId(@Param("articleId") Integer articleId);

    /**
     * 根据文章id查找出所有的关联类别数据
     * @param articleId
     * @return
     */
    List<ArticleCategory> getArticleCategoryById(@Param("articleId") Integer articleId);
}
