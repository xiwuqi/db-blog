package com.blog.dbblog.config.mail;

import lombok.Builder;
import lombok.Data;


/**
 * 邮件接收配置信息
 *
 * @author wuxi
 * @create 2023-08-18
 **/
@Builder
@Data
public class MailInfo {
    /**
     * 接收的邮箱
     */
    private String receiveMail;

    /**
     * 邮件标题
     */
    private String title;

    /**
     * 邮件内容
     */
    private String content;

}

