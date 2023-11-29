package es.deusto.prog3.cap03.resueltos;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.sql.Date;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;


public class EncuentraErrores {

	//Lista de nombres de usuario válidos
	public static List<String> usernames = Arrays.asList("Ronaldus", "Iway", "leidiNana");
	//Lista de ID's de categoría válidas
	public static List<Integer> categories = Arrays.asList(1, 2, 3);
	
	public static void main(String[] args) {
	
		//Invoca al método que procesa el fichero de datos de carga de imágenes
		//y muestra los errores encontrados al finalizar el proceso.
		
		File file = new File("resources/datos_fotos_aCargar.txt");
		procesarFichero(file);
		
	}

	/**
	 * Este método procesa un fichero de datos de carga de nuevas imágenes (resources/datos_fotos_aCargar.txt).
	 * Cada línea del fichero representa a una imagen. Cada línea tiene los
	 * datos de una foto separados por tabulador (\t): username\tcodigoDeCategoria\tfecha(en Long)\trutaFoto
	 * Ejecutando el método usando el fichero, se procesan correctamente 9 fotos.
	 * El proceso de cada línea del fichero debe comprobar los siguientes errores:
	 * - formato incorrecto (la línea no tiene todo los datos o el formato de algún dato no es adecuado)
	 * - no existe usuario (el username no existe)
	 * - no existe categoría (el código de categoría no es numérico o no existe)
	 * - fecha incorrecta (la fecha no es un long válido)
	 * - no existe foto (la ruta del fichero no existe)
	 * Este es el resultado para comprobar:
	 * Línea 9: Formato categoría incorrecto
	 * Línea 10: Formato fecha incorrecto
	 * Línea 11: User no existe
	 * Línea 13: Categoría no existe
	 * Línea 14: no existe foto o ruta incorrecta
	 * Línea 15: #datos incorrecto
	 * @return	Lista de errores encontrados en el proceso, vacía si no ha habido ninguno
	 */
	public static List<String> procesarFichero(File file) {
		List<String> errores = new ArrayList<>();

		//Introduce el código para procesar las líneas del fichero de texto y generar la lista
		//de errores encontrados.
		
		try (BufferedReader in = new BufferedReader(new FileReader(file))) {
			String linea;
			
			int numLine = 1;
			//Se leen líneas hasta llegar al final del fichero.
			while( (linea = in.readLine()) != null ) {
				//Se trasnforma cada línea en un objeto User y se añade a la lista.
				System.out.print("Línea "+numLine+": ");
				for(String error: procesaLinea(linea)) {
					System.out.print(error+" ");
				}
				System.out.println();
				numLine++;
			}
			
		} catch(Exception ex) {
			System.err.println(String.format("Error en el main: %s", ex.getMessage()));
		}
		
		return errores;
	}

	//TODO puedes usar una función de apoyo si lo crees conveniente.
	private static ArrayList<String> procesaLinea(String linea) {
		
		String user = null;
		int cat = 0;
		long fecha = 0;
		String ruta = null;
		ArrayList<String> datos = new ArrayList<>();
		ArrayList<String> erroresLinea = new ArrayList<>();
		try (Scanner scanner = new Scanner(linea).useDelimiter("\t")) {
			while(scanner.hasNext()) {
				datos.add(scanner.next());
			}
		} catch (Exception ex) {
			System.err.println(String.format("Error en línea", ex.getMessage()));			
		}
		if(datos.size()!=4) erroresLinea.add("#datos incorrecto");
		
		if(datos.size()>0) {
			try {
				user = datos.get(0);
				if(!usernames.contains(user)) erroresLinea.add("User no existe");
				
			}catch (Exception e) {
				erroresLinea.add("Formato user incorrecto");
			}
		}
		if(datos.size()> 1) {
			try {
				cat = Integer.parseInt(datos.get(1));
				if(!categories.contains(cat)) erroresLinea.add("Categoría no existe");
			} catch (NumberFormatException e) {
				erroresLinea.add("Formato categoría incorrecto");
			}
		}
		if(datos.size()> 2) {
			try {
				fecha = Long.parseLong(datos.get(2));
			} catch (Exception e) {
				erroresLinea.add("Formato fecha incorrecto");
			}
			
			try {
				Date date = new Date(fecha);
			} catch (Exception e) {
				erroresLinea.add("Fecha incorrecta");
			}
		}
		if(datos.size()> 3) {
			ruta = datos.get(3);
			File file = new File(ruta);
			if(!file.exists()) erroresLinea.add("no existe foto o ruta incorrecta");
			
		}
		return erroresLinea;
		
		
//		System.out.println(user+","+String.valueOf(cat)+","+String.valueOf(fecha)+","+ruta);
		
	}
}
