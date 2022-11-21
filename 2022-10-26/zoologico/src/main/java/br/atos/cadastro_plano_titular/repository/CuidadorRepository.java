package br.atos.cadastro_plano_titular.repository;

import br.atos.cadastro_plano_titular.model.Cuidador;
import org.springframework.data.repository.CrudRepository;

public interface CuidadorRepository extends CrudRepository<Cuidador, Long> {
    Cuidador findById(long id);
}
