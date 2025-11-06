package com.alamgir.order_service.feignclient;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.alamgir.order_service.response.PaymentResponse;

@FeignClient("payment-service")
public interface PaymentMicroserviceFeginClient {

    @RequestMapping(method = RequestMethod.GET,path = "/payment/check")
    List<PaymentResponse> checkAllPayment();
}
