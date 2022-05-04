package com.cerc.paymentsRegister.parser;

import com.cerc.paymentsRegister.dto.PayrollDTO;
import com.cerc.paymentsRegister.model.Payroll;

public class PayrollParser {

	public static PayrollParser get() {
		return new PayrollParser();
	}

	public PayrollDTO dto(Payroll entidade) {
		PayrollDTO dto = new PayrollDTO();

		dto.setId(entidade.getId());
		dto.setEmployee(entidade.getEmployee());
		dto.setMonth(entidade.getMonth());
		dto.setDiscounts(entidade.getDiscounts());
		dto.setTotalDiscounts(entidade.getTotalDiscounts());
		dto.setNetSalary(entidade.getNetSalary());

		return dto;

	}
}