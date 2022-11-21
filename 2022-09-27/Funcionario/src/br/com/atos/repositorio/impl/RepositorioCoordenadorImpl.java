package br.com.atos.repositorio.impl;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;

import br.com.atos.model.Coordenador;
import br.com.atos.repositorio.RepositorioCoordenadorInterface;

public class RepositorioCoordenadorImpl implements RepositorioCoordenadorInterface{


    private List<Coordenador> coordenadores = new ArrayList<>();
    boolean sucesso = true;

    @Override
    public List<Coordenador> listarCoordenadores() {
        return this.coordenadores;
    }

    @Override
    public void salvarCoordenador(Coordenador coordenador) {
        try{
            coordenadores = listarCoordenadores();
            int id = coordenadores !=null? coordenadores.size()>0?coordenadores.size()+1:1:1;
            coordenador.setId(id);
            coordenadores.add(coordenador);
            System.out.println("\nCoordenador cadastrado com sucesso!!\n");
            JOptionPane.showMessageDialog(null, "Coordernador "+coordenador.getCpf()+" cadastrado com sucesso!!");
        }
        catch (Exception exception){
            sucesso =false;
        	JOptionPane.showMessageDialog(null, "Não foi possível salvar  coordenador de CPF:"+coordenador.getCpf());
        }
    }

    @Override
    public void alterarCoordenador(Coordenador coordenador) {
        try {
            coordenadores = listarCoordenadores();
            if(!coordenadores.stream()
                    .filter(g->g.getCpf().equals(coordenador.getCpf())).findFirst().isPresent()){
                System.out.printf("\nNenhum coordenador encontrado com esse cpf: %s",coordenador.getCpf());
                JOptionPane.showMessageDialog(null, "Nenhum coordenador encontrado com esse cpf: "+coordenador.getCpf());
            }
            for (Coordenador f: coordenadores) {
            	  if(f.getCpf().equals(coordenador.getCpf())){                	
                  	f.setEndereco(coordenador.getEndereco());
                  	f.setNome(coordenador.getNome());
                  	f.setCpf(coordenador.getCpf());
                	f.setSalarioLiquido(coordenador.getSalarioLiquido());
                     System.out.println("Coordenador alterado com sucesso!!\n");
                     // JOptionPane.showMessageDialog(null, "coordenador alterado com Sucesso!");
                  }
            }
        }
        catch (Exception exception){
            System.out.println("\ncatch: Erro ao alterar coordenador!!!!\n");
            JOptionPane.showMessageDialog(null, "catch: Erro ao alterar coordenador!!!"+exception.getMessage());
        }
    }

    @Override
    public void deletarCoordenador(Coordenador coordenador) {
    	try {
    		 coordenadores = listarCoordenadores();
            if(!coordenadores.stream()
                    .filter(g->g.getCpf().equals(coordenador.getCpf())).findFirst().isPresent()){
            	JOptionPane.showMessageDialog(null, "Nenhum coordenador encontrado com esse cpf: "+coordenador.getCpf());
                System.out.printf("\nNenhum coordenador encontrado com esse cpf: %s",coordenador.getCpf());
            }
            for (Coordenador c:coordenadores) {
                if(c.getCpf().equals(coordenador.getCpf())){
                	coordenadores.remove(c);
                	  JOptionPane.showMessageDialog(null, "Coordenador excluído com Sucesso!");
                   break;
                }
            }
        }
        catch (Exception exception){
        	JOptionPane.showMessageDialog(null, "catch: Erro ao exlcuir coordenador!!!"+exception.getMessage());
            System.out.println("\ncatch: Erro ao exlcuir coordenador!!!!\n");
        }
       
    }
}
