package cn.sp.service;

import cn.sp.bean.User;
import cn.sp.dao.UserDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by 2YSP on 2018/9/19.
 */
@Service
public class UserService {

    @Autowired
    private UserDao userDao;

    public void save(User user){
        userDao.save(user);
    }

    public User queryById(Long id){
       return userDao.queryById(id);
    }
}
