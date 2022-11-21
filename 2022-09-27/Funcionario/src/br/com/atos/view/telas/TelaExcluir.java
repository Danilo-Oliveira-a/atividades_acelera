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
import br.com.atos.view.controleTelas.ControleExcluir;
import br.com.atos.view.controleTelas.ControleInicio;
import br.com.atos.view.telas.comuns.TelaComumListar;



public class TelaExcluir implements ItemListener {
	
	JButton botaoExcluir;
	JComboBox<String> jComboBoxTipoFuncionarios;
	JTextField cpfTextField;
	FrameTela frameTela = new FrameTela();
	
	public TelaExcluir() {
		
	}
	
	public TelaExcluir(JButton botaoExcluir,JComboBox<String> jComboBoxTipoFuncionarios,JTextField cpfTextField  ) {
		this.botaoExcluir=botaoExcluir;
		this.jComboBoxTipoFuncionarios=jComboBoxTipoFuncionarios;
		this.cpfTextField=cpfTextField;
    }

	public void excluir(JFrame frameMenuInicial, RepositorioGerenteImpl repositorioGerenteImpl,RepositorioCoordenadorImpl repositorioCoordenadorImpl) {
		List<Gerente> listaGerente = repositorioGerenteImpl.getGerentes();
		List<Coordenador> listaCoordenador = repositorioCoordenadorImpl.listarCoordenadores();
		
		TelaComumListar telaListar= new TelaComumListar();
		FrameTela telaListarD = telaListar.apresentarLista(listaGerente,listaCoordenador, frameMenuInicial);
	
		JPanel paneldeletarGerente = telaListarD.getjPanel();
		/////////////
		//JFrame frameDeletaGerente = new JFrame();
		JFrame frameDeletaGerente = new JFrame();
		frameDeletaGerente.setSize(500,600);		
		frameDeletaGerente.add(paneldeletarGerente);
		frameDeletaGerente.setVisible(true);
		
		JLabel nomeTextoLabel = new JLabel("CPF para Exluir");
		paneldeletarGerente.add(nomeTextoLabel);
		
		cpfTextField = new JTextField(5);
		paneldeletarGerente.add(cpfTextField);
		
		
		
		
		//INSTANCIA BOTAO
		botaoExcluir = new JButton("Excluir");
		 // create JComboBox
		 // array of string containing TipoFuncionario
	    String tiposFuncionario[] = { "     Cargo para alterar      ",TipoFuncionario.GERENTE.getDescricao(),TipoFuncionario.COORDENADOR.getDescricao() };
	    jComboBoxTipoFuncionarios = new JComboBox<String>(tiposFuncionario);
	    jComboBoxTipoFuncionarios.addItemListener(new TelaListaAlterar(botaoExcluir,jComboBoxTipoFuncionarios,cpfTextField));
	    paneldeletarGerente.add(jComboBoxTipoFuncionarios);
			    
	    //add botao
	    botaoExcluir.setName("btnBuscar");
	    botaoExcluir.setActionCommand("btnBuscar");
	    botaoExcluir.setEnabled(false);
	    paneldeletarGerente.add(botaoExcluir);
	    
		JButton botaoMenuInicial = new JButton("Menu inicial");
		paneldeletarGerente.add(botaoMenuInicial);
		
		frameDeletaGerente.add(paneldeletarGerente);
		frameDeletaGerente.setVisible(true);
		
		frameTela.setFrameMenuInical(frameMenuInicial);		
		frameTela.setFrameAtual(frameDeletaGerente);
		frameTela.setCpfTextField(cpfTextField);
		frameTela.setjComboBoxTipoFuncionarios(jComboBoxTipoFuncionarios);
		frameTela.setRepositorioGerenteImpl(repositorioGerenteImpl);
		frameTela.setRepositorioCoordenadorImpl(repositorioCoordenadorImpl);
		
		ControleExcluir menuDeleteControle = new ControleExcluir(frameTela);
		botaoExcluir.addActionListener(menuDeleteControle);
		//voltar para menu inicial
		ControleInicio telaListarControle = new ControleInicio(frameDeletaGerente, frameMenuInicial); 
		botaoMenuInicial.addActionListener(telaListarControle);
		
		
	}
	
	
	@Override
	public void itemStateChanged(ItemEvent e) {
		//Habiliat ou desabilida o botao de alterar
		try {
			if(jComboBoxTipoFuncionarios!=null) {
				String tipo=jComboBoxTipoFuncionarios.getSelectedItem().toString();
				if(tipo.equals(TipoFuncionario.GERENTE.getDescricao())) {
					botaoExcluir.setEnabled(true);
				}
				else if(tipo.equals(TipoFuncionario.COORDENADOR.getDescricao())) {
					botaoExcluir.setEnabled(true);
				}
				else{
					botaoExcluir.setEnabled(false);
				}
				
			}
		}catch (Exception ex) {
			botaoExcluir.setEnabled(false);
		}
	}
	
	
	
}
