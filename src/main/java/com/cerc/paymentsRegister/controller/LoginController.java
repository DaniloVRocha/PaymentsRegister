package com.cerc.paymentsRegister.controller;

import java.net.URI;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.cerc.paymentsRegister.model.Employee;
import com.cerc.paymentsRegister.service.EmployeeService;

@RestController
@RequestMapping(value = "/employee/login")
public class LoginController {

	@Autowired
	private EmployeeService service;

	@Autowired
	private EmployeeController controller;

	@RequestMapping(method = RequestMethod.POST)
	public ResponseEntity<Void> login(@RequestBody Long id) {
		Employee employee = service.findById(id);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(employee.getId())
				.toUri();
		return ResponseEntity.created(uri).build();
	}
}
