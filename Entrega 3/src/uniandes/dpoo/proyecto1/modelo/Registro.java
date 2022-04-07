package uniandes.dpoo.proyecto1.modelo;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;

public class Registro {

	File archivoProyecto = new File("./data/proyecto.txt");
	File archivoMenu = new File("./data/participantes.txt");
	File archivoCombos = new File("./data/actividades.txt");

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

	public void escribirProyecto(String nombre, String descripccion, String fechaInicio, String fechaFin) throws IOException
	{
		FileWriter fw = new FileWriter(archivoProyecto);
		BufferedWriter bw = new BufferedWriter(fw);
		String contenido = "Nombre: " + nombre + "\n Descripccion: "+ descripccion +"\n Fecha Inicio: " 
							+"\n Fecha Finalizacion: "+ fechaFin;
		bw.write(contenido);
		bw.close();
	}


}

