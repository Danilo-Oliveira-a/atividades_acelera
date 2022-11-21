package br.com.atos.view.controleTelas;

import java.awt.AWTEvent;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.UIDefaults;
import javax.swing.UIManager;

import br.com.atos.model.Gerente;
import br.com.atos.repositorio.impl.RepositorioGerenteImpl;


public class ControleAlterar implements ActionListener {

	JFrame frameMenuInicial;
	JFrame frameAlteraGerente;
	
	JTextField nomeTextField;
	JTextField cpfTextField;
	JTextField estadoTextField;
	JTable tabelaFuncionario;
	RepositorioGerenteImpl repositorioGerenteImpl;
	
	boolean validarDeletar = false;

	
	
	public ControleAlterar(JTextField cpfTextField, JFrame frameTelaDelete, JFrame frameMenuInicial, RepositorioGerenteImpl repositorioGerenteImpl,JTable tabelaFuncionario) {
		super();
		this.frameMenuInicial = frameMenuInicial;
		this.frameAlteraGerente = frameTelaDelete;
		this.repositorioGerenteImpl = repositorioGerenteImpl;
		this.cpfTextField = cpfTextField;
		this.tabelaFuncionario=tabelaFuncionario;
	}
	
	public ControleAlterar() {
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		//tabelaFuncionario.isEditing();
		String botaoAcionado = e.getActionCommand();
		
		if(botaoAcionado.toUpperCase().equals("btnAlterar".toUpperCase())) {
			if((cpfTextField!=null
					&& cpfTextField.getText()!=null
					&& cpfTextField.getText().equals(""))
					|| cpfTextField.getText().equals(null)){
		    	JOptionPane.showMessageDialog(null, "CPF Necessário!");
		    }
			else {
				if (tabelaFuncionario.isEditing())
					tabelaFuncionario.getCellEditor().stopCellEditing();
				
				int selectedRow = tabelaFuncionario.getSelectedRow();
				int totalCollumns= tabelaFuncionario.getColumnModel().getColumnCount();
			    String nome=null;
			    String cpf=null;
			    String estado=null;
		    	for (int i = 0; i < totalCollumns; i++) {	
		    		if(i==0)nome = (String) tabelaFuncionario.getValueAt(selectedRow, i);
		    		if(i==1)cpf = (String) tabelaFuncionario.getValueAt(selectedRow, i);
		    		if(i==2)estado = (String) tabelaFuncionario.getValueAt(selectedRow, i);
			     
		    	}
		    	Gerente gerente = new Gerente();
				gerente.setCpf(cpf);
				gerente.setNome(nome);
				gerente.setEstado(estado);
				
				acionarAlterar(gerente);
			//	frameDeletaGerente.setVisible(false);
			//	frameMenuInicial.setVisible(true);
			}
		}
		//voltar menu
		else {
			frameMenuInicial.setVisible(true);
			frameAlteraGerente.setVisible(false);
		}
		
	}

	
	private void acionarAlterar(Gerente gerente ) {
		repositorioGerenteImpl.alterarGerente(gerente);
	}

	
	
	
	
	
	
}
