package es.deusto.prog3.cap06;


import javax.swing.*;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;


/*
 * Un Document es una interfaz que define la estructura de datos subyacente de los componentes de texto,
 * como JTextField y JTextPane.
 * Representa el contenido del texto y proporciona métodos para manipular y acceder a dicho contenido.
 * https://docs.oracle.com/javase%2F7%2Fdocs%2Fapi%2F%2F/javax/swing/text/Document.html
 * 
 * Un DocumentListener es una interfaz que permite escuchar y responder a cambios en un componente
 * de texto asociado a un Document.
 * La interfaz DocumentListener define tres métodos: insertUpdate, removeUpdate, changedUpdate.
 * */
public class EjemploDocumentTextField {
    public static void main(String[] args) {
        JFrame frame = new JFrame("JTextField Eventos");
        JTextField textField = new JTextField();

        // Agregar un DocumentListener al JTextField
        textField.getDocument().addDocumentListener(new DocumentListener() {
            @Override
            public void insertUpdate(DocumentEvent e) {
                // Se llama cuando se inserta texto
                System.out.println("Texto insertado: " + textField.getText());
            }

            @Override
            public void removeUpdate(DocumentEvent e) {
                // Se llama cuando se elimina texto
                System.out.println("Texto eliminado: " + textField.getText());
            }

            @Override
            public void changedUpdate(DocumentEvent e) {
                // Este método se llama cuando hay un cambio en atributos del documento (raro en JTextField)
            }
        });

        frame.getContentPane().add(textField);
        frame.setSize(300, 200);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }
}

