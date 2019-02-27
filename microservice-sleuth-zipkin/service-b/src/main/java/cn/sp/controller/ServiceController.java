package cn.sp.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author:ship
 * @Description:
 * @Date: Created in 2019/2/27
 */
@RestController
public class ServiceController {

    private final Logger logger = LoggerFactory.getLogger(this.getClass());


    @GetMapping("/test")
    public String test(){
        logger.info("==<Call Service-b>==");
        return "OK";
    }
}
