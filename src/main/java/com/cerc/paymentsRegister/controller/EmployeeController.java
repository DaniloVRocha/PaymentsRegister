package com.cerc.paymentsRegister.controller;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.cerc.paymentsRegister.dto.EmployeeDTO;
import com.cerc.paymentsRegister.model.Employee;
import com.cerc.paymentsRegister.service.EmployeeService;

@RestController
@RequestMapping(value="/employee")
public class EmployeeController {
	
	@Autowired
	private EmployeeService service;
	
	@RequestMapping(method = RequestMethod.GET)
	public ResponseEntity<List<EmployeeDTO>> findAllEmployee(){
		List<EmployeeDTO> employees = service.findAll();
		return ResponseEntity.ok().body(employees);
	}
	
	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public ResponseEntity<Employee> findById(@PathVariable Long id){
		Employee employee = service.findById(id);
		return ResponseEntity.ok().body(employee);
	}
	
	@RequestMapping(method = RequestMethod.POST)
	public ResponseEntity<Void> insertEmployee(@RequestBody Employee employee){
		service.insertEmployee(employee);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest()
				.path("/{id}").buildAndExpand(employee.getId()).toUri();
		return ResponseEntity.created(uri).build();
	}
	
	@RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
	public ResponseEntity<String> deleteEmployee(@PathVariable Long id) throws Exception{
		service.deleteEmployee(id);
		return ResponseEntity.ok().body("Employee Id: " + id + " Deleted." );
	}
	
	@RequestMapping(value = "/{id}", method = RequestMethod.PUT)
	public Employee updateEmployee(@RequestBody Employee employee, @PathVariable Long id){
		return service.updateEmployee(id, employee);
	}
	
}
