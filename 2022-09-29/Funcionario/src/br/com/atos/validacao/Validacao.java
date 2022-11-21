package br.com.atos.validacao;

import java.util.List;
import java.util.regex.Pattern;

import javax.swing.JOptionPane;
import javax.swing.JTextField;

import br.com.atos.enums.TipoFuncionario;
import br.com.atos.model.Coordenador;
import br.com.atos.model.Gerente;
import br.com.atos.model.tela.FrameTela;

public class Validacao {

	public boolean validaCamposSalvar(FrameTela frameTela) {
		boolean validNome = validaNome(frameTela.getNomeTextField());
		if(!validNome)return false;
		
		boolean validCPF = 	validaCPF(frameTela);
		if(!validCPF)return false;
		
		boolean validEstado = validaEstado(frameTela.getEstadoTextField());
		if(!validEstado)return false;
		
		boolean validRua = validaRua(frameTela.getRuaTextField());
		if(!validRua)return false;
		
		boolean validNumero = validaNumero(frameTela.getNumeroTextField());
		if(!validNumero)return false;
		
		boolean validHoras = validaHorasTrabalhdas(frameTela.getHorasTextField());
		if(!validHoras)return false;
		
		
		return true;		
		
	}
	public boolean validaCamposEditar(FrameTela frameTela) {
		boolean validNome = validaNome(frameTela.getNomeTextField());
		if(!validNome)return false;
		
		boolean validCPF = 	validaCpfEditar(frameTela);
		if(!validCPF)return false;
		
		boolean validEstado = validaEstado(frameTela.getEstadoTextField());
		if(!validEstado)return false;
		
		boolean validRua = validaRua(frameTela.getRuaTextField());
		if(!validRua)return false;
		
		boolean validNumero = validaNumero(frameTela.getNumeroTextField());
		if(!validNumero)return false;
		
		boolean validHoras = validaHorasTrabalhdas(frameTela.getHorasTextField());
		if(!validHoras)return false;
		
		
		return true;		
		
	}
	
	
	private boolean validaNome(JTextField texto) {
		boolean valid = true;
		if(texto!=null)
			if(texto.getText().length()<4) {
				JOptionPane.showMessageDialog(null, "Nome precisa ter mais de 3 Caracteres!!");
				valid=false;
			}
		
		return valid;
	}
	
	private boolean validaCpfEditar(FrameTela frameTela)  {
		boolean valid = true;
		JTextField texto = frameTela.getCpfTextField();
		if(texto!=null) {
			if(texto.getText().length()<3) {
				JOptionPane.showMessageDialog(null, "CPF precisa ter no minímo 3 Caracteres!!");
				return false;
			}
		}
		return valid;
	}
	private boolean validaCPF(FrameTela frameTela)  {
		boolean valid = true;
		String tipoFuncionario = frameTela.getjComboBoxTipoFuncionarios().getSelectedItem().toString();
		JTextField texto = frameTela.getCpfTextField();
		if(texto!=null) {
			if(texto.getText().length()<3) {
				JOptionPane.showMessageDialog(null, "CPF precisa ter no minímo 3 Caracteres!!");
				return false;
			}
		}
		String cpf = texto.getText();
		if(tipoFuncionario.equals(TipoFuncionario.GERENTE.getDescricao())) {
			List<Gerente>lista = frameTela.getRepositorioGerenteImpl().listar();
			boolean isExiste = lista.stream().filter(g->g.getCpf().equals(cpf) && g.getCargo().getDescricao().equals(tipoFuncionario)).findFirst().isPresent();
			if(isExiste) {
				JOptionPane.showMessageDialog(null, "CPF "+cpf+ "já existe para esse cargo "+tipoFuncionario+"!!");
				return false;
			}
		}
		else if(tipoFuncionario.equals(TipoFuncionario.COORDENADOR.getDescricao())) {
			List<Coordenador>lista = frameTela.getRepositorioCoordenadorImpl().listar();
			boolean isExiste = lista.stream().filter(g->g.getCpf().equals(cpf) && g.getCargo().getDescricao().equals(tipoFuncionario)).findFirst().isPresent();
			if(isExiste) {
				JOptionPane.showMessageDialog(null, "CPF "+cpf+ "já existe para esse cargo "+tipoFuncionario+"!!");
				return false;
			}
		}
		return valid;
	}

	private boolean validaEstado(JTextField texto)  {
		boolean valid =true;
		if(texto!=null)
			if(texto.getText().length()<2) {
				JOptionPane.showMessageDialog(null, "Estado precisa ter no minimo de 2 Caracteres!!");
				valid =false;
			}
		
		return 	valid;
	}
	private boolean validaRua(JTextField texto) {
		boolean valid =true;
		if(texto!=null&&texto.getText().length()<3) {
			JOptionPane.showMessageDialog(null, "Rua precisa ter mais de 3 Caracteres!!");
			valid =false;
		}
		return 	valid;
	}
	
	private boolean  validaNumero(JTextField texto)  {
		boolean valid =true;
		Pattern p = Pattern.compile("[0-9]+"); //
		if(texto!=null) {
			if(!p.matcher(texto.getText()).matches()) {
				JOptionPane.showMessageDialog(null, "N°  aceita apenas números!");
				valid =false;
			}
		};
		return 	valid;
	}
	
	private boolean  validaHorasTrabalhdas(JTextField texto)  {
		boolean valid =true;
		Pattern p = Pattern.compile("^[-+]?\\d{1,3}(.\\d{3})*");
		if(texto!=null) {
			if(!p.matcher(texto.getText()).matches()) {
				JOptionPane.showMessageDialog(null, "Horas trabalhadas aceita apenas números com formatos EX: {30, 30.0,30.50}!");
				valid =false;
			}
		};
		return 	valid;
	}
			

}
