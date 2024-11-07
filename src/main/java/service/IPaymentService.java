package service;

import com.razorpay.RazorpayException;

public interface IPaymentService {
    String doPayment(String email, Integer amount,String phoneNo,String orderId) throws RazorpayException;
}
