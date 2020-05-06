package com.it.yangbo.service;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import javax.annotation.Resource;

/**@Name: PaymentServiceImpl
 * @Description: 支付实现类
 * @Author: yangbo
 * @Date: 2020/4/8 3:19 下午
 */

@Service
public class PaymentServiceImpl implements PaymentService{

    @Value("${server.port}")
    private String serverPort;

    @Override
    public String getMessage() {
        return "调用Hystrix 成功 , 当前线程号为:"+Thread.currentThread().getName() +"端口号为:"+serverPort;
    }

    @Override
//    @HystrixCommand(fallbackMethod = "fallBackMsg",commandProperties = {
//            //设置这个线程的超时时间是3s，3s内是正常的业务逻辑，超过3s调用fallbackMethod指定的方法进行处理
//            @HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds",value = "2000")})
    @HystrixCommand(fallbackMethod = "fallBackMsg")
    public String getTimeOutMessage() {
        //int a = 10/0;
        try {
            Thread.sleep(8000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return "调用Hystrix 成功 , ***延迟3秒****  ，   当前线程号为:"+Thread.currentThread().getName() +"端口号为 :"+serverPort;
    }

    @Override
    public String fallBackMsg() {
        return "调用方法异常，fallback()";
    }



    //熔断方法测试
    // 注意  ：服务降级fallbackmethod 的方法的 参数个数类型  必须与原方法打参数个数类型一致，否则报错 找不到 fallbackmethod方法
    @HystrixCommand(fallbackMethod ="rongduanFallBack",commandProperties = {
            @HystrixProperty(name ="circuitBreaker.enabled" ,value ="true" ), //是否开启熔断
            @HystrixProperty(name ="circuitBreaker.requestVolumeThreshold" ,value ="10" ),//相求次数
            @HystrixProperty(name ="circuitBreaker.sleepWindowInMilliseconds" ,value ="10000" ),//窗口时间
            @HystrixProperty(name ="circuitBreaker.errorThresholdPercentage" ,value ="60" )//请求结果错误率
    })
    @Override
    public String rongduan(@PathVariable("id") int id) {
            if(id <0){
                throw new RuntimeException("参数不能为负数");
            }else{
                return "调用熔断方法正常 ， 参数为："+ id;
            }
    }

    @Override
    public String rongduanFallBack(@PathVariable("id") int id) {
        return "调用熔断方法异常  rongduanfallback()";
    }


}
