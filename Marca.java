package com.br.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="marca")
public class Marca {
	
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long codigo; 
	
	@Column(name="nome")
	private String nome;
	
	//Construtor padrão
	public Marca() {
		super();
	}
	
	
	//Construtor com todos os campos
	public Marca(Long codigo, String nome) {
		super();
		this.codigo = codigo;
		this.nome = nome;

	}


	public Long getCodigo() {
		return codigo;
	}


	public void setCodigo(Long codigo) {
		this.codigo = codigo;
	}


	public String getNome() {
		return nome;
	}


	public void setNome(String nome) {
		this.nome = nome;
	}


}
