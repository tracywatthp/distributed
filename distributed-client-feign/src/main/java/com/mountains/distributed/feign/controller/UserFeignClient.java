package com.mountains.distributed.feign.controller;

import com.mountains.distributed.api.client.IUserClientService;
import com.mountains.distributed.api.crm.sys.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.List;

/**
 * @author tinxi
 * @ClassName UserClient
 * @Description 用户模块客户端
 * @date 2019/7/9 18:03
 */
@RestController
@RequestMapping("/client")
public class UserFeignClient {

	private Logger logger = LoggerFactory.getLogger(this.getClass());

	@Autowired
	private IUserClientService userClientService;

	@RequestMapping(value = "/user/add")
	public boolean add(User user) {
		return userClientService.add(user);
	}

	@RequestMapping(value = "/user/get/{id}")
	public User get(@PathVariable("id") Long id) {
		return userClientService.get(id);
	}

	@SuppressWarnings("unchecked")
	@RequestMapping(value = "/user/list")
	public List<User> list() {
		return userClientService.list();
	}

}
