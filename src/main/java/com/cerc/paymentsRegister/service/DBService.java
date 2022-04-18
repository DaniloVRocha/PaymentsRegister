package com.cerc.paymentsRegister.service;

import java.text.ParseException;
import java.time.LocalDate;
import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cerc.paymentsRegister.model.Employee;
import com.cerc.paymentsRegister.model.Position;
import com.cerc.paymentsRegister.repository.EmployeeRepository;
import com.cerc.paymentsRegister.repository.PositionRepository;

@Service
public class DBService {

	@Autowired
	private EmployeeRepository employeeRepository;
	@Autowired
	private PositionRepository positionRepository;

	public void instantiateTestDatabase() throws ParseException {
		Position pos = new Position(null, "Desenvolvedor", 3400.0, "TI");
		Position pos2 = new Position(null, "Gerente de Projetos", 5400.0, "TI");
		Position pos3 = new Position(null, "Lider Técnico", 7400.0, "TI");
		
		Employee emp = new Employee(null, "Brunno", pos2, true, LocalDate.of(2022,04,18), 168.0);
		Employee emp2 = new Employee(null, "Danilo", pos, true, LocalDate.of(2022,04,18), 168.0);
		Employee emp3 = new Employee(null, "Renata", pos3, true, LocalDate.of(2022,04,18), 168.0);
		Employee emp4 = new Employee(null, "João", pos, true, LocalDate.of(2022,04,18), 168.0);
		
		positionRepository.saveAll(Arrays.asList(pos,pos2,pos3));
		employeeRepository.saveAll(Arrays.asList(emp,emp2,emp3,emp4));
	}
}
