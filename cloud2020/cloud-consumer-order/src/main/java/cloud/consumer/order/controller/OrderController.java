package cloud.consumer.order.controller;

import cloud.common.entity.CommonResult;
import cloud.common.entity.Payment;
import cloud.consumer.order.bl.LoanBalance;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;
import java.net.URI;
import java.util.List;

/**
 * @Name: OrderController
 * @Description: 订单Controller
 * @Author: yangbo
 * @Date: 2020/4/3 7:52 下午
 */
@RestController
@Slf4j
public class OrderController {

    private static final String PATH = "http://cloud-provider-service";
    @Resource
    private RestTemplate restTemplate;
    @Resource
    private DiscoveryClient discoveryClient;
    @Resource
    private LoanBalance loanBalance;

    @Value("${server.port}")
    private String server_port;

    @RequestMapping("/consumer/order/create")
    public CommonResult<Payment> create(Payment payment) {
        log.info("=====开始调用consumer的create方法,payment信息为" + payment.toString());
        //return restTemplate.getForEntity(PATH + "/payment/create", payment, CommonResult.class);
        return restTemplate.postForObject(PATH + "/payment/create", payment, CommonResult.class);
    }

    @RequestMapping("/consumer/order/findAll/{id}")
    public CommonResult<Payment> getPaymentById(@PathVariable("id") int id) {
        log.info("=====开始调用consumer的findAll方法");
        //return restTemplate.getForEntity(PATH + "/payment/findAll" + id, CommonResult.class);
        return restTemplate.getForObject(PATH + "/payment/findAll/" + id, CommonResult.class);

    }

    @RequestMapping("/loandbalance/{id}")
    public CommonResult<Payment> getMessage(@PathVariable("id") int id) {

        /*
         * 通过访问次数与 总的服务实例数量进行% 计算 获取指定的服务实例
         */

        List<ServiceInstance> instances1 = discoveryClient.getInstances("CLOUD-PROVIDER-SERVICE");
        if (instances1 == null || instances1.size() < 0) {
            return null;
        }
        int next = loanBalance.getNextNum(instances1);
        int num = next%instances1.size();
        ServiceInstance serviceInstance = instances1.get(num);
        return restTemplate.getForObject(serviceInstance.getUri() + "/payment/findAll/" + id, CommonResult.class);
    }

    @RequestMapping("/order/zipkin")
    public String paymentZipkin(){
        log.info("调用Sleuth 成功  zipkin 展示信息,order端信息，server_port"+server_port);

        String result = restTemplate.getForObject("http://localhost:8001"+"/payment/zipkin", String.class);
        return result;
    }


}