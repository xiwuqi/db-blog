package com.blog.dbblog.service;

import com.blog.dbblog.config.page.PageRequest;
import com.blog.dbblog.entity.OperationLog;
import java.util.List;

/**
 * 操作日志实现接口
 *
 * @author wuxi
 * @create 2023-08-21
 */
public interface OperationLogService {

    /**
     * 保存操作日志
     *
     * @param operationLog
     * @return
     */
    void saveOperationLog(OperationLog operationLog);

    /**
     * 操作日志列表（分页）
     *
     * @param pageRequest
     * @return
     */
    List<OperationLog> getOperationLogPage(PageRequest pageRequest);

}
