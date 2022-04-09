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

import uniandes.dpoo.proyecto1.modelo.Actividad;
import uniandes.dpoo.proyecto1.modelo.Participante;
import uniandes.dpoo.proyecto1.modelo.Proyecto;
import uniandes.dpoo.proyecto1.modelo.Registro;
import uniandes.dpoo.proyecto1.modelo.Stopwatch;

public class Aplicacion {

	public static void main(String[] args) throws FileNotFoundException, IOException 
	{
		// TODO Auto-generated method stub
		System.out.println((LocalDateTime.now().toLocalTime().getHour())+":"+(LocalDateTime.now().toLocalTime().getMinute()));
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
				String horaInicio = (partes[4]);
				String horaFin = (partes[5]); 
				int duracion = Integer.parseInt(partes[6]); 
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
					/*pruebaStopwatch();*/
					/*System.out.println("Construccion ...");*/
					ejecutarCronometro();

				else if (opcion_seleccionada == 3 && proyecto != null)
					cargarReporte();
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


	private void ejecutarCronometro() throws IOException 
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
		System.out.println("\nLISTA DE PARTICIPANTES:");
		ArrayList<Participante> listaParticipantes = proyecto.getParticipantes();
		int posParticipante = 0;
		for (Participante elParticipante:listaParticipantes)
		{
			System.out.println(posParticipante+"- " + elParticipante.getNombre());
			posParticipante++;
		}
		String horaInicio = String.valueOf((LocalDateTime.now().toLocalTime().getHour()))+":"+
				String.valueOf((LocalDateTime.now().toLocalTime().getMinute()));
		int participanteID = Integer.parseInt(input("Ingrese id de quien realizo la Actividad: "));
		System.out.println("----INICIANDO CRONOMETRO----"+"\n la actividad se registra al final \n");
		System.out.println("1. Iniciar");
		System.out.println("2. Pausar");
		System.out.println("3. Reanudar");
		System.out.println("4. Terminar");
		
		int duracion = 0;
		boolean continuar = true;
		Stopwatch prueba = new Stopwatch();
		while (continuar)
		{

			int opcion_seleccionada = Integer.parseInt(input("Por favor seleccione una opción"));
			if (opcion_seleccionada == 1)
			{
				prueba.start();
			}
			else if (opcion_seleccionada == 2) {
				prueba.pause();
			}
			else if (opcion_seleccionada == 3)
			{
				prueba.resume();
			}
			else if (opcion_seleccionada == 4)
			{
				prueba.stop();
				duracion=prueba.getDuration().toMinutesPart();
				continuar=false;
			}
		}
		String horaFin = String.valueOf((LocalDateTime.now().toLocalTime().getHour()))+":"+
				String.valueOf((LocalDateTime.now().toLocalTime().getMinute()));
		
		
		registro.escribirActividades(titulo, descripccion, tipoID, fecha, horaInicio, horaFin, duracion, participanteID);
		proyecto.cargarActividad(titulo, descripccion, tipoID, fecha, horaInicio, horaFin, duracion, participanteID);
		
	}

	/*private void pruebaStopwatch() 
	{
		Stopwatch prueba = new Stopwatch();
		prueba.start();
		String prueba1 = input("Algo: ");
		prueba.stop();
		System.out.println((prueba.getDuration()).toMinutesPart());
	}*/

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
		String horaInicio = (input("Ingrese hora de inicio: (formato 24 horas 'HH:MM')"));
		String horaFin = (input("Ingrese hora de finalizacion(formato 24 horas 'HH:MM')"));
		String[] splitHoraInicio = horaInicio.split(":");
		int horaIn = Integer.parseInt(splitHoraInicio[0]);
		int minutosIn = Integer.parseInt(splitHoraInicio[1]);
		
		String[] splitHoraFin = horaFin.split(":");
		int horaFi = Integer.parseInt(splitHoraFin[0]);
		int minutosFi = Integer.parseInt(splitHoraFin[1]);
		int horaProcesada = (horaFi-horaIn)*60 ;
		int duracion = (minutosFi-minutosIn+horaProcesada);

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
		System.out.println("2. Cronometrar actividad");
		System.out.println("3. Generar reporte");
		System.out.println("4. Agregar participante");
		System.out.println("5. Salir de aplicacion");
	}




	private void cargarReporte(){
		ArrayList<Participante> listaParticipantes = proyecto.getParticipantes();
		int posParticipante = 0;
		for (Participante elParticipante:listaParticipantes)
		{
			System.out.println(posParticipante+"- " + elParticipante.getNombre());
			posParticipante++;
		}
		int id = Integer.parseInt(input("Ingrese el ID del participante para el reporte"));
		proyecto.ejecutarReporte(id);
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
