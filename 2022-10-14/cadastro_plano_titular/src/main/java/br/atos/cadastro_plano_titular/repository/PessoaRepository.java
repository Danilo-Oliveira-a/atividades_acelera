package br.atos.cadastro_plano_titular.repository;

import br.atos.cadastro_plano_titular.model.Pessoa;
import org.springframework.data.repository.CrudRepository;
//Implementa os metodos do crdu(create, read, update, delete)

// Interface que implementa os metodos de salvar, alterar, ler  e deletar (CRUD) - Herda os metodos da classe CrudRepository 
public interface PessoaRepository extends CrudRepository<Pessoa, Long> {
	Pessoa findById(long id);
}
