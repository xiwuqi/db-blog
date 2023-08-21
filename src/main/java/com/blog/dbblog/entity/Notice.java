package com.blog.dbblog.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import java.time.LocalDateTime;

/**
 * 通知公告
 *
 * @author wuxi
 * @create 2023-08-17
 */
@Data
public class Notice {

    /**
     * 主键id
     */
    private Integer noticeId;

    /**
     * 公告标题
     */
    private String noticeTitle;

    /**
     * 公告类型
     */
    private Integer noticeType;

    /**
     * 公告状态，默认0, true-正常, false-关闭
     */
    private Boolean noticeStatus;

    /**
     * 公告内容
     */
    private String noticeContent;

    /**
     * 创建者
     */
    private String createBy;

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
}
