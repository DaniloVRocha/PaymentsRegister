package com.cerc.paymentsRegister.parser;

import com.cerc.paymentsRegister.dto.EmployeeDTO;
import com.cerc.paymentsRegister.model.Employee;

public class EmployeeParser {
	public static EmployeeParser get() {
		return new EmployeeParser();
	}

	public EmployeeDTO dto(Employee entidade) {
		EmployeeDTO dto = new EmployeeDTO();

		dto.setId(entidade.getId());
		dto.setName(entidade.getName());
		dto.setActive(entidade.getActive());
		dto.setPosition(entidade.getPosition());
		dto.setAdmissionDate(entidade.getAdmissionDate());
		dto.setWorkHours(entidade.getWorkHours());

		return dto;
	}
}
