package cloud.consumer.zk.order80.controller;


import com.sun.xml.internal.ws.api.FeatureListValidatorAnnotation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;

@RestController
@Slf4j
public class OrderController {

    private static final String INVOKE_PATH = "http://cloud-provider-payment";


    @Value("${server.port}")
    private String serverPort;

    @Resource
    private RestTemplate restTemplate;

    @RequestMapping("/order/find")
    public String orderServcie() {

        log.info("调用orderService方法   orderService 端口 ：" + serverPort);
        String forObject = restTemplate.getForObject(INVOKE_PATH + "/payment/zk", String.class);
        return forObject;
    }
}
