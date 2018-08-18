package com.boot.service.impl;

import com.alibaba.fastjson.JSONObject;
import com.boot.mapper.UserMapper;
import com.boot.model.UserBean;
import com.boot.service.UserService;
import com.boot.util.Constants;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author ghy
 */
@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserMapper userMapper;

    @Override
    public PageInfo findAllUser(Integer currentPage,Integer pageSize,String condition) {
        UserBean userBean = JSONObject.parseObject(condition,UserBean.class);
        PageHelper.startPage(currentPage==null? Constants.PAGE_NUM:currentPage, pageSize==null?Constants.PAGE_SIZE:pageSize);
        List<UserBean> userList = userMapper.queryAllUser(userBean);
        return new PageInfo(userList);
    }

    @Override
    public UserBean findUserById(Integer id) {
        return userMapper.selectById(id);
    }

    /**
     * 修改保存用户信息
     *
     * @param userBean
     * @return
     */
    @Override
    public int updateUser(UserBean userBean) {
        return userMapper.updateById(userBean);
    }

    /**
     * 删除用户
     *
     * @param id
     */
    @Override
    public int deleteUserById(int id) {
        return userMapper.deleteById(id);
    }


    /**
     * 根据名字查找用户
     *
     * @param username
     * @return
     */
    @Override
    public UserBean getUser(String username) {
        Map<String,Object> map = new HashMap<String,Object>(16);
        map.put("username",username);
        List<UserBean> list = userMapper.selectByMap(map);
        return list.size()>0?list.get(0):null;
    }

    /**
     * 添加保存用户
     *
     * @param userBean
     */
    @Override
    public int saveUser(UserBean userBean) {
        return userMapper.insert(userBean);
    }
}
