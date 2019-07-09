package com.mountains.distributed.controller;

import com.mountains.distributed.entity.crm.sys.User;
import com.mountains.distributed.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author tinxi
 * @ClassName UserController
 * @Description TODO
 * @date 2019/7/9 13:28
 */
@RestController
@RequestMapping("/user")
public class UserController {

	@Autowired
	private IUserService userServiceImpl;
	private IUserService getService() {
		return userServiceImpl;
	}

	@RequestMapping(value = "/add", method = RequestMethod.POST)
	public boolean add(@RequestBody User user) {
		return getService().add(user);
	}

	@RequestMapping(value = "/get/{id}", method = RequestMethod.GET)
	public User get(@PathVariable("id") Long id) {
		return getService().get(id);
	}

	@RequestMapping(value = "/list", method = RequestMethod.GET)
	public List<User> list() {
		return getService().list();
	}
}
