package com.neo.service;

import com.neo.entity.Role;
import org.springframework.stereotype.Service;

import java.util.Set;

/**
 * @Author:lichangqing
 * @Description
 * @Date Create in 15:36 2018/3/27
 * @modified By
 */

public interface RoleService {
    int deleteByPrimaryKey(String id);

    int insert(Role record);

    int insertSelective(Role record);

    Role selectByPrimaryKey(String id);

    Set<Role> getAll();

    int updateByPrimaryKeySelective(Role record);

    int updateByPrimaryKey(Role record);
}
