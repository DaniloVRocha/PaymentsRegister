package com.cerc.paymentsRegister.controller;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
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
	
	@GetMapping(value ="/show-all")
	public ResponseEntity<List<EmployeeDTO>> findAllEmployee(){
		List<EmployeeDTO> employees = service.findAll();
		return ResponseEntity.ok().body(employees);
	}
	
	@GetMapping(value = "/{id}")
	public ResponseEntity<Employee> findById(@PathVariable Long id){
		Employee employee = service.findById(id);
		return ResponseEntity.ok().body(employee);
	}
	
	@PostMapping(value = "/new")
	public ResponseEntity<Void> insertEmployee(@RequestBody Employee employee){
		service.insertEmployee(employee);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest()
				.path("/{id}").buildAndExpand(employee.getId()).toUri();
		return ResponseEntity.created(uri).build();
	}
	
	@DeleteMapping(value = "/delete/{id}")
	public ResponseEntity<String> deleteEmployee(@PathVariable Long id) throws Exception{
		service.deleteEmployee(id);
		return ResponseEntity.ok().body("Employee Id: " + id + " Deleted." );
	}
	
	@PutMapping(value = "/update/{id}")
	public Employee updateEmployee(@RequestBody Employee employee, @PathVariable Long id){
		return service.updateEmployee(id, employee);
	}
	
	
	
}
