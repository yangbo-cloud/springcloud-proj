package com.it.yangbo.service;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import org.springframework.web.bind.annotation.PathVariable;

/**@Name: PaymentService
 * @Description:  支付service接口
 * @Author: yangbo
 * @Date: 2020/4/8 3:18 下午
 */

public interface PaymentService {

    String getMessage();


    String getTimeOutMessage();

    String fallBackMsg();


    String rongduan(@PathVariable("id") int id);

    String rongduanFallBack(@PathVariable("id") int id);
}
