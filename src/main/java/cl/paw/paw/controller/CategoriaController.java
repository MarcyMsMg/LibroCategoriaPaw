package cl.paw.paw.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import cl.paw.paw.model.Categoria;
import cl.paw.paw.service.impl.CategoriaService;

@RestController
@RequestMapping("crud/categoria")
public class CategoriaController {
    @Autowired
    CategoriaService categoriaServicio;


    @GetMapping
    public List<Categoria> getAllList(){
        return categoriaServicio.listarTodo();
    }

    @GetMapping("/{id}")
    public Categoria getById(@PathVariable Integer id) {
       return categoriaServicio.listarId(id);
    }

    @PostMapping
    public Categoria insertCategoria(@RequestBody Categoria categoria){
        Categoria aux = categoriaServicio.insertCategoria(categoria);
        return aux;
    }

    @PutMapping ("/{id}") 
    public Categoria actualizarCategoria(@PathVariable Integer id, @RequestBody Categoria categoria){
        Categoria aux = categoriaServicio.actualizarCategoria(id, categoria);
        return aux;
    }

    @DeleteMapping ("/{id}") 
    public Categoria eliminarCategoria (@PathVariable Integer id){
        Categoria aux = categoriaServicio.eliminarCategoria(id);
        return aux;
    }

}
