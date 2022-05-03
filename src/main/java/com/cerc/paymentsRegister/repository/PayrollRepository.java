package com.cerc.paymentsRegister.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.cerc.paymentsRegister.model.Payroll;

public interface PayrollRepository extends JpaRepository<Payroll, Long>{

    @Query("SELECT p FROM Payroll p WHERE fk_employee_id  = :employeeId")
    public List<Payroll> findAllPayrollsByEmployee (@Param("employeeId") Long employeeId);
}
