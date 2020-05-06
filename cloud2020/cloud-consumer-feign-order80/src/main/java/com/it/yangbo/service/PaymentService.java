package com.it.yangbo.service;


import cloud.common.entity.CommonResult;
import cloud.common.entity.Payment;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;


/**@Name: PaymentService
 * @Description:  feign 调用服务的对应接口
 * @Author: yangbo
 * @Date: 2020/4/7 11:01 下午
 */

@Component
@FeignClient(value = "cloud-provider-service")
public interface PaymentService {
    @RequestMapping("/payment/findAll/{id}")
    CommonResult<Payment> getMessage(@PathVariable("id") int id);


    /**
    * @Description:  feign 超时时间 控制 (jar包内置了ribbon   配置ribbon 信息即可控制)
    * @Param:
    * @return:
    * @Author: yangbo
    * @Date: 2020/4/8 10:26 上午
    */

    @RequestMapping("/payment/timeout")
    public String timeOutMessage();
}
