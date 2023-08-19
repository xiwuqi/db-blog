package com.blog.dbblog.config.mail;

import cn.hutool.extra.mail.MailAccount;
import cn.hutool.extra.mail.MailUtil;
import cn.hutool.json.JSONUtil;
import lombok.extern.log4j.Log4j2;

/**
 * 邮件发送
 *
 * @author wuxi
 * @create 2023-08-18
 **/
@Log4j2
public class SendMailConfig {

    /**
     * 邮件发送实现方法
     * @param mailInfo
     */
    public static void sendMail(MailInfo mailInfo) {
        try {
            MailAccount account = new MailAccount();
            //邮件服务器的SMTP地址
            account.setHost("smtp.qq.com");
            //邮件服务器的SMTP端口
            account.setPort(587);
            //发件人邮箱，改成你自己的
            account.setFrom("2822649171@qq.com");
            //密码，刚开通的授权码
            account.setPass("xxxxxxxxxxx");
            //使用SSL安全连接
            account.setSslEnable(true);
            MailUtil.send(account, mailInfo.getReceiveMail(),
                    mailInfo.getTitle(), mailInfo.getContent(), false);
            log.info("邮件发送成功！");
        } catch (Exception e) {
            log.error("邮件发送失败" + JSONUtil.toJsonStr(mailInfo));
        }

    }

}

