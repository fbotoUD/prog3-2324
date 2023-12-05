package es.deusto.prog3.cap05;

import java.util.*;

public class EjemploHashMap {
	
    public static void main(String[] args) {
        Map<String, String> mapa = new HashMap<>();

        // Agregar una entrada al mapa solo si la clave no existe
        mapa.putIfAbsent("45972478", "Albert");
        mapa.putIfAbsent("45786445", "Thomas");
        mapa.putIfAbsent("45972478", "Ludwig"); // No se añadirá porque la clave ya existe

        // Imprimir el mapa resultante
        System.out.println("Mapa resultante: " + mapa);
    }

}
