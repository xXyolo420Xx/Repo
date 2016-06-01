package Ventanas;

import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.EventQueue;
import java.awt.LayoutManager;

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
import javax.swing.SwingConstants;
import javax.swing.JSeparator;
import java.awt.Component;
import javax.swing.Box;
import javax.swing.JCheckBoxMenuItem;

public class VentanaPostLogin extends JFrame {
	
	JPanel contentPane;
	Jugador j1;
	final static String JUEGO = "Juego";
	final static String PERFIL = "Perfil";
	final static String CAMBIO = "Cambio Jugador";
	private Juego jueg;
	private Perfil perf;
	CambioJugador camb;
	VentanaPostLogin v2;
	private final JMenuBar menuBar = new JMenuBar();
	private final JMenu mnVentanas = new JMenu("Ventanas");
	private final JMenuItem mntmJuego = new JMenuItem("Juego");
	private final JMenuItem mntmPerfil = new JMenuItem("Perfil");
	
	public VentanaPostLogin() {
		
		v2=this;
		jueg = new Juego();
		camb = new CambioJugador(jueg, v2);
		perf = new Perfil(jueg, camb);
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 997, 578);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		contentPane.setLayout(new CardLayout(0, 0));
	
		contentPane.add(jueg,JUEGO);
		contentPane.add(perf,PERFIL);
		contentPane.add(camb,CAMBIO);
		setJMenuBar(menuBar);
		
		menuBar.add(mnVentanas);
		mntmJuego.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			    CardLayout cl = (CardLayout)(contentPane.getLayout());
			    cl.show(contentPane, JUEGO);
			}
		});
		
		mnVentanas.add(mntmJuego);
		mntmPerfil.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			    CardLayout cl = (CardLayout)(contentPane.getLayout());
			    cl.show(contentPane, PERFIL);
			}
		});
	
		mnVentanas.add(mntmPerfil);
		
		Component horizontalGlue = Box.createHorizontalGlue();
		menuBar.add(horizontalGlue);
		
		JMenu mnOperaciones = new JMenu("Operaciones");
		menuBar.add(mnOperaciones);
		
		JMenuItem mntmCambiarJugador = new JMenuItem("Cambiar jugador");
		mntmCambiarJugador.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
			    CardLayout cl = (CardLayout)(contentPane.getLayout());
			    cl.show(contentPane, CAMBIO);
				
			}
		});
		mnOperaciones.add(mntmCambiarJugador);
		
	}
	//SETTER DE j1
	public void setJ1(Jugador j1) {
	this.j1 = j1;
	jueg.lblBienvenida.setText("Bienvenido "+j1.getNombre());
	jueg.lblPuntos.setText("Tienes "+String.valueOf(j1.getPuntos())+" puntos.");
	perf.txtNombre.setText(j1.getNombre());
	perf.txt1Apellido.setText(j1.getApellido1());
	perf.txt2Apellido.setText(j1.getApellido2());
	perf.txtEdad.setText(String.valueOf(j1.getEdad()));
	Perfil.txtPuntos.setText(String.valueOf(j1.getPuntos()));
	perf.setJ1(j1);
	jueg.setJ1(j1);
	}
	
	public LayoutManager getLayout(){
		CardLayout cl = (CardLayout)(contentPane.getLayout());
		return cl;
	}
}