package controller;

import com.razorpay.RazorpayException;
import dto.PaymentsRequestDTO;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import service.IPaymentService;

@RestController
public class PaymentController {
    private IPaymentService razorPayService;
    private IPaymentService stripePayService;
    public PaymentController(@Qualifier("razorpayPaymentService") IPaymentService razorPayService,
                             @Qualifier("stripePaymentService") IPaymentService stripePayService){
        this.razorPayService = razorPayService;
        this.stripePayService = stripePayService;
    }
    @PostMapping("/payment")
    public String initiatePayment(@RequestBody PaymentsRequestDTO dto) throws RazorpayException {
        int gatewayType = getPaymentGatewayType();
        String response;
        switch (gatewayType){
            case 1:
                response = razorPayService.doPayment(dto.getEmail(),dto.getAmount(),dto.getPhoneNo()
                ,dto.getOrderId());
            case 2:
                response = stripePayService.doPayment(dto.getEmail(),dto.getAmount(),dto.getPhoneNo()
                        ,dto.getOrderId());
        }
        return null;
    }

    private int getPaymentGatewayType() {
        return 1;
    }

}
