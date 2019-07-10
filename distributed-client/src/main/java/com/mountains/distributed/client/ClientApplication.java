package com.mountains.distributed.client;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

/**
 * @author tinxi
 * @ClassName Client
 * @Description 用户模块客户端(消费者)
 * @date 2019/7/9 18:51
 */
@SpringBootApplication(exclude = DataSourceAutoConfiguration.class)
public class ClientApplication {

	public static void main(String[] args) {
		SpringApplication.run(ClientApplication.class, args);
	}

}
