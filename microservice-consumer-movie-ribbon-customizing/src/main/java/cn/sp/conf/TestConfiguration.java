package cn.sp.conf;

import org.springframework.cloud.netflix.ribbon.RibbonClient;
import org.springframework.context.annotation.Configuration;

/**
 * @author ship
 * @Description  使用RibbonClient，为特定name的Ribbon Client 自定义配置
 *               使用@RibbonClient的configuration属性，指定Ribbon的配置类
 * @Date: 2018-07-17 09:37
 */
@RibbonClient(name = "microservice-provider-user",configuration = RibbonConfiguration.class)
@Configuration
public class TestConfiguration {


}
