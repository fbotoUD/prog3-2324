package es.deusto.prog3.cap05;

import java.util.*;

/*
 *  HashMap: acceso rápido y el orden no importa
 *  TreeMap: mantener un orden específico de los elementos. Tiene un rendimiento logarítmico.
 *  LinkedHashMap: Mantener el orden de inserción, rendimiento cercano a HashMap.
 */

public class EjemploMap {
	
    public static void main(String[] args) {
    	
    	//HashMap
        Map<String, String> mapa = new HashMap<>();

        // Agregar una entrada al mapa solo si la clave no existe
        mapa.putIfAbsent("75972478", "Albert");
        mapa.putIfAbsent("45786445", "Thomas");
        mapa.putIfAbsent("75972478", "Ludwig"); // No se añadirá porque la clave ya existe

        // Imprimir el mapa resultante
        System.out.println("Mapa resultante: " + mapa);
        
        //TreeMap
        Map<String, String> mapaTree = new TreeMap<>();
        mapaTree.put("75972478", "Albert");
        mapaTree.put("45786445", "Thomas");
        mapaTree.put("75972478", "Ludwig");
     // Imprimir el TreMap resultante
        System.out.println("Mapa resultante: " + mapaTree);
        
        //LinkedHashMap
        Map<String, String> linked = new LinkedHashMap<>();
        linked.put("75972478", "Albert");
        linked.put("45786445", "Thomas");
        linked.put("75972478", "Ludwig");
     // Imprimir el TreMap resultante
        System.out.println("Mapa resultante: " + linked);
        
        //¿Analiza los resultados en la consola?
    }

}
