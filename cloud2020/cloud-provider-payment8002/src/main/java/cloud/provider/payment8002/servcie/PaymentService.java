package cloud.provider.payment8002.servcie;


import cloud.common.entity.Payment;
import org.apache.ibatis.annotations.Param;

public interface PaymentService {
    public int create(Payment payment);
    public Payment getById(@Param("id") int id);
}
