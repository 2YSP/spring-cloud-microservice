package cn.sp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.feign.EnableFeignClients;

/**
 * Feign整合Hystrix
 */
@EnableFeignClients
@EnableEurekaClient
@SpringBootApplication
public class MicroserviceConsumerMovieFeignHystrixFallbackFactoryApplication {

	public static void main(String[] args) {
		SpringApplication.run(MicroserviceConsumerMovieFeignHystrixFallbackFactoryApplication.class, args);
	}
}
