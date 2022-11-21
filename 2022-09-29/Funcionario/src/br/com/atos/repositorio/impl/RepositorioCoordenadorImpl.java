package br.com.atos.repositorio.impl;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;

import br.com.atos.dao.CoordenadorDAO;
import br.com.atos.model.Coordenador;
import br.com.atos.repositorio.RepositorioCoordenadorInterface;

public class RepositorioCoordenadorImpl implements RepositorioCoordenadorInterface{

	
	private List<Coordenador> Coordenadors = new ArrayList<>();
    boolean sucesso = false;
    CoordenadorDAO dao = new CoordenadorDAO();

    @Override
    public List<Coordenador> listar() {
        return dao.listar();
    }

    @Override
    public void salvar(Coordenador f) {
        try{
        	
        	if(dao.salvar(f))
        		JOptionPane.showMessageDialog(null, "Coordenador "+f.getCpf()+" cadastrado com sucesso!!");
        	else 
        		JOptionPane.showMessageDialog(null, "Não foi possível salvar Coordenador de CPF: "+f.getCpf());
        }
        catch (Exception exception){
        	JOptionPane.showMessageDialog(null, "Não foi possível salvar Coordenador de CPF: "+f.getCpf());
        }
    }

    @Override
    public void alterar(Coordenador f) {
        try {
        	Coordenadors = listar();
            if(!Coordenadors.stream()
                    .filter(g->g.getCpf().equals(f.getCpf())).findFirst().isPresent()){
            	JOptionPane.showMessageDialog(null, "Nenhum Coordenador encontrado com esse cpf: "+f.getCpf());
                System.out.printf("\nNenhum Coordenador encontrado com esse cpf: %s",f.getCpf());
            }
            for (Coordenador c:Coordenadors) {
                if(f.getCpf().equals(c.getCpf())){                	
                	if(dao.alterar(f))
                		JOptionPane.showMessageDialog(null, "Coordenador alterado com Sucesso!");
                	else 
                		JOptionPane.showMessageDialog(null, "Não foi possível alterar Coordenador de CPF: "+f.getCpf());
                }
            }
        }
        catch (Exception exception){
        	JOptionPane.showMessageDialog(null, "catch: Erro ao alterar Coordenador!!!"+exception.getMessage());
            System.out.println("\ncatch: Erro ao alterar Coordenador!!!!\n");
        }
    }

    @Override
    public void deletar(Coordenador f) {
        try {
            Coordenadors = listar();
            if(!Coordenadors.stream()
                    .filter(g->g.getCpf().equals(f.getCpf())).findFirst().isPresent()){
            	JOptionPane.showMessageDialog(null, "Nenhum Coordenador encontrado com esse cpf: "+f.getCpf());
                System.out.printf("\nNenhum Coordenador encontrado com esse cpf: %s",f.getCpf());
            }
            for (Coordenador c:Coordenadors) {
                if(c.getCpf().equals(f.getCpf())){
                	if(dao.alterar(f))
                		JOptionPane.showMessageDialog(null, "coordenador excluído com Sucesso!");
                	else 
                		JOptionPane.showMessageDialog(null, "Não foi possível excluir coordenador de CPF: "+f.getCpf());
                	  
                   break;
                }
            }
        }
        catch (Exception exception){
        	JOptionPane.showMessageDialog(null, "catch: Erro ao exlcuir Coordenador!!!"+exception.getMessage());
            System.out.println("\ncatch: Erro ao exlcuir Coordenador!!!!\n");
        }
    }
}
