package com.cerc.paymentsRegister.service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cerc.paymentsRegister.dto.EmployeeDTO;
import com.cerc.paymentsRegister.model.Employee;
import com.cerc.paymentsRegister.parser.EmployeeParser;
import com.cerc.paymentsRegister.repository.EmployeeRepository;
import com.cerc.paymentsRegister.service.exception.NotFoundException;

@Service
public class EmployeeService {

	@Autowired
	private EmployeeRepository repository;

	public List<EmployeeDTO> findAll() {
		return repository.findAll().stream().map(EmployeeParser.get()::dto).collect(Collectors.toList());
	}

	public Employee insertEmployee(Employee employee) {
		return repository.save(employee);
	}

	public Employee findById(Long id) {
		Optional<Employee> employee = repository.findById(id);

		return employee.orElseThrow(() -> new NotFoundException(
				"Employee not found! Id: " + id + ", Type : " + Employee.class.getName(), null));
	}

	public void deleteEmployee(Long id) throws Exception {
		Employee employee = findById(id);
		if (employee == null) {
			throw new NotFoundException("Employee not found");
		}
		repository.deleteById(id);
	}

	public Employee updateEmployee(Long id, Employee employee) {
		Employee newEmployee = findById(id);
		if (newEmployee == null) {
			throw new NotFoundException("Employee not found");
		}
		updateData(newEmployee, employee);

		return repository.save(newEmployee);
	}

	@Transactional
	private void updateData(Employee newEmployee, Employee employee) {
		if (newEmployee.getName() != null) {
			newEmployee.setName(employee.getName());
		}
		if (newEmployee.getAdmissionDate() != null) {
			newEmployee.setAdmissionDate(employee.getAdmissionDate());
		}
		if (newEmployee.getPosition() != null) {
			newEmployee.setPosition(employee.getPosition());
		}
	}
}