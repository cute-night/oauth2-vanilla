package demo;/**
 * Created by lcqwr on 2018/3/26.
 * describe
 */

import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.logout.LogoutHandler;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * @Author:lichangqing
 * @Description
 * @Date Create in 19:57 2018/3/26
 * @modified By
 */
public class MylogoutHandler implements LogoutHandler {
    @Override
    public void logout(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Authentication authentication) {
        if(httpServletRequest.getSession()!=null){
            HttpSession session = httpServletRequest.getSession();
            System.out.println("sessionId"+session.getId());
            session.invalidate();
        }
    }
}
