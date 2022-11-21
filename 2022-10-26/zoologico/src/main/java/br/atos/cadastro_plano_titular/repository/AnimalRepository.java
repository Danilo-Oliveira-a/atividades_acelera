package br.atos.cadastro_plano_titular.repository;

import br.atos.cadastro_plano_titular.model.Animal;
import org.springframework.data.repository.CrudRepository;

public interface AnimalRepository extends CrudRepository<Animal, Long> {
    Animal findById(long id);
}
