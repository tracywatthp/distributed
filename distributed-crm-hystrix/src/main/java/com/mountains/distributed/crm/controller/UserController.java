package com.mountains.distributed.crm.controller;

import com.mountains.distributed.api.crm.sys.User;
import com.mountains.distributed.crm.service.IUserService;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author tinxi
 * @ClassName UserController
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

	// 通过此方式进行服务熔断会造成该类里的方法膨胀,且熔断逻辑与业务逻辑高度融和, 故需将此熔断机制抽离出去, 放到service中
	@HystrixCommand(fallbackMethod = "defaultStores") // 当需要用hystrix dashboard进行监控必须要配置HystrixCommand 及 fallbackMethod
	@RequestMapping(value = "/get/{id}", method = RequestMethod.GET)
	public User get(@PathVariable("id") Long id) {
		User user = getService().get(id);
		if (null == user) {
			throw new RuntimeException("no object in DB");
		}
		return user;
	}

	/**
	 * 报错后调用的方法
	 * @param id
	 * @return
	 */
	public User defaultStores(@PathVariable("id") Long id) {
		return new User().setId(id)
				.setUserName("该id" + id + "没有对应的信息,null--@HystrixCommand")
				.setDbName("no this database in MySQL");
	}

	@RequestMapping(value = "/list", method = RequestMethod.GET)
	public List<User> list() {
		return getService().list();
	}
}
