package com.org.hsd.service;

import com.github.pagehelper.PageInfo;
import com.org.hsd.model.UserBean;

/**
 * @author ghy
 */
@SuppressWarnings("ALL")
public interface UserService {


    /**
     * 查询所有用户
     * @param currentPage
     * @param pageSize
     * @param condition
     * @return
     */
    PageInfo findAllUser(Integer currentPage, Integer pageSize, String condition);

    /**
     * 根据ID查询用户
     * @param id
     * @return
     */
    UserBean findUserById(Integer id);

    /**
     * 修改保存用户信息
     * @param userBean
     * @return
     */
    int updateUser(UserBean userBean);

    /**
     * 删除用户
     * @param id
     * @return
     */
    int deleteUserById(int id);

    /**
     * 添加保存用户
     * @param userBean
     * @return
     */
    int saveUser(UserBean userBean);

    /**
     * 根据名字查找用户
     * @param username
     * @return
     */
    UserBean getUser(String username);

}