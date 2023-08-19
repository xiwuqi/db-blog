package com.blog.dbblog.mapper;

import com.blog.dbblog.entity.ArticleTag;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author wuxi
 * @create 2023-08-18
 */
@Repository
public interface ArticleTagMapper {

    /**
     * 批量插入
     * @param articleTagList
     */
    int insertBatch(@Param("articleTagList") List<ArticleTag> articleTagList);

    /**
     * 根据文章id删除关联表的数据
     * @param articleId
     */
    void deleteByArticleId(@Param("articleId") Integer articleId);

    /**
     * 根据文章id查找出所有的关联标签数据
     * @param articleId
     * @return
     */
    List<ArticleTag> getArticleTagById(@Param("articleId") Integer articleId);
}

