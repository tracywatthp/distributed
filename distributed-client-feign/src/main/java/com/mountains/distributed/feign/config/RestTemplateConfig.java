package com.mountains.distributed.feign.config;

import com.netflix.loadbalancer.IRule;
import com.netflix.loadbalancer.RandomRule;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

/**
 * @author tinxi
 * @ClassName RestTemplateConfig
 * @date 2019/7/9 21:07
 */
@Configuration
public class RestTemplateConfig {

	private Logger logger = LoggerFactory.getLogger(this.getClass());

	@Bean
	@LoadBalanced // 默认负载策略为轮询
	public RestTemplate getRestTemplate() {
		return new RestTemplate();
	}

	@Bean // 如果没有自定义的IRule则启用默认的负载策略(默认为轮询), 也可在启动类增加自定义的负载策略
	public IRule myRule() {
		return new RandomRule();    // 随机策略
	}

}
