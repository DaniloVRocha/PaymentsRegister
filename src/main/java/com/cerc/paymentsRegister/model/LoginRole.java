package com.cerc.paymentsRegister.model;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

import org.springframework.security.core.GrantedAuthority;

@Entity
public class LoginRole implements GrantedAuthority{
	@Id
	private String roleName;

	@ManyToMany(mappedBy = "roles")
    private List<Employee> employees;
	
	public String getNameRole() {
		return roleName;
	}

	public void setRoleName(String nomeRole) {
		this.roleName = roleName;
	}
	
	public List<Employee> getEmployees() {
		return employees;
	}

	public void setEmployees(List<Employee> employees) {
		this.employees = employees;
	}

	@Override
	public String getAuthority() {
		// TODO Auto-generated method stub
		return this.roleName;
	}
	
}
