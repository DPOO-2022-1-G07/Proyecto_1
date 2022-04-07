package uniandes.dpoo.proyecto1.modelo;

import java.util.ArrayList;

public class Proyecto {
	
	private String nombre;
	private String descripccion;
	private String fechaInicio;
	private String fechaFin;
	private ArrayList <String> tipoActividades;
	
	
	public Proyecto(String nombre, String descripccion, String fechaInicio, String fechaFin, ArrayList <String> listaTiposActividades)
	{
		this.nombre = nombre;
		this.descripccion = descripccion;
		this.fechaInicio = fechaInicio;
		this.fechaFin = fechaFin;
		this.tipoActividades = listaTiposActividades;
		
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
	
	
	public String crearArchivoProyecto()
	{
		String contenido = "Nombre: "+ getNombre() +"\n Descripccion: "+ getDescripccion()
		+"\n Fecha Inicio: "+ getFechaInicio()+"\n Fecha Fin: "+ getFechaFin();
		return contenido;
		
	}










}
