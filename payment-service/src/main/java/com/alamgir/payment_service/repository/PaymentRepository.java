package com.alamgir.payment_service.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.alamgir.payment_service.entity.Payment;

@Repository
public interface PaymentRepository extends JpaRepository<Payment, Long> {

}
