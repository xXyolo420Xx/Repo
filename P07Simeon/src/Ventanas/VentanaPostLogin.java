package Ventanas;

import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import Clases.Jugador;

import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class VentanaPostLogin extends JFrame {
	
	private JPanel contentPane;

	Juego jueg = new Juego();
	Perfil perf = new Perfil();
	private Jugador j1;	
	final static String JUEGO = "Juego";
	final static String PERFIL = "Perfil";
	private final JMenuBar menuBar = new JMenuBar();
	private final JMenu mnVentanas = new JMenu("Ventanas");
	private final JMenuItem mntmJuego = new JMenuItem("Juego");
	private final JMenuItem mntmPerfil = new JMenuItem("Perfil");
	
	public VentanaPostLogin() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 997, 578);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new CardLayout(0, 0));
	
		contentPane.add(jueg,JUEGO);
		contentPane.add(perf,PERFIL);
		
		//MENU
		setJMenuBar(menuBar);
		menuBar.add(mnVentanas);
		
		mnVentanas.add(mntmJuego);
		mntmJuego.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			    CardLayout cl = (CardLayout)(contentPane.getLayout());
			    cl.show(contentPane, JUEGO);
			}
		});
		mnVentanas.add(mntmPerfil);
		mntmPerfil.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			    CardLayout cl = (CardLayout)(contentPane.getLayout());
			    cl.show(contentPane, PERFIL);
			}
		});		
	}
	//SETTER DE j1
	public void setJ1(Jugador j1) {
	this.j1 = j1;
	jueg.lblBienvenida.setText("Bienvenido "+j1.getNombre());
	perf.txtNombre.setText(j1.getNombre());
	perf.txt1Apellido.setText(j1.get1Apellido());
	perf.txt2Apellido.setText(j1.get2Apellido());
	perf.txtEdad.setText(String.valueOf(j1.getEdad()));
	}	
}
