package cn.sp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

/**
 * 也可以用@EnableDiscoveryClient来代替@EnableEurekaClient，只不过前者是SpringCloud提供的更通用
 */
@EnableEurekaClient
@SpringBootApplication
public class MicroserviceProviderUserApplication {

	public static void main(String[] args) {
		SpringApplication.run(MicroserviceProviderUserApplication.class, args);
	}
}
