
package logica.Dominio;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Editorial implements Serializable {
    
    @Id
    private String id;
    
    @Basic
    private String nombre;
    private Boolean alta;

    public Editorial() {
    }

    public Editorial(String id, String nombre, Boolean alta) {
        this.id = id;
        this.nombre = nombre;
        this.alta = alta;
    }

    public String getId() {
        return id;
    }

    public String getNombre() {
        return nombre;
    }

    public Boolean getAlta() {
        return alta;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setAlta(Boolean alta) {
        this.alta = alta;
    }
    
    

    @Override
    public String toString() {
        return "Editorial [ " + " id : " + id
                + ", Nombre Editorial : " + nombre 
                + " ] ";
    }
    
    
}
