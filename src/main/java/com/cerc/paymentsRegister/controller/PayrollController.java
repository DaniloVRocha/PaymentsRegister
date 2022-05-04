package com.cerc.paymentsRegister.controller;

import com.cerc.paymentsRegister.dto.PayrollDTO;
import com.cerc.paymentsRegister.service.PayrollService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.Month;
import java.util.Date;
import java.util.List;

@RestController
@RequestMapping(value = "/payroll")
public class PayrollController {

	@Autowired
	private PayrollService service;
	
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
		Integer numberOfRecords = service.payrollExist(id,month);
		if(numberOfRecords != 0) {
			payroll = service.findPayrollMonthByIdEmployee(id, date);
		}else {
			payroll = service.generatePayroll(id, date);
		}
		return ResponseEntity.ok().body(payroll);
	}
}
