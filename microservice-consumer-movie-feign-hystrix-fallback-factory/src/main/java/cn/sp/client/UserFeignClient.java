package cn.sp.client;

import cn.sp.bean.User;
import feign.hystrix.FallbackFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
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
@FeignClient(name = "microservice-provider-user",fallbackFactory = FeignClientFallbackFactory.class)
public interface UserFeignClient {

    @RequestMapping(value = "/{id}",method = RequestMethod.GET)
    User findById(@PathVariable("id") Long id);

}

/**
 * 通过FallbackFactory检查回退原因
 */
@Component
class FeignClientFallbackFactory implements FallbackFactory<UserFeignClient>{

    private static final Logger logger = LoggerFactory.getLogger(FeignClientFallbackFactory.class);

    /**
     * 还可以根据不同的异常类型返回不同的结果
     * @param cause
     * @return
     */
    @Override
    public UserFeignClient create(Throwable cause) {
        return new UserFeignClient() {

            @Override
            public User findById(Long id) {
                //日志最好放在各个fallback方法中，而不是create方法中
                //否则在引用启动时,就会打印该日志
                logger.info("fallback reason was:",cause);
                User user = new User();
                user.setId(-1L);
                user.setUsername("默认用户");
                return user;
            }
        };
    }
}
