package br.atos.controller;

import java.util.ArrayList;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import br.atos.model.Endereco;
import br.atos.model.Professor;
import br.com.atos.dao.ProfessorDAO;

@ManagedBean(name = "professorMB")
@SessionScoped
public class ProfessorMB {

	List<Professor> professores= new ArrayList<>();
	private Professor professor = new Professor();
	ProfessorDAO dao = new ProfessorDAO();
	
	public String salvar() {
		
		if(!professor.getNome().equals("")&&!professor.getCpf().equals("")) {
			try {
				dao.salvar(professor);
			} catch (Exception e) {
				System.out.println("Erro ao salvar");
				e.printStackTrace();
			}
		}
		limpar();
		return "";		
	}
	public String remover(Professor professor) {
		professor.setEditable(false);
		try {
			dao.exlcuir(professor);
		} catch (Exception e) {
			System.out.println("Usuario nao existe!");
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return "";		
	}
	
	
	public String editar(Professor professor) {
		if(professor.getTipoBotao().toUpperCase().equals("EDITAR")) {
			System.out.println("Editar");
			professor.setEditable(true);	
			professor.setTipoBotao("Salvar");
			
		}else if(professor.getTipoBotao().toUpperCase().equals("SALVAR")) {
			professor.setTipoBotao("Editar");
			dao.editar(professor);
			professor.setEditable(false);
			System.out.println("Salvar");
			
		}
		
		return "";
	}
	
	public void limpar() {
		this.professor = new Professor();
	}
	
	public List<Professor> getProfessores() {
		if(professores!=null && professores.isEmpty())
			professores = dao.listaProfessores();
		else if (professores ==null)
			professores = dao.listaProfessores();
		return this.professores;
	}

	public void setProfessores(List<Professor> professores) {
		this.professores = professores;
	}

	public Professor getProfessor() {
		if(professor.getEndereco()==null)
			professor.setEndereco(new Endereco());
		professor.setEditable(false);
		return professor;
	}

	public void setProfessor(Professor professor) {
		this.professor = professor;
	}
	
	
	
	
}
