package es.deusto.prog3.cap03.ejercicios;

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
 * 
 * Versión 2: crea un nuevo programa principal en el que los nombres de los ficheros .obj y CSV se obtengan desde un fichero de propiedades. Utiliza la clase Properties.
 * */
public class MainRocket {

	
}
