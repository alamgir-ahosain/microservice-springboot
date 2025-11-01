package com.alamgir.order_service.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.alamgir.order_service.entity.Order;
import com.alamgir.order_service.entity.ProductInfo;
import com.alamgir.order_service.repository.OrderRepository;
import com.alamgir.order_service.request.OrderRequest;

@Service
public class OrderService {

    @Autowired
    private OrderRepository orderRepository;

    public String createOrder(OrderRequest orderRequest) {
        Order order = new Order();
        order.setUserId(orderRequest.getUserId());
        order.setTotalAmount(orderRequest.getTotalAmount());

        List<ProductInfo> productInfos = new ArrayList<>();

        orderRequest.getProductInfo().forEach(p -> {
            ProductInfo product = new ProductInfo();
            product.setName(p.getName());
            product.setPrice(p.getPrice());
            productInfos.add(product);
        });

        order.setProductInfo(productInfos);
        Order savedOrder = orderRepository.save(order);
        if (savedOrder.getId() != null) {
            return "Order Created Successfully..";
        }
        return "Not Created any Order";

    }

}
