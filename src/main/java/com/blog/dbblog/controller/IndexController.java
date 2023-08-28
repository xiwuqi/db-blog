package com.blog.dbblog.controller;


import com.blog.dbblog.annotation.OperationLogSys;
import com.blog.dbblog.annotation.OperationType;
import com.blog.dbblog.entity.Notice;
import com.blog.dbblog.service.NoticeService;
import com.blog.dbblog.service.StatisticsService;
import com.blog.dbblog.util.JsonResult;
import com.blog.dbblog.vo.StatisticsBaseCountVO;
import com.blog.dbblog.vo.StatisticsCategoryCountVO;
import com.blog.dbblog.vo.StatisticsTopCountVO;
import com.blog.dbblog.vo.StatisticsWordCloudVO;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

/**
 * 首页统计
 *
 * @author wuxi
 * @create 2023-08-26
 **/

@Api(tags = "首页统计")
@RestController
@RequestMapping("/index")
public class IndexController {
    @Resource
    private StatisticsService statisticsService;
    @Resource
    private NoticeService noticeService;

    /**
     * 顶部统计查询
     * @return
     */
    @ApiOperation(value = "首页顶部统计查询")
    @PostMapping("/getTopCount")
    @OperationLogSys(desc = "首页顶部统计查询", operationType = OperationType.SELECT)
    public JsonResult<Object> getTopCount() {
        StatisticsTopCountVO topCount = statisticsService.getTopCount();
        return JsonResult.success(topCount);
    }

    /**
     * 近一周发文的数量
     * @return
     */
    @ApiOperation(value = "近一周发文的数量")
    @PostMapping("/getWeekNum")
    @OperationLogSys(desc = "近一周发文的数量", operationType = OperationType.SELECT)
    public JsonResult<Object> getWeekNum() {
        List<StatisticsBaseCountVO> list = statisticsService.getArticleCount();
        return JsonResult.success(list);
    }

    /**
     * 获取分类数据
     * @return
     */
    @ApiOperation(value = "获取分类数据")
    @PostMapping("/getCategoryCount")
    @OperationLogSys(desc = "获取标签数据", operationType = OperationType.SELECT)
    public JsonResult<Object> getCategoryCount() {
        List<StatisticsCategoryCountVO> categoryCount = statisticsService.getCategoryCount();
        return JsonResult.success(categoryCount);
    }

    /**
     * 在线人数
     * @return
     */
    @ApiOperation(value = "在线人数")
    @PostMapping("/getOnline")
    @OperationLogSys(desc = "在线人数", operationType = OperationType.SELECT)
    public JsonResult<Object> getOnline() {
        List<StatisticsBaseCountVO> online = statisticsService.getOnline();
        return JsonResult.success(online);
    }

    /**
     * 获取最新前5条公告
     * @return
     */
    @ApiOperation(value = "获取最新前5条公告")
    @PostMapping("/getNoticeList")
    @OperationLogSys(desc = "获取最新前5条公告", operationType = OperationType.SELECT)
    public JsonResult<Object> getNoticeList() {
        List<Notice> list = noticeService.getNoticeTopFive();
        return JsonResult.success(list);
    }

    /**
     * 获取词云数据
     * @return
     */
    @ApiOperation(value = "获取词云数据")
    @PostMapping("/getWordCloud")
    @OperationLogSys(desc = "获取词云数据", operationType = OperationType.SELECT)
    public JsonResult<Object> getWordCloud() {
        List<StatisticsWordCloudVO> wordCloud = statisticsService.getWordCloud();
        return JsonResult.success(wordCloud);
    }


}
