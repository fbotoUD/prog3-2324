package es.deusto.prog3.cap05;


import java.util.*;

class PersonaBis implements Comparable<PersonaBis>{
    private String nombre;
    private int edad;

    public PersonaBis(String nombre, int edad) {
        this.nombre = nombre;
        this.edad = edad;
    }

    public String getNombre() {
        return nombre;
    }

    public int getEdad() {
        return edad;
    }

    @Override
    public String toString() {
        return "Persona{" +
                "nombre='" + nombre + '\'' +
                ", edad=" + edad +
                '}';
    }

	@Override
	public int compareTo(PersonaBis o) {
		return getNombre().compareTo(o.getNombre());
	}

}

/*
 *  List:
 *  Descripción: Una colección ordenada que permite elementos duplicados.
 *  Los elementos se almacenan en un orden específico, y cada elemento tiene un índice.
 *  Implementaciones: ArrayList, LinkedList.
 *          
 *  ArrayList: Se suele preferir cuando se necesita un acceso rápido a elementos por índice
 *  y no se realizan muchas operacionesde inserción o eliminación en el medio de la lista.
 *  LinkedList: Puede ser más eficiente en escenarios donde se realizan frecuentes operaciones de inserción
 *  o eliminación en el medio de la lista y el acceso por índice no es crítico.
 * */

public class EjemploList2 {

    public static void main(String[] args) {
        // Crear una lista de personas
        List<PersonaBis> personas = new ArrayList<>();
        personas.add(new PersonaBis("Issac", 30));
        personas.add(new PersonaBis("Carl Friedrich", 22));
        personas.add(new PersonaBis("Albert", 25));

        // Imprimir la lista antes de ordenar
        System.out.println("Lista antes de ordenar:");
        personas.forEach(e -> System.out.println(e));

//        // Ordenar la lista por edad utilizando un Comparator y una función lambda
//        Comparator<Persona> compEdad = (p1, p2) -> { 
//        	return Integer.compare(p1.getEdad(), p2.getEdad());
//		};
//		personas.sort(compEdad);
//		
//		Comparator<Persona> compNom  = (p1, p2) -> { 
//        	return p1.getNombre().compareTo(p2.getNombre());
//		};
//		personas.sort();
        TreeSet<PersonaBis> mapaOrd = new TreeSet<>(personas);
        
        
		// Imprimir la lista antes de ordenar
//        System.out.println("Lista antes de ordenar por nombre:");
//        personas.forEach(e -> System.out.println(e));
//		
//
//        // Imprimir la lista después de ordenar
//        System.out.println("\nLista después de ordenar por edad:");
//        personas.forEach(System.out::println);
        
        //TODO ordenar alfabéticamente
        System.out.println("Lista antes de ordenar por nombre con treeSet:");
        mapaOrd.forEach(e -> System.out.println(e));
        
        
        /////////
        //Revisa el uso de reverse order
        List<Integer> numeros = new ArrayList<>();
        numeros.add(5);
        numeros.add(2);
        numeros.add(8);
        numeros.add(1);

        // Ordenar la lista en orden inverso
//        Collections.sort(numeros, Collections.reverseOrder());
        
        // Imprimir la lista ordenada en orden inverso
        System.out.println("Lista ordenada en orden inverso: " + numeros);
        //Ten en cuenta que no es lo mismo que Collections.reverse()
        //TODO pruebalo y verifica el comportamiento
        
        Collections.reverse(numeros);
        System.out.println("Lista ordenada en orden inverso: " + numeros);
        
        
        
        /////////////////
        
        LinkedList<String> listaLinkedList = new LinkedList<>();

        // Agregar elementos
        listaLinkedList.add("Manzana");
        listaLinkedList.add("Banana");
        listaLinkedList.add("Naranja");
        listaLinkedList.add("Uva");

        // Utilizar una expresión lambda para imprimir cada elemento
        System.out.println("Elementos en LinkedList:");

        listaLinkedList.forEach(elemento -> System.out.println(elemento));
        
        LinkedList<Persona> personasLinked = new LinkedList<>();
        personasLinked.add(new Persona("Albert", 25));
        personasLinked.add(new Persona("Carl Friedrich", 22));
        System.out.println("Linked list con algunos:");
        personasLinked.forEach(e -> System.out.println(e));
        
        personasLinked.add(1, new Persona("Issac", 30));
        System.out.println("Linked list con el último en medio:");
        personasLinked.forEach(e -> System.out.println(e));
        
        //Revisa el orden de las adiciones
        
        
        

    }
}
