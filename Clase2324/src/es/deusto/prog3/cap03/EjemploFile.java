package es.deusto.prog3.cap03;

import java.io.File;
import java.nio.file.Path;

public class EjemploFile {

	public static void main(String[] args) {
		verFicheros();
		probarPath();
	}
	
	// Ejemplo con file ver ficheros en carpetas
	private static void verFicheros() {
		File f = new File( "./" );
		for (File f2 : f.listFiles()) {
			System.out.println( f2.getName() + (f2.isDirectory() ? " D" : " F") );
			if (f2.isDirectory()) {
				for (File f3 : f2.listFiles()) {
					System.out.println( "   " + f3.getAbsolutePath() );
				}
			}
		}
	}
	
	private static void probarPath() {
		File f = new File( "./" );
		System.out.println( f.getAbsolutePath() );
		Path p = f.toPath();
		System.out.println( p.getRoot() );
		for (int i=0; i<p.getNameCount(); i++) {
			System.out.println( "  " + p.getName(i) );
		}
	}
	
}
