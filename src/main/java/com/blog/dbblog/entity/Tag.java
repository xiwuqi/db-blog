package com.blog.dbblog.entity;

import lombok.Data;

import java.time.LocalDateTime;

/**
 * 标签
 *
 * @author wuxi
 * @create 2023-08-17
 */
@Data
public class Tag {

    /**
     * 主键id
     */
    private Integer id;

    /**
     * 标签名称
     */
    private String tagName;

    /**
     * 创建时间
     */
    private LocalDateTime createTime;

    /**
     * 更新时间
     */
    private LocalDateTime updateTime;

}
