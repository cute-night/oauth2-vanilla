package com.neo.web;

import com.neo.entity.Role;
import com.neo.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Set;

/**
 * @Author:lichangqing
 * @Description
 * @Date Create in 15:40 2018/3/27
 * @modified By
 */
@RestController
@RequestMapping("/role")
public class RoleController {
    @Autowired
    RoleService roleService;

    @RequestMapping("/deleteByPrimaryKey")
    public int deleteByPrimaryKey(String id) {
        return roleService.deleteByPrimaryKey(id);
    }

    @RequestMapping("/insert")
    public int insert(Role record) {
        return roleService.insert(record);
    }

    @RequestMapping("/insertSelective")
    public int insertSelective(Role record) {
        return roleService.insertSelective(record);
    }

    @RequestMapping("/selectByPrimaryKey")
    public Role selectByPrimaryKey(String id) {
        return roleService.selectByPrimaryKey(id);
    }

    @RequestMapping("/updateByPrimaryKeySelective")
    public int updateByPrimaryKeySelective(Role record) {
        return roleService.updateByPrimaryKeySelective(record);
    }

    @RequestMapping("/updateByPrimaryKey")
    public int updateByPrimaryKey(Role record) {
        return roleService.updateByPrimaryKey(record);
    }

    @RequestMapping("/getAll")
    public Set<Role> getAll() {
        return roleService.getAll();
    }
}
