package es.deusto.prog3.cap03.resueltos;

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
	
	public void GestorBD() {
//		try {
//			//Cargar el diver SQLite
//			Class.forName("org.sqlite.JDBC");
//		} catch (ClassNotFoundException ex) {
//			System.err.println(String.format("* Error al cargar el driver de BBDD: %s", ex.getMessage()));
//			ex.printStackTrace();
//		}
	}
	
	public void connect(String name) {
		try {
			conn = DriverManager.getConnection(name);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public Connection getConnection() {
		return conn;
	}
	
	public void createTable() {
		String sql = "CREATE TABLE IF NOT EXISTS employees (\n" + " idinteger PRIMARY KEY,\nname text NOT NULL,\nsalary real\n" + ");";
		try {
			Statement statement = conn.createStatement();
			statement.setQueryTimeout(30);
			statement.executeUpdate(sql);
			statement.close();
			
		} catch (SQLException e) {System.out.println(e.getMessage());}
		
	}
	
	public void insert(int idinteger,String name, double salary) throws SQLException {
		Statement statement = null;
		try {
//			statement = conn.createStatement();
//			statement.setQueryTimeout(30);
//			String sql = "INSERT INTO employees(name, salary) VALUES('"+name+"',"+String.valueOf(salary)+");";
//			String sql = "INSERT INTO employees(idinteger, name, salary) VALUES(?,?,?)";
//			statement.executeUpdate(sql);
//			System.out.println("Consulta ejecutada: " + sql);
			
			String sql = "INSERT INTO employees(idinteger, name, salary) VALUES('%s','%s','%s')";
			sql = sql.format(sql, String.valueOf(idinteger),name,String.valueOf(salary));
			statement = conn.createStatement();
			statement.executeUpdate(sql);
//			
//			statement.close();
//			PreparedStatement statement = conn.prepareStatement(sql);
//			statement.setInt(1, idinteger);
//			statement.setString(2, name);
//			statement.setDouble(3, salary);
//			statement.execute();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}
	
	public ResultSet selectAll() {
		String sql = "SELECT * FROM employees";
		
		Statement statement;
		ResultSet rs = null;
		try {
			statement = conn.createStatement();
			statement.setQueryTimeout(30);
			rs =statement.executeQuery(sql);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return rs;	
	}
	
	public static void main(String[] args) throws SQLException {
		
		GestorBD gestor = new GestorBD();
		gestor.connect("jdbc:sqlite:bd/empleados.db");
		gestor.createTable();
		
		gestor.insert(7,"Oihan", 2000.0);
		
		ResultSet rs = gestor.selectAll();
		
		while(rs.next()) {
			// Leer el resultset
			System.out.println("name = " + rs.getString("name"));
			System.out.println("Salary = " + rs.getInt("salary"));
		}
		gestor.getConnection().close();
	
	}

}