package com.neo.web;

import java.security.Principal;
import java.util.List;
import java.util.Map;
import java.util.Set;

import com.neo.entity.Resource;
import com.neo.entity.Role;
import com.neo.enums.UserSexEnum;
import com.neo.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.AccessDeniedException;
import javax.servlet.http.HttpSession;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.oauth2.provider.authentication.OAuth2AuthenticationDetails;
import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;
import org.springframework.web.bind.annotation.*;

import com.neo.entity.UserEntity;
import com.neo.mapper.UserMapper;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author lcqwr
 */
@RestController
public class UserController {
    private static final Logger log = LoggerFactory.getLogger(UserController.class);

    @Autowired
	private UserMapper userMapper;
    @Autowired
    private UserService userService;
	
	@RequestMapping("/getUsers")
	public List<UserEntity> getUsers() {
		List<UserEntity> users=userMapper.getAll();
		return users;
	}
	
    @RequestMapping("/getUser")
    public UserEntity getUser(Long id) {
    	UserEntity user=userMapper.getOne(id);
        return user;
    }
    @RequestMapping("/getCurrentUser")
    public UserEntity getUser() {
	    String username = SecurityContextHolder.getContext().getAuthentication().getName();
        UserEntity user = userMapper.getByUsername(username);
        return user;
    }
    @RequestMapping("/loginSuccess")
    @ResponseBody
    public String loginSuccess(Long id) {
        UserEntity user=new UserEntity();
        user.setId("userIdaaaaaaaaaaaaaaaaa");
        user.setNickName("joker");
        user.setPassword("123456");
        user.setUsername("lichangqing");
        user.setUserSex(UserSexEnum.MAN);
        userMapper.insert(user);
        return "添加成功";
    }
    
    @RequestMapping("/add")
    public void save(UserEntity user) {
    	userMapper.insert(user);
    }
    
    @RequestMapping(value="update")
    public void update(UserEntity user) {
    	userMapper.update(user);
    }
    
    @RequestMapping(value="/delete/{id}")
    public void delete(@PathVariable("id") Long id) {
    	userMapper.delete(id);
    }

    @RequestMapping(value="getRoles")
    public Set<Role> getRoles(String userId) {
        Set<Role> list = userService.getRoles(userId);
        return list;
    }

    @RequestMapping("/userLogout")
    @ResponseBody
    public String logout(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse) {
        log.info("请求退出系统："+httpServletRequest.getRequestURL());
        SecurityContext securityContext = SecurityContextHolder.getContext();
        securityContext.setAuthentication((Authentication)null);
        /*securityContext.getAuthentication().setAuthenticated(false);*/
        SecurityContextHolder.clearContext();
        httpServletRequest.removeAttribute(OAuth2AuthenticationDetails.ACCESS_TOKEN_VALUE);

        HttpSession session = httpServletRequest.getSession(false);

        if(session!=null){
            System.out.println("session 不为空"+session.getId());
            session.invalidate();
        }
        return "退出成功";
    }

    @RequestMapping(value="getResource")
    public Set<Resource> getResource(String userId) {
        Set<Resource> list = userService.getResource(userId);
        return list;
    }
    /**
     * 登录认证异常
     */
    @ExceptionHandler({AccessDeniedException.class })
    public  void authenticationException(HttpServletRequest request, HttpServletResponse response) {
        response.setStatus(401);
    }
}