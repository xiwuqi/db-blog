package com.blog.dbblog.util;

import com.blog.dbblog.config.page.PageRequest;
import com.blog.dbblog.config.page.PageResult;
import com.github.pagehelper.PageInfo;

/**
 * 分页工具类
 *
 * @author wuxi
 * @create 2023-08-17
 */
public class PageUtil {

    /**
     *  分页信息封装
     * @param pageRequest
     * @param pageInfo
     * @return
     */
    public static PageResult getPageResult(PageRequest pageRequest, PageInfo<?> pageInfo){
        PageResult pageResult = new PageResult();
        pageResult.setPageNum(pageInfo.getPageNum());
        pageResult.setPageSize(pageInfo.getPageSize());
        pageResult.setTotalSize(pageInfo.getTotal());
        pageResult.setTotalPages(pageInfo.getPages());
        pageResult.setResult(pageInfo.getList());
        return pageResult;
    }

}