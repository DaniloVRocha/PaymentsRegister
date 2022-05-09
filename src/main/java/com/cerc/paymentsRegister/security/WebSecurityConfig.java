package com.cerc.paymentsRegister.security;


import com.cerc.paymentsRegister.service.EmployeeDetailService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;


@Configuration
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter{
	

	  @Bean
	  public UserDetailsService userDetailsService() {
	    return new EmployeeDetailService();
	  }
	  
	  @Bean
	  public BCryptPasswordEncoder passwordEncoder() {
	    return new BCryptPasswordEncoder();
	  }
	  
	  @Bean
	  public DaoAuthenticationProvider authenticationProvider() {
	    DaoAuthenticationProvider authProvider = new DaoAuthenticationProvider();
	    authProvider.setUserDetailsService(userDetailsService());
	    authProvider.setPasswordEncoder(passwordEncoder());
	    
	    return authProvider;
	  }


	@Override
	protected void configure(HttpSecurity http) throws Exception{
		http.headers().frameOptions().disable();
		http.csrf().disable()
				.authorizeRequests()
				.antMatchers("/").permitAll()
				.antMatchers("/department/**").hasAuthority("Gerente RH")
				.antMatchers("/position/**").hasAuthority("Gerente RH")
				.antMatchers("/payroll/**").hasAuthority("Gerente RH")
				.antMatchers("/employee/new", "/employee/show-all", "/employee/update/{id}","/employee/delete/{id}").hasAuthority("Gerente RH")
				.antMatchers("/employee/{id}").permitAll()
				.anyRequest().authenticated()
				.and().httpBasic()
				.and().formLogin().permitAll()
		.and().logout().logoutRequestMatcher(new AntPathRequestMatcher("/logout"));


	}


}

