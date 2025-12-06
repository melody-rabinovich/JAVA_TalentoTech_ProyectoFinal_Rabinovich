package com.BE_JAVA.CRUD.repository;



import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.BE_JAVA.CRUD.models.Articulo;

import java.util.List;

@Repository //esta interfaz es un componente de acceso a datos (DAO/Repository)


public interface ArticuloRepository extends JpaRepository<Articulo, Long> { // el generic tiene el tipo de dato de la entity y de la PK
    

     /** MÉTODOS "HEREDADOS" DE JPA {
       ========================================
         * findall()
         * findById(Long id)
         * save(Articulo articulo)
         * deleteById(Long id)
         * count()
         * existsById(Long id)
         
    }*/

    // búsqueda parcial: devuelve los que /incluyan/ el texto
    List<Articulo> findByNombreContainingIgnoreCase(String nombre);


    
} 
