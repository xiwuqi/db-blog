package com.blog.dbblog.vo;

import lombok.Data;

/**
 * 用于显示分类占比数据回显
 *
 * @author wuxi
 * @create 2023-08-28
 **/
@Data
public class StatisticsCategoryCountVO {

    /**
     * 标签名称
     */
    private String categoryName;

    /**
     * 标签总数
     */
    private Integer categoryCount;
}

