package com.cerc.paymentsRegister.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cerc.paymentsRegister.dto.PayrollDTO;
import com.cerc.paymentsRegister.model.Payroll;
import com.cerc.paymentsRegister.parser.PayrollParser;
import com.cerc.paymentsRegister.repository.PayrollRepository;


@Service
public class PayrollService {

	@Autowired
	private PayrollRepository repository;

	public List<PayrollDTO> findAll() {
		
		return repository.findAll().stream().map(PayrollParser.get()::dto).collect(Collectors.toList());
	}

	/*public List<PayrollDTO> findAllPayrollsByEmployee(Long employeeId) {
		
		return repository;
	}*/

	
	
	
}
