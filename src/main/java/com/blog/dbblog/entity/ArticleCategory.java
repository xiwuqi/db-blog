package com.blog.dbblog.entity;

import lombok.Builder;
import lombok.Data;

/**
 * @author wuxi
 * @create 2023-08-18
 */
@Data
@Builder
public class ArticleCategory {

    /**
     * id主键
     */
    private Integer id;

    /**
     * 文章id
     */
    private Integer articleId;

    /**
     * 标签id
     */
    private Integer categoryId;

}
