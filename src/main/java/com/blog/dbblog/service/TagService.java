package com.blog.dbblog.service;

import com.blog.dbblog.bo.TagBO;
import com.blog.dbblog.config.page.PageRequest;
import com.blog.dbblog.entity.Tag;

import java.util.List;

/**
 * 博客标签实现接口
 *
 * @author wuxi
 * @create 2023-08-17
 */
public interface TagService {

    /**
     * 获取所有的标签（分页）
     * @return
     */
    List<Tag> getTagPage(PageRequest pageRequest);

    /**
     * 新建标签
     * @param tag
     * @return
     */
    int saveTag(Tag tag) throws Exception;

    /**
     * 修改标签
     * @param tag
     * @return
     */
    int updateTag(Tag tag);

    /**
     * 删除标签
     * @param tagId
     */
    void deleteTag(Integer tagId);

    /**
     * 批量添加
     * @param tags
     * @return
     */
    boolean batchAddTag(String tags) throws Exception;

    /**
     * 批量删除标签
     * @param ids
     * @return
     */
    boolean batchDelTag(String ids);

    /**
     * 根据标签查找
     * @param tagName
     * @return
     */
    Tag findByTagName(String tagName);

    /**
     * 根据id查找
     * @param tagId
     * @return
     */
    Tag findById(Integer tagId);

    /**
     * 搜索文章标签
     *
     * @param bo
     * @return
     */
    List<Tag> getTagsByTagName(TagBO bo);

}

