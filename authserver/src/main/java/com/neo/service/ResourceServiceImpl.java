package com.neo.service;/**
 * Created by lcqwr on 2018/3/27.
 * describe
 */

import com.neo.entity.Resource;
import com.neo.mapper.ResourceMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Set;

/**
 * @Author:lichangqing
 * @Description
 * @Date Create in 14:22 2018/3/27
 * @modified By
 */
@Service
public class ResourceServiceImpl implements ResourceService {

    @Autowired
    ResourceMapper resourceMapper;

    @Override
    public int deleteByPrimaryKey(String id) {
        return resourceMapper.deleteByPrimaryKey(id);
    }

    @Override
    public int insert(Resource record) {
        return resourceMapper.insert(record);
    }

    @Override
    public int insertSelective(Resource record) {
        return resourceMapper.insertSelective(record);
    }

    @Override
    public Resource selectByPrimaryKey(String id) {
        return resourceMapper.selectByPrimaryKey(id);
    }

    @Override
    public int updateByPrimaryKeySelective(Resource record) {
        return resourceMapper.updateByPrimaryKeySelective(record);
    }

    @Override
    public int updateByPrimaryKey(Resource record) {
        return resourceMapper.updateByPrimaryKey(record);
    }

    @Override
    public Set<Resource> getAllResources() {
        return resourceMapper.getAllResources();
    }
}
