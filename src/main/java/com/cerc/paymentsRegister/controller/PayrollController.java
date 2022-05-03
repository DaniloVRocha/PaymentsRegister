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

import com.cerc.paymentsRegister.dto.PayrollDTO;
import com.cerc.paymentsRegister.model.Payroll;
import com.cerc.paymentsRegister.service.PayrollService;

@RestController
@RequestMapping(value = "/payroll")
public class PayrollController {

	@Autowired
	private PayrollService service;
	
	//Necessario rota adm
	@GetMapping(value = "/show-all")
	public ResponseEntity <List<PayrollDTO>> findAllPayrolls(){
		List<PayrollDTO> payrolls = service.findAll();
		return ResponseEntity.ok().body(payrolls);
	}
	/*
	@GetMapping(value = "/{id}/payroll-history")
	public ResponseEntity <List<PayrollDTO>> findAllPayrollsByEmployee(@PathVariable Long id){
		List<PayrollDTO> payrolls = service.findAllPayrollsByEmployee(id);
		return ResponseEntity.ok().body(payrolls);
	}
	
	@PostMapping(value = "/{id}/")
	public ResponseEntity <Void> insertPayroll(@RequestBody Payroll payroll, @PathVariable Long id){
		service.insertPayroll(payroll);
		URI uri = ServeletUriComponentsBuilder.fromCurrentRequest()
				.path("/{id}").buildAndExpand(payroll.getId()).toUri();
		return ResponseEntity.created(uri).build()
	}
	
	@PutMapping(value = "/update/{id}")
	public Payroll updatePayroll(@RequestBody Payroll payroll, @PathVariable Long id) {
		return service.updatePayroll(id, payroll);
		
	}
	
	@DeleteMapping(value = "/delete/{id}")
	public ResponseEntity <String> deletePayroll(@PathVariable Long id) throws Exception{
		service.deletePayroll(id);
		return ResponseEntity.ok().body("payroll id: " + id + " deleted");
	}*/
}
