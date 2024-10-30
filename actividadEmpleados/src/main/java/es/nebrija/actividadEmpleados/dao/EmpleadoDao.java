package es.nebrija.actividadEmpleados.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import es.nebrija.actividadEmpleados.entidades.Empleado;

public class EmpleadoDao {

	private static SessionFactory factory = new Configuration().configure("hibernate.cfg.xml").buildSessionFactory();

	//GUARDAR EMPLEADO
	public void guardarEmpleado(Empleado empleado) {
	    Transaction transaction = null;
	    try (Session session = factory.openSession()) {
	        transaction = session.beginTransaction();
	        session.save(empleado); 
	        transaction.commit();
	        System.out.println("Empleado guardado correctamente");
	    } catch (Exception e) {
	        if (transaction != null && transaction.isActive()) {
	            try {
	                transaction.rollback();
	            } catch (RuntimeException rollbackException) {
	                System.err.println("Error al realizar el rollback: " + rollbackException);
	            }
	        }
	        e.printStackTrace();
	    }
	}
	
	//OBTENER EMPLEADO POR SU ID
	public Empleado obtenerEmpleadoId(int id){
		try (Session session = factory.openSession()) {
            return session.get(Empleado.class, id);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
	}
	
	//OBTENER TODOS LOS EMPLEADOS
	public List<Empleado> obtenerTodosEmpleados(){
		try (Session session = factory.openSession()){
			return session.createQuery("from Empleado", Empleado.class).list();
		}catch (Exception e) {
            e.printStackTrace();
            return null;
        }
	}
	
	// MODIFICAR EMPLEADO
	public void modificarEmpleado(Empleado empleado) {
		Transaction transaction = null;
		try (Session session = factory.openSession()){
			transaction = session.beginTransaction();
			session.merge(empleado);
			transaction.commit();
            System.out.println("Empleado actualizado correctamente");
		}catch (Exception e) {
            e.printStackTrace();
        }
	}
	
	
	//BORRAR UN EMPLEADO
	public void borrarEmpleado(int id) {
		Transaction transaction = null;
		try (Session session = factory.openSession()){
            transaction = session.beginTransaction();
			Empleado empleado = session.get(Empleado.class, id);
			if (empleado != null) {
				session.remove(empleado);
				System.out.println("Empleado borrado correctamente");
			}
			transaction.commit();
		}catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	
}
