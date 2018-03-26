package com.neo.service;

import com.neo.entity.Resource;
import com.neo.entity.Role;
import com.neo.entity.UserEntity;
import com.neo.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * @Author:lichangqing
 * @Description
 * @Date Create in 15:02 2018/3/5
 * @modified By
 */
@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserMapper userMapper;

    @Override
    public UserDetails loadUserByUsername(String arg0) throws UsernameNotFoundException {
        UserEntity ue = userMapper.getByUsername(arg0);
        if (ue != null) {
            Set<Role> roles = ue.getRoles();

            List<GrantedAuthority> listGa = new ArrayList<GrantedAuthority>();
            for(Role role :roles){
                listGa.add(new SimpleGrantedAuthority(role.getRoleName()));
            }
            ue.setAuthorities(listGa);
            return ue;
        }
        return ue;
    }

    @Override
    public Set<Role> getRoles(String userId) {
        Set<Role> list = userMapper.getRoles(userId);
        return list;
    }

    @Override
    public Set<Resource> getResource(String userId) {
        Set<Resource> list = userMapper.getResource(userId);
        return list;
    }
}
