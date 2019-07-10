package com.mountains.distributed.service;

import com.mountains.distributed.entity.crm.sys.User;

import java.util.List;

/**
 * @author tinxi
 * @className IUserService
 * @date 2019/7/9 13:29
 */
public interface IUserService {

	boolean add(User dept);

	User get(Long id);

	List<User> list();
}
