package com.cerc.paymentsRegister.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.cerc.paymentsRegister.entity.Employee;
import com.cerc.paymentsRegister.service.EmployeeService;

@RestController
@RequestMapping(value="/employee")
public class EmployeeController {
	
	@Autowired
	private EmployeeService service;
	
	@RequestMapping(method = RequestMethod.GET)
	public ResponseEntity<List<Employee>> findAllEmployee(){
		List<Employee> employees = service.findAll();
		return ResponseEntity.ok().body(employees);
	}
	
	@RequestMapping(method = RequestMethod.POST)
	public ResponseEntity<Void> insertEmployee(@RequestBody Employee employee){
		service.insertEmployee(employee);
		return ResponseEntity.ok().build();
	}
	
}
