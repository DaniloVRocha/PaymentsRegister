package com.cerc.paymentsRegister.model;

import java.time.Month;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "discount")
public class Discount {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@ManyToOne
	@JoinColumn(name = "fk_payroll_id")
	@JsonIgnore
	private Payroll payroll;

	private String nameDiscount;

	private Double totalDiscount;

	private Month month;

	private Double percentage;

	public Discount() {
		super();
	}

	public Discount(Long id, String nameDiscount, Double totalDiscount, Month month,
			Double percentage) {
		super();
		this.id = id;
		this.nameDiscount = nameDiscount;
		this.totalDiscount = totalDiscount;
		this.month = month;
		this.percentage = percentage;
	}

	public Payroll getPayroll() {
		return payroll;
	}

	public void setPayroll(Payroll payroll) {
		this.payroll = payroll;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Double getPercentage() {
		return percentage;
	}

	public void setPercentage(Double percentage) {
		this.percentage = percentage;
	}

	public Month getMonth() {
		return month;
	}

	public void setMonth(Month month) {
		this.month = month;
	}

	public String getNameDiscount() {
		return nameDiscount;
	}

	public void setNameDiscount(String nameDiscount) {
		this.nameDiscount = nameDiscount;
	}

	public Double getTotalDiscount() {
		return totalDiscount;
	}

	public void setTotalDiscount(Double totalDiscount) {
		this.totalDiscount = totalDiscount;
	}

}
