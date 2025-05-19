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

    //Insertar categoria
    @Override
    public Categoria insertCategoria(Categoria categoria){
        Categoria aux = repo.save(categoria);
        return aux;
    }

    //Actualizar categoria
    @Override
    public Categoria actualizarCategoria(int id , Categoria categoria){
    categoria.setId_categoria(id);
    Categoria aux = repo.save(categoria);
    return aux;
    }

    //Eliminar categoria
    @Override
    public Categoria eliminarCategoria(int id){
    //Optional es un valor que puede estar presente o no, onda, puede devolver un dato vacío
    Optional<Categoria> optional = repo.findById(id);
    //Evalúa si tiene un dato
    if (optional.isPresent()) {  //tiene que romper la relación primero, xq no la maneja
        //Almacena el objeto
        Categoria categoria = optional.get();
        //Si tiene libros, los va obtener y almacenar en libro
        for (Libro libro : categoria.getLibros()) {
            //Le quita la categoria
            libro.getCategorias().remove(categoria); 
        }
        repo.delete(categoria);
        return categoria;
    }
    return null;
}

    //Listar todo
    @Override
    public List<Categoria> listarTodo(){
        List<Categoria> aux = new ArrayList<>();
        repo.findAll().forEach(aux::add);
        return aux;
        }

    //Listar por id
    @Override
        public Categoria listarId(int id){
            return repo.findById(id).get();
        };
}
