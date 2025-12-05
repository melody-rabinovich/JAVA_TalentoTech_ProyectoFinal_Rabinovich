package models;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity 
@Table(name = "articulos") 

public class Articulo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    // por cada atributo, declaro la columna
    @Column (name = "id") 
    private Long id;   //  la PK autoincremental
    @Column(name = "nombre", nullable = false, length = 200)
    private String nombre;
    @Column(name="precio", nullable = false)
    private double precio;

    Articulo(long id, String nombre, double precio){
        setId(id); 
        setNombre(nombre);
        setPrecio(precio);
    }

    Articulo (){
        // Constructor sobrecargado vacío, requerido por JPA (?)
    }

    
    private void setId(long id) {
        this.id = id;
    }

    private void setNombre(String nombre) {
        this.nombre = nombre;
    }
    private void setPrecio(double precio) {
        this.precio = precio;
    }
    public long getId() {
        return id;
    }

    public String getNombre() {
        return nombre;
    }
    public double getPrecio() {
        return precio;
    }
}
