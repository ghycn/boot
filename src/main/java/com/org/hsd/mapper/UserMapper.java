package com.org.hsd.mapper;

import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.org.hsd.model.UserBean;

import java.util.List;
public interface UserMapper extends BaseMapper<UserBean> {
//    int deleteByPrimaryKey(Integer id);
//
//    Integer insert(UserBean record);
//
//    int insertSelective(UserBean record);
//
//    UserBean selectByPrimaryKey(Integer id);
//
//    int updateByPrimaryKeySelective(UserBean record);
//
//    int updateByPrimaryKey(UserBean record);

    List<UserBean> queryAllUser(UserBean user);

//    UserBean getUser(String username);
}