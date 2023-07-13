package com.br.model;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="automovel")
public class Automovel {

	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long codigo; 
	
	@Column(name="nome")
	private String nome;
	
	@Column(name="modelo")
	private String modelo;
	
	@Column(name="datafabricacao")
    private Date dataFabricacao;
	
	@Column(name="quantidade")
    private int quantidade;
	
	@Column(name="precovenda")
    private double precoVenda;
	
	@Column(name="trioeletrico")
    private boolean trioEletrico;
	
	@ManyToOne(optional = false, fetch = FetchType.EAGER)
    private Marca marca;

	
	
	//Construtor padrão
	public Automovel() {
		super();
	}
	
	
	//Construtor com todos os campos
	public Automovel(Long codigo, String nome, String modelo, Date datafabricacao, int quantidade, double precovenda, boolean trioeletrico, Marca marca) {
		super();
		this.codigo = codigo;
		this.nome = nome;
		this.modelo = modelo;
		this.dataFabricacao = datafabricacao;
		this.quantidade = quantidade;
		this.precoVenda = precovenda;
		this.trioEletrico = trioeletrico;
		this.marca = marca;
		
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


	public String getModelo() {
		return modelo;
	}


	public void setModelo(String modelo) {
		this.modelo = modelo;
	}


	public Date getDataFabricacao() {
		return dataFabricacao;
	}


	public void setDataFabricacao(Date dataFabricacao) {
		this.dataFabricacao = dataFabricacao;
	}


	public int getQuantidade() {
		return quantidade;
	}


	public void setQuantidade(int quantidade) {
		this.quantidade = quantidade;
	}


	public double getPrecoVenda() {
		return precoVenda;
	}


	public void setPrecoVenda(double precoVenda) {
		this.precoVenda = precoVenda;
	}


	public boolean isTrioEletrico() {
		return trioEletrico;
	}


	public void setTrioEletrico(boolean trioEletrico) {
		this.trioEletrico = trioEletrico;
	}


	public Marca getMarca() {
		return marca;
	}


	public void setMarca(Marca marca) {
		this.marca = marca;
	}

	
	
}
