package com.mountains.distributed.api.client;

import com.mountains.distributed.api.crm.sys.User;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

/**
 * @author tinxi
 * @ClassName IUserClientService
 * @Description TODO
 * @date 2019/7/11 15:52
 */
// @FeignClient("DISTRIBUTED-CRM")  // 单独用feign的配置
@FeignClient(value = "DISTRIBUTED-CRM-HYSTRIX", fallbackFactory = UserClientServiceFallBackFactory.class)  //配置服务熔断回调信息处理类
public interface IUserClientService {

	@RequestMapping(value = "/user/get/{id}", method = RequestMethod.GET)
	User get(@PathVariable("id") long id);

	@RequestMapping(value = "/user/list", method = RequestMethod.GET)
	List<User> list();

	@RequestMapping(value = "/user/add", method = RequestMethod.POST)
	boolean add(User user);

}
