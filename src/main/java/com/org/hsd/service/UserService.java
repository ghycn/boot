package com.org.hsd.service;

import com.github.pagehelper.PageInfo;
import com.org.hsd.model.UserBean;

public interface UserService {

    /**
     * 查询用户信息
     * @return
     */
    PageInfo findAllUser(Integer currentPage, Integer pageSize, String condition);

    /**
     * 根据ID查询用户
     * @param id
     * @return
     */
    UserBean findUserById(int id);

    /**
     * 修改保存用户信息
     * @param UserBean
     * @return
     */
    int updateUser(UserBean UserBean);

    /**
     * 删除用户
     */
    int deleteUserById(int id);

    /**
     * 添加保存用户
     */
    int saveUser(UserBean UserBean);

    /**
     * 根据名字查找用户
     * @param username
     * @return
     */
    UserBean getUser(String username);

}