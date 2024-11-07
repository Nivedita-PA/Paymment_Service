package controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RazorpayWebhook {

    @GetMapping("/razorpay/webhook")
    public String razorpayCallback(){
       return "redirecting customer....";
    }
}
