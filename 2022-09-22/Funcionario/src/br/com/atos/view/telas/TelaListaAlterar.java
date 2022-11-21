package br.com.atos.view.telas;

import java.awt.BorderLayout;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;

import br.com.atos.model.Gerente;
import br.com.atos.repositorio.impl.RepositorioGerenteImpl;
import br.com.atos.view.controleTelas.ControleAlterar;
import br.com.atos.view.controleTelas.ControleInicio;



public class TelaListaAlterar {

	public void alterar(JTextField opcaoMenuJTextField, JFrame frameMenuInicial, RepositorioGerenteImpl repositorioGerenteImpl) {
		
		List<Gerente> listaGerente = repositorioGerenteImpl.getGerentes();
		int quantidadeDeLinhas = listaGerente.size();
		
		String [][] tabelaString = new String [quantidadeDeLinhas][3];
		
		int posicaoLinha = 0;
		int posicaoColuna = 0;
		
		for(Gerente gerente: listaGerente) {
			
			tabelaString [posicaoLinha][posicaoColuna] = gerente.getNome();
			posicaoColuna++;
			
			tabelaString [posicaoLinha][posicaoColuna] = gerente.getCpf();
			posicaoColuna++;
			
			
			tabelaString [posicaoLinha][posicaoColuna] = gerente.getEstado();
			posicaoColuna = 0;
			posicaoLinha++;
		
		}
		
		
		String colunasTitulos[] = {"Nome", "Cpf", "Estado"};
		
		JFrame frameDeletaGerente = new JFrame();
		frameDeletaGerente.setSize(500,600);
		
		JTable tabelaFuncionario = new JTable(tabelaString,colunasTitulos);
		tabelaFuncionario.setBounds(30,40,00,200);
		
		JScrollPane scrollPaneTabela = new JScrollPane(tabelaFuncionario);
		scrollPaneTabela.setViewportView(tabelaFuncionario);
		scrollPaneTabela.setLocation(700,150);
		scrollPaneTabela.setSize(600,350);
		
		JPanel paneldeletarGerente= new JPanel();
		
		//add tabela
		paneldeletarGerente.add(scrollPaneTabela);
		
		
		//		
		JLabel nomeTextoLabel = new JLabel("CPF para alterar");
		paneldeletarGerente.add(nomeTextoLabel);
		
		JTextField opcaoCpfTextField = new JTextField(5);
		paneldeletarGerente.add(opcaoCpfTextField);
		
		JButton botaoMenu = new JButton("Alterar");
		paneldeletarGerente.add(botaoMenu);
		
		JButton botaoMenuInicial = new JButton("Menu inicial");
		paneldeletarGerente.add(botaoMenuInicial);
		
		frameDeletaGerente.add(paneldeletarGerente);
		frameDeletaGerente.setVisible(true);
		
		
		ControleAlterar menuDeleteControle = new ControleAlterar(opcaoCpfTextField, frameDeletaGerente, frameMenuInicial, repositorioGerenteImpl,tabelaFuncionario);
		botaoMenu.addActionListener(menuDeleteControle);
		
		//voltar para menu inicial
		ControleInicio telaListarControle = new ControleInicio(frameDeletaGerente, frameMenuInicial); 
		botaoMenuInicial.addActionListener(telaListarControle);
		
	}
	
	
	
	
	
}
