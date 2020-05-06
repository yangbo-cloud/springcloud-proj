package cloud.consumer.order.bl;

import org.springframework.cloud.client.ServiceInstance;

import java.net.URI;
import java.util.List;

public interface LoanBalance {

    int getNextNum(List<ServiceInstance> instances);
}
