package cloud.consumer.order.bl;

import lombok.extern.slf4j.Slf4j;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.net.URI;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;


@Component
@Slf4j
public class MyRuleImpl implements LoanBalance {



    private AtomicInteger atomicInteger = new AtomicInteger(0);

    @Override
    public int getNextNum(List<ServiceInstance> instances) {
        /**
         *  原子数进行计数访问的次数
         */
        int current;
        int next;
        do{
        current = atomicInteger.get();
        next = current >= Integer.MAX_VALUE ? 0:current+1;
        log.info("======当前信息的值，current："+current +"，next :"+next);
        }while(!this.atomicInteger.compareAndSet(current, next));
        return next;
    }
}
