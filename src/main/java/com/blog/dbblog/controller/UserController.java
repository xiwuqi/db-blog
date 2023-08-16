package com.blog.dbblog.controller;

import com.blog.dbblog.entity.User;
import com.blog.dbblog.service.UserService;
import com.blog.dbblog.util.JsonResult;
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

