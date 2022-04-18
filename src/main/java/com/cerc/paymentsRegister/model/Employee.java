package com.cerc.paymentsRegister.model;

import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "employee")
public class Employee {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;

	private String nome;
	
	@OneToOne
	private Position cargo;

	private boolean ativo;
	
	private LocalDate dataAdmissao;

	private Double horasTrabalhadas;
	
	
	public Employee() {
		super();
	}

	public Employee(Long id, String nome, Position cargo, boolean ativo, LocalDate dataAdmissao,
			Double horasTrabalhadas) {
		super();
		this.id = id;
		this.nome = nome;
		this.cargo = cargo;
		this.ativo = ativo;
		this.dataAdmissao = dataAdmissao;
		this.horasTrabalhadas = horasTrabalhadas;
	}

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

	public boolean getAtivo() {
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
