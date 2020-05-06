package cloud.provider.payment.servcie;

import cloud.common.entity.Payment;
import cloud.provider.payment.dao.PaymentDao;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class PaymentServiceImpl implements PaymentService {

    @Resource
    private PaymentDao paymentDao;

    @Override
    public int create(Payment payment) {
        return paymentDao.create(payment);
    }

    @Override
    public Payment getById(int id) {
        return paymentDao.getById(id);
    }
}
