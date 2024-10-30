module es.nebrija.actividadEmpleados {
    requires javafx.controls;
    requires javafx.fxml;
    requires org.hibernate.orm.core; // Hibernate ORM
    requires java.sql; // Para JDBC y conexiones de base de datos
    requires jakarta.persistence; // Si usas la API JPA (opcional)

    exports es.nebrija.actividadEmpleados;
    exports es.nebrija.actividadEmpleados.dao;
    exports es.nebrija.actividadEmpleados.entidades;
    
    opens es.nebrija.actividadEmpleados to javafx.fxml;
    opens es.nebrija.actividadEmpleados.entidades to org.hibernate.orm.core;
}