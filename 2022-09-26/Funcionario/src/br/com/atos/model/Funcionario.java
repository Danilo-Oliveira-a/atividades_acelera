package br.com.atos.model;

import br.com.atos.enums.TipoFuncionario;

public class Funcionario {

    private String nome;
    private Double salarioLiquido;
    private String cpf;
    private TipoFuncionario cargo;

    public Funcionario(String nome, Double salarioLiquido, String cpf) {
        this.nome = nome;
        this.salarioLiquido = salarioLiquido;
        this.cpf = cpf;
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
}
