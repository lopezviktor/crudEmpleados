package es.nebrija.actividadEmpleados.entidades;

public class Empleado {

	private int idEmpleado;
	private String nombre;
	private String apellidos;
	private String direccion;
	private String telefono;
	private double salario;
	
	public Empleado() {
		
	}

	public Empleado( String nombre, String apellidos, String direccion, String telefono, double salario) {
		super();
		this.nombre = nombre;
		this.apellidos = apellidos;
		this.direccion = direccion;
		this.telefono = telefono;
		this.salario = salario;
	}

	public int getIdEmpleado() {
		return idEmpleado;
	}

	public String getNombre() {
		return nombre;
	}

	public String getApellidos() {
		return apellidos;
	}

	public String getDireccion() {
		return direccion;
	}

	public String getTelefono() {
		return telefono;
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

	public void setApellidos(String apellidos) {
		this.apellidos = apellidos;
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}

	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}

	public void setSalario(double salario) {
		this.salario = salario;
	}
	
	
}
