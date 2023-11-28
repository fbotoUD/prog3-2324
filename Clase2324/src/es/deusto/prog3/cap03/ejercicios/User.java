package es.deusto.prog3.cap03.ejercicios;

import java.util.Scanner;

public class User {

	private String username;
	private String identifier;
	private String firstName;
	private String lastName;

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getIdentifier() {
		return identifier;
	}

	public void setIdentifier(String identifier) {
		this.identifier = identifier;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	
	public String toString() {
		return String.format("[%s - %-9s] %s, %s", 
				identifier, username, lastName, firstName);
	}
	
	/**
	 * Crea un objeto User a partir de una cadena de texto searado
	 * por comas con los 4 atributos del usuario.
	 * @param linea String con la cadena de texto con los atributos del usuario
	 * @return User con el nuevo usuario creado
	 */
	public static User parseCSV(String linea) {
		//TODO implementa el parser de la línea
		//Se puede usar la clase Scanner, StringTokenizer o incluso String.split()
		
		return null;
	}
}