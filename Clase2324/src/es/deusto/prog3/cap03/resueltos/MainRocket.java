package es.deusto.prog3.cap03.resueltos;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.ObjectInputStream;
import java.io.PrintWriter;
import java.util.List;
import java.util.Properties;

import es.deusto.prog3.examen.ord202201.RocketLaunch;


/*
 * Este ejercicio se trata de lanzamientos de cohetes espaciales (examen ordinaria 2022). Se proporciona el código fuente de la clase RocketLaunch.java que representa la información de un lanzamiento.
 * Además, un fichero binario "lanzamientos.obj" en el que se ha serializado (almacenado)
 * una lista de objetos de tipo RocketLaunch (List<RocketLaunch>).
 * Objetivo: leer el contenido del fichero lanzamientos.obj para recuperar la lista de lanzamientos
 * y almacenar la siguiente información de los lanzamientos en un fichero CSV: compañía, fecha de lanzamiento (con el siguiente formato: dd-MM-yyyy HH:mm) y estatus.
 * Ejemplo: Roscosmos;30-07-2020 21:25;SUCCESS
 * Pista: usa las clases ObjectInputStream, PrintWriter y DateTimeFormatter.
 * Versión 2: crea un nuevo programa principal en el que los nombres de los ficheros .obj y CSV se obtengan desde un fichero de propiedades. Utiliza la clase Properties.
 * */
public class MainRocket {

	private static final String INPUT_KEY = "input";
	private static final String OUTPUT_KEY = "output";
	private static final String PROPERTIES_FILE = "resources/config.properties";

	public static void main(String[] args) {
		try {
			Properties properties = loadProperties(); 
					
			if (properties.containsKey(INPUT_KEY)) {
				// Se leen la información desde el fichero serializado.
				List<RocketLaunch> lanzamientos = loadData(properties.getProperty(INPUT_KEY));
	
				System.out.println(String.format("- Se han leído %d lanzamientos del fichero '%s'", 
						lanzamientos.size(), properties.getProperty(INPUT_KEY)));
	
				if (lanzamientos != null && properties.containsKey(OUTPUT_KEY)) {
					// Se guarda la información de los lanzamientos en un CSV
					storeCSV(properties.getProperty(OUTPUT_KEY), lanzamientos);
				} else {
					System.out.println("- No se puede crear el CSV.");
				}
			} else {
				System.out.println("- No se puede localizar el fichero de entrada.");
			}
		} catch (Exception ex) {
			System.err.println(String.format("Error en el main: %s", ex.getMessage()));
			ex.printStackTrace();
		}
	}

	/**
	 * Carga los parámetros de configuración en un objeto Properties.
	 * @return Properties con los parámetros de configuración.
	 */	
	private static Properties loadProperties() {
		Properties properties = new Properties();

		try {
			// Se carga el fichero Properties
			properties.load(new FileReader(PROPERTIES_FILE));
		} catch (Exception ex) {
			System.err.println(String.format("Error leyendo propiedades: %s", ex.getMessage()));
			ex.printStackTrace();
		}

		return properties;
	}
	
	
	/**
	 * Lee una lista de lanzamientos desde un ficheros serializado.
	 * @param filename String con el nombre del fichero serializado.
	 * @return List<RocketLaunch> con la lista de lanzamientos o null si hay errores.
	 */
	@SuppressWarnings("unchecked")
	private static List<RocketLaunch> loadData(String filename) {
		try (ObjectInputStream in = new ObjectInputStream(new FileInputStream(filename))) {
			//OjO: Casting explícito
			return (List<RocketLaunch>) in.readObject();
		} catch (Exception ex) {
			System.err.println(String.format("Error leyendo '%s': %s", filename, ex.getMessage()));
			ex.printStackTrace();
		}

		return null;
	}

	/**
	 * Guarda una lista de lanzamientos en un fichero de texto.
	 * @param filename String con el nombre del fichero de texto.
	 * @param lanzamientos List<RocketLaunch> con la lista de lanzamientos.
	 */
	private static void storeCSV(String filename, List<RocketLaunch> lanzamientos) {
		if (filename != null && !lanzamientos.isEmpty()) {
			try (PrintWriter out = new PrintWriter(new File(filename))) {
				out.println("Company;Date;Status");

				lanzamientos.forEach(l -> out.println(l.toCSVString()));		

				System.out.println(String.format("- Se ha creado el fichero '%s' con %d lanzamientos.", 
						filename, lanzamientos.size()));
			} catch (Exception ex) {
				System.err.println(String.format("Error escribiendo CSV '%s': %s", 
						filename, ex.getMessage()));
			}
		} else {
			System.out.println("- No se puede escribir el fichero CSV.");
		}
	}
}
