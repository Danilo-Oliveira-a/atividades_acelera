package br.atos.cadastro_plano_titular.repository;

import br.atos.cadastro_plano_titular.model.Pessoa;
import br.atos.cadastro_plano_titular.model.Pet;
import org.springframework.data.repository.CrudRepository;
//Implementa os metodos do crdu(create, read, update, delete)

// Interface que implementa os metodos de salvar, alterar, ler  e deletar (CRUD) - Herda os metodos da classe CrudRepository 
public interface PetsRepository extends CrudRepository<Pet, Long> {
	Pet findById(long id);
	Iterable<Pet> findByPessoa(Pessoa pessoa);

	//long findIdPessoaByIdPet(long id);
}
