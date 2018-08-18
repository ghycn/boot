package com.boot.controller;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.boot.model.UserBean;
import com.boot.service.UserService;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 *
 * @author Administrator
 * @date 2017/2/9
 */
@Api
@RestController
@RequestMapping(value = "/users")
public class UserController {

    @Autowired
    private UserService userService;


    /**
     * 查询用户列表
     * @return
     */
    @GetMapping(value = "/")
    public Page userList(Page page, UserBean userBean){
        return userService.findAllUser(page,userBean);
    }

}
