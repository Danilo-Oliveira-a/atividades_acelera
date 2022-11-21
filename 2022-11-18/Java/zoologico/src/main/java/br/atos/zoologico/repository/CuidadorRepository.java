package br.atos.zoologico.repository;

import br.atos.zoologico.model.Cuidador;
import org.springframework.data.repository.CrudRepository;

public interface CuidadorRepository extends CrudRepository<Cuidador, Long> {
    Cuidador findById(long id);
}
