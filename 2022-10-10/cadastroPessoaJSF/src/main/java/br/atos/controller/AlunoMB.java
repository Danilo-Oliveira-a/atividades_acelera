package br.atos.controller;

import java.util.ArrayList;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import br.atos.model.Aluno;
import br.atos.model.Endereco;
import br.com.atos.dao.AlunoDAO;

@ManagedBean(name = "alunoMB")
@SessionScoped
public class AlunoMB {

	List<Aluno> alunos= new ArrayList<>();
	private Aluno aluno = new Aluno();
	private boolean hiddenButton =false;
	AlunoDAO dao = new AlunoDAO();
	
	
	
	public String salvar() {
		if(!aluno.getNome().equals("")&&!aluno.getCpf().equals(""))
			try {
				dao.salvar(aluno);
			} catch (Exception e) {
				System.out.println("erro ao listar aluno");
				e.printStackTrace();
			}
		limpar();
		return "";	
	}
	public String remover(Aluno aluno) {
		dao.exlcuir(aluno);
		return "";		
	}
	public void limpar() {
		this.aluno = new Aluno();
	}

	
	public String editar(Aluno aluno) {
		if(aluno.getTipoBotao().toUpperCase().equals("EDITAR")) {
			System.out.println("Editar");
			aluno.setEditable(true);	
			aluno.setTipoBotao("Salvar");
			
			hiddenButton = true;
		}else if(aluno.getTipoBotao().toUpperCase().equals("SALVAR")) {
			aluno.setTipoBotao("Editar");
			dao.editar(aluno);
			aluno.setEditable(false);
			System.out.println("Salvar");
			hiddenButton = false;
		}
		
		return "";
	}
	public String finalizarEditacao(Aluno aluno) {
		if(aluno.getTipoBotao().toUpperCase().equals("EDITAR")) {
			System.out.println("Editar");
			aluno.setEditable(false);
			aluno.setTipoBotao("Salvar");
			
			hiddenButton = false;
		}else if(aluno.getTipoBotao().toUpperCase().equals("SALVAR")) {
			aluno.setTipoBotao("Editar");
			dao.editar(aluno);
			aluno.setEditable(true);
			System.out.println("Salvar");
		}
		return "";
	}
	public List<Aluno> getAlunos() {
		if(alunos!=null && alunos.isEmpty())
			alunos = dao.listaAlunos();
		else if(alunos==null)
			alunos = dao.listaAlunos();
		return alunos;
	}

	public void setAlunos(List<Aluno> alunos) {
		this.alunos = alunos;
	}

	public Aluno getAluno() {
		if(aluno.getEndereco()==null)
			aluno.setEndereco(new Endereco());
		aluno.setEditable(false);
		return aluno;
	}

	public void setAluno(Aluno aluno) {
		this.aluno = aluno;
	}
	public boolean isHiddenButton() {
		return hiddenButton;
	}
	public void setHiddenButton(boolean hiddenButton) {
		this.hiddenButton = hiddenButton;
	}

	
	
	
}
