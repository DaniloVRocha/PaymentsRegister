package com.cerc.paymentsRegister.model;

import java.time.LocalDate;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "employee")
public class Employee {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	private String name;

	@Column(unique = true)
	private String cpf;

	@OneToOne
	private Position position;

	private boolean active;

	private LocalDate admissionDate;

	@OneToMany
	@JsonIgnore
	private List<Payroll> payroll;

	public Employee() {
		super();
	}

	public Employee(Long id, String name, String cpf, Position position, boolean active, LocalDate admissionDate) {
		super();
		this.id = id;
		this.name = name;
		this.cpf = cpf;
		this.position = position;
		this.active = active;
		this.admissionDate = admissionDate;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public Position getPosition() {
		return position;
	}

	public void setPosition(Position position) {
		this.position = position;
	}

	public boolean isActive() {
		return active;
	}

	public void setActive(boolean active) {
		this.active = active;
	}

	public LocalDate getAdmissionDate() {
		return admissionDate;
	}

	public void setAdmissionDate(LocalDate admissionDate) {
		this.admissionDate = admissionDate;
	}

	public List<Payroll> getPayroll() {
		return payroll;
	}

	public void setPayroll(List<Payroll> payroll) {
		this.payroll = payroll;
	}

}