package com.blog.dbblog.service;


import com.blog.dbblog.config.page.PageRequest;
import com.blog.dbblog.entity.LoginOperationLog;
import java.util.List;

/**
 * 登录日志实现接口
 *
 * @author wuxi
 * @create 2023-08-21
 */
public interface LoginOperationLogService {

    /**
     * 添加登录日志
     *
     * @param loginOperationLog
     * @return
     */
    void saveOperationLog(LoginOperationLog loginOperationLog);

    /**
     * 登录日志列表（分页）
     *
     * @param pageRequest
     * @return
     */
    List<LoginOperationLog> getLoginOperationLogPage(PageRequest pageRequest);

}

