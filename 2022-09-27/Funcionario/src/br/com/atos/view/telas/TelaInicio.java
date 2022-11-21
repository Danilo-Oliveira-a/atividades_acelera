package br.com.atos.view.telas;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

import br.com.atos.view.controleTelas.*;


public class TelaInicio {

	public void apresentaMenuInicial() {

		System.out.println("INICIO");
		String menuInicial =           " Menu Inicial             ";
		String opcaoUmMenuTexto =      " [1] - Salvar              ";
		String opcaoDoisMenuTexto =     "[2] - Listar              ";
		String opcaoTresMenuTexto =    " [3] - Excluir             ";
		String opcaoQuatroMenuTexto =  " [4] - Alterar             ";
		String opcaoCincoMenuTexto ="    [5] - Encerrar             ";

	
		String titulo =  "Cadastro de Funcionario";

		
		JFrame frameMenuInicial = new JFrame();
		frameMenuInicial.setSize(200, 230);
		frameMenuInicial.setTitle(titulo);
		frameMenuInicial.setLocation(300,300);
		
		
		JPanel panelMenuInicial = new JPanel();
		
		JLabel menuInicialTextoLabel = new JLabel(menuInicial);
		menuInicialTextoLabel.setHorizontalAlignment(SwingConstants.CENTER);
		panelMenuInicial.add(menuInicialTextoLabel);
		
		JLabel opcaoUmMenuTextoLabel = new JLabel(opcaoUmMenuTexto);
		opcaoUmMenuTextoLabel.setHorizontalAlignment(SwingConstants.LEFT);
		panelMenuInicial.add(opcaoUmMenuTextoLabel);
		
		JLabel opcaoDoisMenuTextoLabel = new JLabel(opcaoDoisMenuTexto );
		opcaoDoisMenuTextoLabel.setHorizontalAlignment(SwingConstants.LEFT);
		panelMenuInicial.add(opcaoDoisMenuTextoLabel);
		
		JLabel opcaoTresMenuTextoLabel = new JLabel(opcaoTresMenuTexto);
		opcaoTresMenuTextoLabel.setHorizontalAlignment(SwingConstants.LEFT);
		panelMenuInicial.add(opcaoTresMenuTextoLabel);
		
		JLabel opcaoQuatroMenuTextoLabel = new JLabel(opcaoQuatroMenuTexto);
		panelMenuInicial.add(opcaoQuatroMenuTextoLabel);
		
		JLabel opcaoCincoMenuTextoLabel = new JLabel(opcaoCincoMenuTexto);
		panelMenuInicial.add(opcaoCincoMenuTextoLabel);
		
		
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
