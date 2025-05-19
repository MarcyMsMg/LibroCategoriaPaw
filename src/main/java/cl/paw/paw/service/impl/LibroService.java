package cl.paw.paw.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cl.paw.paw.model.Libro;
import cl.paw.paw.repository.LibroRepository;
import cl.paw.paw.service.ILibroService;

@Service
public class LibroService implements ILibroService {
    @Autowired
    LibroRepository repo;

    //Nuevo Libro
    @Override
    public Libro insLibroDTO(Libro libro){
        return repo.save(libro);
    }

    //Modificar Libro
    @Override
    public Libro actLibroDTO(int id_libro, Libro libro) {
        libro.setId_libro(id_libro);
        return repo.save(libro);
    }

    //Eliminar Libro
    @Override
    public Libro deleteLibroDTO(int id_libro) {
        repo.deleteById(id_libro);
        return null;
    }

    //Listar todos los libros
    @Override
    public List<Libro> getAllLibro() {
        List<Libro> aux = new ArrayList<>();
        repo.findAll().forEach(aux::add);
        return aux;
    }

    //Listar libro por su id
    @Override
    public Libro getByIdLibro(int id_libro) {
        return repo.findById(id_libro).orElse(null); // evita excepción si no existe
    }

    //Existencia por su id
    @Override
    public boolean existePorId(int id_libro) {
        return repo.existsById(id_libro);
    }
}

