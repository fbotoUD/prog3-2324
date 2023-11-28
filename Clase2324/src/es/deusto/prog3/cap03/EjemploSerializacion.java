package es.deusto.prog3.cap03;

import java.io.*;

//Una clase que implementa Serializable
class Persona implements Serializable {
	 private static final long serialVersionUID = 1L; // Identificador de versión
	
	 private String nombre;
	 private int edad;
	
	 public Persona(String nombre, int edad) {
	     this.nombre = nombre;
	     this.edad = edad;
	 }
	
	 @Override
	 public String toString() {
	     return "Persona [nombre=" + nombre + ", edad=" + edad + "]";
	 }
}

public class EjemploSerializacion {
 public static void main(String[] args) {
     // Crear una instancia de la clase Persona
     Persona persona = new Persona("Juan", 30);

     // Serialización del objeto
     try (ObjectOutputStream objectOutputStream = new ObjectOutputStream(new FileOutputStream("persona.dat"))) {
         objectOutputStream.writeObject(persona);
         System.out.println("Objeto serializado y guardado en persona.dat");
     } catch (IOException e) {
         e.printStackTrace();
     }

     // Deserialización del objeto
     try (ObjectInputStream objectInputStream = new ObjectInputStream(new FileInputStream("persona.dat"))) {
         Persona personaDeserializada = (Persona) objectInputStream.readObject();
         System.out.println("Objeto deserializado: " + personaDeserializada);
     } catch (IOException | ClassNotFoundException e) {
         e.printStackTrace();
     }
 }
}

