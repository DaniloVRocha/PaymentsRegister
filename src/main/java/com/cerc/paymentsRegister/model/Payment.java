package com.cerc.paymentsRegister.model;

import java.time.Month;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "payment")
public class Payment {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@ManyToOne
	@JoinColumn(name = "fk_payroll_id")
	private Payroll payroll;

	private Month month;

	private Double percentage;

	private Integer extraHours;

	public Payment() {
		super();
	}

	public Payment(Long id, Payroll payroll, Month month, Double percentage, Integer extraHours) {
		super();
		this.id = id;
		this.payroll = payroll;
		this.month = month;
		this.percentage = percentage;
		this.extraHours = extraHours;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Payroll getPayroll() {
		return payroll;
	}

	public void setPayroll(Payroll payroll) {
		this.payroll = payroll;
	}

	public Month getMonth() {
		return month;
	}

	public void setMonth(Month month) {
		this.month = month;
	}

	public Double getPercentage() {
		return percentage;
	}

	public void setPercentage(Double percentage) {
		this.percentage = percentage;
	}

	public Integer getExtraHours() {
		return extraHours;
	}

	public void setExtraHours(Integer extraHours) {
		this.extraHours = extraHours;
	}

}
