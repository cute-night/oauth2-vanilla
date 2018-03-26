package demo;/**
 * Created by lcqwr on 2018/3/13.
 * describe
 */

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
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
}
