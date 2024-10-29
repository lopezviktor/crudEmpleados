package es.nebrija.actividadEmpleados.entidades;

public class Empleado {

	private int idEmpleado;
	private String nombre;
	private String apellido;
	private double salario;
	
	public Empleado() {
		
	}
	
	public Empleado(int idEmpleado, String nombre, String apellido, double salario) {
		super();
		this.idEmpleado = idEmpleado;
		this.nombre = nombre;
		this.apellido = apellido;
		this.salario = salario;
	}

	public int getIdEmpleado() {
		return idEmpleado;
	}

	public String getNombre() {
		return nombre;
	}

	public String getApellido() {
		return apellido;
	}

	public double getSalario() {
		return salario;
	}

	public void setIdEmpleado(int idEmpleado) {
		this.idEmpleado = idEmpleado;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public void setApellido(String apellido) {
		this.apellido = apellido;
	}

	public void setSalario(double salario) {
		this.salario = salario;
	}
}
