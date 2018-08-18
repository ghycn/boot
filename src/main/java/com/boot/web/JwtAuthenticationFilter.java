package com.boot.web;

import com.boot.util.JwtUtils;
import com.boot.util.ResponseBean;
import org.springframework.http.HttpStatus;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.filter.GenericFilterBean;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.util.ArrayList;

/**
 * jwt权限认证
 */
public class JwtAuthenticationFilter extends GenericFilterBean {
    @Override
    public void doFilter(ServletRequest request,ServletResponse response,FilterChain filterChain)throws IOException, ServletException {

        HttpServletRequest req = (HttpServletRequest) request;

        //获取Token
        String token = req.getHeader(JwtUtils.AUTHORIZATION);

        if (!JwtUtils.validate(token)) {//验证Token
            filterChain.doFilter(request, response);
            return;
        }
        String username = JwtUtils.parseJWT(token);

        UsernamePasswordAuthenticationToken authenticationToken = null;
        if(username!=null){
            authenticationToken = new UsernamePasswordAuthenticationToken(username, null, new ArrayList<>());
        }

        if(authenticationToken==null){
            response.setContentType("application/json");
            response.setCharacterEncoding("UTF-8");
            response.getWriter().println(ResponseBean.resultString(HttpStatus.UNAUTHORIZED.value(), "认证失败！", null));
            return;
        }
        SecurityContextHolder.getContext().setAuthentication(authenticationToken);
        filterChain.doFilter(request, response);
    }
}
