package com.BE_JAVA.CRUD.services;


import java.util.List;
import java.util.Optional;
import com.BE_JAVA.CRUD.models.Articulo;




public interface ArticuloService {
    // métodos para el contrato
    List<Articulo> findAll();
    Optional<Articulo> findById(Long id);
    // Articulo save(Articulo articulo);
    // Articulo update(Long id, Articulo articulo);
    // Articulo deleteById(Long id);
    
}
