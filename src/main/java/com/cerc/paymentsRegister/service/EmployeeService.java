package com.cerc.paymentsRegister.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cerc.paymentsRegister.entity.Employee;
import com.cerc.paymentsRegister.repository.EmployeeRepository;

@Service
public class EmployeeService {
	
	@Autowired
	private EmployeeRepository repository;
	
	public List<Employee> findAll(){
		return repository.findAll();
	}
	
	public Employee insertEmployee(Employee employee) {
		return repository.save(employee);
	}

}
