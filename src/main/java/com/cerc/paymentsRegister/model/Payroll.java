package com.cerc.paymentsRegister.model;

import javax.persistence.*;
import java.time.Month;
import java.util.List;

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

	private Month month;

	private Double totalDiscounts;

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

}
