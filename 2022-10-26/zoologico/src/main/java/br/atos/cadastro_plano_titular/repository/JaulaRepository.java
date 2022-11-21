package br.atos.cadastro_plano_titular.repository;

import br.atos.cadastro_plano_titular.model.Jaula;
import org.springframework.data.repository.CrudRepository;

public interface JaulaRepository extends CrudRepository<Jaula, Long> {

    Jaula findById(long id);

}
