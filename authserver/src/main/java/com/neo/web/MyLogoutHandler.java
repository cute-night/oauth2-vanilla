package com.neo.web;/**
 * Created by lcqwr on 2018/3/23.
 * describe
 */

import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.logout.LogoutSuccessHandler;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @Author:lichangqing
 * @Description
 * @Date Create in 11:45 2018/3/23
 * @modified By
 */
public class MyLogoutHandler implements LogoutSuccessHandler {
    @Override
    public void onLogoutSuccess(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Authentication authentication) throws IOException, ServletException {
            System.out.println("退出了单点登录系统");
    }
}
