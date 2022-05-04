package com.cerc.paymentsRegister.controller;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.Month;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.cerc.paymentsRegister.dto.PayrollDTO;
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
	
	@GetMapping(value = "/{id}")
	public ResponseEntity <PayrollDTO> findByIdEmployee(@PathVariable Long id, @RequestParam String date) throws ParseException{
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		PayrollDTO payroll = null;
		Date dateConsulting = sdf.parse(date);
		Month month = Month.of(dateConsulting.getMonth() + 1);
		Integer quantidadeRegistros = service.payrollExist(id,month);
		if(quantidadeRegistros != 0) {
			payroll = service.findPayrollMonthByIdEmployee(id, date);
		}else {
			payroll = service.generatePayroll(id, date);
		}
		return ResponseEntity.ok().body(payroll);
	}
}
