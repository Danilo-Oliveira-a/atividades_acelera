package br.atos.zoologico.repository;

import br.atos.zoologico.model.Jaula;
import org.springframework.data.repository.CrudRepository;

public interface JaulaRepository extends CrudRepository<Jaula, Long> {

    Jaula findById(long id);

}
