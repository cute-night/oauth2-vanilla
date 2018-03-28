package demo;/**
 * Created by lcqwr on 2018/3/13.
 * describe
 */

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.HashMap;

/**
 * @Author:lichangqing
 * @Description
 * @Date Create in 10:22 2018/3/13
 * @modified By
 */
@RestController
public class UIController {
    @ExceptionHandler
    public HashMap<String,Object> exceptionHandle(){
        HashMap<String,Object> map = new HashMap<>();
        map.put("success","exception:");
        return map;
    }
    @RequestMapping(value="/getMessage")
    public String getMessage (HttpServletRequest request, HttpServletResponse response) {
        return "获取信息";
    }
    @GetMapping(value="/logout")
    public String logoutSuccess (HttpServletRequest request, HttpServletResponse response) {
        HttpSession session = request.getSession();

        Cookie cookie1 = new Cookie("USESSIONID", "");
        cookie1.setDomain("localhost");
        cookie1.setPath("/");
        cookie1.setMaxAge(0);
        response.addCookie(cookie1);
        /*删除server端的cookies*/
        Cookie cookie = new Cookie("JSESSIONID", "");
        cookie.setDomain("localhost");
        cookie.setPath("/uaa");
        cookie.setMaxAge(0);
        response.addCookie(cookie);

        session.invalidate();
        return "退出成功";
    }
}
