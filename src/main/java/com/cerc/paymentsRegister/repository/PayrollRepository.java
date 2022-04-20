package com.cerc.paymentsRegister.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cerc.paymentsRegister.model.Payroll;

public interface PayrollRepository extends JpaRepository<Payroll, Long>{

}
