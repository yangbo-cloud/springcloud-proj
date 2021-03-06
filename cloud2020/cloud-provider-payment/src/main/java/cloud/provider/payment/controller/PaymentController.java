package cloud.provider.payment.controller;

import cloud.common.entity.CommonResult;
import cloud.common.entity.Payment;
import cloud.provider.payment.servcie.PaymentService;
import com.netflix.appinfo.InstanceInfo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

@RestController
@Slf4j


//问题：
//  @PathVariable("id")  的用法    和 RequestParam 的区别
//  代码的测试
//  插入数据的信息传递
//  class  泛型的定义  应用场景


/**@Name: PaymentController
 * @Description: 支付controller
 * @Author: yangbo
 * @Date: 2020/4/2 10:33 下午
 */

public class PaymentController {

    @Resource
    private PaymentService paymentService;


    @Value("${server.port}")
    private String server_port;

    //服务发现对象
    @Resource
    private DiscoveryClient discoveryClient;

    @RequestMapping("/payment/create")
    public CommonResult create(@RequestBody Payment payment) {
        log.info("=====开始调用create()方法=====");
        log.info("payment信息为" + payment.toString());
        int result = paymentService.create(payment);
        if (result > 0) {
            return new CommonResult(200, "插入信息成功,server_port   " + server_port, result);
        } else {
            return new CommonResult(400, "插入信息失败", null);
        }
    }

    //@RequestMapping("payment/findAll")
    //public CommonResult getMessage(@RequestParam("id") int id) {
    //  log.info("传递进来的参数id为"+id);
    @RequestMapping("/payment/findAll/{id}")
    public CommonResult getMessage(@PathVariable("id") int id) {
        log.info("=====开始调用findAll方法=====");
        Payment payment = paymentService.getById(id);
        if (payment != null) {
            log.info("查询出的信息为" + payment.toString());
            return new CommonResult(200, "查询信息成功,server_port   " + server_port, payment);
        } else {
            return new CommonResult(444, "没有查询到id为" + id + "的信息", null);
        }
    }

    /**
    * @Description: feign 调用  超时时间测试
    * @Param:
    * @return:
    * @Author: yangbo
    * @Date: 2020/4/8 10:12 上午
    */

    @RequestMapping("/payment/timeout")
    public String timeOutMessage(){
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            log.info("调用延时异常");
            e.printStackTrace();
        }
        log.info("端口信息为:" +server_port);
        return server_port;
    }

    @RequestMapping("/payment/discovery")
    public Object discovery() {
        List<String> services = discoveryClient.getServices();
        for (String service :
                services) {
            log.info(service);
        }
        List<ServiceInstance> instances = discoveryClient.getInstances("cloud-provider-service");
        for (ServiceInstance serviceInstance : instances
        ) {
            log.info(serviceInstance.getServiceId() + "    ,    " + serviceInstance.getHost() + "    ,    " +
                    serviceInstance.getPort() + "    ,    " + serviceInstance.getUri());
        }
        return discoveryClient;
    }

    @RequestMapping("/payment/zipkin")
    public String paymentZipkin(){
        return  "调用Sleuth 成功  zipkin 展示信息,provide端信息，server_port"+server_port;
    }

}
