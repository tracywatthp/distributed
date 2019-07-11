package com.mountains.distributed.client;

import com.mountains.distributed.balance.MyRule1;
import com.mountains.distributed.balance.MyRule2;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.ribbon.RibbonClient;

/**
 * @author tinxi
 * @ClassName Client
 * @Description 用户模块客户端(消费者)
 * @date 2019/7/9 18:51
 */
@SpringBootApplication(exclude = DataSourceAutoConfiguration.class)
@EnableEurekaClient
//在启动该微服务的时候就能去加载我们的自定义Ribbon配置类，从而使配置生效
// @RibbonClient(name="DISTRIBUTED-CRM",configuration=MyRule2.class)
public class ClientApplication {

	public static void main(String[] args) {
		SpringApplication.run(ClientApplication.class, args);
	}

}
