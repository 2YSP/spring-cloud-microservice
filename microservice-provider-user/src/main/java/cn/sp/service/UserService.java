package cn.sp.service;

import cn.sp.bean.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;

/**
 * Created by 2YSP on 2018/7/8.
 */
@Service
public class UserService {

    private static  final Logger log = LoggerFactory.getLogger(UserService.class);


    public User findById(Long id){
        User user = new User();
        user.setId(id);
        user.setUsername("xxx");
        user.setName("zhangsan");
        user.setAge(22);
        user.setBalance(new BigDecimal("100"));
        log.info("========模拟查询数据库,id:{}",id);
        return user;
    }
}
