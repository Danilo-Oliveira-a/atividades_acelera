package br.com.atos.view.telas;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import br.com.atos.view.controleTelas.*;


public class TelaInicio {

	public void apresentaMenuInicial() {

		System.out.println("INICIO");
		String menuInicial =           " Menu Inicial                   ";
		String opcaoUmMenuTexto =      "1 - Cadastro                    ";
		String opcaoDoisMenuTexto =    "2 - Listar                      ";
		String opcaoTresMenuTexto =    "3 - Excluir                     ";
		String opcaoQuatroMenuTexto =  "4 - Alterar                     ";

	
		String titulo =  "Cadastro de Funcionario";

		
		JFrame frameMenuInicial = new JFrame();
		frameMenuInicial.setSize(200, 230);
		frameMenuInicial.setTitle(titulo);
		frameMenuInicial.setLocation(300,300);
		
		
		JPanel panelMenuInicial = new JPanel();
		
		JLabel menuInicialTextoLabel = new JLabel(menuInicial);
		panelMenuInicial.add(menuInicialTextoLabel);
		
		JLabel opcaoUmMenuTextoLabel = new JLabel(opcaoUmMenuTexto);
		panelMenuInicial.add(opcaoUmMenuTextoLabel);
		
		JLabel opcaoDoisMenuTextoLabel = new JLabel(opcaoDoisMenuTexto );
		panelMenuInicial.add(opcaoDoisMenuTextoLabel);
		
		JLabel opcaoTresMenuTextoLabel = new JLabel(opcaoTresMenuTexto);
		panelMenuInicial.add(opcaoTresMenuTextoLabel);
		
		JLabel opcaoQuatroMenuTextoLabel = new JLabel(opcaoQuatroMenuTexto);
		panelMenuInicial.add(opcaoQuatroMenuTextoLabel);
		
		
		JTextField opcaoMenuJTextField = new JTextField(10);
		panelMenuInicial.add(opcaoMenuJTextField);
		
		JButton botaoMenu = new JButton("Enviar");
		panelMenuInicial.add(botaoMenu);
		
		
		
		frameMenuInicial.add(panelMenuInicial);
		frameMenuInicial.setVisible(true);
		
		ControleTelas menuInicialControle = new ControleTelas(opcaoMenuJTextField,frameMenuInicial);
		botaoMenu.addActionListener(menuInicialControle);
	
	}
	
}
