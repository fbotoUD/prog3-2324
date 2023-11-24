package es.deusto.prog3.cap03.resueltos;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;

public class CsvReadMain {

	public static void main(String[] args) {
		//Se abre el fichero usando la utilizadad "try-catch with closeable resources"
		try (BufferedReader in = new BufferedReader(new FileReader("src/es/deusto/prog3/cap03/resueltos/usuarios.csv"))) {
			String linea;
			List<User> users = new ArrayList<>();
			
			//Lectura inicial para saltar la cabecera del fichero CSV.
			in.readLine();
			
			//Se leen líneas hasta llegar al final del fichero.
			while( (linea = in.readLine()) != null ) {
				//Se trasnforma cada línea en un objeto User y se añade a la lista.
				users.add(User.parseCSV(linea));
			}
			
			//Se recorre la lista de usuarios y se muestra su contenido por pantalla.
			users.forEach(user -> System.out.println(user));
			
		} catch(Exception ex) {
			System.err.println(String.format("Error en el main: %s", ex.getMessage()));
		}
	}
}