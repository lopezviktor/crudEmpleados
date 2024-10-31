package es.nebrija.actividadEmpleados.entidades;


import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "usuarios")
public class Usuario {
	
	@Id
	@Column(name = "nombreUsuario", nullable = false, unique = true)
	private String nombreUsuario;
	
	@Column (name = "mail", nullable = false)
	private String mail;
	
	@Column (name = "password", nullable = false)
	private String password;
	
	public Usuario() {
		
	}

	public Usuario(String nombreUsuario, String mail, String password) {
		super();
		this.nombreUsuario = nombreUsuario;
		this.mail = mail;
		this.password = password;
	}

	public String getNombreUsuario() {
		return nombreUsuario;
	}

	public String getMail() {
		return mail;
	}

	public String getPassword() {
		return password;
	}

	public void setNombreUsuario(String nombreUsuario) {
		this.nombreUsuario = nombreUsuario;
	}

	public void setMail(String mail) {
		this.mail = mail;
	}

	public void setPassword(String password) {
		this.password = password;
	}
	
}
