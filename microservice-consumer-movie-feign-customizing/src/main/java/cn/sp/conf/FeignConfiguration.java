package cn.sp.conf;

import feign.Contract;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author ship
 * @Description
 * @Date: 2018-07-17 15:38
 */
@Configuration
public class FeignConfiguration {

    /**
     * 将契约改为feign默认契约，这样就可以使用feign自带的注解了。
     * 之前默认是SpringMvcContract
     * @return
     */
    @Bean
    public Contract feignContract(){
        return new Contract.Default();
    }
}
