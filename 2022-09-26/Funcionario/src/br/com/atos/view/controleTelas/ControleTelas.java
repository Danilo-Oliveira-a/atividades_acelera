package br.com.atos.view.controleTelas;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import br.com.atos.repositorio.impl.RepositorioGerenteImpl;
import br.com.atos.view.telas.*;

public class ControleTelas implements ActionListener {

	JTextField opcaoMenuJTextField;
	JFrame frameMenuInicial;

	TelaListar telaListar = new TelaListar();

	TelaExcluir telaExcluir = new TelaExcluir();
	
	TelaSalvar telaExlcuir = new TelaSalvar();
	
	TelaListaAlterar telaAlterar = new TelaListaAlterar();

	RepositorioGerenteImpl repositorioGerenteImpl = new RepositorioGerenteImpl();

	public ControleTelas(JTextField opMenuJtextField, JFrame menuInicial) {
		this.opcaoMenuJTextField = opMenuJtextField;
		this.frameMenuInicial = menuInicial;
	}

	@Override
	public void actionPerformed(ActionEvent event) {
			if((opcaoMenuJTextField!=null
					&& opcaoMenuJTextField.getText()!=null
					&& opcaoMenuJTextField.getText().equals(""))
					|| opcaoMenuJTextField.getText().equals(null)){
		    	JOptionPane.showMessageDialog(null, "Escolha uma opção para continuar!");
		    }
		    else {		  
		    	frameMenuInicial.setVisible(false);
				switch (opcaoMenuJTextField.getText()) {
				
					case "1":
						telaExlcuir.salvarFuncionario(opcaoMenuJTextField, frameMenuInicial, repositorioGerenteImpl);
						System.out.println("Cadastre o Gerente!");
						break;
					case "2":
						telaListar.apresentarLista(repositorioGerenteImpl.listarGerentes(), frameMenuInicial);
						System.out.println("Lista Gerente");
						break;
					case "3":
						telaExcluir.excluir(frameMenuInicial, repositorioGerenteImpl);
						System.out.println("deleta Gerente");
						break;
					
					case "4":
						telaAlterar.alterar(opcaoMenuJTextField, frameMenuInicial, repositorioGerenteImpl);
						System.out.println("deleta Gerente");
						break;
						
					default:
						System.out.println("Opção Invalida!!");
				}		
			}
		    
			
	}

}
