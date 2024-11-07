package service;

import com.razorpay.PaymentLink;
import com.razorpay.RazorpayClient;
import com.razorpay.RazorpayException;
import org.json.JSONObject;
import org.springframework.stereotype.Service;

@Service("razorpayPaymentService")
public class RazorpayPaymentService implements IPaymentService{
    private RazorpayClient razorpayClient;
    public RazorpayPaymentService(RazorpayClient razorpayClient){
        this.razorpayClient = razorpayClient;
    }
    @Override
    public String doPayment(String email, Integer amount, String phoneNo, String orderId) throws RazorpayException {
        JSONObject requestBody = getRequestBodyForRazorpay(amount,orderId);
        PaymentLink razorpayPaymentLink = razorpayClient.paymentLink.create(requestBody);
        return razorpayPaymentLink.toString();
    }

    private JSONObject getRequestBodyForRazorpay(Integer amount, String orderId) {
        JSONObject customerInfo = new JSONObject();
        customerInfo.put("phone","999999999");
        customerInfo.put("email","nivedita.pal@gmail.com");

        JSONObject notify = new JSONObject();
        notify.put("sms",true);
        notify.put("email",true);

        JSONObject orderRequest = new JSONObject();
        orderRequest.put("amount",amount);
        orderRequest.put("currency","INR");
        orderRequest.put("receipt",orderId);
        orderRequest.put("customer",customerInfo);
        orderRequest.put("notify", notify);
        orderRequest.put("callback_url","https://localhost:8800/razorpay/webhook");
        orderRequest.put("callback_method","get");
        return  orderRequest;
    }
}
