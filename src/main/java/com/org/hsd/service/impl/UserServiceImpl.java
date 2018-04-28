package com.org.hsd.service.impl;

import com.alibaba.fastjson.JSONObject;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.org.hsd.mapper.UserMapper;
import com.org.hsd.model.UserBean;
import com.org.hsd.service.UserService;
import com.org.hsd.util.Constants;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class UserServiceImpl implements UserService{
    @Autowired
    private UserMapper userMapper;

    @Override
    public PageInfo findAllUser(Integer currentPage,Integer pageSize,String condition) {
        UserBean userBean = JSONObject.parseObject(condition,UserBean.class);
//        PageHelper.startPage(currentPage==null? Constants.PAGE_NUM:currentPage, pageSize==null?Constants.PAGE_SIZE:pageSize);
        List<UserBean> userList = userMapper.queryAllUser(userBean);
//        EntityWrapper<UserBean> entry = new EntityWrapper<UserBean>();
//        List<UserBean> userList = userMapper.selectList( entry);

        return new PageInfo(userList);
    }

    @Override
    public UserBean findUserById(int id) {
        return userMapper.selectById(id);
    }

    /**
     * 修改保存用户信息
     *
     * @param UserBean
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
        Map<String,Object> map = new HashMap<String,Object>();
        map.put("username",username);
        List<UserBean> list = userMapper.selectByMap(map);
        return list.size()>0?list.get(0):null;
    }

    /**
     * 添加保存用户
     *
     * @param UserBean
     */
    @Override
    public int saveUser(UserBean userBean) {
        return userMapper.insert(userBean);
    }
}
