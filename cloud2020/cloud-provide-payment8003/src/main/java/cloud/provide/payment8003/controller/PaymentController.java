package cloud.provide.payment8003.controller;


import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

/**@Name: PaymentController
 * @Description:   Zookeeper    测试 Controller
 * @Author: yangbo
 * @Date: 2020/4/4 9:33 下午
 */
@RestController
@Slf4j
public class PaymentController {

    @Value("${server.port}")
    private String serverPort;

    @RequestMapping("/payment/zk")
    public String testZookeeper(){
        return  " 注册服务到zookeeper完成   端口号为   "+serverPort + "    ,"+ UUID.randomUUID().toString();
    }


}
