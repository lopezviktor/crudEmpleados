module es.nebrija.actividadEmpleados {
    requires javafx.controls;
    requires javafx.fxml;
    requires org.hibernate.orm.core; // Hibernate ORM
    requires java.sql; // Para JDBC y conexiones de base de datos
    requires jakarta.persistence; // Si usas la API JPA (opcional)

    exports es.nebrija.actividadEmpleados;

    opens es.nebrija.actividadEmpleados to
        javafx.fxml;
}