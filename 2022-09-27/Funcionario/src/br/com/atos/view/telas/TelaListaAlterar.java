package br.com.atos.view.telas;

import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import br.com.atos.enums.TipoFuncionario;
import br.com.atos.model.Coordenador;
import br.com.atos.model.Gerente;
import br.com.atos.model.tela.FrameTela;
import br.com.atos.repositorio.impl.RepositorioCoordenadorImpl;
import br.com.atos.repositorio.impl.RepositorioGerenteImpl;
import br.com.atos.view.controleTelas.ControleAlterar;
import br.com.atos.view.telas.comuns.TelaComumListar;



public class TelaListaAlterar implements ItemListener {
    
	JButton botaoAlterar;
	JComboBox<String> jComboBoxTipoFuncionarios;
	JTextField cpfTextField;
	FrameTela frameTela = new FrameTela();
	
	
	public TelaListaAlterar() {
		
	}
	
	public TelaListaAlterar(JButton botaoAlterar,JComboBox<String> jComboBoxTipoFuncionarios,JTextField cpfTextField  ) {
		this.botaoAlterar=botaoAlterar;
		this.jComboBoxTipoFuncionarios=jComboBoxTipoFuncionarios;
		this.cpfTextField=cpfTextField;
    }
	
	public void alterar(JTextField opcaoMenuJTextField, JFrame frameMenuInicial, RepositorioGerenteImpl repositorioGerenteImpl,RepositorioCoordenadorImpl repositorioCoordenadorImpl) {
		
		TelaComumListar telaListar= new TelaComumListar();
		List<Gerente> listaGerente = repositorioGerenteImpl.getGerentes();		
		List<Coordenador> listaCoordenador = repositorioCoordenadorImpl.listarCoordenadores();	
		//painel que lista funcionarios


		
		FrameTela frameTelaLista = telaListar.apresentarLista(listaGerente,listaCoordenador, frameMenuInicial);
		
		JPanel jPanel = frameTelaLista.getjPanel();
		JFrame frameAlteraGerente = new JFrame();
		frameAlteraGerente.setSize(500,600);		
		frameAlteraGerente.add(jPanel);
		frameAlteraGerente.setVisible(true);
		
		//INSTANCIA BOTAO
		botaoAlterar = new JButton("Alterar");
		 // create JComboBox
		 // array of string containing TipoFuncionario
	    String tiposFuncionario[] = { "     Cargo para alterar      ",TipoFuncionario.GERENTE.getDescricao(),TipoFuncionario.COORDENADOR.getDescricao() };
	    jComboBoxTipoFuncionarios = new JComboBox<String>(tiposFuncionario);
	    jComboBoxTipoFuncionarios.addItemListener(new TelaListaAlterar(botaoAlterar,jComboBoxTipoFuncionarios,cpfTextField));
	    jPanel.add(jComboBoxTipoFuncionarios);
       
       
		//		
		JLabel cpfTextoLabel = new JLabel("CPF para alterar");
		jPanel.add(cpfTextoLabel);
		
		cpfTextField = new JTextField(15);
		jPanel.add(cpfTextField);
		
		
		
		botaoAlterar.setName("btnBuscar");
		botaoAlterar.setActionCommand("btnBuscar");
		botaoAlterar.setEnabled(false);
		jPanel.add(botaoAlterar);
		
		JButton botaoMenuInicial = new JButton("Menu inicial");
		botaoMenuInicial.setName("btnMenu");
		botaoMenuInicial.setActionCommand("btnMenu");
		jPanel.add(botaoMenuInicial);
		
		frameAlteraGerente.add(jPanel);
		frameAlteraGerente.setVisible(true);
		
		
		frameTela.setFrameMenuInical(frameMenuInicial);		
		frameTela.setFrameAtual(frameAlteraGerente);
		frameTela.setCpfTextField(cpfTextField);
		frameTela.setjComboBoxTipoFuncionarios(jComboBoxTipoFuncionarios);
		frameTela.setRepositorioGerenteImpl(repositorioGerenteImpl);
		frameTela.setRepositorioCoordenadorImpl(repositorioCoordenadorImpl);
		//frameTela.setjButton(botaoCadastrar);
		
		ControleAlterar AlteraeControle = new ControleAlterar(frameTela);
		botaoAlterar.addActionListener(AlteraeControle);
//		
		ControleAlterar menu = new ControleAlterar(frameTela);
		botaoMenuInicial.addActionListener(menu);
		
	}
	
	
	
	@Override
	public void itemStateChanged(ItemEvent e) {
		//Habiliat ou desabilida o botao de alterar
		try {
			if(jComboBoxTipoFuncionarios!=null) {
				String tipo=jComboBoxTipoFuncionarios.getSelectedItem().toString();
				if(tipo.equals(TipoFuncionario.GERENTE.getDescricao())) {
					botaoAlterar.setEnabled(true);
				}
				else if(tipo.equals(TipoFuncionario.COORDENADOR.getDescricao())) {
					botaoAlterar.setEnabled(true);
				}
				else{
					botaoAlterar.setEnabled(false);
				}
				
			}
		}catch (Exception ex) {
			botaoAlterar.setEnabled(false);
		}
	}

	
}
