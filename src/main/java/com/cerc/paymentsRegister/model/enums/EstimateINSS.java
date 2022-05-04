package com.cerc.paymentsRegister.model.enums;

public enum EstimateINSS {

	FAIXA1(0, 0.00, 1212.00, 0.075), 
	FAIXA2(1, 1212.01, 2427.35, 0.09), 
	FAIXA3(2, 2427.36, 3641.03, 0.12),
	FAIXA4(3, 3641.04, 7087.22, 0.14);

	private int cod;
	private double baseSalary;
	private double limitSalary;
	private double percentage;

	private EstimateINSS(int cod, double baseSalary, double limitSalary, double percentage) {
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
	
	public static EstimateINSS toEnum(Integer cod) {
		if(cod==null) {
			return null;
		}
		
		for(EstimateINSS x : EstimateINSS.values()) {
			if(cod.equals(x.getCod())) {
				return x;
			}
		}
		throw new IllegalArgumentException("Id Invalido: " + cod);
	}
}
