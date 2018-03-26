package demo;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.security.Principal;

/**
 * @Author:lichangqing
 * @Description
 * @Date Create in 16:51 2018/3/5
 * @modified By
 */
@RestController
public class ResourceController {
    @RequestMapping("/")
    public Message home() {
        return new Message("Hello World");
    }

    @RequestMapping("/json")
    @ResponseBody
    public Message get() {
        return new Message("nihao,pengyou ,woshi lichangqing");
    }

    @RequestMapping("/getUser")
    @ResponseBody
    public Principal getUser(Principal user) {
        return user;
    }
}
