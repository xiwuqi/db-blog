package com.blog.dbblog.controller;

import com.blog.dbblog.annotation.OperationLogSys;
import com.blog.dbblog.annotation.OperationType;
import com.blog.dbblog.bo.ArticleBO;
import com.blog.dbblog.bo.ArticleInsertBO;
import com.blog.dbblog.config.page.PageRequest;
import com.blog.dbblog.config.page.PageResult;
import com.blog.dbblog.entity.Article;
import com.blog.dbblog.service.ArticleService;
import com.blog.dbblog.util.JsonResult;
import com.blog.dbblog.util.PageUtil;
import com.github.pagehelper.PageInfo;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.validation.Valid;
import java.util.List;

/**
 * 博客管理接口
 *
 * @author wuxi
 * @create 2023-08-18
 */
@Api(tags = "文章管理")
@RestController
@RequestMapping("/article")
public class ArticleController {

    @Autowired
    ArticleService articleService;

    /**
     * 文章列表
     * @param articleBO
     * @return
     */
    @ApiOperation(value = "文章列表")
    @PostMapping("list")
    public JsonResult<Object> listPage(@RequestBody @Valid ArticleBO articleBO) {
        List<Article> articleList = articleService.getArticlePage(articleBO);
        PageInfo pageInfo = new PageInfo(articleList);
        PageRequest pageRequest = new PageRequest();
        pageRequest.setPageNum(articleBO.getPageNum());
        pageRequest.setPageSize(articleBO.getPageSize());
        PageResult pageResult = PageUtil.getPageResult(pageRequest, pageInfo);
        return JsonResult.success(pageResult);
    }

    /**
     * 添加文章
     * @return
     */
    @ApiOperation(value = "添加文章")
    @PostMapping("/create")
    @OperationLogSys(desc = "添加文章", operationType = OperationType.INSERT)
    public JsonResult<Object> articleCreate(@RequestBody @Valid ArticleInsertBO bo) throws Exception {
        articleService.insertOrUpdateArticle(bo);
        return JsonResult.success();
    }

    /**
     * 修改文章
     * @return
     */
    @ApiOperation(value = "修改文章")
    @PostMapping("/update")
    @OperationLogSys(desc = "修改文章", operationType = OperationType.UPDATE)
    public JsonResult<Object> articleUpdate(@RequestBody @Valid Article article) {
        articleService.updateArticle(article);
        return JsonResult.success();
    }

    /**
     * 删除文章
     * @return
     */
    @ApiOperation(value = "删除文章")
    @DeleteMapping("/delete/{id}")
    @OperationLogSys(desc = "删除文章", operationType = OperationType.DELETE)
    public JsonResult<Object> articleDelete(@PathVariable(value = "id") int id) {
        articleService.deleteArticle(id);
        return JsonResult.success();
    }

    /**
     * 根据文章id查找
     * @param id
     * @return
     */
    @ApiOperation(value = "根据文章id查找")
    @PostMapping("/getArticle/{id}")
    @OperationLogSys(desc = "根据文章id查找", operationType = OperationType.SELECT)
    public JsonResult<Object> getArticleById(@PathVariable(value = "id") int id) {
        Article article = articleService.findById(id);
        return JsonResult.success(article);
    }

    /**
     * 上传网站logo封面
     * @param file
     * @return 返回logo地址
     */
    @ApiOperation(value = "上传网站logo封面")
    @PostMapping("upload")
    public JsonResult<String> uploadImg(@RequestParam(value = "file") MultipartFile file) {
        String s = articleService.uploadFile(file);
        return JsonResult.success(s);
    }



}

