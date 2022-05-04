package com.cerc.paymentsRegister.model;

import java.time.Month;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "payroll")
public class Payroll {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@OneToOne
	@JoinColumn(name = "fk_employee_id")
	private Employee employee;

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER, mappedBy = "payroll")
	private List<Discount> discounts;

	@OneToMany(cascade = CascadeType.ALL)
	private List<Payment> payments;

	private Double workHours;

	private Month month;

	private Double totalDiscounts;

	private Double totalPayments;

	private Double netSalary;

	public Payroll() {
		super();
	}

	public Payroll(Long id, Employee employee, Month month) {
		super();
		this.id = id;
		this.employee = employee;
		this.month = month;
	}

	public List<Payment> getPayments() {
		return payments;
	}

	public void setPayments(List<Payment> payments) {
		this.payments = payments;
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

	public Double getNetSalary() {
		return netSalary;
	}

	public void setNetSalary(Double netSalary) {
		this.netSalary = netSalary;
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

}
