package com.it.yangbo;


import com.netflix.hystrix.contrib.metrics.eventstream.HystrixMetricsStreamServlet;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
@EnableEurekaClient
//主启动类激活 fallback  服务降级
//@HystrixCommand
//               : 可以设置 commandProperties   可以设置也可以不设置 但是必须放到  接口的实现类中去
//@HystrixCommand(fallbackMethod = "fallBackMsg",commandProperties = {
//            //设置这个线程的超时时间是3s，3s内是正常的业务逻辑，超过3s调用fallbackMethod指定的方法进行处理
//            @HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds",value = "2000")})
@EnableCircuitBreaker
public class Hystrix8001App {
    public static void main(String[] args) {
        SpringApplication.run(Hystrix8001App.class);
    }


    /**
     * 此配置是为了服务监控而配置，与服务容错本身无关,SpringCloud升级后的坑
     * ServletRegistrationBean因为springboot的默认路径不是"/hystrix.stream"，
     * 只要在自己的项目里配置上下面的servlet就可以了
     */
    @Bean
    public ServletRegistrationBean getServlet(){
        HystrixMetricsStreamServlet streamServlet = new HystrixMetricsStreamServlet();
        ServletRegistrationBean registrationBean = new ServletRegistrationBean(streamServlet);
        registrationBean.setLoadOnStartup(1);
        registrationBean.addUrlMappings("/hystrix.stream");
        registrationBean.setName("HystrixMetricsStreamServlet");
        return registrationBean;
    }

}
