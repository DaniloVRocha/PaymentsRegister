package com.cerc.paymentsRegister.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cerc.paymentsRegister.model.Department;

public interface DepartmentRepository extends JpaRepository<Department, Long>{

}
