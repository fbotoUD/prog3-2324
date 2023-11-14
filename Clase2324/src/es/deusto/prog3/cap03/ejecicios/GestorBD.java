package es.deusto.prog3.cap03.ejecicios;

import java.sql.*;

/*
 * Rellena todos los huecos necesarios de la siguiente clase GestorBD. Los métodos
deben ejecutar la sentencia sql que se indica en la variable llamada sql. Finalmente,
escribe en el método main cómo realizarías la llamada a todos los métodos de la
clase que has rellenado: connect(), createTable(), insert(), selectAll().
Con este último, muestra en pantalla los resultados que éste debería de dar.
 * */
public class GestorBD {
	private Connection conn;
	public void connect(String name) {
		//TODO completa
	}
	
	public Connection getConnection() {
		return conn;
	}
	
	public void createTable() {
		String sql = "CREATE TABLE IF NOT EXISTS employees (\n" + " idinteger PRIMARY KEY,\nname text NOT NULL,\nsalary real\n" + ");";
		//TODO completa
//		try {
//			
//		} catch (SQLException e) {System.out.println(e.getMessage());}
		
	}
	
	public void insert(String name, double salary) throws SQLException {
		String sql = "INSERT INTO employees(name, salary) VALUES(?,?)";
		
		//TODO completa la tabla con usa serie de empleados
		
	}
	
	public ResultSet selectAll() {
		String sql = "SELECT * FROM employees";
		
		//TODO completa
		
		return null;
	}
	
	public static void main(String[] args) throws SQLException {	
	
	}

	
	


}
