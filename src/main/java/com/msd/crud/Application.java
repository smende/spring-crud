package com.msd.crud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
//@EnableEurekaClient
//@RestController
@EnableAspectJAutoProxy(proxyTargetClass=true)
public class Application {

//	@Bean
//	@LoadBalanced
//	public RestTemplate restTemplate() {
//	    return new RestTemplate();
//	}
	
//	@Autowired
//	private RestTemplate rt;
	
	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}

	
}
