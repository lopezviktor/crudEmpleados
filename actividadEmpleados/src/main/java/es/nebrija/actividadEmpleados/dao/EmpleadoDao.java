package es.nebrija.actividadEmpleados.dao;

import java.util.Arrays;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import es.nebrija.actividadEmpleados.CSVHandler;
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
	
	//EXPORTAR EMPLEADOS A CSV
	public void exportarEmpleadosACSV(CSVHandler csvHandler) {
		List<Empleado> empleados = obtenerTodosEmpleados();
		for (Empleado empleado : empleados) {
			csvHandler.escribirEmpleado(
					empleado.getNombre(),
					empleado.getApellidos(),
					empleado.getDireccion(),
					empleado.getTelefono(),
					String.valueOf(empleado.getSalario())
			);
		}
		System.out.println("Exportación de empleados completada");
	}
	
	//IMPORTAR EMPLEADOS DESDE UN CSV
	public void importarEmpleadosDesdeCSV(CSVHandler csvHandler) {
	    List<String[]> empleadosCSV = csvHandler.leerEmpleados();
	    for (String[] datos : empleadosCSV) {
	        if (datos.length == 5) { // Verificar que el número de datos sea correcto
	            try {
	                String nombre = datos[0];
	                String apellidos = datos[1];
	                String telefono = datos[3];

	                // Verificar si el empleado ya existe basado en el teléfono
	                Empleado empleadoExistente = buscarEmpleadoPorTelefono(telefono);
	                if (empleadoExistente == null) { 
	                    Empleado empleado = new Empleado(
	                        nombre,
	                        apellidos,
	                        datos[2], // Dirección
	                        telefono,
	                        Double.parseDouble(datos[4]) // Salario
	                    );
	                    guardarEmpleado(empleado);
	                } else {
	                    System.out.println("Empleado ya existe: " + nombre + " " + apellidos);
	                }
	            } catch (NumberFormatException e) {
	                System.out.println("Error al convertir salario para " + Arrays.toString(datos) + ": " + e.getMessage());
	            }
	        } else {
	            System.out.println("Fila con datos incorrectos: " + Arrays.toString(datos));
	        }
	    }
	    System.out.println("Importación de empleados desde archivo completada");
	}
	
	//BUSCAR EMPLEADO POR TELEFONO
	public Empleado buscarEmpleadoPorTelefono(String telefono) {
	    try (Session session = factory.openSession()) {
	        return session.createQuery("from Empleado where telefono = :telefono", Empleado.class)
	                .setParameter("telefono", telefono)
	                .uniqueResult();
	    } catch (Exception e) {
	        e.printStackTrace();
	        return null;
	    }
	}

}