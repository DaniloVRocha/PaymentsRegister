package com.cerc.paymentsRegister.repository;

import java.time.Month;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.cerc.paymentsRegister.model.Payroll;

public interface PayrollRepository extends JpaRepository<Payroll, Long>{

    @Query("SELECT p FROM Payroll p WHERE fk_employee_id  = :employeeId")
    public List<Payroll> findAllPayrollsByEmployee (@Param("employeeId") Long employeeId);
    
    @Query("SELECT count(p.id) FROM Payroll p WHERE fk_employee_id = :employeeId AND month = :month")
    public Integer countRegister(@Param("employeeId") Long employeeId, @Param("month") Month month);
    
    @Query("SELECT p FROM Payroll p WHERE fk_employee_id = :employeeId AND month = :month")
    public Payroll findPayrollMonthByIdEmployee(@Param("employeeId") Long employeeId, @Param("month") Month month);
}
