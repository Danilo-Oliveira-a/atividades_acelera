package br.com.atos.repositorio;
import java.util.List;

import br.com.atos.model.Coordenador;

public interface RepositorioCoordenadorInterface {

    List<Coordenador> listarCoordenadores();

    void salvarCoordenador(Coordenador coordenador);

    void alterarCoordenador(Coordenador coordenador);

    void deletarCoordenador(Coordenador coordenador);
}
