package com.BE_JAVA.CRUD.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.BE_JAVA.CRUD.models.Articulo;
import com.BE_JAVA.CRUD.repository.ArticuloRepository;

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
}
