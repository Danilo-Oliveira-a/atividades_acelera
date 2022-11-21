package br.atos.zoologico.repository;

import br.atos.zoologico.model.Animal;
import org.springframework.data.repository.CrudRepository;

public interface AnimalRepository extends CrudRepository<Animal, Long> {
    Animal findById(long id);
}
