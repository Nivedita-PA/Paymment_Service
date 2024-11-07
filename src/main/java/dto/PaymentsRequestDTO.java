package dto;

import lombok.Data;

@Data
public class PaymentsRequestDTO {
    String phoneNo;
    String email;
    Integer amount;
    String orderId;
}
