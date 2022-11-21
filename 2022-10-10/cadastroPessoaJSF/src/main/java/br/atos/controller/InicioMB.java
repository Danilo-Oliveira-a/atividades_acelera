package br.atos.controller;

import javax.faces.bean.ManagedBean;

@ManagedBean(name = "inicio")
public class InicioMB {

	public String cadastrarAluno() {
		return "crudaluno.xhtml";
	}
	
	public String cadastrarProfessor() {
		return "crudprofessor.xhtml";
	}
	
}
