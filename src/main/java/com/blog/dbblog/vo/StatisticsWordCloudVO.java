package com.blog.dbblog.vo;

import lombok.Data;

/**
 * 用于显示词云时数据回显
 *
 * @author wuxi
 * @create 2023-08-28
 **/

@Data
public class StatisticsWordCloudVO {

    /**
     * 标签名称
     */
    private String tagName;
    /**
     * 背景颜色
     */
    private String bgColor;
    /**
     * 颜色
     */
    private String color;
    /**
     * 数值
     */
    private String value;

}

