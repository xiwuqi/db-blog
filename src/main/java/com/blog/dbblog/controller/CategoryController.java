package com.blog.dbblog.controller;

import com.blog.dbblog.annotation.OperationLogSys;
import com.blog.dbblog.annotation.OperationType;
import com.blog.dbblog.config.page.PageRequest;
import com.blog.dbblog.config.page.PageResult;
import com.blog.dbblog.entity.Category;
import com.blog.dbblog.service.CategoryService;
import com.blog.dbblog.util.JsonResult;
import com.blog.dbblog.util.PageUtil;
import com.github.pagehelper.PageInfo;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

/**
 * 分类管理接口
 *
 * @author wuxi
 * @create 2023-08-17
 */
@Api(tags = "分类管理")
@RestController
@RequestMapping("/category")
public class CategoryController {

    @Autowired
    CategoryService categoryService;

    /**
     * 分页查询列表
     * @param pageRequest
     * @return
     */
    @PostMapping("list")
    public JsonResult<Object> listPage(@RequestBody @Valid PageRequest pageRequest) {
        List<Category> categoryList = categoryService.getCategoryPage(pageRequest);
        PageInfo pageInfo = new PageInfo(categoryList);
        PageResult pageResult = PageUtil.getPageResult(pageRequest, pageInfo);
        return JsonResult.success(pageResult);
    }

    /**
     * 添加分类
     * @return
     */
    @ApiOperation(value = "添加分类")
    @PostMapping("/create")
    @OperationLogSys(desc = "添加分类", operationType = OperationType.INSERT)
    public JsonResult<Object> categoryCreate(@RequestBody @Valid Category category) {
        int isStatus = categoryService.saveCategory(category);
        if (isStatus == 0) {
            return JsonResult.error("添加分类失败");
        }
        return JsonResult.success();
    }


    /**
     * 修改分类
     * @return
     */
    @ApiOperation(value = "修改分类")
    @PostMapping("/update")
    @OperationLogSys(desc = "修改分类", operationType = OperationType.UPDATE)
    public JsonResult<Object> categoryUpdate(@RequestBody @Valid Category category) {
        int isStatus = categoryService.updateCategory(category);
        if (isStatus == 0) {
            return JsonResult.error("修改分类失败");
        }
        return JsonResult.success();
    }

    /**
     * 删除
     * @return
     */
    @ApiOperation(value = "删除分类")
    @PostMapping("/delete/{id}")
    @OperationLogSys(desc = "删除分类", operationType = OperationType.DELETE)
    public JsonResult<Object> categoryDelete(@PathVariable(value = "id") int id) {
        categoryService.deleteCategory(id);
        return JsonResult.success();
    }

}
