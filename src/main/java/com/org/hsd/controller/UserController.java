package com.org.hsd.controller;

import com.github.pagehelper.PageInfo;
import com.org.hsd.model.UserBean;
import com.org.hsd.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * Created by Administrator on 2017/2/9.
 */
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
    public PageInfo  userList(Integer currentPage,Integer pageSize,String condition){
        return userService.findAllUser(currentPage,pageSize,condition);
    }

    /**
     * 根据ID查询用户
     */
    @GetMapping(value = "/{id}")
    public UserBean UserBean(@PathVariable("id") int id){
        return userService.findUserById(id);
    }

    /**
     * 修改保存用户
     */
    @PutMapping(value = "/")
    public int  updateUser(@RequestBody UserBean UserBean){
        return userService.updateUser(UserBean);
    }

    /**
     * 添加保存用户
     */
    @PostMapping(value = "/")
    public int saveUser(@RequestBody UserBean UserBean){
        return userService.saveUser(UserBean);
    }

    /**
     * 删除用户
     */
    @DeleteMapping(value = "/{id}")
    public int deleteUser(@PathVariable("id") int id){
        return userService.deleteUserById(id);
    }


    @RequestMapping("/hello")
    public String hello(){
        return "hello";
    }
}