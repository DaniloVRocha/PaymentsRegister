package com.cerc.paymentsRegister.security;


import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

@Configuration
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter{
	
	private static final String[] PUBLIC_MATCHERS = {"/h2-console/**"};
	
	@Override
	protected void configure(HttpSecurity http) throws Exception{
		http.headers().frameOptions().disable();
		http.authorizeRequests()
		.antMatchers(HttpMethod.GET, "/").permitAll()
		.antMatchers(PUBLIC_MATCHERS).permitAll()
		.antMatchers("/employee").permitAll()
		.anyRequest().authenticated()
		.and().formLogin().permitAll()
		.and().logout().logoutRequestMatcher(new AntPathRequestMatcher("/logout"));
	}
	
	@Override
	public void configure(WebSecurity web) throws Exception{
		web.ignoring().antMatchers("/materialize/**", "/style/**");
	}
}
