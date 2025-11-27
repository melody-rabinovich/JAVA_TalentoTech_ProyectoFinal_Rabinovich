package models;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;

@Entity
@Table(name = "articulos") // Mapea a la tabla "articulo"
public class Articulo {

    private long id;
    private String nombre;
    private double precio;

    Articulo(long id, String nombre, double precio){
        setId(id); 
        setNombre(nombre);
        setPrecio(precio);
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
