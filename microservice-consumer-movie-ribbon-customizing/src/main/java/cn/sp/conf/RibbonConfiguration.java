package cn.sp.conf;

import com.netflix.loadbalancer.IRule;
import com.netflix.loadbalancer.RandomRule;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author ship
 * @Description 该类为Ribbon的配置类
 *
 * @Date: 2018-07-17 09:30
 */
@Configuration
public class RibbonConfiguration {

    @Bean
    public IRule ribbonRule(){
        //负载均衡规则，改为随机
        return new RandomRule();
    }
}
