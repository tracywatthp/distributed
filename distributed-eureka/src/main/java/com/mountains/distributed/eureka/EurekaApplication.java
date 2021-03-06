package com.mountains.distributed.eureka;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

/**
 * @author tinxi
 * @ClassName EurekaApplication
 * @Description EurekaServer服务器端启动类
 * @date 2019/7/9 22:14
 */
@SpringBootApplication
@EnableEurekaServer // EurekaServer服务器端启动类, 接受其他微服务注册进来
public class EurekaApplication {

	public static void main(String[] args) {
		SpringApplication.run(EurekaApplication.class, args);
	}

}
