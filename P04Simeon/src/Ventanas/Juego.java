package Ventanas;

import Clases.Jugador;
import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.util.Random;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;

public class Juego extends JFrame {
	
	private JPanel contentPane;
	private JLabel lblBienvenida;
	//REFERENCIA DE j1;
	private Jugador j1;
	
	//DEFINIMOS ETIQUETAS DE LOS DADOS
	private JLabel a1,a2,a3,r1,r2,m1;
	
	//ARRAYS DE LOS DADOS
	private ImageIcon[] dados3 = new ImageIcon[3];
	private ImageIcon[] dados6 = new ImageIcon [6];
	private ImageIcon[] dados12 = new ImageIcon [12];
		
	public Juego() {
		setTitle("Juego");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1002, 552);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		//LABEL DE BIENVENIDA
		lblBienvenida = new JLabel("");
		lblBienvenida.setBounds(664, 11, 312, 14);
		contentPane.add(lblBienvenida);
		
		//ARRAYS DE LOS DADOS
		for (int i=0;i<dados3.length;i++){
			dados3[i]=new ImageIcon(getClass().getResource("/Ventanas/Azul/"+String.valueOf(i+1)+"a.jpg"));
		}
			
		for (int i=0;i<dados6.length;i++){
			dados6[i] = new ImageIcon(getClass().getResource("/Ventanas/Rojo/"+String.valueOf(i+1)+"r.jpg"));
		}
		
		for (int i=0;i<dados12.length;i++){
			dados12[i] = new ImageIcon(getClass().getResource("/Ventanas/Morado/"+String.valueOf(i+1)+"m.jpg"));
		}
				
		//ETIQUETAS DE LOS DADOS
		a1 = new JLabel("New label");
		a1.setIcon(dados3[new Random().nextInt(dados3.length)]);
		a1.setBounds(27, 11, 130, 130);
		contentPane.add(a1);
		
		a2 = new JLabel("New label");
		a2.setIcon(dados3[new Random().nextInt(dados3.length)]);
		a2.setBounds(184, 11, 130, 130);
		contentPane.add(a2);
		
		a3 = new JLabel("New label");
		a3.setIcon(dados3[new Random().nextInt(dados3.length)]);
		a3.setBounds(348, 11, 130, 130);
		contentPane.add(a3);
		
		r1 = new JLabel("New label");
		r1.setIcon(dados6[new Random().nextInt(dados6.length)]);
		r1.setBounds(27, 180, 130, 130);
		contentPane.add(r1);
		
		r2 = new JLabel("New label");
		r2.setIcon(dados6[new Random().nextInt(dados6.length)]);
		r2.setBounds(184, 180, 130, 130);
		contentPane.add(r2);
		
		m1 = new JLabel("New label");
		m1.setIcon(dados12[new Random().nextInt(dados12.length)]);
		m1.setBounds(27, 355, 130, 130);
		contentPane.add(m1);
		
		
}
	//SETTER DE j1
	public void setJ1(Jugador j1) {
		this.j1 = j1;
		lblBienvenida.setText("Bienvenido "+j1.getNombre());
	}
}
