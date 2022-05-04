package com.cerc.paymentsRegister.dto;

import java.time.Month;
import java.util.List;

import com.cerc.paymentsRegister.model.Discount;
import com.cerc.paymentsRegister.model.Employee;
import com.cerc.paymentsRegister.model.Payment;
import com.cerc.paymentsRegister.model.Payroll;

public class PayrollDTO {

	private Long id;

	private Employee employee;

	private List<Discount> discounts;

	private List<Payment> payments;

	private Double workHours;

	private Month month;

	private Double totalDiscounts;

	private Double totalPayments;

	private Double netSalary;
	

	public PayrollDTO() {
		super();
	}

	public PayrollDTO(Payroll payroll) {
		super();
		this.id = payroll.getId();
		this.employee = payroll.getEmployee();
		this.discounts = payroll.getDiscounts();
		this.payments = payroll.getPayments();
		this.month = payroll.getMonth();
		this.totalDiscounts = payroll.getTotalDiscounts();
		this.totalPayments = payroll.getTotalPayments();
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

	public List<Payment> getPayments() {
		return payments;
	}

	public void setPayments(List<Payment> payments) {
		this.payments = payments;
	}

	public Double getWorkHours() {
		return workHours;
	}

	public void setWorkHours(Double workHours) {
		this.workHours = workHours;
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

	public Double getTotalPayments() {
		return totalPayments;
	}

	public void setTotalPayments(Double totalPayments) {
		this.totalPayments = totalPayments;
	}

	public Double getNetSalary() {
		return netSalary;
	}

	public void setNetSalary(Double netSalary) {
		this.netSalary = netSalary;
	}

}
