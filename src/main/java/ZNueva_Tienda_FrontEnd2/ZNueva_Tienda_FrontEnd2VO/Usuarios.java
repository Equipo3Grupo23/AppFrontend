package ZNueva_Tienda_FrontEnd2.ZNueva_Tienda_FrontEnd2VO;

public class Usuarios {
	private String cedula_usuario;

	private String email_usuario;

	private String nombre_usuario;

	private String password;

	private String usuario;

	/**
	 * 
	 */
	public Usuarios() {
		super();
		this.cedula_usuario = cedula_usuario;
		this.email_usuario = email_usuario;
		this.nombre_usuario = nombre_usuario;
		this.password = password;
		this.usuario = usuario;
	}

	public String getCedula_usuario() {
		return cedula_usuario;
	}

	public void setCedula_usuario(String cedula_usuario) {
		this.cedula_usuario = cedula_usuario;
	}

	public String getEmail_usuario() {
		return email_usuario;
	}

	public void setEmail_usuario(String email_usuario) {
		this.email_usuario = email_usuario;
	}

	public String getNombre_usuario() {
		return nombre_usuario;
	}

	public void setNombre_usuario(String nombre_usuario) {
		this.nombre_usuario = nombre_usuario;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getUsuario() {
		return usuario;
	}

	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}

	@Override
	public String toString() {
		return "Usuarios [cedula_usuario=" + cedula_usuario + ", email_usuario=" + email_usuario + ", nombre_usuario="
				+ nombre_usuario + ", password=" + password + ", usuario=" + usuario + "]";
	}

	/*@Override
	public String toString() {
		return "Usuarios [cedula_usuario=" + cedula_usuario + ", email_usuario=" + email_usuario + ", nombre_usuario="
				+ nombre_usuario + ", password=" + password + ", usuario=" + usuario + "]";
	}*/

}
