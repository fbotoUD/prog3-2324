package es.deusto.prog3.cap05;

import java.util.*;

/*
 *   Set:
 *   Descripción: Una colección que no permite elementos duplicados.
 *   Garantiza que no puede haber elementos repetidos en la colección.
 *   Implementaciones: HashSet, TreeSet y LinkedHashSet.        
 * */

public class EjemploSet {
	
	public void EjemploSet() {
		// Ejemplo HashSet
        Set<String> conjuntoHashSet = new HashSet<>();
        	
        // Agregar elementos
        conjuntoHashSet.add("Manzana");
        conjuntoHashSet.add("Banana");
        conjuntoHashSet.add("Naranja");
        conjuntoHashSet.add("Uva");

        // No permite elementos duplicados
        conjuntoHashSet.add("Manzana");

        // Mostrar elementos (orden no garantizado)
        System.out.println("Elementos en HashSet: " + conjuntoHashSet);
        //¿En qué orden se imprime?
        
        ///////////////////////////
        
        //Ejemplo TreeSet
        Set<String> conjuntoTreeSet = new TreeSet<>();

        // Agregar elementos
        conjuntoTreeSet.add("Manzana");
        conjuntoTreeSet.add("Banana");
        conjuntoTreeSet.add("Naranja");
        conjuntoTreeSet.add("Uva");

        // No permite elementos duplicados
        conjuntoTreeSet.add("Manzana");

        // Mostrar elementos (orden ascendente garantizado)
        System.out.println("Elementos en TreeSet: " + conjuntoTreeSet);
        //¿En qué orden se imprime?
        
        ///////////////////////////
        
        //Ejemplo LinkedHashSet
     // Crear un LinkedHashSet
        Set<String> linkedHashSet = new LinkedHashSet<>();

        // Agregar elementos
        linkedHashSet.add("Manzana");
        linkedHashSet.add("Banana");
        linkedHashSet.add("Naranja");
        linkedHashSet.add("Uva");

        // No permite elementos duplicados
        linkedHashSet.add("Manzana");

        // Mostrar elementos (orden de inserción garantizado)
        System.out.println("Elementos en LinkedHashSet: " + linkedHashSet);
      //¿En qué orden se imprime?
        
	}
	public static void main(String[] args) {
		EjemploSet jc = new EjemploSet();
		
		jc.EjemploSet();

	}

}
