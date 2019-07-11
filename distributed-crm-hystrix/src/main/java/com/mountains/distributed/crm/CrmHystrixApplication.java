package com.mountains.distributed.crm;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@MapperScan({"com.mountains.distributed.**.mapper"}) // mapper扫描路径
@EnableEurekaClient  //本服务启动后会自动注册进eureka服务中
@EnableCircuitBreaker //对hystrixR熔断机制的支持
public class CrmHystrixApplication {

	public static void main(String[] args) {
		SpringApplication.run(CrmHystrixApplication.class, args);
	}

}
