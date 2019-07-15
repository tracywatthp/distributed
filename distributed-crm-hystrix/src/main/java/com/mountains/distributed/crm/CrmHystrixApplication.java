package com.mountains.distributed.crm;

import com.netflix.hystrix.contrib.metrics.eventstream.HystrixMetricsStreamServlet;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
@MapperScan({"com.mountains.distributed.**.mapper"}) // mapper扫描路径
@EnableEurekaClient  //本服务启动后会自动注册进eureka服务中
@EnableCircuitBreaker //对hystrixR熔断机制的支持
public class CrmHystrixApplication {

	public static void main(String[] args) {
		SpringApplication.run(CrmHystrixApplication.class, args);
	}

	// @Bean
	// public ServletRegistrationBean hystrixMetricsStreamServlet() {
	// 	ServletRegistrationBean registration = new ServletRegistrationBean(new HystrixMetricsStreamServlet());
	// 	registration.addUrlMappings("/hystrix.stream");
	// 	return registration;
	// }

	/**
	 * 低版本直接启动即可使用 http://ip:port/hystrix.stream 查看监控信息
	 * 高版本需要添加本方法方可使用 http://ip:port/hystix.stream 查看监控信息
	 * @return
	 */
	@Bean
	public ServletRegistrationBean getServlet() {
		HystrixMetricsStreamServlet streamServlet = new HystrixMetricsStreamServlet();
		ServletRegistrationBean registrationBean = new ServletRegistrationBean(streamServlet);
		// registrationBean.setLoadOnStartup(1);
		registrationBean.addUrlMappings("/hystrix.stream");
		registrationBean.setName("HystrixMetricsStreamServlet");
		return registrationBean;
	}

}
