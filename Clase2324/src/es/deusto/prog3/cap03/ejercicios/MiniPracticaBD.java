package es.deusto.prog3.cap03.ejercicios;

import java.sql.*;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;

/*
 * 1. Crear tabla Usuario con campos nick, pass DONE
2. Añadir una fila 'admin' - 'admin' [insert]
3. Comprobar creación/datos con SQLiteMan
4. ¿Cómo hacer que solo se inserte 'admin' si no existe ya antes? [select]
5. Hacer una pequeña ventana que permita insertar usuarios nuevos de forma interactiva
6. Añadir a la ventana botón de borrado
7. Añadir los usuario en un JTable
 * 
 * */

public class MiniPracticaBD {

	private static Logger logger = Logger.getLogger( "MiniPracticaBD" );
	private static Connection con;
	private static Statement s;
	private static ResultSet rs;
	public static void main(String[] args) {
		String com = "";
		try {
			Class.forName( "org.sqlite.JDBC" );
			con = DriverManager.getConnection( "jdbc:sqlite:test.db" );
			s = con.createStatement();
			//TODO crear la tabla y el usuario admin en la BD
			
			editarUsuarios();
			/* Al final (cuando se cierre la ventana):
			rs.close();
			s.close();
			con.close();
			*/
		} catch (SQLException|ClassNotFoundException e) {
			System.out.println( "Último comando: " + com );
			e.printStackTrace();
		}
	}
	
	private static JTextField tfUsuario = new JTextField( "", 10 );
	private static JTextField tfPassword = new JTextField( "", 10 );
	private static DefaultTableModel mUsuarios; // Modelo de datos para la JTable
	private static JTable tUsuarios; // JTable de usuarios
	private static JFrame ventana;
	private static void editarUsuarios() {
		// Inicializar tabla y modelo de tabla
		Vector<String> cabeceras = new Vector<String>();
		cabeceras.add( "nick" ); cabeceras.add( "pass" );
		mUsuarios = new DefaultTableModel(  // Inicializa el modelo
				new Vector<Vector<Object>>(),  // Datos de la jtable (vector de vectores)
				cabeceras  // Cabeceras de la jtable
				);
		tUsuarios = new JTable( mUsuarios );
		// Inicializar ventana
		ventana = new JFrame( "Añadir usuarios" );
		ventana.setDefaultCloseOperation( JFrame.DISPOSE_ON_CLOSE );
		JPanel pSuperior = new JPanel( new BorderLayout() );
		JPanel p = new JPanel();
		p.add( new JLabel( "Nick: ") ); p.add( tfUsuario );
		pSuperior.add( p, BorderLayout.NORTH );
		p = new JPanel();
		p.add( new JLabel( "Password: ") ); p.add( tfPassword );
		pSuperior.add( p, BorderLayout.CENTER );
		p = new JPanel();
		JButton bAnyadir = new JButton( "Añadir usuario" );
		p.add( bAnyadir );
		JButton bBorrar = new JButton( "Borrar nick" );
		p.add( bBorrar );
		pSuperior.add( p, BorderLayout.SOUTH );
		ventana.add( pSuperior, BorderLayout.NORTH );  // Panel de datos al norte
		ventana.add( new JScrollPane( tUsuarios ), BorderLayout.CENTER );  // JTable al center
		ventana.pack();
		ventana.setVisible( true );
		bAnyadir.addActionListener( new ActionListener() { // Acción de añadir usuario
			@Override
			public void actionPerformed(ActionEvent e) {
				if (!tfUsuario.getText().isEmpty() && !tfPassword.getText().isEmpty()) {
					String com = "";
//					try {
						//TODO 
						// Ver si existe usuario
						// Si queremos asegurar el string habría que hacer algo así...
						// String nick = tfUsuario.getText().replaceAll( "'", "''" );
						// ...si no, cuidado con lo que venga en el campo de entrada.
						// "select * from Usuario where nick = 'admin'";
						
//					}
//					catch (SQLException e2) {
//						System.out.println( "Último comando: " + com );
//						e2.printStackTrace();
//					}
				} else {
					JOptionPane.showMessageDialog( ventana, "Debes rellenar los dos campos" );
				}
				actualizaTabla();
			}
		});
		bBorrar.addActionListener( new ActionListener() { // Acción de borrar usuario
			@Override
			public void actionPerformed(ActionEvent e) {
				if (!tfUsuario.getText().isEmpty() && !tfPassword.getText().isEmpty()) {
					//TODO Borrar usuario
				} else {
					JOptionPane.showMessageDialog( ventana, "Debes rellenar los dos campos" );
				}
				actualizaTabla();
			}
		});
		ventana.addWindowListener( new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) {
				//TODO cierra los objetos java.sql.*
			}
		});
		// Actualiza por primera vez la tabla de usuarios en la BD
		actualizaTabla();
	}
	
	private static void actualizaTabla() {
		String com = "";
//		try {
			//TODO Vacía el modelo para volverlo a cargar de la bd y repinta la tabla
//		} catch (SQLException e2) {
//			System.out.println( "Último comando: " + com );
//			e2.printStackTrace();
//		}
	}

}


