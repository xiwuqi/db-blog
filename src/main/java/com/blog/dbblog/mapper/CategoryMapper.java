package com.blog.dbblog.mapper;

import com.blog.dbblog.entity.Category;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * 博客分类数据接口
 *
 * @author wuxi
 * @create 2023-08-17
 */

@Repository
public interface CategoryMapper {

    /**
     * 创建
     * @param category
     * @return
     */
    int create(Category category);

    /**
     * 修改
     * @param category
     * @return
     */
    int update(Category category);

    /**
     * 分类列表（分页）
     * @return
     */
    List<Category> getCategoryPage();

    /**
     * 删除
     * @param id
     */
    void delete(Integer id);

    /**
     * 根据id查找分类
     * @param id
     * @return
     */
    Category getById(Integer id);

}

