package com.alamgir.order_service.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.alamgir.order_service.entity.Order;
import com.alamgir.order_service.entity.ProductInfo;
import com.alamgir.order_service.feignclient.PaymentMicroserviceFeginClient;
import com.alamgir.order_service.repository.OrderRepository;
import com.alamgir.order_service.request.OrderRequest;
import com.alamgir.order_service.response.PaymentResponse;

@Service
public class OrderService {

    @Autowired
    private OrderRepository orderRepository;

    @Autowired
    PaymentMicroserviceFeginClient paymentMicroserviceFeginClient;

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

    public List<Order> checkAllOrder() {
        List<Order> orders = orderRepository.findAll();
        return orders;
    }

    public List<PaymentResponse> checkAllPayment() {
        String url = "http://localhost:8080/payment-service/payment/check"; // add http://

        RestTemplate restTemplate = new RestTemplate();

        ResponseEntity<List<PaymentResponse>> response = restTemplate.exchange(
                url,
                HttpMethod.GET,
                HttpEntity.EMPTY,
                new ParameterizedTypeReference<List<PaymentResponse>>() {
                });

        List<PaymentResponse> payments = response.getBody();
        return payments;
    }

    //! FeignClient
    public List<PaymentResponse> checkAllPaymentv2() {
        return paymentMicroserviceFeginClient.checkAllPayment();
    }

}
