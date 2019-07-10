package com.mountains.distributed.client.controller;

import com.mountains.distributed.entity.crm.sys.User;
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
public class UserClient {

	private Logger logger = LoggerFactory.getLogger(this.getClass());

	@Autowired
	private RestTemplate restTemplate;

	private static final String REST_URL_PREFIX = "http://localhost:8001";

	@RequestMapping(value = "/user/add")
	public boolean add(User user) {
		return restTemplate.postForObject(REST_URL_PREFIX + "/user/add", user, Boolean.class);
	}

	@RequestMapping(value = "/user/get/{id}")
	public User get(@PathVariable("id") Long id) {
		return restTemplate.getForObject(REST_URL_PREFIX + "/user/get/" + id, User.class);
	}

	@SuppressWarnings("unchecked")
	@RequestMapping(value = "/user/list")
	public List<User> list() {
		return restTemplate.getForObject(REST_URL_PREFIX + "/user/list", List.class);
	}

	// 测试@EnableDiscoveryClient,消费端可以调用服务发现
	@RequestMapping(value = "/user/discovery")
	public Object discovery() {
		return restTemplate.getForObject(REST_URL_PREFIX + "/user/discovery", Object.class);
	}

}
