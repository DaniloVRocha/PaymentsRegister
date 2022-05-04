package com.cerc.paymentsRegister.model.enums;

public enum EstimateIRPF {

	FAIXA1(0, 0.00, 1903.98, 0.0), 
	FAIXA2(1, 1903.99, 2826.65, 0.075), 
	FAIXA3(2, 2826.66, 3751.05, 0.15),
	FAIXA4(3, 3751.06, 4664.68, 0.225),
	FAIXA5(4, 4664.68, 7087.22, 0.275);

	private int cod;
	private double baseSalary;
	private double limitSalary;
	private double percentage;

	EstimateIRPF(int cod, double baseSalary, double limitSalary, double percentage) {
		this.cod = cod;
		this.baseSalary = baseSalary;
		this.limitSalary = limitSalary;
		this.percentage = percentage;
	}

	public int getCod() {
		return cod;
	}

	public void setCod(int cod) {
		this.cod = cod;
	}

	public double getBaseSalary() {
		return baseSalary;
	}

	public void setBaseSalary(double baseSalary) {
		this.baseSalary = baseSalary;
	}

	public double getLimitSalary() {
		return limitSalary;
	}

	public void setLimitSalary(double limitSalary) {
		this.limitSalary = limitSalary;
	}

	public double getPercentage() {
		return percentage;
	}

	public void setPercentage(double percentage) {
		this.percentage = percentage;
	}

	public static EstimateIRPF toEnum(Integer cod) {
		if(cod==null) {
			return null;
		}
		
		for(EstimateIRPF x : EstimateIRPF.values()) {
			if(cod.equals(x.getCod())) {
				return x;
			}
		}
		throw new IllegalArgumentException("Id Invalido: " + cod);
	}
}
