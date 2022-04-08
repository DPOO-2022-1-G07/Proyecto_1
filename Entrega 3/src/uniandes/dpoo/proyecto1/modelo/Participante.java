package uniandes.dpoo.proyecto1.modelo;

public class Participante {
	
	private String nombre;
	private String correo;
	
	public Participante(String nombre, String correo)
	{
		this.nombre = nombre;
		this.correo = correo;
	}

	public String getNombre() {
		return nombre;
	}

	public String getCorreo() {
		return correo;
	}

}
