package com.mountains.distributed;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@MapperScan({"com.mountains.distributed.**.mapper"}) // mapper扫描路径
@EnableEurekaClient  //本服务启动后会自动注册进eureka服务中
public class Crm {

	public static void main(String[] args) {
		SpringApplication.run(Crm.class, args);
	}
}
