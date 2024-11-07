package service;

import org.springframework.stereotype.Service;

@Service("stripePaymentService")
public class StripePaymentService implements IPaymentService {

    @Override
    public String doPayment(String email, Integer amount, String phoneNo, String orderId) {
        return null;
    }
}
