package com.cerc.paymentsRegister.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.cerc.paymentsRegister.model.Employee;

public interface EmployeeRepository extends JpaRepository<Employee, Long>{
	Employee findByName(String name);
	@Query("SELECT e FROM Employee e WHERE e.name = :name")
	public Employee getByUsername(@Param("name")String name);
}
