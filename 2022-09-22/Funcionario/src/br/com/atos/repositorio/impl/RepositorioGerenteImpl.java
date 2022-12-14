package br.com.atos.repositorio.impl;

import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;

import br.com.atos.model.Gerente;
import br.com.atos.repositorio.RepositorioGerenteInterface;

public class RepositorioGerenteImpl implements RepositorioGerenteInterface{


    private List<Gerente> gerentes = new ArrayList<>();
    boolean sucesso = false;

    @Override
    public List<Gerente> listarGerentes() {
        return this.gerentes;
    }

    @Override
    public Gerente listarGerentePorId(Gerente gerente) {
        return  new Gerente();
    }

    @Override
    public void salvarGerente(Gerente gerente) {
        try{
            gerentes = listarGerentes();
            int id = gerentes!=null?gerentes.size()>0?gerentes.size()+1:1:1;
            gerente.setId(id);
            gerentes.add(gerente);
            System.out.println("\nGerente cadastrado com sucesso!!\n");
            JOptionPane.showMessageDialog(null, "Funcion?rio "+gerente.getCpf()+" cadastrado com sucesso!!");
            
        }
        catch (Exception exception){
        	JOptionPane.showMessageDialog(null, "N?o foi poss?vel salvar Funcion?rio "+gerente.getCpf());
        }
    }

    @Override
    public void alterarGerente(Gerente gerente) {
        try {
        	gerentes = listarGerentes();
            if(!gerentes.stream()
                    .filter(g->g.getCpf().equals(gerente.getCpf())).findFirst().isPresent()){
            	JOptionPane.showMessageDialog(null, "Nenhum gerente encontrado com esse cpf: "+gerente.getCpf());
                System.out.printf("\nNenhum gerente encontrado com esse cpf: %s",gerente.getCpf());
            }
            for (Gerente g:gerentes) {
                if(g.getCpf().equals(gerente.getCpf())){
                	g.setEstado(gerente.getEstado());
                	g.setNome(gerente.getNome());
                	g.setCpf(g.getCpf());
                  //  g = gerente;
                    JOptionPane.showMessageDialog(null, "Funcion?rio alterado com Sucesso!");
                }
            }
        }
        catch (Exception exception){
        	JOptionPane.showMessageDialog(null, "catch: Erro ao alterar gerente!!!"+exception.getMessage());
            System.out.println("\ncatch: Erro ao alterar gerente!!!!\n");
            sucesso =false;
        }
    }

    @Override
    public void deletarGerente(Gerente gerente) {
        try {
            gerentes = listarGerentes();
            if(!gerentes.stream()
                    .filter(g->g.getCpf().equals(gerente.getCpf())).findFirst().isPresent()){
            	JOptionPane.showMessageDialog(null, "Nenhum gerente encontrado com esse cpf: "+gerente.getCpf());
                System.out.printf("\nNenhum gerente encontrado com esse cpf: %s",gerente.getCpf());
            }
            for (Gerente g:gerentes) {
                if(g.getCpf().equals(gerente.getCpf())){
                	gerentes.remove(g);
                	  JOptionPane.showMessageDialog(null, "Funcion?rio exclu?do com Sucesso!");
                   break;
                }
            }
        }
        catch (Exception exception){
        	JOptionPane.showMessageDialog(null, "catch: Erro ao exlcuir gerente!!!"+exception.getMessage());
            System.out.println("\ncatch: Erro ao exlcuir gerente!!!!\n");
        }
    }

	public List<Gerente> getGerentes() {
		return gerentes;
	}

	public void setGerentes(List<Gerente> gerentes) {
		this.gerentes = gerentes;
	}
    
}
