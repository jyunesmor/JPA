
package Logica.entidades;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
public class Prestamo implements Serializable {
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(nullable = true)
    private Integer id;
    
    @Temporal(TemporalType.DATE)
    private Date fPrestamo;
    @Temporal(TemporalType.DATE)
    private Date devPrestamo;
    
    @OneToOne
    private Libro libro;
    
    @OneToOne
    private Cliente cliente;

    public Prestamo() {
    }

    public Prestamo(Date fPrestamo, Date devPrestamo, Libro libro, Cliente cliente) {
        this.fPrestamo = fPrestamo;
        this.devPrestamo = devPrestamo;
        this.libro = libro;
        this.cliente = cliente;
    }

    public Date getfPrestamo() {
        return fPrestamo;
    }

    public void setfPrestamo(Date fPrestamo) {
        this.fPrestamo = fPrestamo;
    }

    public Date getDevPrestamo() {
        return devPrestamo;
    }

    public void setDevPrestamo(Date devPrestamo) {
        this.devPrestamo = devPrestamo;
    }

    public Libro getLibro() {
        return libro;
    }

    public void setLibro(Libro libro) {
        this.libro = libro;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    @Override
    public String toString() {
        return "Prestamo{" + "id=" + id + ", fPrestamo=" + fPrestamo + ", devPrestamo=" + devPrestamo + ", libro=" + libro + ", cliente=" + cliente + '}';
    }
    
    
    
}
