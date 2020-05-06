package cloud.provide.consul.payment8006.controller;


import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.UUID;

@RestController
@Slf4j
public class PaymentConsulController {

    @Value("${server.port}")
    private String server_port;

    private static final String INVOKE_PATH = "http://consul-provider-peyment";

    @RequestMapping("/consul/payment")
    public String getConsul() {
        return "服务注册到consul成功   server_port  : " + server_port + ",    " + UUID.randomUUID().toString();
    }


}
