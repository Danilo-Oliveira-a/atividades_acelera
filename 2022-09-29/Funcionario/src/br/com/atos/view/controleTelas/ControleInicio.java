package br.com.atos.view.controleTelas;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;


public class ControleInicio implements ActionListener {

	JFrame frameTelaLista;
	JFrame frameMenuInicial;

	
	public ControleInicio(JFrame frameTelaLista, JFrame frameMenuInicial) {
		super();
		this.frameTelaLista = frameTelaLista;
		this.frameMenuInicial = frameMenuInicial;
		
	}
	

	@Override
	public void actionPerformed(ActionEvent e) {
		frameMenuInicial.setVisible(true);
		frameTelaLista.setVisible(false);
		
	}

	
	
	
	
	
	
	
}
