package br.com.atos.repositorio;
import java.util.List;

import br.com.atos.model.Coordenador;

public interface RepositorioCoordenadorInterface {

    List<Coordenador> listarCoordenadores();

    boolean salvarCoordenador(Coordenador coordenador);

    boolean alterarCoordenador(Coordenador coordenador);

    boolean deletarCoordenador(Coordenador coordenador);
}
