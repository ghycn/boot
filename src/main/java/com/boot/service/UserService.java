package com.boot.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.boot.model.UserBean;

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
     * @param userBean
     * @return
     */
    Page findAllUser(Page page, UserBean userBean);
}