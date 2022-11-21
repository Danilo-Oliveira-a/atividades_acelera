package br.atos.controller;

import javax.faces.bean.ManagedBean;

@ManagedBean(name = "inicio")
public class InicioMB {

	
	
	public String cadastrarProduto() {
		
		
		return "crudaluno.xhtml";
	}
	
	public String cadastrarCliente() {
		
		
		return "crudprofessor.xhtml";
	}
	
	
}
