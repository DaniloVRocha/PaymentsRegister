package com.cerc.paymentsRegister.service;

import com.cerc.paymentsRegister.model.Employee;
import com.cerc.paymentsRegister.model.Position;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.UUID;



public class MyEmployeeDetails implements UserDetails, Serializable {

	private static final long serialVersionUID = 1L;

	private UUID id;
	
	private Employee user;

	public MyEmployeeDetails(Employee user) {
		super();
		this.user = user;
	}

	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		Position role = user.getPosition();
		List<SimpleGrantedAuthority> authorities = new ArrayList<>();

		

		authorities.add(new SimpleGrantedAuthority(role.getDescription()));
		return authorities;
	}

	@Override
	public String getPassword() {
		return user.getPassword();
	}

	@Override
	public String getUsername() {
		return user.getUsername();
	}

	@Override
	public boolean isAccountNonExpired() {
		return true;
	}

	@Override
	public boolean isAccountNonLocked() {
		return true;
	}

	@Override
	public boolean isCredentialsNonExpired() {
		return true;
	}

	@Override
	public boolean isEnabled() {
		return user.getActive();
	}

	public UUID getId() {
		return id;
	}

	public void setId(UUID id) {
		this.id = id;
	}
}
