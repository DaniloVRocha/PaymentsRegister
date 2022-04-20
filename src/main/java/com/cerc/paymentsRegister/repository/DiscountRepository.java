package com.cerc.paymentsRegister.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cerc.paymentsRegister.model.Discount;

public interface DiscountRepository extends JpaRepository<Discount, Long>{

}
