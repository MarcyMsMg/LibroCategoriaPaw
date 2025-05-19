package cl.paw.paw.repository;


import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import cl.paw.paw.model.Categoria;



@Repository
public interface CategoriaRepository extends CrudRepository<Categoria, Integer>{

}
