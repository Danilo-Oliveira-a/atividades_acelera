package br.com.atos.view.controleTelas;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import br.com.atos.enums.TipoFuncionario;
import br.com.atos.model.Coordenador;
import br.com.atos.model.Endereco;
import br.com.atos.model.Gerente;
import br.com.atos.model.tela.FrameTela;
import br.com.atos.validacao.Validacao;


public class ControleSalvar implements ActionListener  {

	FrameTela frameTela;
	boolean validarSalvar = false;

	public ControleSalvar(FrameTela frameTela) {
		super();
		this.frameTela=frameTela;
	}
	
	public ControleSalvar() {}

	@Override
	public void actionPerformed(ActionEvent e) {
		Validacao validacao= new Validacao();
		boolean isValid = validacao.validaCamposSalvar(frameTela);
		if(isValid) {
			acionarSalvar();
			frameTela.getFrameMenuInical().setVisible(true);
			frameTela.getFrameAtual().setVisible(false);
		}
		else {
			frameTela.getFrameMenuInical().setVisible(false);
			frameTela.getFrameAtual().setVisible(true);
		}
		
	}

	private void acionarSalvar() {
		String tipoFuncionario = frameTela.getjComboBoxTipoFuncionarios().getSelectedItem().toString();
		if(tipoFuncionario.equals(TipoFuncionario.GERENTE.getDescricao())) {
			Gerente gerente = new Gerente();
			gerente.setNome(frameTela.getNomeTextField().getText());
			gerente.setCpf(frameTela.getCpfTextField().getText());
			gerente.setCargo(TipoFuncionario.GERENTE);
			if(frameTela.getHorasTextField()!=null) {
				Double salarioLiq= gerente.calcularSalario( Double.parseDouble(frameTela.getHorasTextField().getText()));
				gerente.setSalarioLiquido(salarioLiq);
			}		
			Endereco endereco = new Endereco();
			endereco.setEstado(frameTela.getEstadoTextField().getText());
			endereco.setNumero(frameTela.getNumeroTextField().getText());
			endereco.setRua(frameTela.getRuaTextField().getText());
		
			gerente.setEndereco(endereco);
			frameTela.getRepositorioGerenteImpl().salvarGerente(gerente);
		}
		else if(tipoFuncionario.equals(TipoFuncionario.COORDENADOR.getDescricao())) {
			Coordenador coordenador = new Coordenador();
			coordenador.setNome(frameTela.getNomeTextField().getText());
			coordenador.setCpf(frameTela.getCpfTextField().getText());
			coordenador.setCargo(TipoFuncionario.COORDENADOR);
			if(frameTela.getHorasTextField()!=null) {
				Double salarioLiq= coordenador.calcularSalario( Double.parseDouble(frameTela.getHorasTextField().getText()));
				coordenador.setSalarioLiquido(salarioLiq);
			}
			Endereco endereco = new Endereco();
			endereco.setEstado(frameTela.getEstadoTextField().getText());
			endereco.setNumero(frameTela.getNumeroTextField().getText());
			endereco.setRua(frameTela.getRuaTextField().getText());
		
			coordenador.setEndereco(endereco);
			frameTela.getRepositorioCoordenadorImpl().salvarCoordenador(coordenador);
		}
	}
	
	
	
}
