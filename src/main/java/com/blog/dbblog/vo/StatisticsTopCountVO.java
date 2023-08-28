package com.blog.dbblog.vo;

import lombok.Data;

/**
 * 用于显示顶部统计时数据回显
 *
 * @author wuxi
 * @create 2023-08-26
 **/

@Data
public class StatisticsTopCountVO {

    /**
     * 文章总数
     */
    private Integer articleCount;
    /**
     * 分类总数
     */
    private Integer categoryCount;
    /**
     * 用户总数
     */
    private Integer userCount;
    /**
     * 标签总数
     */
    private Integer tagCount;

}
