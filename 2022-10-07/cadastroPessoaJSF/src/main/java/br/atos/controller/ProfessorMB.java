package br.atos.controller;

import java.util.ArrayList;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import br.atos.model.Endereco;
import br.atos.model.Professor;

@ManagedBean(name = "professorMB")
@SessionScoped
public class ProfessorMB {

	List<Professor> professores= new ArrayList<>();
	private Professor professor = new Professor();
	
	public String salvar() {
		if(!professor.getNome().equals("")&&!professor.getCpf().equals(""))
			professores.add(professor);
		limpar();
		return "";		
	}
	public String remover(Professor professor) {
		professores.remove(professor);
		return "";		
	}
	public String editar(Professor professor) {
		professores.remove(professor);
		return "editarProfessor.xml";		
	}
	public void limpar() {
		this.professor = new Professor();
	}
	
	public List<Professor> getProfessores() {
		return professores;
	}

	public void setProfessores(List<Professor> professores) {
		this.professores = professores;
	}

	public Professor getProfessor() {
		if(professor.getEndereco()==null)
			professor.setEndereco(new Endereco());
		return professor;
	}

	public void setProfessor(Professor professor) {
		this.professor = professor;
	}

	
}
