package com.cerc.paymentsRegister.dto;

import com.cerc.paymentsRegister.model.Discount;
import com.cerc.paymentsRegister.model.Employee;
import com.cerc.paymentsRegister.model.Payroll;

import java.time.Month;
import java.util.List;

public class PayrollDTO {

	private Long id;

	private Employee employee;

	private List<Discount> discounts;

	private Month month;

	private Double totalDiscounts;

	private Double netSalary;
	

	public PayrollDTO() {
		super();
	}

	public PayrollDTO(Payroll payroll) {
		super();
		this.id = payroll.getId();
		this.employee = payroll.getEmployee();
		this.discounts = payroll.getDiscounts();
		this.month = payroll.getMonth();
		this.totalDiscounts = payroll.getTotalDiscounts();
		this.netSalary = payroll.getNetSalary();
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Employee getEmployee() {
		return employee;
	}

	public void setEmployee(Employee employee) {
		this.employee = employee;
	}

	public List<Discount> getDiscounts() {
		return discounts;
	}

	public void setDiscounts(List<Discount> discounts) {
		this.discounts = discounts;
	}

	public Month getMonth() {
		return month;
	}

	public void setMonth(Month month) {
		this.month = month;
	}

	public Double getTotalDiscounts() {
		return totalDiscounts;
	}

	public void setTotalDiscounts(Double totalDiscounts) {
		this.totalDiscounts = totalDiscounts;
	}

	public Double getNetSalary() {
		return netSalary;
	}

	public void setNetSalary(Double netSalary) {
		this.netSalary = netSalary;
	}

}
