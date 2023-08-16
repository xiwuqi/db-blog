package com.blog.dbblog.service;

import com.blog.dbblog.config.page.PageRequest;
import com.blog.dbblog.entity.Category;
import java.util.List;

/**
 * 博客分类实现接口
 *
 * @author wuxi
 * @create 2023-08-17
 */
public interface CategoryService {

    /**
     * 获取所有的分类（分页）
     * @return
     */
    List<Category> getCategoryPage(PageRequest pageRequest);

    /**
     * 新建分类
     * @param category
     * @return
     */
    int saveCategory(Category category);

    /**
     * 修改分类
     * @param category
     * @return
     */
    int updateCategory(Category category);

    /**
     * 删除分类
     * @param categoryId
     */
    void deleteCategory(Integer categoryId);

    /**
     * 根据分类id查找分类
     * @param categoryId
     * @return
     */
    Category findById(Integer categoryId);

}