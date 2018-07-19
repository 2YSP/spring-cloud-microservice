package cn.sp.controller;

import cn.sp.bean.User;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.loadbalancer.LoadBalancerClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.math.BigDecimal;

/**
 * 请求用户微服务的API
 * Created by 2YSP on 2018/7/8.
 */
@RestController
public class MovieController {

    @Autowired
    private LoadBalancerClient loadBalancerClient;

    @Autowired
    private RestTemplate restTemplate;

    private static final Logger logger = LoggerFactory.getLogger(MovieController.class);


    @HystrixCommand(fallbackMethod = "findByIdFallBack")
    @GetMapping("/user/{id}")
    public User findById(@PathVariable Long id){
        //microservice-provider-user是虚拟主机名，默认和服务名称一致
        //不能包括"_"之类的字符，否则Ribbon在调用时会报异常
        return this.restTemplate.getForObject("http://microservice-provider-user/"+id,User.class);
    }

    public User findByIdFallBack(Long id){
        User user = new User();
        user.setId(-1L);
        user.setAge(0);
        user.setBalance(BigDecimal.ZERO);
        user.setName("默认用户");
        user.setUsername("默认用户");
        return user;
    }
}
