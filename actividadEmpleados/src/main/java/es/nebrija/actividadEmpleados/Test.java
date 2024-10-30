package es.nebrija.actividadEmpleados;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import es.nebrija.actividadEmpleados.dao.EmpleadoDao;
import es.nebrija.actividadEmpleados.entidades.Empleado;

public class Test {

    public static void main(String[] args) {
        // Prueba para verificar la conexión a Hibernate
    	SessionFactory factory = new Configuration().configure().buildSessionFactory();

    	try (Session session = factory.openSession()) {
            System.out.println("¡Conexión a la base de datos establecida con éxito usando Hibernate!");
            
            EmpleadoDao empleadoDao = new EmpleadoDao();
            
            // Crear un nuevo empleado
            Empleado empleado1 = new Empleado("Carlos", "López", "Madrid", "123456789", 3000.00);
            empleadoDao.guardarEmpleado(empleado1);
            System.out.println("Empleado añadido: " + empleado1.getIdEmpleado());

            // Actualizar el salario del empleado
            empleado1.setSalario(3500.00);
            empleadoDao.modificarEmpleado(empleado1);
            System.out.println("Salario del empleado actualizado a: " + empleado1.getSalario());

            // Leer el empleado para verificar el cambio
            Empleado empleadoLeido = empleadoDao.obtenerEmpleadoId(empleado1.getIdEmpleado());
            System.out.println("Empleado leído: " + empleadoLeido.getNombre() + " con salario " + empleadoLeido.getSalario());
        
            
            
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (factory != null) {
                factory.close();
            }
        }
    }
}
