package br.com.atos.view.telas;

import java.util.Objects;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import br.com.atos.enums.TipoFuncionario;
import br.com.atos.model.Coordenador;
import br.com.atos.model.Gerente;
import br.com.atos.model.tela.FrameTela;
import br.com.atos.repositorio.impl.RepositorioCoordenadorImpl;
import br.com.atos.repositorio.impl.RepositorioGerenteImpl;
import br.com.atos.view.controleTelas.ControleAlterar;

public class TelaAlterar {
	
	

	public void alterar(JFrame frameMenuInicial, JFrame frameAnterior,
			RepositorioGerenteImpl repositorioGerenteImpl,RepositorioCoordenadorImpl repositorioCoordenadorImpl, String valorCpf,JComboBox<String>jComboBoxTipoFuncionarios) {
		
		JFrame frameTelaAltera = new JFrame();
	
		String tipoFuncionario = jComboBoxTipoFuncionarios.getSelectedItem().toString();
		
		boolean existeFuncionario ;
		
		String nome=null;
		String cpf=null;
		String estado=null;
		String rua=null;
		String numero=null;	
		String horas=null;
		
		if(tipoFuncionario.equals(TipoFuncionario.GERENTE.getDescricao())) {
			existeFuncionario = repositorioGerenteImpl.listar().stream()
					.filter(Objects::nonNull)
					.filter(f->f.getCpf().equals(valorCpf)).findFirst().isPresent();
			if(existeFuncionario) {
				Gerente func = repositorioGerenteImpl.listar().stream()
						.filter(Objects::nonNull)
						.filter(f->f.getCpf().equals(valorCpf)).findFirst().get();
				nome = func.getNome();
				cpf=func.getCpf();
				estado=func.getEndereco().getEstado();
				rua = func.getEndereco().getRua();
				numero = func.getEndereco().getNumero();
				Double salarioLiq = func.getSalarioLiquido();
				horas = func.obterHorasTrabalhadas(salarioLiq);
			}
			else{
				JOptionPane.showMessageDialog(null, "Nenhum gerente encontrado com esse CPF: "+valorCpf);
			}
		}
		else {
			existeFuncionario = repositorioCoordenadorImpl.listar().stream()
					.filter(Objects::nonNull)
					.filter(f->f.getCpf().equals(valorCpf)).findFirst().isPresent();
			if(existeFuncionario) {
				Coordenador func = repositorioCoordenadorImpl.listar().stream()
						.filter(Objects::nonNull)
						.filter(f->f.getCpf().equals(valorCpf)).findFirst().get();
				nome = func.getNome();
				cpf=func.getCpf();
				estado=func.getEndereco().getEstado();
				rua = func.getEndereco().getRua();
				numero = func.getEndereco().getNumero();
				Double salarioLiq = func.getSalarioLiquido();
				horas = func.obterHorasTrabalhadas(salarioLiq)+"";
			}
			else{
				JOptionPane.showMessageDialog(null, "Nenhum coordenador encontrado com esse CPF: "+valorCpf);
			}
		}
		
		if(existeFuncionario) {
			
			String nomeTexto =    "NOME                 ";
			String cpfTexto =     "CPF                  ";
			String estadoTexto =  "ESTADO               ";
			String ruaTexto = 	  "RUA                  ";
			String numeroTexto =  "NÚMERO               ";
			
			String horasTexto =   "HORAS TRABALHADAS    ";
			
			JPanel painelTelaRegistro = new JPanel();
			//NOME
			JTextField nomeTextField = adicionaLabelTexto(painelTelaRegistro,nomeTexto,nome);	
			//CPF
			JTextField cpfTextField = adicionaLabelTexto(painelTelaRegistro,cpfTexto,cpf);
			//ESTADO
			JTextField estadoTextField = adicionaLabelTexto(painelTelaRegistro,estadoTexto,estado);
			//RUA
			JTextField ruaTextField = adicionaLabelTexto(painelTelaRegistro,ruaTexto,rua);
			//NUMERO
			JTextField numeroTextField = adicionaLabelTexto(painelTelaRegistro,numeroTexto,numero);
			
			//Horas
			JTextField horasTextField = adicionaLabelTexto(painelTelaRegistro,horasTexto,horas);
					
			JButton botaoAlterar = new JButton("Alterar");
			botaoAlterar.setName("btnAlterar");
			botaoAlterar.setActionCommand("btnAlterar");
			painelTelaRegistro.add(botaoAlterar);
			//CRIA FRAME
			
			frameTelaAltera.setSize(310, 350);
			frameTelaAltera.setTitle("SALVAR FUNCIONARIO");
			frameTelaAltera.setLocation(300,300);		
			frameTelaAltera.add(painelTelaRegistro);
			frameTelaAltera.setVisible(true);
			
			FrameTela frameTela = new FrameTela();
			frameTela.setCpfTextField(cpfTextField);
			frameTela.setNomeTextField(nomeTextField);
			frameTela.setEstadoTextField(estadoTextField);
			frameTela.setNumeroTextField(numeroTextField);
			frameTela.setRuaTextField(ruaTextField);
			frameTela.setRepositorioCoordenadorImpl(repositorioCoordenadorImpl);
			frameTela.setRepositorioGerenteImpl(repositorioGerenteImpl);
			frameTela.setFrameAtual(frameTelaAltera);
			frameTela.setFrameMenuInical(frameMenuInicial);
			frameTela.setjButton(botaoAlterar);
			frameTela.setHorasTextField(horasTextField);
			frameTela.setjComboBoxTipoFuncionarios(jComboBoxTipoFuncionarios);
			ControleAlterar telaRegistroControle = new ControleAlterar(frameTela);
			botaoAlterar.addActionListener(telaRegistroControle);
			
		}
		else {
			
			frameTelaAltera.setVisible(false);
			frameAnterior.setVisible(true);
		}
	}
	
	
	private JTextField adicionaLabelTexto(JPanel jPanel,String texto,String valor) {
		//cria o texto
		JLabel jLabel = new JLabel(texto);
		jLabel.setSize(20, 50);		
		jPanel.add(jLabel);
		
		//cria o campo de texto
		JTextField jTextField = new JTextField(20);
		jTextField.setText(valor);
		jPanel.add(jTextField);
		return jTextField;
	}

}
