package uniandes.dpoo.proyecto1.modelo;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.List;


public class Reporte {
	
	/*private List<Actividad> actividad;
	private Proyecto proyecto;*/
	
	
	private void ejecutarConsultarPedido() throws IOException 
	{
		BufferedReader br = new BufferedReader(new FileReader("./data/proyecto.txt"));
		String linea = br.readLine();
		while (linea != null) // Cuando se llegue al final del archivo, linea tendrá el valor null
		{
			linea = br.readLine();
			String[] parts = linea.split(";");
			String part1 = parts[7];
		}
		br.close();
	}
	
}
