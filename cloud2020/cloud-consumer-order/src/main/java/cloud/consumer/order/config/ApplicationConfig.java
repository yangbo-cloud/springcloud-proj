package cloud.consumer.order.config;

import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;



/**@Name: ApplicationConfig
 * @Description:   订单模块的配置文件
 * @Author: yangbo
 * @Date: 2020/4/3 7:53 下午
 */

@Configuration
public class ApplicationConfig {

    //远程调用对象注入
    @Bean
    //负载均衡
    //@LoadBalanced
    public RestTemplate getRestTemplate(){
        return new RestTemplate();
    }
}
