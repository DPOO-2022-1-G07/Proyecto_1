package uniandes.dpoo.proyecto1.modelo;

import java.util.ArrayList;

public class Proyecto {
	
	private String nombre;
	private String descripccion;
	private String fechaInicio;
	private String fechaFin;
	private ArrayList <String> tipoActividades;
	private ArrayList<Participante> participantes;
	private ArrayList<Actividad> actividades;
	
	
	public Proyecto(String nombre, String descripccion, String fechaInicio, String fechaFin, ArrayList <String> listaTiposActividades)
	{
		this.nombre = nombre;
		this.descripccion = descripccion;
		this.fechaInicio = fechaInicio;
		this.fechaFin = fechaFin;
		this.tipoActividades = listaTiposActividades;
		this.participantes = new ArrayList<>();
		this.actividades = new ArrayList<>();
		
	}
	
	public String getNombre() 
	{
		return nombre;
	}
	
	public String getDescripccion() 
	{
		return descripccion;
	}
	
	public String getFechaInicio() 
	{
		return fechaInicio;
	}
	
	public String getFechaFin() 
	{
		return fechaFin;
	}

	public ArrayList <String> getTipoActividades() 
	{
		return tipoActividades;
	}
	
	public ArrayList<Participante> getParticipantes()
	{
		return participantes;
	}
	
	public void cargarParticipante(String participante, String correo)
	{
		Participante elParticipante = new Participante (participante, correo);
		participantes.add(elParticipante);
	}
	
	public void cargarActividad(String titulo, String descripccion, int tipoID, String fecha, double horaInicio,
			double horaFin, double duracion , int participanteID)
	{
		//aqui hacen falta los "defaults" en caso que el input sea vacio.
		
		Actividad laActividad = new Actividad (titulo, descripccion, tipoID, fecha,
				horaInicio, horaFin, duracion, participanteID);
		actividades.add(laActividad);
	}




}
