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
public class MyLogoutSuccessHandler implements LogoutSuccessHandler{
    @Override
    public void onLogoutSuccess(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Authentication authentication) throws IOException, ServletException {
        if(httpServletRequest.getSession()!=null){
            HttpSession session = httpServletRequest.getSession();
            Cookie[] cookies = httpServletRequest.getCookies();
            for(int i = 0;i<cookies.length;i++){
                Cookie cookie = cookies[i];
                System.out.println(i+"-----------------"+cookie.getName()+""+cookie.getValue());
                cookie.setMaxAge(0);
                httpServletResponse.addCookie(cookie);
                System.out.println(i+"----------------------"+cookie.getName()+""+cookie.getValue());
            }
            System.out.println("退出成功sessionId"+session.getId());
            session.invalidate();
        }
    }
}
