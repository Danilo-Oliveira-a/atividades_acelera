package br.com.atos.repositorio;
import java.util.List;

import br.com.atos.model.Coordenador;

public interface RepositorioCoordenadorInterface {

    List<Coordenador> listar();

    void salvar(Coordenador coordenador);

    void alterar(Coordenador coordenador);

    void deletar(Coordenador coordenador);
}
