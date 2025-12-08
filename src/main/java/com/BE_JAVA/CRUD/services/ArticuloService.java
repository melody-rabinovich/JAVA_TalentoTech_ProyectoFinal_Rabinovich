package com.BE_JAVA.CRUD.services;


import java.util.List;
import java.util.Optional;
import com.BE_JAVA.CRUD.models.Articulo;




public interface ArticuloService {
    // métodos para el contrato
    List<Articulo> findAll();
    Optional<Articulo> findById(Long id);
    Optional<Articulo> save(Articulo articulo);
    Optional<Articulo> deleteById(Long id);
    Optional<Articulo> update(Long id, Articulo articulo);
    
}
