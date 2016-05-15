package Ventanas;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import Clases.Jugador;
import DDBB.ConexionDDBB;

import java.awt.GridBagLayout;
import javax.swing.JLabel;
import java.awt.GridBagConstraints;
import javax.swing.JComboBox;
import java.awt.Insets;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.awt.event.ActionEvent;
import javax.swing.SwingConstants;

public class Login extends JFrame {

	private JPanel contentPane;
	private JComboBox comboBox;
	private Login l;
	private VentanaPostLogin v2;
	private Jugador j1;
	private ConexionDDBB con;
	
	public Login(VentanaPostLogin v2) {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 439, 229);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		GridBagLayout gbl_contentPane = new GridBagLayout();
		gbl_contentPane.columnWidths = new int[]{0, 0, 0};
		gbl_contentPane.rowHeights = new int[]{84, 0, 0, 0};
		gbl_contentPane.columnWeights = new double[]{0.0, 1.0, Double.MIN_VALUE};
		gbl_contentPane.rowWeights = new double[]{0.0, 0.0, 0.0, Double.MIN_VALUE};
		contentPane.setLayout(gbl_contentPane);
		
		JLabel lblUsuario = new JLabel("Usuario");
		GridBagConstraints gbc_lblUsuario = new GridBagConstraints();
		gbc_lblUsuario.insets = new Insets(0, 0, 5, 5);
		gbc_lblUsuario.anchor = GridBagConstraints.EAST;
		gbc_lblUsuario.gridx = 0;
		gbc_lblUsuario.gridy = 0;
		contentPane.add(lblUsuario, gbc_lblUsuario);
		
		comboBox = new JComboBox();
		GridBagConstraints gbc_comboBox = new GridBagConstraints();
		gbc_comboBox.insets = new Insets(0, 0, 5, 0);
		gbc_comboBox.fill = GridBagConstraints.HORIZONTAL;
		gbc_comboBox.gridx = 1;
		gbc_comboBox.gridy = 0;
		contentPane.add(comboBox, gbc_comboBox);
		
		//REFERENCIAMOS ESTA VENTANA
		l=this;
		
		JButton btnJugar = new JButton("Jugar");
		btnJugar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//CERRAMOS LA VENTANA LOGIN
				l.dispose();
				//HACEMOS EL SET DE J1 Y HACCEMOS VISIBLE LA VENTANA DE JUEGO
				v2.setJ1((Jugador)comboBox.getSelectedItem());
				v2.setVisible(true);
				
				//CERRAMOS LA CONEXIÓN A LA BBDD
				try {
					if(ConexionDDBB.conexion!=null){
						ConexionDDBB.conexion.close();
						System.out.println("Desconectado de la bbdd");
					}
				} catch (SQLException z) {
					System.out.println(z);
				}
				//EN CASO DE QUE FALLE LA DESCONEXION SE VUELVE A INTENTAR 1 VEZ MAS
				try{
					if(ConexionDDBB.conexion!=null){
						ConexionDDBB.conexion.close();
						}
					} catch (SQLException a) {
					System.out.println(a);
			}
			}
		});
		GridBagConstraints gbc_btnJugar = new GridBagConstraints();
		gbc_btnJugar.anchor = GridBagConstraints.SOUTH;
		gbc_btnJugar.weighty = 1.0;
		gbc_btnJugar.insets = new Insets(0, 0, 5, 0);
		gbc_btnJugar.fill = GridBagConstraints.HORIZONTAL;
		gbc_btnJugar.gridwidth = 2;
		gbc_btnJugar.gridx = 0;
		gbc_btnJugar.gridy = 1;
		contentPane.add(btnJugar, gbc_btnJugar);
		
		JButton btnReg = new JButton("Registrar nuevo usuario");
		btnReg.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				//CERRAMOS LA VENTANA DE LOGIN Y ABRIMOS LA DE REGISTRO
				l.dispose();
				Registro r = new Registro(v2);
				r.setVisible(true);
			}
		});
		GridBagConstraints gbc_btnReg = new GridBagConstraints();
		gbc_btnReg.anchor = GridBagConstraints.SOUTH;
		gbc_btnReg.fill = GridBagConstraints.HORIZONTAL;
		gbc_btnReg.gridwidth = 2;
		gbc_btnReg.gridx = 0;
		gbc_btnReg.gridy = 2;
		contentPane.add(btnReg, gbc_btnReg);
		
		//NOS CONECTAMOS A LA BBDD PARA RECOGER A LOS USUARIOS YA REGISTRADOS
		con = new ConexionDDBB("localhost","java","root","1234");
		ConexionDDBB.getUsuarios(comboBox);
	}

}
