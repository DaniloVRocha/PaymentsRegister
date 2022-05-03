package com.cerc.paymentsRegister.service;
/*
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import com.cerc.paymentsRegister.model.Employee;
import com.cerc.paymentsRegister.repository.EmployeeRepository;



public class EmployeeDetailService implements UserDetailsService {

	 @Autowired
	  private EmployeeRepository employeeRepository;
	  
	  
	  public UserDetails loadUserByUsername(String username)
	      throws UsernameNotFoundException {
	    Employee user = employeeRepository.getByUsername(username);
	    
	    if (user == null) {
	      throw new UsernameNotFoundException("Could not find user");
	    }
	    
	    return new MyEmployeeDetails(user);
	  }

}
*/