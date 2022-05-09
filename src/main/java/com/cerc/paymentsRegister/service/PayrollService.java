package com.cerc.paymentsRegister.service;

import com.cerc.paymentsRegister.dto.PayrollDTO;
import com.cerc.paymentsRegister.model.Discount;
import com.cerc.paymentsRegister.model.Employee;
import com.cerc.paymentsRegister.model.Payroll;
import com.cerc.paymentsRegister.model.enums.EstimateINSS;
import com.cerc.paymentsRegister.model.enums.EstimateIRPF;
import com.cerc.paymentsRegister.parser.PayrollParser;
import com.cerc.paymentsRegister.repository.DiscountRepository;
import com.cerc.paymentsRegister.repository.PayrollRepository;
import com.cerc.paymentsRegister.service.exception.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.Month;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;


@Service
public class PayrollService {

	@Autowired
	private PayrollRepository payrollRepository;
	@Autowired
	private DiscountRepository discountRepository;
	@Autowired
	private EmployeeService employeeService;

	public List<PayrollDTO> findAll() {
		
		return payrollRepository.findAll().stream().map(PayrollParser.get()::dto).collect(Collectors.toList());
	}
	
	public PayrollDTO findPayrollMonthByIdEmployee(Long id, String date) throws ParseException {
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		Date dateConsulting = sdf.parse(date);
		Payroll payroll = payrollRepository.findPayrollMonthByIdEmployee(id,  Month.of(dateConsulting.getMonth() + 1));
		return new PayrollDTO(payroll);
	}

	@Transactional
	public PayrollDTO generatePayroll(Long id, String date) throws ParseException {
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		Date dateConsulting = sdf.parse(date);
		Employee employee = employeeService.findById(id);
		Double totalDiscounts = 0.0;
		Double netSalary;
		if(employee == null) {
			throw new NotFoundException("Employee does not exists");
		}
		
		Payroll payroll = new Payroll(null, employee, Month.of(dateConsulting.getMonth() + 1));
		List<Discount> discounts = new ArrayList<>();
		
		discounts.add(calculateINSS(payroll));
		if(payroll.getEmployee().getPosition().getSalary() >= EstimateIRPF.FAIXA2.getBaseSalary()) {
			discounts.add(calculateIRPF(payroll));
		}
		for(Discount discount: discounts) {
			totalDiscounts += discount.getTotalDiscount();
		}

		netSalary = employee.getPosition().getSalary() - totalDiscounts;
		
		payroll.setNetSalary(netSalary);
		payroll.setTotalDiscounts(totalDiscounts);
		payroll.setDiscounts(discounts);

		Integer numberOfRecords = payrollRepository.countRegister(payroll.getEmployee().getId(), payroll.getMonth());
		if(numberOfRecords == 0) {
			payrollRepository.save(payroll);
			discountRepository.saveAll(discounts);
		}

		return new PayrollDTO(payroll);
		
	}
	
	public Discount calculateINSS(Payroll payroll) {
		Double percentage = 0.0;
		Double salary = payroll.getEmployee().getPosition().getSalary();
		Double totalDiscount = 0.0;

		
		if(salary <= EstimateINSS.FAIXA1.getLimitSalary()) {
			 percentage = EstimateINSS.FAIXA1.getPercentage();
			 totalDiscount = salary * percentage;
		}
		else if(salary >= EstimateINSS.FAIXA2.getBaseSalary() && salary <= EstimateINSS.FAIXA2.getLimitSalary()) {
			percentage = EstimateINSS.FAIXA2.getPercentage();
			totalDiscount = ((salary - 1212) * percentage) + 90.9;
		}
		else if(salary >= EstimateINSS.FAIXA3.getBaseSalary() && salary <= EstimateINSS.FAIXA3.getLimitSalary()) {
			percentage = EstimateINSS.FAIXA3.getPercentage();
			totalDiscount = ((salary - 2427.78) * percentage) + 200.32;;
		}

		else if(salary >= EstimateINSS.FAIXA4.getBaseSalary() && salary <= EstimateINSS.FAIXA4.getLimitSalary()){
			percentage = EstimateINSS.FAIXA4.getPercentage();
			totalDiscount = ((salary - 3641.67) * percentage) + 346.00;;

		} else if (salary > EstimateINSS.FAIXA4.getLimitSalary()) {
			totalDiscount = 828.39;
		}


		Discount discountINSS = new Discount(null,"INSS", totalDiscount, LocalDate.now().getMonth(), percentage);
		discountINSS.setPayroll(payroll);
		return discountINSS;
	}

	public Discount calculateIRPF(Payroll payroll) {
		Double percentage = 0.0;
		Double deduction = 0.0;
		Double totalDiscount = 0.0;
		Double salary = payroll.getEmployee().getPosition().getSalary();
		
		if(salary <= EstimateIRPF.FAIXA1.getLimitSalary()) {
			percentage = EstimateIRPF.FAIXA1.getPercentage();
		}else if(salary >= EstimateIRPF.FAIXA2.getBaseSalary() && salary <= EstimateIRPF.FAIXA2.getLimitSalary()) {
			percentage = EstimateIRPF.FAIXA2.getPercentage();
			deduction = 142.80;
		}else if(salary >= EstimateIRPF.FAIXA3.getBaseSalary() && salary <= EstimateIRPF.FAIXA3.getLimitSalary()) {
			percentage = EstimateIRPF.FAIXA3.getPercentage();
			deduction = 354.80;
		}else if(salary >= EstimateIRPF.FAIXA4.getBaseSalary() && salary <= EstimateIRPF.FAIXA4.getLimitSalary()) {
			percentage = EstimateIRPF.FAIXA4.getPercentage();
			deduction = 636.13;
		}else if(salary >= EstimateIRPF.FAIXA5.getBaseSalary()) {
			percentage = EstimateIRPF.FAIXA5.getPercentage();
			deduction = 869.36;
		}


		totalDiscount = (salary  * percentage) - deduction;

		Discount discountIRPF =  new Discount(null,"IRPF", totalDiscount, LocalDate.now().getMonth(), percentage);
		discountIRPF.setPayroll(payroll);
		return discountIRPF;
	}
	
	public Integer payrollExist(Long id, Month month) {
		return payrollRepository.countRegister(id, month);
	}
	
}
