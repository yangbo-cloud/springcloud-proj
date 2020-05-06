package cloud.consumer.zk.order80;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class Order80App {
    public static void main(String[] args) {
        SpringApplication.run(Order80App.class);
    }
}
