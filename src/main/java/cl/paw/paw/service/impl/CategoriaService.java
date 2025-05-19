package cl.paw.paw.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cl.paw.paw.model.Categoria;
import cl.paw.paw.model.Libro;
import cl.paw.paw.repository.CategoriaRepository;
import cl.paw.paw.service.ICategoriaService;

@Service
public class CategoriaService implements ICategoriaService{
    @Autowired
    CategoriaRepository repo;

    @Override
    public Categoria insertCategoria(Categoria categoria){
        Categoria aux = repo.save(categoria);
        return aux;
    }

    @Override
    public Categoria actualizarCategoria(int id , Categoria categoria){
    categoria.setId_categoria(id);
    Categoria aux = repo.save(categoria);
    return aux;
    }

    @Override
    public Categoria eliminarCategoria(int id){
    Optional<Categoria> optional = repo.findById(id);
    if (optional.isPresent()) {
        Categoria categoria = optional.get();
    
        for (Libro libro : categoria.getLibros()) {
            libro.getCategorias().remove(categoria); 
        }
        repo.delete(categoria);
        return categoria;
    }
    return null;
}

    @Override
    public List<Categoria> listarTodo(){
        List<Categoria> aux = new ArrayList<>();
        repo.findAll().forEach(aux::add);
        return aux;
        }

    @Override
        public Categoria listarId(int id){
            return repo.findById(id).get();
        };
}
