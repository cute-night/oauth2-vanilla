package demo;/**
 * Created by lcqwr on 2018/3/26.
 * describe
 */

import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.logout.LogoutSuccessHandler;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

/**
 * @Author:lichangqing
 * @Description
 * @Date Create in 20:11 2018/3/26
 * @modified By
 */
public class MyLogoutSuccessHandler implements LogoutSuccessHandler {
    @Override
    public void onLogoutSuccess(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Authentication authentication) throws IOException, ServletException {
        if (httpServletRequest.getSession() != null) {
            HttpSession session = httpServletRequest.getSession();
            Cookie[] cookies = httpServletRequest.getCookies();
           /* *//*删除UI服务器的cookies*//*
            for (int i = 0; i < cookies.length; i++) {
                Cookie cookie = cookies[i];
                cookie.setPath("/");
                cookie.setMaxAge(0);
*//*                cookie.setValue("ddddddddddddd");*//*
                httpServletResponse.addCookie(cookie);
            }*/
            /*删除UI端的cookies*/
            Cookie cookie1 = new Cookie("JSESSIONID", "");
            cookie1.setDomain("localhost");
            cookie1.setPath("/");
            cookie1.setMaxAge(0);
            httpServletResponse.addCookie(cookie1);
            System.out.println("退出成功sessionId" + session.getId());
            /*删除server端的cookies*/
            Cookie cookie = new Cookie("JSESSIONID", "");
            cookie.setDomain("localhost");
            cookie.setPath("/uaa");
            cookie.setMaxAge(0);
            httpServletResponse.addCookie(cookie);
            System.out.println("退出成功sessionId" + session.getId());
        }
    }
}
