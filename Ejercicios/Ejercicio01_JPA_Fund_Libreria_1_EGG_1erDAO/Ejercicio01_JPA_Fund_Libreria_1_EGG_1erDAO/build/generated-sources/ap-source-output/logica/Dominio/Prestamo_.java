package logica.Dominio;

import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;
import logica.Dominio.Cliente;
import logica.Dominio.Libro;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2022-12-26T21:00:00")
@StaticMetamodel(Prestamo.class)
public class Prestamo_ { 

    public static volatile SingularAttribute<Prestamo, Libro> libro;
    public static volatile SingularAttribute<Prestamo, Cliente> cliente;
    public static volatile SingularAttribute<Prestamo, Date> fechaDevolucion;
    public static volatile SingularAttribute<Prestamo, Date> fechaPrestamo;
    public static volatile SingularAttribute<Prestamo, Integer> id;

}