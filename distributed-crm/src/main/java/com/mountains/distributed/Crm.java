package com.mountains.distributed;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan({"com.mountains.distributed.**.mapper"}) // mapper扫描路径
public class Crm {

	public static void main(String[] args) {
		SpringApplication.run(Crm.class, args);
	}
}
