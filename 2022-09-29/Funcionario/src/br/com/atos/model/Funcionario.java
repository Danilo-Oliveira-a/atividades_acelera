package br.com.atos.model;

import java.math.BigDecimal;

import br.com.atos.enums.TipoFuncionario;

public abstract class Funcionario {

    private String nome;
    private Double salarioLiquido;
    private Double horasTrabalhadas;
    private String cpf;
    private TipoFuncionario cargo;
    private Endereco endereco;

    public Funcionario(String nome, Double salarioLiquido, String cpf) {
        this.nome = nome;
        this.salarioLiquido = salarioLiquido;
        this.cpf = cpf;
    }

    public Endereco getEndereco() {
		return endereco;
	}

	public void setEndereco(Endereco endereco) {
		this.endereco = endereco;
	}

	public Funcionario() {

    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Double getSalarioLiquido() {
        return salarioLiquido;
    }

    public void setSalarioLiquido(Double salarioLiquido) {
        this.salarioLiquido = salarioLiquido;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public Double calcularSalario(Double horaTrabalhada){
        return this.salarioLiquido * horaTrabalhada;
    }

    public TipoFuncionario getCargo() {
        return cargo;
    }

    public void setCargo(TipoFuncionario cargo) {
        this.cargo = cargo;
    }
    public String obterHorasTrabalhadas(Double salario){
    	String hrs =BigDecimal.valueOf(this.horasTrabalhadas / salario).setScale(2).toString();
        return hrs;
    }

	public Double getHorasTrabalhadas() {
		return horasTrabalhadas;
	}

	public void setHorasTrabalhadas(Double horasTrabalhadas) {
		this.horasTrabalhadas = horasTrabalhadas;
	}
    
    
}
