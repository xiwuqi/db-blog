package com.blog.dbblog.mapper;

import com.blog.dbblog.entity.Tag;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author wuxi
 * @create 2023-08-17
 */
@Repository
public interface TagMapper {
    /**
     * 创建
     * @param tag
     * @return
     */
    int createTag(Tag tag);

    /**
     * 修改
     * @param tag
     * @return
     */
    int updateTag(Tag tag);

    /**
     * 分类列表（分页）
     * @return
     */
    List<Tag> getTagPage();

    /**
     * 删除
     * @param id
     */
    void deleteTag(Integer id);

    /**
     * 批量添加标签
     * @param strings
     * @return
     */
    boolean batchAddTag(List<Tag> strings);

    /**
     * 批量删除标签
     * @param ids
     */
    boolean deleteBatch(List<Integer> ids);

    /**
     * 根据标签查找该对象
     * @param tag
     * @return
     */
    Tag getByTagName(Tag tag);
}

