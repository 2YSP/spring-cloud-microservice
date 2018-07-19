package cn.sp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.hystrix.EnableHystrix;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

/**
 * 消费者的简单示例
 */
@EnableHystrix//或者@EnableCircuitBreaker，启用断路器
@EnableEurekaClient
@SpringBootApplication
public class MicroserviceConsumerMovieRibbonHystrixApplication {


	@Bean
	@LoadBalanced//使其具有负载均衡能力
	public RestTemplate restTemplate(){
		return new RestTemplate();
	}

	public static void main(String[] args) {
		SpringApplication.run(MicroserviceConsumerMovieRibbonHystrixApplication.class, args);
	}
}
