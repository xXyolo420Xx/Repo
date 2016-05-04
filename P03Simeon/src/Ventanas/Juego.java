package Ventanas;

import Clases.Jugador;
import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;

public class Juego extends JFrame {
	
	private JPanel contentPane;
	private JLabel lblBienvenida;
	//REFERENCIA DE j1;
	private Jugador j1;
	
	public Juego() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		lblBienvenida = new JLabel("");
		lblBienvenida.setBounds(112, 11, 312, 14);
		contentPane.add(lblBienvenida);
		
		
}
	//SETTER DE j1
	public void setJ1(Jugador j1) {
		this.j1 = j1;
		lblBienvenida.setText("Bienvenido "+j1.getNombre());
	}

}
