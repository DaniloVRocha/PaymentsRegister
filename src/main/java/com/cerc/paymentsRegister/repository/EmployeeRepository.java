package com.cerc.paymentsRegister.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cerc.paymentsRegister.entity.Employee;

public interface EmployeeRepository extends JpaRepository<Employee, Long>{

}
