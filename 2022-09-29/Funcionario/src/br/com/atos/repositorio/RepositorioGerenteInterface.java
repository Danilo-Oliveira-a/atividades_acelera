package br.com.atos.repositorio;
import java.util.List;

import br.com.atos.model.Gerente;

public interface RepositorioGerenteInterface {

    List<Gerente> listar();

    Gerente listarPorId(Gerente gerente);

    void salvar(Gerente gerente);

    void alterar(Gerente gerente);

    void deletar(Gerente gerente);

}
