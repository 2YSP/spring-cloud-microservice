package cn.sp.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author ship
 * @Description
 * @Date: 2018-07-25 10:52
 */
@RestController
@RefreshScope
public class ConfigClientController {


    @Value("${profile}")
    private String profile;


    @GetMapping("/profile")
    public String hello(){
        return this.profile;
    }
}
