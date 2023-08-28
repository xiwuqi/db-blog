package com.blog.dbblog.vo;
import lombok.Data;

/**
 * 用于显示近一周发文数据回显
 *
 * @author wuxi
 * @create 2023-08-28
 **/

@Data
public class StatisticsBaseCountVO {


    /**
     * 时间，例如：02-01
     */
    private String date;

    /**
     * 条数
     */
    private Long count;

    public StatisticsBaseCountVO() {

    }

    public StatisticsBaseCountVO(String date, Long count) {
        this.date = date;
        this.count = count;
    }
}
