package com.neo.security;

import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.Collection;

/**
 * @Author:lichangqing
 * @Description
 * @Date Create in 14:58 2018/3/5
 * @modified By
 */
@Component
public class MyAuthenticationProvider implements AuthenticationProvider {

    @Resource
    private UserDetailsService userService;

    /**
     * 自定义验证方式
     */
    @Override
    public Authentication authenticate(Authentication authentication) throws AuthenticationException {
        String username = authentication.getName();
        String password = (String) authentication.getCredentials();     //密码或者验证码
        UserDetails user = userService.loadUserByUsername(username);

        if(password.equals(username+"123")){
            System.out.println("通过验证码认证");
        }else{
            if(user == null){
                throw new BadCredentialsException("Username not found.");

            }
            //加密过程在这里体现
            if (!password.equals(user.getPassword())) {
                throw new BadCredentialsException("Wrong password.");
            }
        }

        Collection<? extends GrantedAuthority> authorities = user.getAuthorities();

        UsernamePasswordAuthenticationToken usernamePasswordAuthenticationToken = new UsernamePasswordAuthenticationToken(user, password, authorities);
        System.out.println(usernamePasswordAuthenticationToken.toString());
        return usernamePasswordAuthenticationToken;
    }

    @Override
    public boolean supports(Class<?> arg0) {
        return true;
    }

}
