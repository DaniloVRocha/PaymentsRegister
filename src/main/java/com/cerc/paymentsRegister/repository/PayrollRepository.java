package com.cerc.paymentsRegister.repository;

import com.cerc.paymentsRegister.model.Payroll;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.time.Month;
import java.util.List;

public interface PayrollRepository extends JpaRepository<Payroll, Long>{

    @Query("SELECT p FROM Payroll p WHERE fk_employee_id  = :employeeId")
    List<Payroll> findAllPayrollsByEmployee (@Param("employeeId") Long employeeId);
    
    @Query("SELECT count(p.id) FROM Payroll p WHERE fk_employee_id = :employeeId AND month = :month")
    Integer countRegister(@Param("employeeId") Long employeeId, @Param("month") Month month);
    
    @Query("SELECT p FROM Payroll p WHERE fk_employee_id = :employeeId AND month = :month")
    Payroll findPayrollMonthByIdEmployee(@Param("employeeId") Long employeeId, @Param("month") Month month);
}
