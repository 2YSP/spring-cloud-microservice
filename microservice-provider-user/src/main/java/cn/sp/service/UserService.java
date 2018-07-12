package cn.sp.service;

import cn.sp.bean.User;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;

/**
 * Created by 2YSP on 2018/7/8.
 */
@Service
public class UserService {

    public User findById(Long id){
        User user = new User();
        user.setId(id);
        user.setUsername("xxx");
        user.setName("zhangsan");
        user.setAge(22);
        user.setBalance(new BigDecimal("100"));
        return user;
    }
}
