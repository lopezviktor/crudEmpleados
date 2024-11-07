package es.nebrija.actividadEmpleados.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import es.nebrija.actividadEmpleados.entidades.Usuario;

public class UsuarioDao {

	private static SessionFactory factory = new Configuration().configure("hibernate.cfg.xml").buildSessionFactory();
	
	//GUARDAR NUEVO USUARIO
	public void guardarUsuario(Usuario usuario) {
		Transaction transaction = null;
		try (Session session = factory.openSession()) {
			transaction = session.beginTransaction();
			session.save(usuario);
			transaction.commit();
			System.out.println("Usuario guardado correctamente");
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
	
	//VALIDAR USUARIO EN EL LOGIN
	public Usuario validarUsuario(String nombreUsuario, String password) {
		Transaction transaction = null;
		Usuario usuario = null;
		try (Session session = factory.openSession()) {
			transaction = session.beginTransaction();
			
			usuario = session.createQuery("FROM Usuario WHERE nombreUsuario = :nombreUsuario AND password = :password", Usuario.class)
						.setParameter("nombreUsuario", nombreUsuario)
						.setParameter("password", password)
						.uniqueResult();
			transaction.commit();
		} catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        }
        return usuario;
	}

	//MODIFICAR USUARIO
	public void modificarUsuario(Usuario usuario) {
		Transaction transaction = null;
		try (Session session = factory.openSession()){
			transaction = session.beginTransaction();
			session.merge(usuario);
			transaction.commit();
            System.out.println("Usuario actualizado correctamente");
		}catch (Exception e) {
            e.printStackTrace();
        }
	}
}
