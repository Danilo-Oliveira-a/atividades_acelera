package br.com.atos.view.telas;

import java.util.List;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

import br.com.atos.model.Coordenador;
import br.com.atos.model.Gerente;
import br.com.atos.model.tela.FrameTela;
import br.com.atos.repositorio.impl.RepositorioCoordenadorImpl;
import br.com.atos.repositorio.impl.RepositorioGerenteImpl;
import br.com.atos.view.controleTelas.ControleInicio;
import br.com.atos.view.telas.comuns.TelaComumListar;



public class TelaListar {

	public void apresentarLista(RepositorioGerenteImpl repositorioGerenteImpl,RepositorioCoordenadorImpl repositorioCoordenadorImpl, JFrame frameMenuInicial) {		
		TelaComumListar telaListar= new TelaComumListar();
		List<Gerente> listaGerente = repositorioGerenteImpl.listar();
		List<Coordenador> listaCoordenador = repositorioCoordenadorImpl.listar();
		
		FrameTela frameTela = telaListar.apresentarLista(listaGerente,listaCoordenador, frameMenuInicial);
		JPanel jPanel = frameTela.getjPanel();
		
		JButton btnVoltar = new JButton("Voltar");
		jPanel.add(btnVoltar);
		
		JFrame frameTelaLista = new JFrame();
		frameTelaLista.setSize(500,600);		
		frameTelaLista.add(jPanel);
		frameTelaLista.setVisible(true);
		
		ControleInicio telaListarControle = new ControleInicio(frameTelaLista, frameMenuInicial);
		btnVoltar.addActionListener(telaListarControle);
	}
		
	
	
}
