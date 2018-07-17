package cn.sp.client;

import cn.sp.bean.User;
import cn.sp.conf.FeignConfiguration;
import feign.Param;
import feign.RequestLine;
import org.springframework.cloud.netflix.feign.FeignClient;

/**
 * @author ship
 * @Description
 * @Date: 2018-07-17 13:25
 */
@FeignClient(name = "microservice-provider-user",configuration = FeignConfiguration.class)
public interface UserFeignClient {

    /**
     * 使用feign自带的注解@RequestLine
     * @param id
     * @return
     */
    @RequestLine("GET /{id}")
    User findById(@Param("id") Long id);
}
