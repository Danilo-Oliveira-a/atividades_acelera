package br.com.atos.view.telas;

import java.util.List;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import br.com.atos.model.Gerente;
import br.com.atos.view.controleTelas.ControleInicio;



public class TelaListar {

	public void apresentarLista(List<Gerente> listaGerente, JFrame frameMenuInicial) {
		
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
		
		JFrame frameTelaLista = new JFrame();
		frameTelaLista.setSize(500,600);
		
		JTable tabelaProgramador = new JTable(tabelaString,colunasTitulos);
		tabelaProgramador.setBounds(30,40,200,300);
		
		JScrollPane scrollPaneTabela = new JScrollPane(tabelaProgramador);
		JPanel panelListarProgramador = new JPanel();
		
		panelListarProgramador.add(scrollPaneTabela);
		
		JButton btnVoltar = new JButton("Voltar");
		panelListarProgramador.add(btnVoltar);
		
		frameTelaLista.add(panelListarProgramador);
		frameTelaLista.setVisible(true);
		
		ControleInicio telaListarControle = new ControleInicio(frameTelaLista, frameMenuInicial);
		btnVoltar.addActionListener(telaListarControle);
	}
	
	
	
	
	
}
