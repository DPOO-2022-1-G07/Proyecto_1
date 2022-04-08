package uniandes.dpoo.proyecto1.modelo;

public class Actividad {
	
	private String titulo;
	private String descripccion;
	private int tipoID;
	private String fecha;
	private double horaInicio;
	private double horaFin;
	private double duracion;
	private int participanteID;
	
	public Actividad(String titulo, String descripccion, int tipoID, String fecha, double horaInicio,
					double horaFin, double duracion , int participanteID)
	{
		this.titulo = titulo;
		this.descripccion = descripccion;
		this.tipoID = tipoID;
		this.fecha = fecha;
		this.horaInicio = horaInicio;
		this.horaFin = horaFin;
		this.duracion = duracion;
		this.participanteID = participanteID;
	}

	public String getTitulo() {
		return titulo;
	}

	public String getDescripccion() {
		return descripccion;
	}

	public int getTipoID() {
		return tipoID;
	}

	public String getFecha() {
		return fecha;
	}

	public double getHoraInicio() {
		return horaInicio;
	}

	public double getHoraFin() {
		return horaFin;
	}

	public double getDuracion() {
		return duracion;
	}

	public int getParticipanteID() {
		return participanteID;
	}

}
