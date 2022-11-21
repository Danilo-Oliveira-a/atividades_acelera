package br.com.atos.repositorio;
import java.util.List;

import br.com.atos.model.Gerente;

public interface RepositorioGerenteInterface {

    List<Gerente> listarGerentes();

    Gerente listarGerentePorId(Gerente gerente);

    void salvarGerente(Gerente gerente);

    void alterarGerente(Gerente gerente);

    void deletarGerente(Gerente gerente);

}
