package yangbo.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Slf4j
public class NacosPaymentController {

    @Value("${server.port}")
    private String server_port;


    @RequestMapping("payment/nacos/{id}")
    public String getPayment(@PathVariable("id") int id) {

        return "调用nacos  PaymentController  成功   端口号为：" + server_port + " 参数信息 id ：" + id;
    }
}
