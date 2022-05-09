package com.cerc.paymentsRegister.model;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "position")
public class Position {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@OneToMany(cascade=CascadeType.ALL)

	private List<Employee> employees;

	private String description;

	private Double salary;
	@OneToOne
	private Department department;
	

	public Position() {
		super();
	}

	public Position(Long id, String description, Double salary, Department department) {
		super();
		this.id = id;
		this.description = description;
		this.salary = salary;
		this.department = department;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public List<Employee> getEmployees() {
		return employees;
	}

	public void setEmployees(List<Employee> employees) {
		this.employees = employees;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Double getSalary() {
		return salary;
	}

	public void setSalary(Double salary) {
		this.salary = salary;
	}

	public Department getDepartment() {
		return department;
	}

	public void setDepartment(Department department) {
		this.department = department;
	}
}