package com.neo.mapper;

import java.util.List;
import java.util.Map;
import java.util.Set;

import com.neo.entity.Resource;
import com.neo.entity.Role;
import com.neo.entity.UserEntity;
import javafx.scene.effect.SepiaTone;
import org.springframework.stereotype.Repository;


@Repository
public interface UserMapper {
	List<UserEntity> getAll();
	
	UserEntity getOne(Long id);
	
	UserEntity getByUsername(String userName);

	void insert(UserEntity user);

	void update(UserEntity user);

	void delete(Long id);

	Set<Role> getRoles(String userId);

	Set<Resource> getResource(String roleIds);
}