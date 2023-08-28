package com.blog.dbblog.service;


import com.blog.dbblog.config.page.PageRequest;
import com.blog.dbblog.entity.Notice;

import java.util.List;

/**
 * 博客公告实现接口
 *
 * @author wuxi
 * @create 2023-08-17
 */
public interface NoticeService {

    /**
     * 获取所有分类
     * @return
     */
    List<Notice> getNoticePage(PageRequest pageRequest);

    /**
     * 新建分类
     * @param notice
     * @return
     */
    int saveNotice(Notice notice);

    /**
     * 修改分类
     * @param notice
     * @return
     */
    int updateNotice(Notice notice);

    /**
     * 删除分类
     * @param noticeId
     */
    void deleteNotice(Integer noticeId);

    /**
     * 根据公告id获取公告
     * @param noticeId
     * @return
     */
    Notice getNoticeById(Integer noticeId);

    /**
     * 获取前5条公告
     * @return
     */
    List<Notice> getNoticeTopFive();

}
