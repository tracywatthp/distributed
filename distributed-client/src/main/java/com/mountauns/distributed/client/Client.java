package com.mountauns.distributed.client;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
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
public class Client {

	private Logger logger = LoggerFactory.getLogger(this.getClass());

	public static void main(String[] args) {
		SpringApplication.run(Client.class, args);
	}

}
