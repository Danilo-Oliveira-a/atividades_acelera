package br.com.atos.view.controleTelas;

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


public class ControleAlterar implements ActionListener, MouseListener {

	JFrame frameMenuInicial;
	JFrame frameDeletaGerente;
	
	JTextField nomeTextField;
	JTextField cpfTextField;
	JTextField estadoTextField;
	JTable tabelaFuncionario;
	RepositorioGerenteImpl repositorioGerenteImpl;
	
	boolean validarDeletar = false;

	
	
	public ControleAlterar(JTextField cpfTextField, JFrame frameTelaDelete, JFrame frameMenuInicial, RepositorioGerenteImpl repositorioGerenteImpl,JTable tabelaFuncionario) {
		super();
		this.frameMenuInicial = frameMenuInicial;
		this.frameDeletaGerente = frameTelaDelete;
		this.repositorioGerenteImpl = repositorioGerenteImpl;
		this.cpfTextField = cpfTextField;
		this.tabelaFuncionario=tabelaFuncionario;
	}
	
	public ControleAlterar() {
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		//tabelaFuncionario.isEditing();
	
		System.out.println("ação botao alterar");
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

	
	private void acionarAlterar(Gerente gerente ) {
		repositorioGerenteImpl.alterarGerente(gerente);
	}

	@Override
	public void mouseClicked(MouseEvent arg0) {
		System.out.println("CLICK");
		
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseEntered(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseExited(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mousePressed(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseReleased(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}
	
	
	
	
	
}
