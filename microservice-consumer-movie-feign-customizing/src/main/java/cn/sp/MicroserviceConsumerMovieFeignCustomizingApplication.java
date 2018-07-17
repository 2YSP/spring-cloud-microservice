package cn.sp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.feign.EnableFeignClients;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

/**
 * 使用Feign进行声明式的REST Full API调用
 */
@EnableFeignClients(basePackages = {"cn.sp.client"})
@EnableEurekaClient
@SpringBootApplication
public class MicroserviceConsumerMovieFeignCustomizingApplication {

	@Bean
	public RestTemplate restTemplate(){
		return new RestTemplate();
	}

	public static void main(String[] args) {
		SpringApplication.run(MicroserviceConsumerMovieFeignCustomizingApplication.class, args);
	}
}
