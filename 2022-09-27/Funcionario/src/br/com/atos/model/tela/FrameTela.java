package br.com.atos.model.tela;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.JTextField;

import br.com.atos.repositorio.impl.RepositorioCoordenadorImpl;
import br.com.atos.repositorio.impl.RepositorioGerenteImpl;

public class FrameTela {

	private JFrame frameAtual;
	private JFrame frameMenuInical;
	private JPanel jPanel;
	private JTable jTable;
	private JTextField nomeTextField;
	private JTextField cpfTextField;;
	private JTextField estadoTextField;;
	private JTextField ruaTextField;;
	private JTextField numeroTextField;
	private JComboBox<String> jComboBoxTipoFuncionarios;
	private JButton jButton;
	private RepositorioGerenteImpl repositorioGerenteImpl;
	private RepositorioCoordenadorImpl repositorioCoordenadorImpl;
	private JTextField horasTextField;
	
	public JFrame getFrameAtual() {
		return frameAtual;
	}
	public void setFrameAtual(JFrame frameAtual) {
		this.frameAtual = frameAtual;
	}
	public JFrame getFrameMenuInical() {
		return frameMenuInical;
	}
	public void setFrameMenuInical(JFrame frameMenuInical) {
		this.frameMenuInical = frameMenuInical;
	}
	public JPanel getjPanel() {
		return jPanel;
	}
	public void setjPanel(JPanel jPanel) {
		this.jPanel = jPanel;
	}
	public JTable getjTable() {
		return jTable;
	}
	public void setjTable(JTable jTable) {
		this.jTable = jTable;
	}
	public JTextField getNomeTextField() {
		return nomeTextField;
	}
	public void setNomeTextField(JTextField nomeTextField) {
		this.nomeTextField = nomeTextField;
	}
	public JTextField getCpfTextField() {
		return cpfTextField;
	}
	public void setCpfTextField(JTextField cpfTextField) {
		this.cpfTextField = cpfTextField;
	}
	public JTextField getEstadoTextField() {
		return estadoTextField;
	}
	public void setEstadoTextField(JTextField estadoTextField) {
		this.estadoTextField = estadoTextField;
	}
	public JTextField getRuaTextField() {
		return ruaTextField;
	}
	public void setRuaTextField(JTextField ruaTextField) {
		this.ruaTextField = ruaTextField;
	}
	public JTextField getNumeroTextField() {
		return numeroTextField;
	}
	public void setNumeroTextField(JTextField numeroTextField) {
		this.numeroTextField = numeroTextField;
	}
	
	public JButton getjButton() {
		return jButton;
	}
	public void setjButton(JButton jButton) {
		this.jButton = jButton;
	}
	public RepositorioGerenteImpl getRepositorioGerenteImpl() {
		return repositorioGerenteImpl;
	}
	public void setRepositorioGerenteImpl(RepositorioGerenteImpl repositorioGerenteImpl) {
		this.repositorioGerenteImpl = repositorioGerenteImpl;
	}
	public RepositorioCoordenadorImpl getRepositorioCoordenadorImpl() {
		return repositorioCoordenadorImpl;
	}
	public void setRepositorioCoordenadorImpl(RepositorioCoordenadorImpl repositorioCoordenadorImpl) {
		this.repositorioCoordenadorImpl = repositorioCoordenadorImpl;
	}
	public JComboBox<String> getjComboBoxTipoFuncionarios() {
		return jComboBoxTipoFuncionarios;
	}
	public void setjComboBoxTipoFuncionarios(JComboBox<String> jComboBoxTipoFuncionarios) {
		this.jComboBoxTipoFuncionarios = jComboBoxTipoFuncionarios;
	}
	public JTextField getHorasTextField() {
		return horasTextField;
	}
	public void setHorasTextField(JTextField horasTextField) {
		this.horasTextField = horasTextField;
	}
	
	
	
	
	
}
