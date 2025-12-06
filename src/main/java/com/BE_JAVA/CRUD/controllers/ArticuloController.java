package com.BE_JAVA.CRUD.controllers;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.BE_JAVA.CRUD.models.Articulo;
import com.BE_JAVA.CRUD.services.ArticuloService;



@RestController
@RequestMapping("/articulos")
public class ArticuloController {
    private final ArticuloService articuloService;

    @Autowired
    public ArticuloController (ArticuloService articuloService){
        this.articuloService = articuloService;
    }

    @GetMapping
    public List<Articulo> findall(){
        return articuloService.findAll();
    }

    @GetMapping("/{id}") // le agrego a la ruta
    public Optional<Articulo> findById(Long id){
        return articuloService.findById(id);
    }
}
