package com.blog.dbblog.bo;

import lombok.Data;

/**
 * @author wuxi
 * @create 2023-08-18
 */
@Data
public class ArticleBO {

    /**
     * 发布，默认0, 0-发布, 1-草稿
     */
    private Integer artStatus;

    /**
     * 文章标题
     */
    private String title;

    /**
     * 页码
     */
    private int pageNum;

    /**
     * 每页的数据条数
     */
    private int pageSize;

}

