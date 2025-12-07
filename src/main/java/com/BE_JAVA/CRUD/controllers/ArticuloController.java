package com.BE_JAVA.CRUD.controllers;

import java.lang.StackWalker.Option;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.apache.coyote.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.BE_JAVA.CRUD.models.Articulo;
import com.BE_JAVA.CRUD.services.ArticuloService;



@RestController
@RequestMapping("/api/articulos")
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
    public ResponseEntity<Articulo> findById(@PathVariable Long id){
        return articuloService.findById(id) // Llamamos al servicio para buscar el artículo
                .map(ResponseEntity::ok)  // .map(articulo -> ResponseEntity.ok(articulo))       // Si el artículo existe, devolvemos 200 OK con el cuerpo
                .orElse(ResponseEntity.notFound().build()); // Si no existe, devolvemos 404 Not Found // sólo se ejecuta si el Optional está vacío
    }

    @PostMapping("/save") 
    public ResponseEntity<Articulo> save( @RequestBody Articulo articulo){ // @RequestBody indica que el JSON del cuerpo se mapea a un Articulo
        ResponseEntity<Articulo> response = null;
        Optional<Articulo> creado = articuloService.save(articulo);
        if(creado.isPresent()){
            response = ResponseEntity.ok(creado.get());
        } else{
            response = ResponseEntity.badRequest().build();
        }
        return response;
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Articulo> deleteById(@PathVariable Long id){
        Optional<Articulo> eliminado = articuloService.deleteById(id);
        ResponseEntity<Articulo> response = null;
        if (eliminado.isEmpty()){
            response = ResponseEntity.notFound().build();
        } else {
            response = ResponseEntity.ok(eliminado.get());
        }
        return response ;
    }

}
