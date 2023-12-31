package com.blog.dbblog.controller;

import com.blog.dbblog.annotation.OperationLogSys;
import com.blog.dbblog.annotation.OperationType;
import com.blog.dbblog.common.PageRequestApi;
import com.blog.dbblog.config.page.PageRequest;
import com.blog.dbblog.config.page.PageResult;
import com.blog.dbblog.entity.Notice;
import com.blog.dbblog.service.NoticeService;
import com.blog.dbblog.util.JsonResult;
import com.blog.dbblog.util.PageUtil;
import com.github.pagehelper.PageInfo;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.apache.shiro.SecurityUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

/**
 * 公告管理接口
 *
 * @author wuxi
 * @create 2023-08-17
 */
@Api(tags = "公告管理")
@RestController
@RequestMapping("/notice")
public class NoticeController {

    @Autowired
    NoticeService noticeService;

    /**
     * 分页查询列表
     * @param pageRequest
     * @return
     */
    @ApiOperation(value = "公告列表")
    @PostMapping("/list")
    public JsonResult<Object> listPage(@RequestBody @Valid PageRequestApi<PageRequest> pageRequest) {
        List<Notice> noticeList = noticeService.getNoticePage(pageRequest.getBody());
        PageInfo pageInfo = new PageInfo(noticeList);
        PageResult pageResult = PageUtil.getPageResult(pageRequest.getBody(), pageInfo);
        return JsonResult.success(pageResult);
    }

    /**
     * 添加公告
     * @return
     */
    @ApiOperation(value = "添加公告")
    @PostMapping("/create")
    @OperationLogSys(desc = "添加公告", operationType = OperationType.INSERT)
    public JsonResult<Object> noticeCreate(@RequestBody @Valid Notice notice) {
        String username = (String) SecurityUtils.getSubject().getPrincipal();
        notice.setCreateBy(username);
        int isStatus = noticeService.saveNotice(notice);
        if (isStatus == 0) {
            return JsonResult.error("添加公告失败");
        }
        return JsonResult.success();
    }

    /**
     * 修改公告
     * @return
     */
    @ApiOperation(value = "修改公告")
    @PostMapping("/update")
    @OperationLogSys(desc = "修改公告", operationType = OperationType.UPDATE)
    public JsonResult<Object> noticeUpdate(@RequestBody @Valid Notice notice){
        int isStatus = noticeService.updateNotice(notice);
        if(isStatus == 0){
            return JsonResult.error("修改公告失败");
        }
        return JsonResult.success();
    }

    /**
     * 删除公告
     * @return
     */
    @ApiOperation(value = "删除公告")
    @PostMapping("/delete/{id}")
    @OperationLogSys(desc = "删除公告", operationType = OperationType.DELETE)
    public JsonResult<Object> noticeDelete(@PathVariable(value = "id") int id){
        noticeService.deleteNotice(id);
        return JsonResult.success();
    }

    /**
     * 根据id查询公告信息
     * @return
     */
    @GetMapping("/info/{id}")
    @ApiOperation("根据id查询公告信息")
    @OperationLogSys(desc = "查询公告", operationType = OperationType.SELECT)
    public JsonResult<Object> getNotice(@PathVariable Integer id) {
        Notice notice = noticeService.getNoticeById(id);
        return JsonResult.success(notice);
    }


}
