package cloud.eureka.server;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

/**@Name: EurekaServerApp
 * @Description:   eureka 注册中心
 * @Author: yangbo
 * @Date: 2020/4/3 10:53 下午
 */

//需要开启Eureka 服务
@EnableEurekaServer
@SpringBootApplication
public class EurekaServerApp {
    public static void main(String[] args) {
        SpringApplication.run(EurekaServerApp.class);
    }

}
