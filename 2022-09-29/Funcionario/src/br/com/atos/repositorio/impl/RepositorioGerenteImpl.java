package br.com.atos.repositorio.impl;

import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;

import br.com.atos.dao.GerenteDAO;
import br.com.atos.model.Gerente;
import br.com.atos.repositorio.RepositorioGerenteInterface;

public class RepositorioGerenteImpl implements RepositorioGerenteInterface{


    private List<Gerente> gerentes = new ArrayList<>();
    boolean sucesso = false;
    GerenteDAO dao = new GerenteDAO();

    @Override
    public List<Gerente> listar() {
        return dao.listar();
    }

    @Override
    public Gerente listarPorId(Gerente f) {
        return  new Gerente();
    }

    @Override
    public void salvar(Gerente f) {
        try{
        	
        	if(dao.salvar(f))
        		JOptionPane.showMessageDialog(null, "Gerente "+f.getCpf()+" cadastrado com sucesso!!");
        	else 
        		JOptionPane.showMessageDialog(null, "Não foi possível salvar gerente de CPF: "+f.getCpf());
        }
        catch (Exception exception){
        	JOptionPane.showMessageDialog(null, "Não foi possível salvar gerente de CPF: "+f.getCpf());
        }
    }

    @Override
    public void alterar(Gerente f) {
        try {
        	gerentes = listar();
            if(!gerentes.stream()
                    .filter(g->g.getCpf().equals(f.getCpf())).findFirst().isPresent()){
            	JOptionPane.showMessageDialog(null, "Nenhum gerente encontrado com esse cpf: "+f.getCpf());
                System.out.printf("\nNenhum gerente encontrado com esse cpf: %s",f.getCpf());
            }
            for (Gerente gerente:gerentes) {
                if(f.getCpf().equals(gerente.getCpf())){                	
                	if(dao.alterar(f))
                		JOptionPane.showMessageDialog(null, "Gerente alterado com Sucesso!");
                	else 
                		JOptionPane.showMessageDialog(null, "Não foi possível alterar gerente de CPF: "+f.getCpf());
                }
            }
        }
        catch (Exception exception){
        	JOptionPane.showMessageDialog(null, "catch: Erro ao alterar gerente!!!"+exception.getMessage());
            System.out.println("\ncatch: Erro ao alterar gerente!!!!\n");
        }
    }

    @Override
    public void deletar(Gerente f) {
        try {
            gerentes = listar();
            if(!gerentes.stream()
                    .filter(g->g.getCpf().equals(f.getCpf())).findFirst().isPresent()){
            	JOptionPane.showMessageDialog(null, "Nenhum gerente encontrado com esse cpf: "+f.getCpf());
                System.out.printf("\nNenhum gerente encontrado com esse cpf: %s",f.getCpf());
            }
            for (Gerente g:gerentes) {
                if(g.getCpf().equals(f.getCpf())){
                	if(dao.deletar(f))
                		JOptionPane.showMessageDialog(null, "Gerente deletado com Sucesso!");
                	else 
                		JOptionPane.showMessageDialog(null, "Não foi possível deletar gerente de CPF: "+f.getCpf());
                   break;
                }
            }
        }
        catch (Exception exception){
        	JOptionPane.showMessageDialog(null, "catch: Erro ao exlcuir gerente!!!"+exception.getMessage());
            System.out.println("\ncatch: Erro ao exlcuir gerente!!!!\n");
        }
    }

}
