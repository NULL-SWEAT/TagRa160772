package br.univel.meusTestes;

import java.math.BigDecimal;

public class Conta {
	
	private int id;
	private String nome;
	private BigDecimal valor;

	public Conta(int id, String nome, BigDecimal valor) {
		super();
		this.id = id;
		this.nome = nome;
		this.valor = valor;
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public BigDecimal getValor() {
		return valor;
	}
	public void setValor(BigDecimal valor) {
		this.valor = valor;
	}

	@Override
	public String toString() {
		return id + "\t" + nome;
	}
	
}
