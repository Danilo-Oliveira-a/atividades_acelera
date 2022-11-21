package br.atos.controller;

import java.util.ArrayList;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import br.atos.model.Aluno;

@ManagedBean(name = "alunoMB")
@SessionScoped
public class AlunoMB {

	List<Aluno> alunos= new ArrayList<>();
	private Aluno aluno = new Aluno();
	
	public String salvar() {
		if(!aluno.getNome().equals("")&&!aluno.getCpf().equals(""))
			alunos.add(aluno);
		limpar();
		return "";	
	}
	public String remover(Aluno aluno) {
		alunos.remove(aluno);
		return "";		
	}
	public void limpar() {
		this.aluno = new Aluno();
	}

	public List<Aluno> getAlunos() {
		return alunos;
	}

	public void setAlunos(List<Aluno> alunos) {
		this.alunos = alunos;
	}

	public Aluno getAluno() {
		return aluno;
	}

	public void setAluno(Aluno aluno) {
		this.aluno = aluno;
	}

	
	
}
