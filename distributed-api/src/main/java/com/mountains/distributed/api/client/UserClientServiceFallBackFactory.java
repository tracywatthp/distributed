package com.mountains.distributed.api.client;

import com.mountains.distributed.api.crm.sys.User;
import feign.hystrix.FallbackFactory;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * @author tinxi
 * @ClassName UserClientServiceFallBackFactory
 * @Description 服务降级处理
 * @date 2019/7/11 22:14
 */
@Component
public class UserClientServiceFallBackFactory implements FallbackFactory<IUserClientService> {

	@Override
	public IUserClientService create(Throwable throwable) {
		return new IUserClientService() {
			@Override
			public User get(long id) {
				return new User().setId(id)
						.setUserName("该ID：" + id + "没有没有对应的信息,Consumer客户端提供的降级信息,此刻服务Provider已经关闭")
						.setDbName("no this database in MySQL");
			}

			@Override
			public List<User> list() {
				return null;
			}

			@Override
			public boolean add(User user) {
				return false;
			}
		};
	}
}
