package com.blog.dbblog.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import java.time.LocalDateTime;
import java.util.List;

/**
 * 博客文章
 *
 * @author wuxi
 * @create 2023-08-17
 */
@Data
public class Article {
    /**
     * 文章id
     */
    private Integer id;

    /**
     * 作者
     */
    private String author;

    /**
     * 文章标题
     */
    private String title;

    /**
     * 用户id
     */
    private Integer userId;

    /**
     * 文章内容
     */
    private String content;

    /**
     * 文章浏览量
     */
    private Long views;

    /**
     * 文章总字数
     */
    private Long totalWords;

    /**
     * 评论id
     */
    private Integer commentableId;

    /**
     * 发布，默认0, 0-发布, 1-草稿
     */
    private Integer artStatus;

    /**
     * 描述
     */
    private String description;

    /**
     * 文章logo
     */
    private String imageUrl;

    /**
     * 创建时间
     */
    @JsonFormat(timezone = "GMT+8",pattern="yyyy-MM-dd HH:mm:ss")
    private LocalDateTime createTime;

    /**
     * 更新时间
     */
    @JsonFormat(timezone = "GMT+8",pattern="yyyy-MM-dd HH:mm:ss")
    private LocalDateTime updateTime;

    /**
     * 文章标签(页面展示)
     */
    private List<Tag> tagList;

    /**
     * 文章分类(页面展示)
     */
    private List<Category> categoryList;

    /**
     * 文章标签添加或更新时使用
     */
    private List<Integer> tagIdList;

    /**
     * 文章类别添加或更新时使用
     */
    private List<Integer> categoryIdList;

}

