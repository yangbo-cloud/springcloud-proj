package cloud.provider.payment.dao;

import cloud.common.entity.Payment;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface PaymentDao {
    public int create(Payment payment);
    public Payment getById(@Param("id") int id);
}
