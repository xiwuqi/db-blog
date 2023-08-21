package com.blog.dbblog.service.Impl;

import com.blog.dbblog.config.page.PageRequest;
import com.blog.dbblog.entity.LoginOperationLog;
import com.blog.dbblog.mapper.LoginOperationLogMapper;
import com.blog.dbblog.service.LoginOperationLogService;
import com.github.pagehelper.PageHelper;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 *
 * @author: SuperMan
 * @create: 2022-04-05
 **/

@Service
public class LoginOperationLogServiceImpl implements LoginOperationLogService {

    @Resource
    private LoginOperationLogMapper loginOperationLogMapper;

    @Override
    public void saveOperationLog(LoginOperationLog loginOperationLog) {
        loginOperationLogMapper.createLoginOperationLog(loginOperationLog);
    }

    @Override
    public List<LoginOperationLog> getLoginOperationLogPage(PageRequest pageRequest) {
        int pageNum = pageRequest.getPageNum();
        int pageSize = pageRequest.getPageSize();
        PageHelper.startPage(pageNum,pageSize);
        List<LoginOperationLog> loginOperationLogList = loginOperationLogMapper.getLoginOperationLogPage();
        return loginOperationLogList;
    }

}

