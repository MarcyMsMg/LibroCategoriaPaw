package cl.paw.paw.controller;


import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import cl.paw.paw.model.Libro;
import cl.paw.paw.service.ILibroService;


@RestController
@RequestMapping("crud/libro")
public class LibroController {
@Autowired
    ILibroService libroService;

    //Crear libro
    @PostMapping
    public ResponseEntity<?> insLibroDTO(@Valid @RequestBody Libro libro, BindingResult result) {
        Libro nuevoLibro = libroService.insLibroDTO(libro);
        return ResponseEntity.status(HttpStatus.CREATED)
                .body("Libro agregado con éxito: " + nuevoLibro.getId_libro());
    }

    //Modificar Libro
    @PutMapping("/{id_libro}")
    public ResponseEntity<?> actLibroDTO(@PathVariable int id_libro, @RequestBody Libro libro) {
        if (!libroService.existePorId(id_libro)) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("No existe un libro con ID: " + id_libro);
            }

            libro.setId_libro(id_libro);
            Libro actualizado = libroService.actLibroDTO(id_libro, libro);
            return ResponseEntity.ok(actualizado);
        }

        //Delete Libro
        @DeleteMapping("/{id_libro}")
        public ResponseEntity<?> deleteLibroDTO(@PathVariable int id_libro) {
            if (!libroService.existePorId(id_libro)) {
                return ResponseEntity.status(HttpStatus.NOT_FOUND).body("No existe un libro con ID: " + id_libro);
            }
            libroService.deleteLibroDTO(id_libro);
                return ResponseEntity.ok("Libro eliminado con ID: " + id_libro);
                }

        @GetMapping //Listar todo
        public List<Libro> getAllList(){
            return libroService.getAllLibro();
        }


        @GetMapping("/{id_libro}")
        public ResponseEntity<?> getByIdLibroDTO(@PathVariable int id_libro) {
            if (!libroService.existePorId(id_libro)) {
                return ResponseEntity.status(HttpStatus.NOT_FOUND).body("No existe un libro con ID: " + id_libro);
            }
    
            return ResponseEntity.ok(libroService.getByIdLibro(id_libro));
        }

        
}
