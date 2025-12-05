package com.BE_JAVA.CRUD.services;


import java.util.List;
import org.springframework.stereotype.Service;

import com.BE_JAVA.CRUD.models.Articulo;
import com.BE_JAVA.CRUD.repository.ArticuloRepository;

import org.springframework.beans.factory.annotation.Autowired;



@Service
public class ArticuloService {

    @Autowired
    private ArticuloRepository repo;

    public List<Articulo> findAll() {
        return repo.findAll();
    }
}
