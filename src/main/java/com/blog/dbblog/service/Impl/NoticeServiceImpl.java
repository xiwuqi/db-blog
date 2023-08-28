package com.blog.dbblog.service.Impl;

import com.blog.dbblog.config.page.PageRequest;
import com.blog.dbblog.entity.Notice;
import com.blog.dbblog.mapper.NoticeMapper;
import com.blog.dbblog.service.NoticeService;
import com.github.pagehelper.PageHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 博客公告实现类
 *
 * @author wuxi
 * @create 2023-08-17
 */
@Service
public class NoticeServiceImpl implements NoticeService {

    @Autowired
    NoticeMapper noticeMapper;

    @Override
    public List<Notice> getNoticePage(PageRequest pageRequest){
        int pageNum = pageRequest.getPageNum();
        int pageSize = pageRequest.getPageSize();
        PageHelper.startPage(pageNum,pageSize);
        List<Notice> noticeList = noticeMapper.getNoticePage();
        return noticeList;
    }

    @Override
    public int saveNotice(Notice notice){
        return noticeMapper.createNotice(notice);
    }

    @Override
    public int updateNotice(Notice notice){
        return noticeMapper.updateNotice(notice);
    }

    @Override
    public void deleteNotice(Integer noticeId){
        noticeMapper.deleteNotice(noticeId);
    }

    @Override
    public Notice getNoticeById(Integer noticeId) {
        Notice notice = noticeMapper.getNoticeById(noticeId);
        return notice;
    }

    @Override
    public List<Notice> getNoticeTopFive() {
        List<Notice> noticeList = noticeMapper.getNoticeTopFive();
        return noticeList;
    }

}
