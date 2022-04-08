package uniandes.dpoo.proyecto1.consola;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.time.LocalDateTime;

import uniandes.dpoo.proyecto1.modelo.Participante;
import uniandes.dpoo.proyecto1.modelo.Proyecto;
import uniandes.dpoo.proyecto1.modelo.Registro;

public class Aplicacion {

	public static void main(String[] args) throws FileNotFoundException, IOException 
	{
		// TODO Auto-generated method stub
		System.out.println(LocalDateTime.now().toLocalTime());
		System.out.println((LocalDateTime.now()).toLocalDate());
		
		Aplicacion consola = new Aplicacion();
		consola.ejecutarAplicacion();
	}

	private Proyecto proyecto;

	private Registro registro;

	public void setRegistro(Registro registro) {
		this.registro = new Registro();
	}

	public void ejecutarAplicacion() throws IOException 
	{
		System.out.println("***BIENVENIDO APP REGISTRO*** \n");
		setRegistro(registro);
		System.out.println("-Registro creado (nota desarrollo)\n");
		
		if (registro.verificarProyecto()==true)
		{
			System.out.println("-Cargando proyecto existente... \n");
			cargarProyecto(proyecto);
			if (registro.verificarParticipantes()==true)
			{
				System.out.println("-Cargando participantes existentes... \n");
				BufferedReader br = new BufferedReader(new FileReader("./data/participantes.txt"));
				String linea = br.readLine();
				int contador = 0;
				while (linea != null) // Cuando se llegue al final del archivo, linea tendrá el valor null
				{
					System.out.println(contador+" - "+linea);
					String[] partes = linea.split(";");
					String nombreParticipante = partes[0];
					String correoParticipante = partes[1];
					proyecto.cargarParticipante(nombreParticipante, correoParticipante);
					linea = br.readLine();
					contador ++;
				}
				br.close();
				System.out.println("\n-Participantes cargados exitosamente \n");
			}
			else
			{
				System.out.println("***ADVERTENCIA - No se han encontrado participantes en el proyecto existente\n");
			}
		}
		else 
		{
			System.out.println("-Creando proyecto nuevo... \n");
			setProyecto(proyecto);
			if (registro.verificarParticipantes()==false)
			{
				System.out.println("-Creando participante nuevo... \n");
				addParticipante();
			}
		}
		
		if (registro.verificarActividades()==true)
		{
			System.out.println("-Cargando actividades existentes...\n");
			BufferedReader br = new BufferedReader(new FileReader("./data/actividades.txt"));
			String linea = br.readLine();
			int contador = 0;
			while (linea != null) // Cuando se llegue al final del archivo, linea tendrá el valor null
			{
				System.out.println(contador+" - "+linea);
				String[] partes = linea.split(";");
				String titulo = partes[0];
				String descripccion = partes[1];
				int tipoID = Integer.parseInt(partes[2]);
				String fecha = partes[3]; 
				double horaInicio = Double.parseDouble(partes[4]);
				double horaFin = Double.parseDouble(partes[5]); 
				double duracion = Double.parseDouble(partes[6]); 
				int participanteID = Integer.parseInt(partes[7]);
				proyecto.cargarActividad(titulo, descripccion, tipoID, fecha, horaInicio, horaFin, duracion, participanteID);
				linea = br.readLine();
				contador ++;
			}
			br.close();
			System.out.println("\n-"+contador +" - Actividades cargadas exitosamente \n");
		}
		else
		{
			System.out.println("\n-Aun no existen actividades \n");
		}
		
		boolean continuar = true;
		while (continuar)
		{
			try
			{
				mostrarMenu();
				int opcion_seleccionada = Integer.parseInt(input("Por favor seleccione una opción"));
				if (opcion_seleccionada == 1 && proyecto != null)
					addActividad();
				else if (opcion_seleccionada == 2 && proyecto != null)
					System.out.println("\nEn construccion... \n");
				else if (opcion_seleccionada == 3 && proyecto != null)
					System.out.println("\nEn construccion... \n");
				else if (opcion_seleccionada == 4 && proyecto != null)					
					addParticipante();
				else if (opcion_seleccionada == 5)
				{
					System.out.println("\n-Saliendo de la aplicacion ...");
					continuar = false;
				}
				else if (proyecto == null)
				{
					System.out.println("***ERROR cargando archivos.");
				}
				else
				{
					System.out.println("\nPor favor seleccione una opcion valida.");
				}
			}
			catch (NumberFormatException e)
			{
				System.out.println("\nDebe seleccionar uno de los numeros de las opciones.");
			}
		}
	
	}





	public void setProyecto(Proyecto proyecto) throws IOException
	{
		String nombreProyecto = input("Ingrese nombre de Proyecto: ");
		String descripccionProyecto = input("Ingrese descripccion del Proyecto: ");
		String fechaInicioProyecto = input("Ingrese fecha de inicio (DD/MM/AAAA): ");
		String fechaFinalizacionProyecto = input("Ingrese fecha de finalizacion (DD/MM/AAAA): ");		
		int numeroActividadesTipo = Integer.parseInt(input("Ingrese cuantos tipos de actividad van a existir: "));
		ArrayList<String> actividadesTipo = new ArrayList<>(numeroActividadesTipo);
		for (int pos = 0; pos < numeroActividadesTipo; pos++)
		{
			String actividadTipo = input("Ingrese nombre de Actividad "+pos+": ");
			actividadesTipo.add(pos, actividadTipo);
		}
		this.proyecto = new Proyecto(nombreProyecto, descripccionProyecto, fechaInicioProyecto, fechaFinalizacionProyecto, actividadesTipo);
		registro.escribirProyecto(nombreProyecto, descripccionProyecto, fechaInicioProyecto, fechaFinalizacionProyecto, actividadesTipo);



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
		System.out.println("\nTipos de actividades existentes: \n");
		
		ArrayList<String> actividadesTipo = new ArrayList<>();
		int pos = 0;
		
		linea = br.readLine();
		while (linea != null) // Cuando se llegue al final del archivo, linea tendrá el valor null
		{
			System.out.println(pos+" - "+linea);
			actividadesTipo.add(pos, linea);
			linea = br.readLine();
			pos ++;
		}
		this.proyecto = new Proyecto(nombreProyecto, descripccionProyecto, fechaInicioProyecto, fechaFinalizacionProyecto, actividadesTipo);
		br.close();
		System.out.println("\n-Proyecto cargado exitosamente! \n");
	}
	
	public void addParticipante() throws IOException
	{
		String nombreParticipante = input("Ingrese nombre del Participante: ");
		String correoParticipante = input("Ingrese correo del Participante: ");
		registro.escribirParticipante(nombreParticipante, correoParticipante);
		proyecto.cargarParticipante(nombreParticipante, correoParticipante);
	}
	
	public void addActividad() throws IOException 
	{
		String titulo = input("Ingrese titulo de la Actividad: ");
		String descripccion = input("Ingrese descripccion de la Actividad: ");
		
		System.out.println("\nTIPOS DE ACTIVIDADES:");
		ArrayList <String> listaActividades = proyecto.getTipoActividades();
		int posTipos = 0;
		for (String tipo:listaActividades)
		{
			System.out.println(posTipos+"- " +tipo);
			posTipos++;
		}
		
		int tipoID = Integer.parseInt(input("\nIngrese el tipo de la Actividad: "));
		String fecha = input("Ingrese fecha en la que se realizo la Actividad (AAAA-MM-DD): ");
		double horaInicio = Double.parseDouble(input("Ingrese hora de inicio: "));
		double horaFin = Double.parseDouble(input("Ingrese hora de finalizacion: "));
		double duracion = Double.parseDouble(input("Ingrese duracion: "));
		
		System.out.println("\nLISTA DE PARTICIPANTES:");
		ArrayList<Participante> listaParticipantes = proyecto.getParticipantes();
		int posParticipante = 0;
		for (Participante elParticipante:listaParticipantes)
		{
			System.out.println(posParticipante+"- " + elParticipante.getNombre());
			posParticipante++;
		}
		
		int participanteID = Integer.parseInt(input("Ingrese id de quien realizo la Actividad: "));
		
		registro.escribirActividades(titulo, descripccion, tipoID, fecha, horaInicio, horaFin, duracion, participanteID);
		proyecto.cargarActividad(titulo, descripccion, tipoID, fecha, horaInicio, horaFin, duracion, participanteID);
	}

	public void mostrarMenu()
	{
		System.out.println("\nOpciones de la aplicación\n");
		System.out.println("1. Agregar actividad");
		System.out.println("2. Iniciar cronometro");
		System.out.println("3. Generar reporte");
		System.out.println("4. Agregar participante");
		System.out.println("5. Salir de aplicacion");
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
