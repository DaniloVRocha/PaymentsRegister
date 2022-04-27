package com.cerc.paymentsRegister.security;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Repository;

import com.cerc.paymentsRegister.model.Employee;
import com.cerc.paymentsRegister.repository.EmployeeRepository;

@Repository
@Transactional
public class ImplementsEmployeeDetailsService implements UserDetailsService{
	
	@Autowired
	private EmployeeRepository er;
	
	@Override
	public UserDetails loadUserByUsername(String login) throws UsernameNotFoundException{
		Employee employee = er.findByName(login);
		
		if (employee == null) {
			throw new UsernameNotFoundException("User not found!");
		}
		return new User(employee.getName(), employee.getPassword(), true, true, true, true, employee.getAuthorities());
	}
}
