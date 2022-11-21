package br.com.atos.view.controleTelas;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;

import br.com.atos.enums.TipoFuncionario;
import br.com.atos.model.Coordenador;
import br.com.atos.model.Endereco;
import br.com.atos.model.Gerente;
import br.com.atos.model.tela.FrameTela;
import br.com.atos.validacao.Validacao;
import br.com.atos.view.telas.TelaAlterar;
import br.com.atos.view.telas.TelaListaAlterar;


public class ControleAlterar implements ActionListener {

FrameTela frameTela;
	
	boolean validarAlterar = false;

	public ControleAlterar(FrameTela frameTela) {
		super();
		this.frameTela=frameTela;
	}
	
	public ControleAlterar() {
		
	}


	@Override
	public void actionPerformed(ActionEvent e) {
		//tabelaFuncionario.isEditing();
		String botaoAcionado = e.getActionCommand();
		if(botaoAcionado.toUpperCase().equals("btnBuscar".toUpperCase())) {
			if(frameTela.getCpfTextField()==null){
		    	JOptionPane.showMessageDialog(null, "CPF Necessário!");
		    }
			else if(frameTela.getCpfTextField()!=null && frameTela.getCpfTextField().getText().equals("")){
		    	JOptionPane.showMessageDialog(null, "CPF Necessário!");
		    }
			else {
				frameTela.getFrameAtual().setVisible(false);
				TelaAlterar telaAlterar = new TelaAlterar();
				telaAlterar.alterar(frameTela.getFrameMenuInical(), frameTela.getFrameAtual(), frameTela.getRepositorioGerenteImpl(),frameTela.getRepositorioCoordenadorImpl(), frameTela.getCpfTextField().getText(),frameTela.getjComboBoxTipoFuncionarios());
					
			}
		}
		if(botaoAcionado.toUpperCase().equals("btnAlterar".toUpperCase())) {
			if(frameTela.getCpfTextField()==null){
		    	JOptionPane.showMessageDialog(null, "CPF Necessário!");
		    }
			else {
				Validacao validacao= new Validacao();
				boolean isValid = validacao.validaCamposEditar(frameTela);
				if(isValid) {
					String tipoFuncionario = frameTela.getjComboBoxTipoFuncionarios().getSelectedItem().toString();
					if(tipoFuncionario.equals(TipoFuncionario.GERENTE.getDescricao())) {
				    	Gerente gerente = new Gerente();
						gerente.setCpf(frameTela.getCpfTextField().getText());
						gerente.setNome(frameTela.getNomeTextField().getText());
						gerente.setCargo(TipoFuncionario.GERENTE);
						if(frameTela.getHorasTextField()!=null) {
							Double sal= gerente.calcularSalario(Double.parseDouble(frameTela.getHorasTextField().getText()));
							gerente.setSalarioLiquido(sal);
						}
						Endereco endereco = new Endereco();
						endereco.setEstado(frameTela.getEstadoTextField().getText());
						endereco.setRua(frameTela.getRuaTextField().getText());
						endereco.setNumero(frameTela.getNumeroTextField().getText());
						gerente.setEndereco(endereco);//				
						frameTela.getRepositorioGerenteImpl().alterar(gerente);
					}
					else if(tipoFuncionario.equals(TipoFuncionario.COORDENADOR.getDescricao())) {
						Coordenador coordenador = new Coordenador();
						coordenador.setNome(frameTela.getNomeTextField().getText());
						coordenador.setCpf(frameTela.getCpfTextField().getText());
						coordenador.setCargo(TipoFuncionario.COORDENADOR);
						if(frameTela.getHorasTextField()!=null) {
							Double sal= coordenador.calcularSalario(Double.parseDouble(frameTela.getHorasTextField().getText()));
							coordenador.setSalarioLiquido(sal);
						}
						Endereco endereco = new Endereco();
						endereco.setEstado(frameTela.getEstadoTextField().getText());
						endereco.setNumero(frameTela.getNumeroTextField().getText());
						endereco.setRua(frameTela.getRuaTextField().getText());
					
						coordenador.setEndereco(endereco);
						frameTela.getRepositorioCoordenadorImpl().alterar(coordenador);
					}
					TelaListaAlterar telaAlterar = new TelaListaAlterar();
					telaAlterar.alterar(null, frameTela.getFrameMenuInical(), frameTela.getRepositorioGerenteImpl(),frameTela.getRepositorioCoordenadorImpl());
					frameTela.getFrameAtual().dispose();
					frameTela.getFrameMenuInical().setVisible(false);
				}
				else {
					frameTela.getFrameMenuInical().setVisible(false);
					frameTela.getFrameAtual().setVisible(true);
					
				}
				
				
			}
		}
		//voltar menu
		if(botaoAcionado.toUpperCase().equals("btnMenu".toUpperCase())) {
			frameTela.getFrameMenuInical().setVisible(true);
			frameTela.getFrameAtual().setVisible(false);
		}
		
	}

	
	

	
	
	
	
	
	
}
