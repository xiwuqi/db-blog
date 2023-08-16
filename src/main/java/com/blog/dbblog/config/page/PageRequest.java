package com.blog.dbblog.config.page;

import lombok.Data;

/**
 * 分页请求
 *
 * @author wuxi
 * @create 2023-08-17
 */
@Data
public class PageRequest {

    /**
     * 页码
     */
    private int pageNum;

    /**
     * 每页的数据条数
     */
    private int pageSize;
}
