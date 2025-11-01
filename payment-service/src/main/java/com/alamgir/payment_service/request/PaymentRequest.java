package com.alamgir.payment_service.request;

public class PaymentRequest {

    private Long orderId;
    private String paymentMethod;
    private String paymentStatus;


    public Long getOrderId() {   return orderId;  }
    public void setOrderId(Long orderId) { this.orderId = orderId; }
    public String getPaymentMethod() {return paymentMethod;  }
    public void setPaymentMethod(String paymentMethod) { this.paymentMethod = paymentMethod;  }
    public String getPaymentStatus() {     return paymentStatus;  }
    public void setPaymentStatus(String paymentStatus) {  this.paymentStatus = paymentStatus;  }



}
