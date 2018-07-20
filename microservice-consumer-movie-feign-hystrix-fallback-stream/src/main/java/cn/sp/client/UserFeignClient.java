package cn.sp.client;

import cn.sp.bean.User;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * @author ship
 * @Description  Feign的fallback测试
 *               使用@FeignClient的fallback属性指定回退类
 * @Date: 2018-07-17 13:25
 */
@FeignClient(name = "microservice-provider-user",fallback = FeignClientFallback.class)
public interface UserFeignClient {

    @RequestMapping(value = "/{id}",method = RequestMethod.GET)
    User findById(@PathVariable("id") Long id);

}

/**
 * 回退类FeignClientFallback需实现Feign Client接口
 */
@Component
class FeignClientFallback implements UserFeignClient {
    @Override
    public User findById(Long id) {
        User user = new User();
        user.setId(-1L);
        user.setUsername("默认用户");
        return user;
    }
}
