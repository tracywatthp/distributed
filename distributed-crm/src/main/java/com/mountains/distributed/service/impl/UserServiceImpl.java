package com.mountains.distributed.service.impl;

// import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.mountains.distributed.entity.crm.sys.User;
import com.mountains.distributed.mapper.UserMapper;
import com.mountains.distributed.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author tinxi
 * @ClassName UserServiceImpl
 * @Description 用户实现类
 * @date 2019/7/9 13:30
 */
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements IUserService {

	@Autowired
	private UserMapper userMapper;

	@Override
	public boolean add(User user) {
		// return userMapper.(user) == 1;
		user.setDbName(userMapper.getDataBase());
		return this.saveOrUpdate(user);
	}

	@Override
	public User get(Long id) {
		// return userMapper.selectById(id);
		return userMapper.findById(id);
	}

	@Override
	public List<User> list() {
		System.out.println(1);
		return userMapper.findAll();
	}
}
