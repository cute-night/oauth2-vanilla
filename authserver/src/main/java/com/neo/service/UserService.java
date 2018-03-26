package com.neo.service;

import com.neo.entity.Resource;
import com.neo.entity.Role;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;

import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * @Author:lichangqing
 * @Description
 * @Date Create in 15:03 2018/3/5
 * @modified By
 */
public interface UserService extends UserDetailsService{
    @Override
    UserDetails loadUserByUsername(String username);
    Set<Role> getRoles(String userId);
    Set<Resource> getResource(String userId);
}
