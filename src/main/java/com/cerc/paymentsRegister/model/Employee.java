package com.cerc.paymentsRegister.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.List;

@Entity
@Table(name = "employee") 
public class Employee {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	private String name;
	
	private String email;
	
	private String password;
	
	private String cpf;

	@ManyToOne
	@JoinColumn(name="fk_position_id")
	@JoinTable(name= "position_employe", joinColumns = @JoinColumn(
			name = "position_id", referencedColumnName = "id"),
			inverseJoinColumns = @JoinColumn (
					name = "employee_id", referencedColumnName = "id"))

	private Position position;


	
	private boolean active;

	private LocalDate admissionDate;

	@OneToMany
	@JsonIgnore
	private List<Payroll> payroll;

	public Employee() {
		super();
	}
	
	public Employee(Object object, String string, String string2, String string3, String string4, Position pos2, boolean b, LocalDate localDate) {
		super();
	}

	public Employee(Long id, String name, String email, String password, String cpf, Position position, boolean active, LocalDate admissionDate) {
		super();
		this.id = id;
		this.name = name;
		this.email= email; 
		this.password = password;
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
	
	public String getUsername() {
		return email;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getCpf() {
		return cpf;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
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

	public boolean getActive() {
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
	
	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
	
}