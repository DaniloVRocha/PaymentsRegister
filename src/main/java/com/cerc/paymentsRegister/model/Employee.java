package com.cerc.paymentsRegister.model;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.Collection;
import java.util.List;

import javax.persistence.*;

/*import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;*/

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "employee") 
public class Employee /*implements UserDetails, Serializable*/{

	//private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	private String name;
	
	/*private String password;
	
	@ManyToMany
	@JoinTable( 
	        name = "usuarios_roles", 
	        joinColumns = @JoinColumn(
	          name = "usuario_id", referencedColumnName = "id"), 
	        inverseJoinColumns = @JoinColumn(
	          name = "role_id", referencedColumnName = "roleName")) 
    private List<LoginRole> roles;*/

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

	public Employee(Long id, String name, String password, String cpf, Position position, boolean active, LocalDate admissionDate) {
		super();
		this.id = id;
		this.name = name;
		//this.password = password;
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
	/*
	//=============!!!! REMOVER ISSO AQUI MAIS TARDE !!!!===============
	public String getUsername() {
		return name;
	}
	//=============!!!!==============================!!!!===============
	 */
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
	
	/*public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
	
	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		// TODO Auto-generated method stub
		return (Collection<? extends GrantedAuthority>) this.roles;
	}

	@Override
	public boolean isAccountNonExpired() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean isAccountNonLocked() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean isCredentialsNonExpired() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean isEnabled() {
		// TODO Auto-generated method stub
		return true;
	}*/

}