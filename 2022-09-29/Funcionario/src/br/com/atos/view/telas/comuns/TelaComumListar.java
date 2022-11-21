package br.com.atos.view.telas.comuns;

import java.util.List;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;

import br.com.atos.model.Coordenador;
import br.com.atos.model.Gerente;
import br.com.atos.model.tela.FrameTela;

public class TelaComumListar {

	public FrameTela apresentarLista(List<Gerente> listaGerente, List<Coordenador> listaCoordenador, JFrame frameMenuInicial) {
		
		int quantidadeDeLinhasGerente = listaGerente.size();		
		int quantidadeDeLinhasCoordenador= listaCoordenador.size();		
		int quantidadeDeLinhasTotais = quantidadeDeLinhasGerente+quantidadeDeLinhasCoordenador;
		
		String colunasTitulos[] = {"Nome", "Cpf", "Estado","Rua", "Numero","Cargo","Salário"};
		
		String [][] tabelaString = new String [quantidadeDeLinhasTotais][colunasTitulos.length];
		
		int posicaoLinha = 0;
		int posicaoColuna = 0;
		
		for(Gerente gerente: listaGerente) {
			tabelaString [posicaoLinha][posicaoColuna] = gerente.getNome();
			posicaoColuna++;			
			tabelaString [posicaoLinha][posicaoColuna] = gerente.getCpf();
			posicaoColuna++;			
			tabelaString [posicaoLinha][posicaoColuna] = gerente.getEndereco().getEstado();			
			posicaoColuna++;
			tabelaString [posicaoLinha][posicaoColuna] = gerente.getEndereco().getRua();
			posicaoColuna++;
			tabelaString [posicaoLinha][posicaoColuna] = gerente.getEndereco().getNumero();
			posicaoColuna++;
			tabelaString [posicaoLinha][posicaoColuna] = gerente.getCargo().getDescricao();
			posicaoColuna++;
			tabelaString [posicaoLinha][posicaoColuna] = gerente.getSalarioLiquido()+"";
			
			posicaoColuna = 0;
			posicaoLinha++;
		}
		
		//ADD COORDENADOR NA TABLE
		 posicaoLinha = tabelaString.length-1;
		 posicaoColuna = 0;
		for(Coordenador coordenador: listaCoordenador) {
			tabelaString [posicaoLinha][posicaoColuna] = coordenador.getNome();
			posicaoColuna++;			
			tabelaString [posicaoLinha][posicaoColuna] = coordenador.getCpf();
			posicaoColuna++;			
			tabelaString [posicaoLinha][posicaoColuna] = coordenador.getEndereco().getEstado();			
			posicaoColuna++;
			tabelaString [posicaoLinha][posicaoColuna] = coordenador.getEndereco().getRua();
			posicaoColuna++;
			tabelaString [posicaoLinha][posicaoColuna] = coordenador.getEndereco().getNumero();
			posicaoColuna++;
			tabelaString [posicaoLinha][posicaoColuna] = coordenador.getCargo().getDescricao();
			posicaoColuna++;
			tabelaString [posicaoLinha][posicaoColuna] = coordenador.getSalarioLiquido()+"";
			
			posicaoColuna = 0;
			posicaoLinha++;
		}
		
		
		JTable tabelaProgramador = new JTable(tabelaString,colunasTitulos);
		tabelaProgramador.setBounds(30,40,300,300);
		
		JScrollPane scrollPaneTabela = new JScrollPane(tabelaProgramador);
		JPanel panelListarProgramador = new JPanel();		
		panelListarProgramador.add(scrollPaneTabela);
		
		FrameTela frameTela = new FrameTela();
		frameTela.setFrameMenuInical(frameMenuInicial);
		frameTela.setjTable(tabelaProgramador);
		frameTela.setjPanel(panelListarProgramador);
		
		return frameTela;
		
	
	}
	
	
	
	
	
}
