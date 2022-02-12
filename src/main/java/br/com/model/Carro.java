package br.com.model;

public class Carro {

	private Integer id;
	private String modelo;
	private Integer ano;

	private String pagaIPVA;
	
	public Carro() {
		
	}
	
	public Carro(String modelo, int ano) {
		super();
		this.modelo = modelo;
		this.ano = ano;
	}


	public Integer getId() {
		return id;
	}


	public void setId(Integer id) {
		this.id = id;
	}


	public String getModelo() {
		return modelo;
	}


	public void setModelo(String modelo) {
		this.modelo = modelo;
	}


	public int getAno() {
		return ano;
	}


	public void setAno(int ano) {
		this.ano = ano;
	}

	public String getPagaIPVA() {
		return pagaIPVA;
	}

	public void setPagaIPVA(String pagaIPVA) {
		this.pagaIPVA = pagaIPVA;
	}
	
	
}
