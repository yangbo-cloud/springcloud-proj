package cloud.provide.consul.payment8006;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class Payment8006App {
    public static void main(String[] args) {
        SpringApplication.run(Payment8006App.class );
    }
}
