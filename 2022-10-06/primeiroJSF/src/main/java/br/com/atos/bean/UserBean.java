package br.com.atos.bean;

import java.io.Serializable;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;

@ManagedBean(name = "userMB")
@RequestScoped
public class UserBean implements Serializable{

	/**
	*
	*/
	private static final long serialVersionUID = 1L;

	private String nome;

	
	public String getNome() {
		return nome;
	}


	public void setNome(String nome) {
		this.nome = nome;
	}


	public void validar() {
		if (nome == null || "".equals(nome)) {
			FacesContext.getCurrentInstance().addMessage("msgValidador", new FacesMessage("Nome Vazio"));
		} else if (nome.length() < 3) {
			FacesContext.getCurrentInstance().addMessage("msgValidador", new FacesMessage("Nome deve ter ao menos 3 dígitos"));
		} else {
			FacesContext.getCurrentInstance().addMessage("msgValidador",
					new FacesMessage("Nome Validado com sucesso !!"));
		}
	}

	

}
