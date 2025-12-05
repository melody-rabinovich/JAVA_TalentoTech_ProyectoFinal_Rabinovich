package com.BE_JAVA.CRUD.controllers;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.BE_JAVA.CRUD.models.Articulo;
import com.BE_JAVA.CRUD.services.ArticuloService;



@RestController
@RequestMapping("/articulos")
public class ArticuloController {
    private final ArticuloService articuloService;

    public ArticuloController (ArticuloService articuloService){
        this.articuloService = articuloService;
    }

    @GetMapping
    public List<Articulo> findall(){
        return articuloService.findAll();
    }
}
