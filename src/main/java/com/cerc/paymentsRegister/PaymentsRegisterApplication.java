package com.cerc.paymentsRegister;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

@EnableWebMvc
@SpringBootApplication
public class PaymentsRegisterApplication {

	public static void main(String[] args) {
		SpringApplication.run(PaymentsRegisterApplication.class, args);
	}

}
