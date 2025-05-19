package cl.paw.paw.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import cl.paw.paw.model.Libro;

@Repository
public interface LibroRepository extends CrudRepository<Libro, Integer>{

}