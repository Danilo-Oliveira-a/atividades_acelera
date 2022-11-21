package br.com.atos.view.telas;

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
import br.com.atos.view.controleTelas.ControleExcluir;
import br.com.atos.view.controleTelas.ControleInicio;



public class TelaExcluir {

	public void excluir(JFrame frameMenuInicial, RepositorioGerenteImpl repositorioGerenteImpl) {
		List<Gerente>listaGerente = repositorioGerenteImpl.listarGerentes();
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
		
		JTable tabelaProgramador = new JTable(tabelaString,colunasTitulos);
		tabelaProgramador.setBounds(30,40,200,300);
		
		JScrollPane scrollPaneTabela = new JScrollPane(tabelaProgramador);
		JPanel paneldeletarGerente= new JPanel();
		
		paneldeletarGerente.add(scrollPaneTabela);
		
		JLabel nomeTextoLabel = new JLabel("CPF para Exluir");
		paneldeletarGerente.add(nomeTextoLabel);
		
		JTextField opcaoCpfTextField = new JTextField(5);
		paneldeletarGerente.add(opcaoCpfTextField);
		
		JButton botaoMenu = new JButton("Deletar");
		paneldeletarGerente.add(botaoMenu);
		
		JButton botaoMenuInicial = new JButton("Menu inicial");
		paneldeletarGerente.add(botaoMenuInicial);
		
		frameDeletaGerente.add(paneldeletarGerente);
		frameDeletaGerente.setVisible(true);
		
		
		ControleExcluir menuDeleteControle = new ControleExcluir(opcaoCpfTextField, frameDeletaGerente, frameMenuInicial, repositorioGerenteImpl);
		botaoMenu.addActionListener(menuDeleteControle);
		//voltar para menu inicial
		ControleInicio telaListarControle = new ControleInicio(frameDeletaGerente, frameMenuInicial); 
		botaoMenuInicial.addActionListener(telaListarControle);
		
		
	}
	
	
	
	
	
}
