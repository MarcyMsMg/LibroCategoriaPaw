package cl.paw.paw.service;

import java.util.List;

import cl.paw.paw.model.Libro;

public interface ILibroService { //Define el conjunto de operaciones que serán implementadas

        Libro insLibroDTO(Libro libro);

        Libro actLibroDTO(int id_libro, Libro libro);

        Libro deleteLibroDTO(int id_libro);

        List<Libro> getAllLibro();

        Libro getByIdLibro(int id_libro);

        boolean existePorId(int id_libro);
}
