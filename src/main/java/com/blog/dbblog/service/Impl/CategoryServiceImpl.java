package com.blog.dbblog.service.Impl;

import com.blog.dbblog.bo.CategoryBO;
import com.blog.dbblog.config.page.PageRequest;
import com.blog.dbblog.entity.Category;
import com.blog.dbblog.mapper.CategoryMapper;
import com.blog.dbblog.service.CategoryService;
import com.github.pagehelper.PageHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 博客分类实现类
 *
 * @author wuxi
 * @create 2023-08-17
 */

@Service
public class CategoryServiceImpl implements CategoryService {

    @Autowired
    CategoryMapper categoryMapper;

    @Override
    public List<Category> getCategoryPage(PageRequest pageRequest) {
        int pageNum = pageRequest.getPageNum();
        int pageSize = pageRequest.getPageSize();
        PageHelper.startPage(pageNum,pageSize);
        List<Category> categoryList = categoryMapper.getCategoryPage();
        return categoryList;
    }

    @Override
    public int saveCategory(Category category) throws Exception {
        if (getCategoryByName(category.getCategoryName()) != null) {
            throw new Exception ("分类已存在");
        }
        return categoryMapper.create(category);
    }

    @Override
    public int updateCategory(Category category) {
        return categoryMapper.update(category);
    }

    @Override
    public void deleteCategory(Integer categoryId) {
        categoryMapper.delete(categoryId);
    }

    @Override
    public Category findById(Integer categoryId) {
        Category category = categoryMapper.getById(categoryId);
        if (category == null) {
            return null;
        }
        return category;
    }

    @Override
    public List<Category> getCategoriesByName(CategoryBO bo) {
        List<Category> categoriesByName = categoryMapper.findCategoriesByName(bo);
        return categoriesByName;
    }

    @Override
    public Category getCategoryByName(String categoryName) {
        Category category = categoryMapper.getCategoryByName(categoryName);
        return category;
    }

}

