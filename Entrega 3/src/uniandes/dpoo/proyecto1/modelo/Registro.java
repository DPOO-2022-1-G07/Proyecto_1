package uniandes.dpoo.proyecto1.modelo;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.time.Duration;
import java.util.ArrayList;

public class Registro {
	
	File archivoProyecto = new File("./data/proyecto.txt");
	File archivoParticipantes = new File("./data/participantes.txt");
	File archivoActividades = new File("./data/actividades.txt");

	public boolean verificarProyecto() throws IOException
	{
		boolean existe = archivoProyecto.exists();
		System.out.println(existe);
		// Si el archivo no existe es creado
		if (archivoProyecto.exists()==false) 
		{
			archivoProyecto.createNewFile();
			FileWriter fw = new FileWriter(archivoProyecto);
			BufferedWriter bw = new BufferedWriter(fw);
			bw.close();

		}
		return (existe);
	}

	public void escribirProyecto(String nombre, String descripccion, String fechaInicio, String fechaFin, ArrayList<String> listaTiposActividades) throws IOException
	{
		FileWriter fw = new FileWriter(archivoProyecto);
		BufferedWriter bw = new BufferedWriter(fw);
		String contenido = "Nombre: " + nombre + "\nDescripccion: "+ descripccion +"\nFecha Inicio: "+ fechaInicio 
							+"\nFecha Finalizacion: "+ fechaFin;
		bw.write(contenido);
		
		for (String actividad:listaTiposActividades)
		{
			bw.write("\n"+actividad);
		}
		
		bw.close();
		System.out.println("\nArchivo proyecto.txt escrito \n");
	}
	
	public boolean verificarParticipantes() throws IOException
	{
		boolean existe = archivoParticipantes.exists();
		// Si el archivo no existe es creado
		if (archivoParticipantes.exists()==false) 
		{
			archivoParticipantes.createNewFile();
			FileWriter fw = new FileWriter(archivoParticipantes);
			BufferedWriter bw = new BufferedWriter(fw);
			bw.close();

		}
		return (existe);
	}

	public void escribirParticipante(String nombre, String correo) throws IOException
	{
		FileWriter fw = new FileWriter(archivoParticipantes, true);
		BufferedWriter bw = new BufferedWriter(fw);
		String contenido = nombre + ";" + correo;
		bw.append(contenido);
		bw.newLine();
		bw.close();
		System.out.println(contenido);
	}

	public boolean verificarActividades() throws IOException
	{
		boolean existe = archivoActividades.exists();
		// Si el archivo no existe es creado
		if (archivoActividades.exists()==false) 
		{
			archivoActividades.createNewFile();
			FileWriter fw = new FileWriter(archivoActividades);
			BufferedWriter bw = new BufferedWriter(fw);
			bw.close();

		}
		return (existe);
	}

	public void escribirActividades(String titulo, String descripccion, int tipoID, String fecha, String horaInicio,
			String horaFin, int duracion , int participanteID) throws IOException
	{
		FileWriter fw = new FileWriter(archivoActividades, true);
		BufferedWriter bw = new BufferedWriter(fw);
		String contenido = titulo + ";" + descripccion + ";" + tipoID + ";" + fecha + ";" 
		+ horaInicio + ";" + horaFin + ";" + duracion + ";" + participanteID;
		bw.append(contenido);
		bw.newLine();
		bw.close();
		System.out.println("\n"+contenido);
	}
	
}

