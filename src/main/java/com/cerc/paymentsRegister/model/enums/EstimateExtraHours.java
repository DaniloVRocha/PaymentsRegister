package com.cerc.paymentsRegister.model.enums;

public enum EstimateExtraHours {

	DOMIGOEFERIADO(0, 100.0),
	SEMANA(1, 50.0),
	NOTURNO(2, 20.0),
	INSALUBRIDADE(3, 10.0);

	private int cod;
	private double percentage;

	private EstimateExtraHours(int cod, double percentage) {
		this.cod = cod;
		this.percentage = percentage;
	}

	public int getCod() {
		return cod;
	}

	public void setCod(int cod) {
		this.cod = cod;
	}

	public double getPercentage() {
		return percentage;
	}

	public void setPercentage(double percentage) {
		this.percentage = percentage;
	}

	public static EstimateExtraHours toEnum(Integer cod) {
		if(cod==null) {
			return null;
		}
		
		for(EstimateExtraHours x : EstimateExtraHours.values()) {
			if(cod.equals(x.getCod())) {
				return x;
			}
		}
		throw new IllegalArgumentException("Id Invalido: " + cod);
	}
}
