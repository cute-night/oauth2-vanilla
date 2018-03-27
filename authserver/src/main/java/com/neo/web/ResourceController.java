package com.neo.web;

import com.neo.entity.Resource;
import com.neo.entity.UserEntity;
import com.neo.service.ResourceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Set;

/**
 * @Author:lichangqing
 * @Description
 * @Date Create in 14:36 2018/3/27
 * @modified By
 */
@RestController
@RequestMapping("/resource")
public class ResourceController {

    @Autowired
    ResourceService resourceService;

    @RequestMapping("/deleteByPrimaryKey")
    public int deleteByPrimaryKey(String id) {
        return resourceService.deleteByPrimaryKey(id);
    }
    @RequestMapping("/insert")
    public int insert(Resource record) {
        return resourceService.insert(record);
    }
    @RequestMapping("/insertSelective")
    public int insertSelective(Resource record) {
        return resourceService.insertSelective(record);
    }
    @RequestMapping("/selectByPrimaryKey")
    public Resource selectByPrimaryKey(String id) {
        return resourceService.selectByPrimaryKey(id);
    }
    @RequestMapping("/updateByPrimaryKeySelective")
    public int updateByPrimaryKeySelective(Resource record) {
        return resourceService.updateByPrimaryKeySelective(record);
    }
    @RequestMapping("/updateByPrimaryKey")
    public int updateByPrimaryKey(Resource record) {
        return resourceService.updateByPrimaryKey(record);
    }
    @RequestMapping("/getAllResources")
    public Set<Resource> getAllResources() {
        return resourceService.getAllResources();
    }
}
