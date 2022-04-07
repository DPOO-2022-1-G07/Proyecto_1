package uniandes.dpoo.proyecto1.modelo;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Registro {
	
	File archivoProyecto = new File("./data/proyecto.txt");
	File archivoParticipantes = new File("./data/participantes.txt");
	File archivoActividades = new File("./data/actividades.txt");

	public boolean verificarProyecto() throws IOException
	{

		// Si el archivo no existe es creado
		if (!archivoProyecto.exists()) 
		{
			archivoProyecto.createNewFile();
			FileWriter fw = new FileWriter(archivoProyecto);
			BufferedWriter bw = new BufferedWriter(fw);
			bw.close();

		}
		return (!archivoProyecto.exists());
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

		// Si el archivo no existe es creado
		if (!archivoParticipantes.exists()) 
		{
			archivoParticipantes.createNewFile();
			FileWriter fw = new FileWriter(archivoParticipantes);
			BufferedWriter bw = new BufferedWriter(fw);
			bw.close();

		}
		return (!archivoParticipantes.exists());
	}

	public void escribirParticipantes(String nombre, String descripccion, String fechaInicio, String fechaFin) throws IOException
	{
		FileWriter fw = new FileWriter(archivoParticipantes);
		BufferedWriter bw = new BufferedWriter(fw);
		String contenido = "falta";
		bw.write(contenido);
		bw.close();
	}

	public boolean verificarActividades() throws IOException
	{

		// Si el archivo no existe es creado
		if (!archivoActividades.exists()) 
		{
			archivoActividades.createNewFile();
			FileWriter fw = new FileWriter(archivoActividades);
			BufferedWriter bw = new BufferedWriter(fw);
			bw.close();

		}
		return (!archivoActividades.exists());
	}

	public void escribirActividades(String nombre, String descripccion, String fechaInicio, String fechaFin) throws IOException
	{
		FileWriter fw = new FileWriter(archivoActividades);
		BufferedWriter bw = new BufferedWriter(fw);
		String contenido = "falta";
		bw.write(contenido);
		bw.close();
	}

}

