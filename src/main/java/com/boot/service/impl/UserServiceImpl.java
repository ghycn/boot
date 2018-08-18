package com.boot.service.impl;

import com.alibaba.fastjson.JSON;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.boot.mapper.UserMapper;
import com.boot.model.UserBean;
import com.boot.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author ghy
 */
@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserMapper userMapper;


    @Override
    public Page findAllUser(Page page, UserBean userBean) {
       IPage<UserBean> iPage = userMapper.selectPage(page,new QueryWrapper<>(userBean));
        System.out.println(JSON.toJSONString(iPage));
        return page;
    }
}
