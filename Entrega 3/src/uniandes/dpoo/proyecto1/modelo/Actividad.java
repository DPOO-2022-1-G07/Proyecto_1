package uniandes.dpoo.proyecto1.modelo;

import java.time.LocalDateTime;

public class Actividad {
	
	private String titulo;
	private String descripccion;
	private int tipoID;
	private String fecha;
	private String horaInicio;
	private String horaFin;
	private int duracion;
	private int participanteID;
	
	public Actividad(String titulo, String descripccion, int tipoID, String fecha, String horaInicio,
			String horaFin, int duracion , int participanteID)
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

	public String getHoraInicio() {
		return horaInicio;
	}

	public String getHoraFin() {
		return horaFin;
	}

	public int getDuracion() {
		return duracion;
	}

	public int getParticipanteID() {
		return participanteID;
	}
	

}
