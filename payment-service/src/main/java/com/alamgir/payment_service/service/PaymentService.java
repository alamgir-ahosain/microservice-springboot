package com.alamgir.payment_service.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.alamgir.payment_service.entity.Payment;
import com.alamgir.payment_service.repository.PaymentRepository;
import com.alamgir.payment_service.request.PaymentRequest;

@Service
public class PaymentService {

    @Autowired
    private PaymentRepository paymentRepository;

    public String createPayment(PaymentRequest paymentRequest) {

        Payment payment = new Payment();
        payment.setOrderId(paymentRequest.getOrderId());
        payment.setPaymentMethod(paymentRequest.getPaymentMethod());
        payment.setPaymentStatus(paymentRequest.getPaymentStatus());
        Payment savedPayment = paymentRepository.save(payment);
        if (savedPayment.getId() != null) {
            return "Payment Success";

        }
        return "Payment Error";

    }

}
