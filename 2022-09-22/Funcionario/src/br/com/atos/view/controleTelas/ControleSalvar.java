package br.com.atos.view.controleTelas;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JTextField;

import br.com.atos.model.Gerente;
import br.com.atos.repositorio.impl.RepositorioGerenteImpl;


public class ControleSalvar implements ActionListener {

	JFrame frameTelaRegistro;
	JFrame frameMenuInicial;
	
	JTextField nomeTextField;
	JTextField cpfTextField;
	JTextField estadoTextField;
	
	RepositorioGerenteImpl repositorioGerenteImpl;
	
	boolean validarSalvar = false;

	public ControleSalvar(JFrame frameTelaRegistro, JFrame frameMenuInicial, JTextField nomeTextField,
			JTextField cpfTextField, JTextField estadoTextField, RepositorioGerenteImpl repositorioGerenteImpl) {
		super();
		this.frameTelaRegistro = frameTelaRegistro;
		this.frameMenuInicial = frameMenuInicial;
		this.nomeTextField = nomeTextField;
		this.cpfTextField = cpfTextField;
		this.estadoTextField = estadoTextField;
		this.repositorioGerenteImpl = repositorioGerenteImpl;
	}
	
	public ControleSalvar() {
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		acionarSalvar();
		frameMenuInicial.setVisible(true);
		frameTelaRegistro.setVisible(false);
		
	}

	
	
	private void acionarSalvar() {
		Gerente gerente = new Gerente();
		gerente.setNome(nomeTextField.getText());
		gerente.setCpf(cpfTextField.getText());
		gerente.setEstado(estadoTextField.getText());
		repositorioGerenteImpl.salvarGerente(gerente);
	}
	
	
	
	
	
}
