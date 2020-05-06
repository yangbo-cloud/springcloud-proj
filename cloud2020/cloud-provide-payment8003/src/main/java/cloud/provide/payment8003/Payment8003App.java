package cloud.provide.payment8003;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**@Name: Payment8003App
 * @Description:    zookeeper 做注册中心  客户端测试
 * @Author: yangbo
 * @Date: 2020/4/4 9:31 下午
 */

@SpringBootApplication
//注册中心为  zookeeper  或是  Consul   都通过DiscoveryClient 做服务的发现
@EnableDiscoveryClient
public class Payment8003App {

    public static void main(String[] args) {
        SpringApplication.run(Payment8003App.class);
    }
}
