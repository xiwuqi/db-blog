package com.blog.dbblog.mapper;

import com.blog.dbblog.entity.Notice;
import com.blog.dbblog.vo.StatisticsCategoryCountVO;
import com.blog.dbblog.vo.StatisticsTopCountVO;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author wuxi
 * @create 2023-08-26
 **/

@Repository
public interface StatisticsMapper {

    /**
     * 获取顶部统计信息
     */
    StatisticsTopCountVO getTopCount();

    /**
     * 获取分类占比信息
     */
    List<StatisticsCategoryCountVO> getCategoryCount();



}
