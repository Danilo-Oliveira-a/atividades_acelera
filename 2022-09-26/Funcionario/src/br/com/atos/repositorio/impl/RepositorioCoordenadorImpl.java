package br.com.atos.repositorio.impl;
import java.util.ArrayList;
import java.util.List;

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
    public boolean salvarCoordenador(Coordenador coordenador) {
        try{
            coordenadores = listarCoordenadores();
            int id = coordenadores !=null? coordenadores.size()>0?coordenadores.size()+1:1:1;
            coordenador.setId(id);
            coordenadores.add(coordenador);
            System.out.println("\nCoordenador cadastrado com sucesso!!\n");
        }
        catch (Exception exception){
            sucesso =false;
            System.out.println("\ncatch: Erro ao alterar coordenador!!!!\n");
        }
        return sucesso;
    }

    @Override
    public boolean alterarCoordenador(Coordenador coordenador) {
        try {
            coordenadores = listarCoordenadores();
            if(!coordenadores.stream()
                    .filter(g->g.getId()==coordenador.getId()).findFirst().isPresent()){
                System.out.printf("\nNenhum coordenador encontrado com esse cpf: %s",coordenador.getCpf());
                return false;
            }
            for (Coordenador g: coordenadores) {
                if(g.getId()==coordenador.getId()){
//                    g.setCargo(coordenador.getCargo());
//                    g.setLoja(coordenador.getLoja());
//                    g.setMetaDaLoja(coordenador.getMetaDaLoja());
                    if(coordenador.getNome()!=null &&!coordenador.getNome().equals("") )
                        g.setNome(coordenador.getNome());
                    if(coordenador.getSalarioLiquido()!=null && coordenador.getSalarioLiquido()!=0 )
                        g.setSalarioLiquido(coordenador.getSalarioLiquido());
//                    g.setCpf(coordenador.getCpf());
                    System.out.println("\nCoordenador alterado com sucesso!!\n");
                    return true;
                }
            }
        }
        catch (Exception exception){
            System.out.println("\ncatch: Erro ao alterar coordenador!!!!\n");
            sucesso =false;
        }
        return sucesso;
    }

    @Override
    public boolean deletarCoordenador(Coordenador coordenador) {
        try {
            coordenadores = listarCoordenadores();
            if(!coordenadores.stream()
                    .filter(g->g.getId()==coordenador.getId()).findFirst().isPresent()){
                System.out.printf("\nNenhum Coordenador encontrado com esse cpf: %s",coordenador.getCpf());
                return false;
            }
            Coordenador coordenadorRemover = new Coordenador();
            for (Coordenador g: coordenadores) {
                if(g.getId()==coordenador.getId()){
                    coordenadorRemover = g;
                   break;
                }
            }
            coordenadores.remove(coordenadorRemover);
            System.out.println("\nCoordenador deletado com sucesso!!\n");
        }
        catch (Exception exception){
            System.out.println("\ncatch: Erro ao alterar coordenador!!!!\n");
            sucesso =false;
        }
        return sucesso;
    }
}
