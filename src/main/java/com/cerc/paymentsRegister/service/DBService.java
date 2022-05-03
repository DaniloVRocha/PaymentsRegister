package com.cerc.paymentsRegister.service;

import java.text.ParseException;
import java.time.LocalDate;
import java.time.Month;
import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cerc.paymentsRegister.model.Department;
import com.cerc.paymentsRegister.model.Discount;
import com.cerc.paymentsRegister.model.Employee;
import com.cerc.paymentsRegister.model.Payment;
import com.cerc.paymentsRegister.model.Payroll;
import com.cerc.paymentsRegister.model.Position;
import com.cerc.paymentsRegister.model.enums.EstimateExtraHours;
import com.cerc.paymentsRegister.model.enums.EstimateINSS;
import com.cerc.paymentsRegister.repository.DepartmentRepository;
import com.cerc.paymentsRegister.repository.DiscountRepository;
import com.cerc.paymentsRegister.repository.EmployeeRepository;
import com.cerc.paymentsRegister.repository.PaymentRepository;
import com.cerc.paymentsRegister.repository.PayrollRepository;
import com.cerc.paymentsRegister.repository.PositionRepository;

@Service
public class DBService {

	@Autowired
	private DepartmentRepository departmentRepository;
	@Autowired
	private PayrollRepository payrollRepository;	
	@Autowired
	private DiscountRepository discountRepository;
	@Autowired
	private PaymentRepository paymentRepository;
	@Autowired
	private EmployeeRepository employeeRepository;
	@Autowired
	private PositionRepository positionRepository;


	public void instantiateTestDatabase() throws ParseException {

		Department dep = new Department(null, "TI", "Departamento de desenvolvimento");
		
		departmentRepository.save(dep);

		Position pos = new Position(null, "Desenvolvedor", 3400.0, dep);
		Position pos2 = new Position(null, "Gerente de Projetos", 5400.0, dep);
		Position pos3 = new Position(null, "Lider Técnico", 7400.0, dep);
		Position pos4 = new Position(null, "Gerente RH", 5400.0, dep);
		
		positionRepository.saveAll(Arrays.asList(pos, pos2, pos3,pos4));
		
		//Senha = "senhaManeira"

		Employee emp = new Employee(null, "Brunno", "brunno@paymentsregister.com.br","$2a$10$GfMcIBNFkQOTPv8x/2KMUuWp6qcN4JaPi9honVKgUVDm4U0oh.05i", "321312312313123", pos2, true, LocalDate.of(2022, 04, 18));
		Employee emp2 = new Employee(null, "Danilo","danilo@paymentsregister.com.br","$2a$10$GfMcIBNFkQOTPv8x/2KMUuWp6qcN4JaPi9honVKgUVDm4U0oh.05i", "321312312313123", pos, true, LocalDate.of(2022, 04, 18));
		Employee emp3 = new Employee(null, "Renata","renata@paymentsregister.com.br","$2a$10$GfMcIBNFkQOTPv8x/2KMUuWp6qcN4JaPi9honVKgUVDm4U0oh.05i", "321312312313123", pos3, true, LocalDate.of(2022, 04, 18));
		Employee emp4 = new Employee(null, "João","joao@paymentsregister.com.br", "$2a$10$GfMcIBNFkQOTPv8x/2KMUuWp6qcN4JaPi9honVKgUVDm4U0oh.05i", "321312312313123", pos4, true, LocalDate.of(2022, 04, 18));
		
		employeeRepository.saveAll(Arrays.asList(emp, emp2, emp3, emp4));
		
		Payroll payroll = new Payroll(null, emp, 168.0 ,Month.MAY);
		
		payrollRepository.save(payroll);
		
		Discount disc = new Discount(null, payroll, Month.MAY, EstimateINSS.FAIXA2.getPercentage());
		
		discountRepository.save(disc);
		
		Payment pay = new Payment(null, payroll, Month.MAY, EstimateExtraHours.DOMIGOEFERIADO.getPercentage(), 20);

		paymentRepository.save(pay);
	}
}