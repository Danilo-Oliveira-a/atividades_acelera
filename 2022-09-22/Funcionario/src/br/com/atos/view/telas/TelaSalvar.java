package br.com.atos.view.telas;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import br.com.atos.repositorio.impl.RepositorioGerenteImpl;
import br.com.atos.view.controleTelas.ControleSalvar;

public class TelaSalvar {

	public void  salvarFuncionario(JTextField opcaoMenuJText, JFrame frameMenuInicial, RepositorioGerenteImpl repositorioGerenteImpl) {
		
		
		String nomeTexto = "Digite o nome do funcionario:";
		String cpfTexto = "Digite o CPF:";
		String estadoTexto = "Digite o Estado:";
		
		JFrame frameTelaRegistro = new JFrame();
		frameTelaRegistro.setSize(200, 300);
		frameTelaRegistro.setTitle("Inserir Funcionario");
		frameTelaRegistro.setLocation(300,300);
		
		JPanel painelTelaRegistro = new JPanel();
		
		JLabel nomeTextoLabel = new JLabel(nomeTexto );
		painelTelaRegistro.add(nomeTextoLabel);
		
		JTextField nomeTextField = new JTextField(10);
		painelTelaRegistro.add(nomeTextField);
		
		
		JLabel cpfTextoLabel = new JLabel(cpfTexto);
		painelTelaRegistro.add(cpfTextoLabel);
		
		JTextField cpfTextField = new JTextField(10);
		painelTelaRegistro.add(cpfTextField);
		
		JLabel estadoTextoLabel = new JLabel(estadoTexto);
		painelTelaRegistro.add(estadoTextoLabel);
		
		JTextField estadoTextField = new JTextField(10);
		painelTelaRegistro.add(estadoTextField);
		
		JButton botaoCadastrar = new JButton("Salvar");
		painelTelaRegistro.add(botaoCadastrar);
		
		frameTelaRegistro.add(painelTelaRegistro);
		
		
		frameTelaRegistro.setVisible(true);
		
		ControleSalvar telaRegistroControle = new ControleSalvar(frameTelaRegistro, frameMenuInicial, nomeTextField, cpfTextField, estadoTextField, repositorioGerenteImpl);
		botaoCadastrar.addActionListener(telaRegistroControle);
	}
	
	
	

}
