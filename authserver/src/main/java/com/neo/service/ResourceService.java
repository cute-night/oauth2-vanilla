package com.neo.service;
import com.neo.entity.Resource;

import java.util.Set;

/**
 * @Author:lichangqing
 * @Description
 * @Date Create in 14:22 2018/3/27
 * @modified By
 */
public interface ResourceService {
    int deleteByPrimaryKey(String id);

    int insert(Resource record);

    int insertSelective(Resource record);

    Resource selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(Resource record);

    int updateByPrimaryKey(Resource record);

    Set<Resource> getAllResources();
}
