package uniandes.dpoo.proyecto1.modelo;

public class Proyecto {
	
	private String nombre;
	private String descripccion;
	private String fechaInicio;
	private String fechaFin;
	
	
	public Proyecto(String nombre, String descripccion, String fechaInicio, String fechaFin)
	{
		this.nombre = nombre;
		this.descripccion = descripccion;
		this.fechaInicio = fechaInicio;
		this.fechaFin = fechaFin;
		
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
