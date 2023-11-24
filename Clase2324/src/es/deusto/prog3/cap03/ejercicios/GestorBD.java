package es.deusto.prog3.cap03.ejercicios;

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
	
	public GestorBD() {
		try {
			Class.forName("org.sqlite.JDBC");
			System.out.println("CORRECTO");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public void connect(String name) {
		try {
			conn = DriverManager.getConnection(name);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	public Connection getConnection() {
		return conn;
	}
	
	public void createTable() {
		String sql = "CREATE TABLE IF NOT EXISTS employees (\n" + " idinteger PRIMARY KEY,\nname text NOT NULL,\nsalary real\n" + ");";
		//TODO completa
		try {
			Statement statement = conn.createStatement();
			statement.setQueryTimeout(30);
			statement.executeUpdate(sql);
			
		} catch (SQLException e) {System.out.println(e.getMessage());}
		
	}
	
	public void insert(String name, double salary) throws SQLException {
		String sql = "INSERT INTO employees(name, salary) VALUES(?,?)";
		
		//TODO completa la tabla con usa serie de empleados
		
		PreparedStatement statement = conn.prepareStatement(sql);
		statement.setString(1, name);
		statement.setDouble(2, salary);
		statement.execute();
		
	}
	
	public ResultSet selectAll() {
		String sql = "SELECT * FROM employees";
		Statement st;
		ResultSet result;
		try {
			st = conn.createStatement();
			result = st.executeQuery(sql);
			
			while(result.next()) {
				System.out.println("name "+result.getString("name"));
				System.out.println("name "+result.getString("salary"));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return null;
	}
	
	public static void main(String[] args) throws SQLException {
		
		GestorBD gestor = new GestorBD();
		gestor.connect("jdbc:sqlite:prueba.bd");
		gestor.createTable();
		gestor.insert("Albert", 2000.0);
		gestor.selectAll();
	
	}

	
	


}
