package com.neo.mapper;

import com.neo.entity.Role;
import org.springframework.stereotype.Repository;

import java.util.Set;

@Repository
public interface RoleMapper {
    int deleteByPrimaryKey(String id);

    int insert(Role record);

    int insertSelective(Role record);

    Role selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(Role record);

    int updateByPrimaryKey(Role record);

    Set<Role> getAll();
}