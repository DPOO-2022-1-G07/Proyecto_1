package uniandes.dpoo.proyecto1.consola;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;

import uniandes.dpoo.proyecto1.modelo.Proyecto;
import uniandes.dpoo.proyecto1.modelo.Registro;

public class Aplicacion {

	public static void main(String[] args) 
	{
		// TODO Auto-generated method stub

		Aplicacion consola = new Aplicacion();


	}
	
	private Proyecto proyecto;

	private Registro registro;
	
	public void setRegistro(Registro registro) {
		this.registro = new Registro();
	}
	
	public void ejecutarAplicacion() throws IOException 
	{
		System.out.println("Registro proyecto \n");
		setRegistro(registro);
		if (registro.verificarProyecto())
		{
			cargarProyecto(proyecto);
		}
		else 
		{
			setProyecto(proyecto);
		}
	}
	

	


	public void setProyecto(Proyecto proyecto) throws IOException
	{
		String nombreProyecto = input("Ingrese nombre de Proyecto: ");
		String descripccionProyecto = input("Ingrese descripccion del Proyecto: ");
		String fechaInicioProyecto = input("Ingrese fecha de inicio (DD/MM/AAAA): ");
		String fechaFinalizacionProyecto = input("Ingrese fecha de finalizacion (DD/MM/AAAA): ");
		this.proyecto = new Proyecto(nombreProyecto, descripccionProyecto, fechaInicioProyecto, fechaFinalizacionProyecto);
		registro.escribirProyecto(nombreProyecto, descripccionProyecto, fechaInicioProyecto, fechaFinalizacionProyecto);
	}
	
	public void cargarProyecto(Proyecto proyecto) throws IOException
	{
		BufferedReader br = new BufferedReader(new FileReader("./data/proyecto.txt"));
		String linea = br.readLine();
		System.out.println(linea);
		String nombreProyecto = linea;
		linea = br.readLine();
		System.out.println(linea);
		String descripccionProyecto = linea;
		linea = br.readLine();
		System.out.println(linea);
		String fechaInicioProyecto = linea;
		linea = br.readLine();
		System.out.println(linea);
		String fechaFinalizacionProyecto = linea;
		
		this.proyecto = new Proyecto(nombreProyecto, descripccionProyecto, fechaInicioProyecto, fechaFinalizacionProyecto);
		linea = br.readLine();
		while (linea != null) // Cuando se llegue al final del archivo, linea tendrá el valor null
		{
			System.out.println(linea);			
			linea = br.readLine();
		}
		br.close();
	}

	public void mostrarMenu()
	{
		System.out.println("\nOpciones de la aplicación\n");
		System.out.println("1. Agregar actividad");
		System.out.println("2. Iniciar cronometro");
		System.out.println("3. Generar reporte");
		System.out.println("4. Agregar participante");
	}

	private void ejecutarCargarDatos()
	{
		File archivoIngredientes = new File("./data/proyecto.txt");
		File archivoMenu = new File("./data/participantes.txt");
		File archivoCombos = new File("./data/actividades.txt");

		try 
		{
			String ruta = "./data/proyecto.txt";
			File file = new File(ruta);
			// Si el archivo no existe es creado
			if (!file.exists()) 
			{	
				String nombreProyecto = input("Ingrese nombre de Proyecto: ");
				String descripccionProyecto = input("Ingrese descripccion del Proyecto: ");
				String fechaInicioProyecto = input("Ingrese fecha de inicio (DD/MM/AAAA): ");
				String fechaFinalizacionProyecto = input("Ingrese fecha de finalizacion (DD/MM/AAAA): ");
				String contenido = generarTextoFactura();
				file.createNewFile();
				FileWriter fw = new FileWriter(file);
				BufferedWriter bw = new BufferedWriter(fw);
				bw.write(contenido);
				bw.close();
			}
			else
			{

			}

		} 
		catch (Exception e) 
		{
			e.printStackTrace();
		}

	}

	public String input(String mensaje)
	{
		try
		{
			System.out.print(mensaje + ": ");
			BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
			return reader.readLine();
		}
		catch (IOException e)
		{
			System.out.println("Error leyendo de la consola");
			e.printStackTrace();
		}
		return null;
	}


}
