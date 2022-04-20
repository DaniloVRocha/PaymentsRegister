package com.cerc.paymentsRegister.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cerc.paymentsRegister.model.Payment;

public interface PaymentRepository extends JpaRepository<Payment, Long>{

}
