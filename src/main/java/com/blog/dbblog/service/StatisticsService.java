package com.blog.dbblog.service;

import com.blog.dbblog.vo.StatisticsBaseCountVO;
import com.blog.dbblog.vo.StatisticsCategoryCountVO;
import com.blog.dbblog.vo.StatisticsTopCountVO;
import com.blog.dbblog.vo.StatisticsWordCloudVO;

import java.util.List;


/**
 * 首页顶部统计实现接口
 *
 * @author wuxi
 * @create 2023-08-26
 **/
public interface StatisticsService {

    /**
     * 首页顶部数据统计
     * @return
     */
    StatisticsTopCountVO getTopCount();

    /**
     * 文章近一周统计数据
     * @return
     */
    List<StatisticsBaseCountVO> getArticleCount();

    /**
     * 获取分类数据
     * @return
     */
    List<StatisticsCategoryCountVO> getCategoryCount();

    /**
     * 获取登录数据
     */
    void login(String username, Long date);

    /**
     * 获取登出数据
     */
    void logout(String username, Long date);

    /**
     * 获取在线人数
     * @return
     */
    List<StatisticsBaseCountVO> getOnline();

    /**
     * 获取词云数据
     * @return
     */
    List<StatisticsWordCloudVO> getWordCloud();



}
