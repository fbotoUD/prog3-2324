package es.deusto.prog3.cap05;


import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

class Persona {
    private String nombre;
    private int edad;

    public Persona(String nombre, int edad) {
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
}

public class AvanzadoArrayList {

    public static void main(String[] args) {
        // Crear una lista de personas
        List<Persona> personas = new ArrayList<>();
        personas.add(new Persona("Albert", 25));
        personas.add(new Persona("Issac", 30));
        personas.add(new Persona("Carl Friedrich", 22));

        // Imprimir la lista antes de ordenar
        System.out.println("Lista antes de ordenar:");
        personas.forEach(e -> System.out.println(e));

        // Ordenar la lista por edad utilizando un Comparator y una función lambda
        Comparator<Persona> compEdad = (p1, p2) -> { 
        	return Integer.compare(p1.getEdad(), p2.getEdad());
		};
		personas.sort(compEdad);
		

        // Imprimir la lista después de ordenar
        System.out.println("\nLista después de ordenar por edad:");
        personas.forEach(System.out::println);
        
        //TODO ordenar alfabéticamente

    }
}
