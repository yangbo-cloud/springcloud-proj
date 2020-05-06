package cloud.consumer.order;


import cloud.consumer.order.cloud.consumer.irule.IRuleConfig;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.ribbon.RibbonClient;

/**@Name: OrderApp
 * @Description: 订单模块的启动项
 * @Author: yangbo
 * @Date: 2020/4/3 7:48 下午
 */
@EnableEurekaClient
@SpringBootApplication
//启用自定义的负载均衡方式   指定调用的服务名称  指定启用的自定义负载均衡方式
//@RibbonClient(name = "CLOUD-PROVIDER-SERVICE" , configuration = IRuleConfig.class)
public class OrderApp {
    public static void main(String[] args) {
        SpringApplication.run(OrderApp.class);
    }
}
