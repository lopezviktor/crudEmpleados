module es.nebrija.actividadEmpleados {
    requires javafx.controls;
    requires javafx.fxml;
    requires org.hibernate.orm.core; 
    requires java.sql;
    requires jakarta.persistence; 

    exports es.nebrija.actividadEmpleados;
    exports es.nebrija.actividadEmpleados.dao;
    exports es.nebrija.actividadEmpleados.entidades;
    
    opens es.nebrija.actividadEmpleados to javafx.fxml;
    opens es.nebrija.actividadEmpleados.entidades to org.hibernate.orm.core;
}