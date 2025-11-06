package com.alamgir.order_service.controller;

import org.springframework.web.bind.annotation.RestController;

import com.alamgir.order_service.entity.Order;
import com.alamgir.order_service.request.OrderRequest;
import com.alamgir.order_service.response.PaymentResponse;
import com.alamgir.order_service.service.OrderService;

import jakarta.validation.Valid;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.GetMapping;

@RestController
public class OrderController {

    @Autowired
    private OrderService orderService;

    @PostMapping("/create")
    public String createOrder(@Valid @RequestBody OrderRequest orderRequest) {
        return orderService.createOrder(orderRequest);
    }

    @GetMapping("/check")
    public List<Order> checkAllOrder() {
        return orderService.checkAllOrder();
    }

    @GetMapping("/check/payment")
    public List<PaymentResponse> checkAllPayment() {
        return orderService.checkAllPayment();
    }

    //!Feign Client
    @GetMapping("/check/payment/v2")
    public List<PaymentResponse> checkAllPaymentv2() {
        return orderService.checkAllPaymentv2();
    }

}
