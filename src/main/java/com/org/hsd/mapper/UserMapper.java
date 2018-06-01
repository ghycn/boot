package com.org.hsd.mapper;

import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.org.hsd.model.UserBean;

import java.util.List;

/**
 * @author ghy
 */
public interface UserMapper extends BaseMapper<UserBean> {

    /**
     * 根据ID删除用户
     * @param id
     * @return
     */
    int deleteByPrimaryKey(Integer id);

    /**
     * 添加用户
     * @param record
     * @return
     */
    @Override
    Integer insert(UserBean record);

    /**
     * 添加用户
     * @param record
     * @return
     */
    int insertSelective(UserBean record);

    /**
     * 查询用户
     * @param id
     * @return
     */
    UserBean selectByPrimaryKey(Integer id);

    /**
     * 修改
     * @param record
     * @return
     */
    int updateByPrimaryKeySelective(UserBean record);

    /**
     * 修改
     * @param record
     * @return
     */
    int updateByPrimaryKey(UserBean record);

    /**
     * 查询用户
     * @param user
     * @return
     */
    List<UserBean> queryAllUser(UserBean user);

    /**
     * 查询用户根据用户名
     * @param username
     * @return
     */
    UserBean getUser(String username);
}