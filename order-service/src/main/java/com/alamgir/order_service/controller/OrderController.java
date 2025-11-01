package com.alamgir.order_service.controller;

import org.springframework.web.bind.annotation.RestController;

import com.alamgir.order_service.request.OrderRequest;
import com.alamgir.order_service.service.OrderService;

import jakarta.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@RestController
public class OrderController {

    @Autowired
    private OrderService orderService;

    @PostMapping("/create")
    public String createOrder(@Valid @RequestBody OrderRequest orderRequest) {
        return orderService.createOrder(orderRequest);

    }

}
