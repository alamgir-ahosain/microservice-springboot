package com.alamgir.payment_service.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

@Entity
@Table(name = "payment")
public class Payment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull(message = "userId Can't be Null")
    @Column(nullable = false)
    private Long orderId;

    @NotNull(message = "paymentMethod Can't be Null")
    @NotBlank(message = "paymentMethod Can't be Blank")
    @Column(nullable = false)
    private String paymentMethod;

    private String paymentStatus;

    public Long getId() {  return id; }
    public void setId(Long id) {    this.id = id;   }
    public Long getOrderId() {   return orderId;   }
    public void setOrderId(Long orderId) {this.orderId = orderId;    }
    public String getPaymentMethod() {  return paymentMethod;    }
    public void setPaymentMethod(String paymentMethod) {       this.paymentMethod = paymentMethod;  }
    public String getPaymentStatus() {    return paymentStatus;   }
    public void setPaymentStatus(String paymentStatus) {   this.paymentStatus = paymentStatus;  }

}
