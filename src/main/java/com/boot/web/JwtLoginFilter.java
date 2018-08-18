package com.boot.web;

import com.boot.util.JwtUtils;
import com.boot.util.ResponseBean;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.boot.model.UserBean;
import org.springframework.http.HttpStatus;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.AbstractAuthenticationProcessingFilter;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class JwtLoginFilter extends AbstractAuthenticationProcessingFilter {
    public JwtLoginFilter(String url, AuthenticationManager authManager) {
        super(new AntPathRequestMatcher(url));
        setAuthenticationManager(authManager);
    }

    //登录时需要验证时候调用
    @Override
    public Authentication attemptAuthentication(
            HttpServletRequest req, HttpServletResponse res)
            throws AuthenticationException, IOException, ServletException {

        // JSON反序列化成 AccountCredentials
        UserBean creds = new ObjectMapper().readValue(req.getInputStream(), UserBean.class);

        // 返回一个验证令牌
        return getAuthenticationManager().authenticate(
                new UsernamePasswordAuthenticationToken(
                        creds.getUsername(),
                        creds.getPassword()
                )
        );
    }


    /**
     * 验证成功后调用
     */
    @Override
    protected void successfulAuthentication(HttpServletRequest req,HttpServletResponse res, FilterChain chain,Authentication auth) throws IOException {
        //创建jwt
        String tokenStr = JwtUtils.createJWT(auth);
        res.setContentType("application/json");
        res.setCharacterEncoding("utf-8");
        res.getWriter().println(ResponseBean.resultString(HttpStatus.OK.value(), "登录成功！", tokenStr));
    }


    //验证失败后调用
    @Override
    protected void unsuccessfulAuthentication(HttpServletRequest request, HttpServletResponse response, AuthenticationException failed) throws IOException {
        response.setContentType("application/json");
        response.setCharacterEncoding("UTF-8");
        response.getWriter().println(ResponseBean.resultString(HttpStatus.UNAUTHORIZED.value(), "登录失败！", null));
    }
}
