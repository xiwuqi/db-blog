package com.blog.dbblog.mapper;

import com.blog.dbblog.entity.LoginOperationLog;
import org.springframework.stereotype.Repository;
import java.util.List;

/**
 * @author wuxi
 * @create 2023-08-21
 */

@Repository
public interface LoginOperationLogMapper {

    /**
     * 创建登录日志
     * @param loginOperationLog
     * @return
     */
    int createLoginOperationLog(LoginOperationLog loginOperationLog);

    /**
     * 分类列表（分页）
     * @return
     */
    List<LoginOperationLog> getLoginOperationLogPage();
}
