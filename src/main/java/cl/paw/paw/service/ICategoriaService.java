package cl.paw.paw.service;

import java.util.List;

import cl.paw.paw.model.Categoria;

public interface ICategoriaService { //Define el conjunto de operaciones que serán implementadas
    List<Categoria> listarTodo();
    Categoria listarId(int id_categoria);
    Categoria insertCategoria(Categoria categoria);
    Categoria actualizarCategoria(int id_categoria , Categoria categoria);
    Categoria eliminarCategoria(int id_categoria);

}

