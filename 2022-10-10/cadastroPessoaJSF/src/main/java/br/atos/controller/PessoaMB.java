package br.atos.controller;

import java.util.ArrayList;
import java.util.List;

import javax.faces.bean.ManagedBean;

import br.atos.model.Pessoa;

@ManagedBean(name = "pessoaMB")
public class PessoaMB {

	List<Pessoa> pessoas = new ArrayList<>();
	private Pessoa pessoa = new Pessoa();
	
	public String salvarPessoa() {
		pessoas.add(pessoa);
		System.out.println(pessoa.getNome());
		
		return "";
		
		
	}

	public List<Pessoa> getPessoas() {
		return pessoas;
	}

	public void setPessoas(List<Pessoa> pessoas) {
		this.pessoas = pessoas;
	}

	public Pessoa getPessoa() {
		return pessoa;
	}

	public void setPessoa(Pessoa pessoa) {
		this.pessoa = pessoa;
	}
	
	
	
}
