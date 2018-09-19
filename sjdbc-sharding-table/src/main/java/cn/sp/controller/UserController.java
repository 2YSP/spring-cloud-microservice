package cn.sp.controller;

import cn.sp.bean.User;
import cn.sp.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * Created by 2YSP on 2018/9/19.
 */
@RestController
@RequestMapping("user")
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping("/add")
    public String addUser(@RequestBody User user){
        userService.save(user);
        return "OK";
    }

    @GetMapping("/{id}")
    public User getUser(@PathVariable("id") Long id){
        return userService.queryById(id);
    }
}
