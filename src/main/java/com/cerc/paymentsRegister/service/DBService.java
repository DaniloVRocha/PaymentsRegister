package com.cerc.paymentsRegister.service;

import java.text.ParseException;
import java.time.LocalDate;
import java.time.Month;
import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cerc.paymentsRegister.model.Departament;
import com.cerc.paymentsRegister.model.Discount;
import com.cerc.paymentsRegister.model.Employee;
import com.cerc.paymentsRegister.model.Payment;
import com.cerc.paymentsRegister.model.Payroll;
import com.cerc.paymentsRegister.model.Position;
import com.cerc.paymentsRegister.model.enums.EstimateExtraHours;
import com.cerc.paymentsRegister.model.enums.EstimateINSS;
import com.cerc.paymentsRegister.repository.DepartamentRepository;
import com.cerc.paymentsRegister.repository.DiscountRepository;
import com.cerc.paymentsRegister.repository.EmployeeRepository;
import com.cerc.paymentsRegister.repository.PaymentRepository;
import com.cerc.paymentsRegister.repository.PayrollRepository;
import com.cerc.paymentsRegister.repository.PositionRepository;

@Service
public class DBService {

	@Autowired
	private DepartamentRepository departamentRepository;
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

		Departament dep = new Departament(null, "TI", "Departamento de desenvolvimento");

		Position pos = new Position(null, "Desenvolvedor", 3400.0, dep);
		Position pos2 = new Position(null, "Gerente de Projetos", 5400.0, dep);
		Position pos3 = new Position(null, "Lider Técnico", 7400.0, dep);

		Employee emp = new Employee(null, "Brunno","321312312313123", pos2, true, LocalDate.of(2022, 04, 18));
		Employee emp2 = new Employee(null, "Danilo","35436456456456", pos, true, LocalDate.of(2022, 04, 18));
		Employee emp3 = new Employee(null, "Renata","3123123123123", pos3, true, LocalDate.of(2022, 04, 18));
		Employee emp4 = new Employee(null, "João", "312312356456", pos, true, LocalDate.of(2022, 04, 18));
		
		Payroll payroll = new Payroll(null, emp, 168.0 ,Month.MAY);
		
		Discount disc = new Discount(null, payroll, Month.MAY, EstimateINSS.FAIXA2.getPercentage());
		
		Payment pay = new Payment(null, payroll, Month.MAY, EstimateExtraHours.DOMIGOEFERIADO.getPercentage(), 20);

		departamentRepository.save(dep);
		positionRepository.saveAll(Arrays.asList(pos, pos2, pos3));
		employeeRepository.saveAll(Arrays.asList(emp, emp2, emp3, emp4));
		payrollRepository.save(payroll);
		discountRepository.save(disc);
		paymentRepository.save(pay);
	}
}
