package cn.sp.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

/**
 * @Author:ship
 * @Description:
 * @Date: Created in 2019/2/27
 */
@RestController
public class ServiceController {

    private final Logger logger = LoggerFactory.getLogger(this.getClass());


    @Autowired
    private RestTemplate restTemplate;

    @GetMapping("/service-a")
    public String test(){
        logger.info("==<Call Service-a>==");
        return restTemplate.getForEntity("http://service-b/test",String.class).getBody();
    }
}
