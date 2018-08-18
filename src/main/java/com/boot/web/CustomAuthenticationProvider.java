package com.boot.web;

import com.boot.util.SpringUtil;
import com.boot.model.UserBean;
import com.boot.service.UserService;
import com.boot.service.impl.UserServiceImpl;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.GrantedAuthority;
import java.util.ArrayList;


/**
 * 登录认证
 * @author ghy
 */
public class CustomAuthenticationProvider  implements AuthenticationProvider {
    private UserService userService;

    @Override
    public Authentication authenticate(Authentication authentication) throws AuthenticationException {
        // 获取认证的用户名 & 密码
        String name = authentication.getName();
        String password = authentication.getCredentials().toString();

        userService = SpringUtil.getBean(UserServiceImpl.class);
        return null;
//        UserBean user = userService.getUser(name);
//        if(user!=null && user.getPassword().equals(password)){
//            // 这里设置权限和角色
//            ArrayList<GrantedAuthority> authorities = new ArrayList<>();
//            // 生成令牌
//            Authentication auth = new UsernamePasswordAuthenticationToken(name, password, authorities);
//            return auth;
//        }else {
//            throw new BadCredentialsException("密码错误~");
//        }
    }

    /**
     *  是否可以提供输入类型的认证服务
     */
    @Override
    public boolean supports(Class<?> authentication) {
        return authentication.equals(UsernamePasswordAuthenticationToken.class);
    }
}
