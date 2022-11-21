package br.com.atos.view.telas;

import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import br.com.atos.enums.TipoFuncionario;
import br.com.atos.model.tela.FrameTela;
import br.com.atos.repositorio.impl.RepositorioCoordenadorImpl;
import br.com.atos.repositorio.impl.RepositorioGerenteImpl;
import br.com.atos.view.controleTelas.ControleSalvar;

public class TelaSalvar implements ItemListener{
	
	JComboBox<String> jComboBoxTipoFuncionarios= null;
	String tipoFuncionario = null;
	JButton botaoCadastrar;
	FrameTela frameTela = new FrameTela();
	
	public TelaSalvar(){
		
	}
	public TelaSalvar(JComboBox<String> jComboBoxTipoFuncionarios,JButton botaoCadastrar){
		this.jComboBoxTipoFuncionarios=jComboBoxTipoFuncionarios;
		this.botaoCadastrar=botaoCadastrar;
	}

	public void  salvarFuncionario(JTextField opcaoMenuJText, JFrame frameMenuInicial, RepositorioGerenteImpl repositorioGerenteImpl,RepositorioCoordenadorImpl repositorioCoordenadorImpl) {
		
		
		String nomeTexto =    "NOME                 ";
		String cpfTexto =     "CPF                  ";
		String estadoTexto =  "ESTADO               ";
		String ruaTexto = 	  "RUA                  ";
		String numeroTexto =  "NÚMERO               ";
		
		String horasTexto =   "HORAS TRABALHADAS    ";
		
		
		JPanel painelTelaRegistro = new JPanel();
		
		//NOME
		JTextField nomeTextField = adicionaLabelTexto(painelTelaRegistro,nomeTexto);	
		//CPF
		JTextField cpfTextField = adicionaLabelTexto(painelTelaRegistro,cpfTexto);
		//ESTADO
		JTextField estadoTextField = adicionaLabelTexto(painelTelaRegistro,estadoTexto);
		//RUA
		JTextField ruaTextField = adicionaLabelTexto(painelTelaRegistro,ruaTexto);
		//NUMERO
		JTextField numeroTextField = adicionaLabelTexto(painelTelaRegistro,numeroTexto);
		
		//Horas
		JTextField horasTextField = adicionaLabelTexto(painelTelaRegistro,horasTexto);
		

        // array of string containing TipoFuncionario
        String tiposFuncionario[] = { "     Escolha o tipo de funcionário      ",TipoFuncionario.GERENTE.getDescricao(),TipoFuncionario.COORDENADOR.getDescricao() };
 
        //create button
        botaoCadastrar = new JButton("Salvar");
		botaoCadastrar.setEnabled(false);
		
        // create JComboBox
        jComboBoxTipoFuncionarios = new JComboBox<String>(tiposFuncionario);
        jComboBoxTipoFuncionarios.setSize(20, 10);
        jComboBoxTipoFuncionarios.addItemListener(new TelaSalvar(jComboBoxTipoFuncionarios,botaoCadastrar));
        painelTelaRegistro.add(jComboBoxTipoFuncionarios);
		
		
		
		painelTelaRegistro.add(botaoCadastrar);
		
		//CRIA FRAME
		JFrame frameTelaRegistro = new JFrame();
		frameTelaRegistro.setSize(310, 400);
		frameTelaRegistro.setTitle("SALVAR FUNCIONARIO");
		frameTelaRegistro.setLocation(300,200);		
		frameTelaRegistro.add(painelTelaRegistro);
		frameTelaRegistro.setVisible(true);
		
		//SETA OBJETO FRAME CONTENDO TUDO DA TELA PARA SALVAR
		
		frameTela.setFrameMenuInical(frameMenuInicial);		
		frameTela.setFrameAtual(frameTelaRegistro);
		frameTela.setjPanel(painelTelaRegistro);
		frameTela.setNomeTextField(nomeTextField);
		frameTela.setCpfTextField(cpfTextField);
		frameTela.setEstadoTextField(estadoTextField);
		frameTela.setNumeroTextField(numeroTextField);
		frameTela.setRuaTextField(ruaTextField);
		frameTela.setjComboBoxTipoFuncionarios(jComboBoxTipoFuncionarios);
		frameTela.setRepositorioGerenteImpl(repositorioGerenteImpl);
		frameTela.setRepositorioCoordenadorImpl(repositorioCoordenadorImpl);
		frameTela.setjButton(botaoCadastrar);
		frameTela.setHorasTextField(horasTextField);
		ControleSalvar telaRegistroControle = new ControleSalvar(frameTela);
		
		botaoCadastrar.addActionListener(telaRegistroControle);
		
	
	}
	
	
	private JTextField adicionaLabelTexto(JPanel jPanel,String texto) {
		//cria o texto
		JLabel jLabel = new JLabel(texto);
		jLabel.setSize(20, 50);
		jPanel.add(jLabel);
		
		//cria o campo de texto
		JTextField jTextField = new JTextField(20);
		jPanel.add(jTextField);
		return jTextField;
	}


	@Override
	public void itemStateChanged(ItemEvent e) {
		
		
		if(jComboBoxTipoFuncionarios.getSelectedItem().toString().equals(TipoFuncionario.GERENTE.getDescricao())) {
			tipoFuncionario = jComboBoxTipoFuncionarios.getSelectedItem().toString();
			botaoCadastrar.setEnabled(true);
			System.out.println("TIPO: gerente"+jComboBoxTipoFuncionarios.getSelectedItem().toString());
		}
		else if(jComboBoxTipoFuncionarios.getSelectedItem().toString().equals(TipoFuncionario.COORDENADOR.getDescricao())) {
			tipoFuncionario = jComboBoxTipoFuncionarios.getSelectedItem().toString();
			botaoCadastrar.setEnabled(true);
			System.out.println("TIPO: Coordenador: "+jComboBoxTipoFuncionarios.getSelectedItem().toString());
		}
		else {
			tipoFuncionario = null;
			botaoCadastrar.setEnabled(false);
		}
	}


	

}
