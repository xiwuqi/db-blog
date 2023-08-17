package com.blog.dbblog.mapper;

import com.blog.dbblog.entity.Notice;
import org.springframework.stereotype.Repository;

import java.util.List;


/**
 * @author wuxi
 * @create 2023-08-16
 */
@Repository
public interface NoticeMapper {

    /**
     * 创建
     * @param notice
     * @return
     */
    int createNotice(Notice notice);

    /**
     * 更新
     * @param notice
     * @return
     */
    int updateNotice(Notice notice);

    /**
     * 分类列表（分页）
     * @return
     */
    List<Notice> getNoticePage();

    /**
     * 删除
     * @param id
     */
    void deleteNotice(Integer id);

}