package com.blog.dbblog.controller;

import cn.hutool.core.util.StrUtil;
import com.blog.dbblog.entity.User;
import com.blog.dbblog.service.UserService;
import com.blog.dbblog.util.JsonResult;
import com.blog.dbblog.util.MD5Util;
import com.blog.dbblog.util.PhoneUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

/**
 * @author wuxi
 * @create 2023-08-16
 */

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    UserService userService;

    /**
     * 用户列表
     * @return
     */
    @PostMapping("/list")
    public JsonResult<Object> list() {
        List<User> userList = userService.findAll();
        return JsonResult.success(userList);
    }

    /**
     * 添加用户
     * @return
     */
    @PostMapping("/create")
    public JsonResult<Object> userCreate(@RequestBody @Valid User user) {
        if (StrUtil.isEmpty(user.getPassWord())) {
            return JsonResult.error("密码为空，请填写密码！");
        }
        //密码加密存储
        user.setPassWord(MD5Util.MD5(user.getPassWord()));
        //判断手机号，这里用hutool工具类也可以
        if (!PhoneUtil.checkMobile(user.getPhone())) {
            return JsonResult.error("手机号码格式错误！");
        }
        userService.createUser(user);
        return JsonResult.success();
    }

    /**
     *
     * 修改用户
     * @return
     */
    @PostMapping("/update")
    public JsonResult<Object> userUpdate(@RequestBody @Valid User user) {
        if (StrUtil.isEmpty(user.getPassWord())) {
            return JsonResult.error("密码为空，请填写密码！");
        }
        //密码加密存储
        user.setPassWord(MD5Util.MD5(user.getPassWord()));
        //判断手机号，这里用hutool工具类也可以
        if (!PhoneUtil.checkMobile(user.getPhone())) {
            return JsonResult.error("手机号码格式错误！");
        }
        userService.updateUser(user);
        return JsonResult.success();
    }

    /**
     * 删除
     * @return
     */
    @PostMapping("/delete/{id}")
    public JsonResult<Object> userDelete(@PathVariable(value = "id") int id) {
        userService.deleteUser(id);
        return JsonResult.success();
    }

}


