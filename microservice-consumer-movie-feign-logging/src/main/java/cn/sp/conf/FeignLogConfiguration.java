package cn.sp.conf;

import feign.Logger;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Created by 2YSP on 2018/7/18.
 */
@Configuration
public class FeignLogConfiguration {

    /**
     * NONE:不记录任何日志（默认）
     * BASIC：仅记录请求方法、URL、响应状态代码以及执行时间
     * HEADERS：记录BASIC级别的基础上，记录请求和响应的header
     * FULL:记录请求和响应的header，body和元数据
     * @return
     */
    @Bean
    Logger.Level feignLoggerLevel(){
        return Logger.Level.FULL;
    }
}
