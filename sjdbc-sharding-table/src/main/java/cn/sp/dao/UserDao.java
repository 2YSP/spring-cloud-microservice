package cn.sp.dao;

import cn.sp.bean.User;
import org.apache.ibatis.annotations.Mapper;

/**
 * Created by 2YSP on 2018/9/19.
 */
@Mapper
public interface UserDao {

    void save(User user);

    User queryById(Long id);
}
