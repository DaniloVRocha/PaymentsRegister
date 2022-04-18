package com.cerc.paymentsRegister.dto;

import java.time.LocalDate;

import com.cerc.paymentsRegister.model.Position;

public class EmployeeDTO {
	private Long id;

	private String nome;

	private Position cargo;

	private boolean ativo;
	
	private LocalDate dataAdmissao;

	private Double horasTrabalhadas;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public Position getCargo() {
		return cargo;
	}

	public void setCargo(Position cargo) {
		this.cargo = cargo;
	}

	public boolean isAtivo() {
		return ativo;
	}

	public void setAtivo(boolean ativo) {
		this.ativo = ativo;
	}

	public LocalDate getDataAdmissao() {
		return dataAdmissao;
	}

	public void setDataAdmissao(LocalDate dataAdmissao) {
		this.dataAdmissao = dataAdmissao;
	}

	public Double getHorasTrabalhadas() {
		return horasTrabalhadas;
	}

	public void setHorasTrabalhadas(Double horasTrabalhadas) {
		this.horasTrabalhadas = horasTrabalhadas;
	}
	
	
}
