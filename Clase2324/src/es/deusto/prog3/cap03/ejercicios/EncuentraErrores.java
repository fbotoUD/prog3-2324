package es.deusto.prog3.cap03.ejercicios;

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
	 * @return 
	 * @return	Lista de errores encontrados en el proceso, vacía si no ha habido ninguno
	 */
	public static void procesarFichero(File file) {

		//Introduce el código para procesar las líneas del fichero de texto y generar la lista
		//de errores encontrados.
	}

//TODO puedes usar una función de apoyo si lo crees conveniente.
//	private static ArrayList<String> procesaLinea(String linea) {
//		return null;
//		
//	}
}
