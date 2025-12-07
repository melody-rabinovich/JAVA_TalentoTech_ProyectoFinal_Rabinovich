package com.BE_JAVA.CRUD.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.BE_JAVA.CRUD.models.Articulo;
import com.BE_JAVA.CRUD.repository.ArticuloRepository;

import jakarta.persistence.PrePersist;
import jakarta.persistence.PreUpdate;

@Service
public class ArticuloServiceImpl implements ArticuloService{
    
    private final ArticuloRepository repositorio;

    @Autowired
    public ArticuloServiceImpl (ArticuloRepository repositorio){
        this.repositorio = repositorio;
    }

    @Override
    public List<Articulo> findAll() {
        return repositorio.findAll();
    }

    @Override
    public Optional<Articulo> findById(Long id){
        return repositorio.findById(id);
    }

    @Override
    public Optional<Articulo> save(Articulo articulo) {
        Optional<Articulo> creado = java.util.Optional.empty() ;
        if(datosArticuloValidos(articulo.getNombre(), articulo.getPrecio())){
            repositorio.save(articulo);
            creado = Optional.of(articulo);
        } 
        return creado;
    }

    private boolean datosArticuloValidos(String nombre, double precio){
        return (nombre != "" && nombre != " " && nombre != null && precio > 0);
    }

    @Override
    public Optional<Articulo> deleteById(Long id) {
        Optional<Articulo> articulo = findById(id);
        repositorio.deleteById(id);
        return articulo;
    }

    
}
