package br.com.atos.view.controleTelas;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import br.com.atos.repositorio.impl.RepositorioCoordenadorImpl;
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
	RepositorioCoordenadorImpl repositorioCoordenadorImpl = new RepositorioCoordenadorImpl();

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
			else if(opcaoMenuJTextField.getText().equals("1")
		    		||opcaoMenuJTextField.getText().equals("2")
		    		||opcaoMenuJTextField.getText().equals("3")
		    		||opcaoMenuJTextField.getText().equals("4")
		    		||opcaoMenuJTextField.getText().equals("5")
		    		){
				frameMenuInicial.setVisible(false);
				switch (opcaoMenuJTextField.getText()) {
				
					case "1":
						telaExlcuir.salvarFuncionario(opcaoMenuJTextField, frameMenuInicial, repositorioGerenteImpl,repositorioCoordenadorImpl);
						System.out.println("Cadastre o Gerente!");
						break;
					case "2":
						telaListar.apresentarLista(repositorioGerenteImpl,repositorioCoordenadorImpl, frameMenuInicial);
						System.out.println("Lista Gerente");
						break;
					case "3":
						telaExcluir.excluir(frameMenuInicial, repositorioGerenteImpl,repositorioCoordenadorImpl);
						System.out.println("deleta Gerente");
						break;
					
					case "4":
						telaAlterar.alterar(opcaoMenuJTextField, frameMenuInicial, repositorioGerenteImpl,repositorioCoordenadorImpl);
						System.out.println("altera Gerente");
						break;
					
					case "5":						
						break;
					default:
						System.out.println("Opção Invalida!!");
				}		
		    }
		    else {		  
		    	JOptionPane.showMessageDialog(null, "Opção inválida!");
			}
		    
			
	}

}
