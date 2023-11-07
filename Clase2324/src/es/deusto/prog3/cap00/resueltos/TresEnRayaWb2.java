package es.deusto.prog3.cap00.resueltos;

import java.awt.EventQueue;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

public class TresEnRayaWb2 extends JFrame implements ActionListener{

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	
	private JButton[][] tablero;
    private char jugadorActual;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TresEnRayaWb2 frame = new TresEnRayaWb2();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public TresEnRayaWb2() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 802, 801);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		
		tablero = new JButton[3][3];
        jugadorActual = 'X';

        // Crear un GridLayout 3x3 para el tablero
        setLayout(new GridLayout(3, 3));

        // Inicializar los botones del tablero
        for (int fila = 0; fila < 3; fila++) {
            for (int columna = 0; columna < 3; columna++) {
                tablero[fila][columna] = new JButton("");
                tablero[fila][columna].setFont(new Font("Arial", Font.PLAIN, 40));
                tablero[fila][columna].setFocusPainted(false);
                tablero[fila][columna].addActionListener(this);
                add(tablero[fila][columna]);
            }
        }
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
	}

}
