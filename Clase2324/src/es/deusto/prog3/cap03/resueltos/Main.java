package es.deusto.prog3.cap03.resueltos;

import java.util.ArrayList;
import java.util.List;

public class Main {

	public static void main(String[] args) {
		GestorBD2 gestorBD = new GestorBD2();		
		
		//CREATE DATABASE: Se crea la BBDD
		gestorBD.crearBBDD();
		
		//INSERT: Insertar datos en la BBDD		
		List<Cliente> clientes = initClientes();
		gestorBD.insertarDatos(clientes.toArray(new Cliente[clientes.size()]));
		
		//SELECT: Se obtienen datos de la BBDD
		clientes = gestorBD.obtenerDatos();
		printClientes(clientes);
		
		//UPDATE: Se actualiza la password de un cliente
		String newPassword = "hWaPvd6R28%1";
		gestorBD.actualizarPassword(clientes.get(0), newPassword);

		//SELECT: Se obtienen datos de la BBDD
		clientes = gestorBD.obtenerDatos();
		printClientes(clientes);

		//DELETE: Se borran datos de la BBDD
		gestorBD.borrarDatos();
		
		//DROP DATABASE: Se borra la BBDD
		gestorBD.borrarBBDD();
	}
	
	private static void printClientes(List<Cliente> clientes) {
		if (!clientes.isEmpty()) {		
			for(Cliente cliente : clientes) {
				System.out.println(String.format(" - %s", cliente.toString()));
			}
		}		
	}
	
	public static List<Cliente> initClientes() {
		List<Cliente> clientes = new ArrayList<>();
		
		Cliente cliente = new Cliente();
		cliente.setName("Bruce Banner");
		cliente.setEmail("hulk@gmail.com");
		cliente.setPassword("NUcRn8h85RZZTjg6UBwa");
		clientes.add(cliente);
		
		cliente = new Cliente();
		cliente.setName("Steve Rogers");
		cliente.setEmail("captain.america@gmail.com");
		cliente.setPassword("bJ7pXP1Hnfq9C0ywVr71");
		clientes.add(cliente);
		
		cliente = new Cliente();
		cliente.setName("Clark Kent");
		cliente.setEmail("superman@gmail.com");
		cliente.setPassword("Bjp5hVDAksDFz3LqYMMe");
		clientes.add(cliente);
		
		cliente = new Cliente();
		cliente.setName("Bruce Wayne");
		cliente.setEmail("batman@gmail.com");
		cliente.setPassword("Nrr5wp8VbgDEqQtGTbUx");
		clientes.add(cliente);
		
		cliente = new Cliente();
		cliente.setName("Peter Parker");
		cliente.setEmail("spiderman@gmail.com");
		cliente.setPassword("AGuogPQkpcJmL16c7P6D");
		clientes.add(cliente);
		
		return clientes;
	}

}