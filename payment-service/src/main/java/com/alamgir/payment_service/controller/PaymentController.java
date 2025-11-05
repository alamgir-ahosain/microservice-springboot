package com.alamgir.payment_service.controller;

import org.springframework.web.bind.annotation.RestController;

import com.alamgir.payment_service.entity.Payment;
import com.alamgir.payment_service.request.PaymentRequest;
import com.alamgir.payment_service.service.PaymentService;

import jakarta.validation.Valid;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.GetMapping;

@RestController
public class PaymentController {

    @Autowired
    private PaymentService paymentService;

    @PostMapping("/create")
    public String createPayment(@Valid @RequestBody PaymentRequest paymentRequest) {
        return paymentService.createPayment(paymentRequest);

    }

    @GetMapping("check")
    public List<Payment> getAllPaymentDetails() {
        return paymentService.getAllPaymentDetails();

    }

}
