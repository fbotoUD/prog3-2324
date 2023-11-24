package es.deusto.prog3.cap03;

import java.io.*;
import java.util.Scanner;
import java.util.StringTokenizer;


public class EjemploLecturaCSV {
	
	public static void main(String[] args) {
		
		try {
			FileReader fileReader = new FileReader("src/es/deusto/prog3/cap03/stock.csv");
			BufferedReader bufferedReader = new BufferedReader(fileReader);
			String linea;
			while( (linea = bufferedReader.readLine()) != null ) {
				System.out.println(linea);
			}
			
//			bufferedReader.close();	
		} catch(IOException e) {
			System.out.println("Error al abrir el archivo");
			
		}
		//Para evitar hacer el close se puede hacer esto. closeable resources
		
		System.out.println("Usando closeable resource");
		try(BufferedReader in = new BufferedReader(new FileReader("src/es/deusto/prog3/cap03/stock.csv"))){
			String linea;
			while( (linea = in.readLine()) != null ) {
				System.out.println(linea);
			}
		} catch (FileNotFoundException e) {
			System.out.println("Error al abrir el archivo");
			e.printStackTrace();
		} catch (IOException e) {
			System.out.println("Error entrada salida");
			e.printStackTrace();
		}
		
		System.out.println("Leer palabra por palabra con un delimitador (StringTokenizer)");
		//Ahora vas a leer palabra por palabra usando un delimitador con StringTokenizer
		try(BufferedReader in = new BufferedReader(new FileReader("src/es/deusto/prog3/cap03/stock.csv"))){
			String linea;
			while( (linea = in.readLine()) != null ) {
				StringTokenizer tokenizer = new StringTokenizer(linea,",");
//				System.out.println("Tokens en la línea " + tokenizer.countTokens());
				while(tokenizer.hasMoreTokens()) {
					System.out.print(tokenizer.nextToken()+"\t");
				}
				System.out.println();
			}
		} catch (FileNotFoundException e) {
			System.out.println("Error al abrir el archivo");
			e.printStackTrace();
		} catch (IOException e) {
			System.out.println("Error entrada salida");
			e.printStackTrace();
		}
		
		System.out.println("Leer palabra por palabra con un delimitador Scanner");
		//Ahora vas a leer palabra por palabra usando un delimitador con StringTokenizer
		try (Scanner scanner = new Scanner(new File("src/es/deusto/prog3/cap03/stock.csv"))) {
            while (scanner.hasNextLine()) {
                String linea = scanner.nextLine();
                
                // Utiliza Scanner para dividir la línea en tokens usando la coma como delimitador
                try (Scanner lineScanner = new Scanner(linea).useDelimiter(",")) {
                    // Procesa cada token
                    while (lineScanner.hasNext()) {
                        String token = lineScanner.next();
                        System.out.print(token + "\t"); // Puedes hacer lo que desees con cada token
                    }
                    System.out.println(); // Salto de línea después de procesar una línea completa
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
		
	}
	
	
	

}
