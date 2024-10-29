package es.nebrija.actividadEmpleados;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class HibernateTest {

    public static void main(String[] args) {
        // Prueba para verificar la conexión a Hibernate
        SessionFactory factory = new Configuration().configure("hibernate.cfg.xml").buildSessionFactory();

        try (Session session = factory.openSession()) {
            System.out.println("¡Conexión a la base de datos establecida con éxito usando Hibernate!");
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (factory != null) {
                factory.close();
            }
        }
    }
}