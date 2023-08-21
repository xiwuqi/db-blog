package com.blog.dbblog.controller;

import com.blog.dbblog.common.PageRequestApi;
import com.blog.dbblog.config.page.PageRequest;
import com.blog.dbblog.config.page.PageResult;
import com.blog.dbblog.entity.LoginOperationLog;
import com.blog.dbblog.entity.OperationLog;
import com.blog.dbblog.service.LoginOperationLogService;
import com.blog.dbblog.service.OperationLogService;
import com.blog.dbblog.util.JsonResult;
import com.blog.dbblog.util.PageUtil;
import com.github.pagehelper.PageInfo;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import javax.validation.Valid;
import java.util.List;

/**
 * 操作日志管理接口
 *
 * @author wuxi
 * @create 2023-08-21
 */

@Api(tags = "操作日志")
@RestController
@RequestMapping("/log")
public class OperationLogController {

    @Resource
    private LoginOperationLogService loginOperationLogService;

    @Resource
    private OperationLogService operationLogService;

    /**
     * 操作日志列表
     * @param pageRequest
     * @return
     */
    @ApiOperation(value = "操作日志列表")
    @PostMapping("/operationLog/list")
    public JsonResult<Object> OperationLogListPage(@RequestBody @Valid PageRequestApi<PageRequest> pageRequest) {
        List<OperationLog> operationLogPage = operationLogService.getOperationLogPage(pageRequest.getBody());
        PageInfo pageInfo = new PageInfo(operationLogPage);
        PageResult pageResult = PageUtil.getPageResult(pageRequest.getBody(), pageInfo);
        return JsonResult.success(pageResult);
    }

    /**
     * 登录日志列表
     * @param pageRequest
     * @return
     */
    @ApiOperation(value = "登录日志列表")
    @PostMapping("/loginOperationLog/list")
    public JsonResult<Object> LoginOperationLogListPage(@RequestBody @Valid PageRequestApi<PageRequest> pageRequest) {
        List<LoginOperationLog> loginOperationLogPage = loginOperationLogService.getLoginOperationLogPage(pageRequest.getBody());
        PageInfo pageInfo = new PageInfo(loginOperationLogPage);
        PageResult pageResult = PageUtil.getPageResult(pageRequest.getBody(), pageInfo);
        return JsonResult.success(pageResult);
    }

}
