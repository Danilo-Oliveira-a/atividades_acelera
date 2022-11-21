package br.com.atos.view.controleTelas;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;

import br.com.atos.enums.TipoFuncionario;
import br.com.atos.model.Coordenador;
import br.com.atos.model.Gerente;
import br.com.atos.model.tela.FrameTela;
import br.com.atos.view.telas.TelaExcluir;


public class ControleExcluir implements ActionListener {

	FrameTela frameTela;
	boolean validarDeletar = false;


	public ControleExcluir(FrameTela frameTela) {
		super();
		this.frameTela=frameTela;
	}
	
	public ControleExcluir() {
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		System.out.println("exlcuir");
		if(frameTela.getCpfTextField()==null){
	    	JOptionPane.showMessageDialog(null, "CPF Necessário!");
	    }
		else if(frameTela.getCpfTextField()!=null && frameTela.getCpfTextField().getText().equals("")){
	    	JOptionPane.showMessageDialog(null, "CPF Necessário!");
	    }
		else {
			String tipoFuncionario = frameTela.getjComboBoxTipoFuncionarios().getSelectedItem().toString();
			if(tipoFuncionario.equals(TipoFuncionario.GERENTE.getDescricao())) {
				Gerente gerente = new Gerente();
				gerente.setCpf(frameTela.getCpfTextField().getText());
				frameTela.getRepositorioGerenteImpl().deletarGerente(gerente);
				TelaExcluir telaExcluir = new TelaExcluir();
				telaExcluir.excluir(frameTela.getFrameMenuInical(), frameTela.getRepositorioGerenteImpl(),frameTela.getRepositorioCoordenadorImpl());
				frameTela.getFrameAtual().dispose();
			}
			else {
				Coordenador coordenador = new Coordenador();
				coordenador.setCpf(frameTela.getCpfTextField().getText());
				frameTela.getRepositorioCoordenadorImpl().deletarCoordenador(coordenador);
				TelaExcluir telaExcluir = new TelaExcluir();
				telaExcluir.excluir(frameTela.getFrameMenuInical(), frameTela.getRepositorioGerenteImpl(),frameTela.getRepositorioCoordenadorImpl());
				frameTela.getFrameAtual().dispose();
				}
		}
	}

	

	
	
	
	
}
