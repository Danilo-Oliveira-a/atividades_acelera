package br.atos.model;

public class Pessoa {

	private String nome;
	private String cpf;
	private Endereco endereco;
	
	private boolean editable=false;
	private String tipoBotao  ="Editar";
	
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getCpf() {
		return cpf;
	}
	public void setCpf(String cpf) {
		this.cpf = cpf;
	}
	public Endereco getEndereco() {
		return endereco;
	}
	public void setEndereco(Endereco endereco) {
		this.endereco = endereco;
	}
	public boolean isEditable() {
		return editable;
	}
	public void setEditable(boolean editable) {
		this.editable = editable;
	}
	public String getTipoBotao() {
		return tipoBotao;
	}
	public void setTipoBotao(String tipoBotao) {
		this.tipoBotao = tipoBotao;
	}
	
	
	
	
	
}
