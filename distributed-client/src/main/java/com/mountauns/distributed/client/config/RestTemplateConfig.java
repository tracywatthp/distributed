package com.mountauns.distributed.client.config;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

/**
 * @author tinxi
 * @ClassName RestTemplateConfig
 * @Description TODO
 * @date 2019/7/9 21:07
 */
@Configuration
public class RestTemplateConfig {

	private Logger logger = LoggerFactory.getLogger(this.getClass());

	@Bean
	public RestTemplate getRestTemplate() {
		return new RestTemplate();
	}

}
