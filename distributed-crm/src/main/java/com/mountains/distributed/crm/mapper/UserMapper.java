package com.mountains.distributed.crm.mapper;

// import com.baomidou.mybatisplus.mapper.BaseMapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.mountains.distributed.entity.crm.sys.User;

import java.util.List;

// @Mapper // 配置包扫描可无需加此注解
public interface UserMapper extends BaseMapper<User> {

	boolean addUser(User dept);

	User findById(Long id);

	List<User> findAll();

	/**
	 * 获取数据库实例名
	 * @return
	 */
	String getDataBase();
}