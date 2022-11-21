package br.com.atos.view.controleTelas;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import br.com.atos.model.Gerente;
import br.com.atos.repositorio.impl.RepositorioGerenteImpl;
import br.com.atos.view.telas.TelaExcluir;


public class ControleExcluir implements ActionListener {

	JFrame frameMenuInicial;
	JFrame frameDeletaGerente;
	
	JTextField nomeTextField;
	JTextField cpfTextField;
	JTextField estadoTextField;
	
	RepositorioGerenteImpl repositorioGerenteImpl;
	
	boolean validarDeletar = false;

	
	public ControleExcluir(JTextField cpfTextField, JFrame frameTelaDelete, JFrame frameMenuInicial, RepositorioGerenteImpl repositorioGerenteImpl) {
		super();
		this.frameMenuInicial = frameMenuInicial;
		this.frameDeletaGerente = frameTelaDelete;
		this.repositorioGerenteImpl = repositorioGerenteImpl;
		this.cpfTextField = cpfTextField;
	}
	
	public ControleExcluir() {
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		System.out.println("exlcuir");
		if((cpfTextField!=null
				&& cpfTextField.getText()!=null
				&& cpfTextField.getText().equals(""))
				|| cpfTextField.getText().equals(null)){
	    	JOptionPane.showMessageDialog(null, "CPF Necessário!");
	    }
		else {
			acionarExcluir();
			TelaExcluir telaExcluir = new TelaExcluir();
			telaExcluir.excluir(frameMenuInicial, repositorioGerenteImpl);
			frameDeletaGerente.dispose();
		}
	}

	
	private void acionarExcluir() {
		Gerente gerente = new Gerente();
		gerente.setCpf(cpfTextField.getText());		
		repositorioGerenteImpl.deletarGerente(gerente);
	}
	
	
	
	
	
}
