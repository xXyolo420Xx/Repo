package Ventanas;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;

import Clases.Jugador;
import DDBB.ConexionDDBB;

public class AWS extends JPanel {


	JComboBox comboBox;
	
	public AWS(VentanaPostLogin v2, Login l) {
		
	GridBagLayout gbl_contentPane = new GridBagLayout();
	gbl_contentPane.columnWidths = new int[]{0, 0, 0};
	gbl_contentPane.rowHeights = new int[]{84, 0, 0, 0};
	gbl_contentPane.columnWeights = new double[]{0.0, 1.0, Double.MIN_VALUE};
	gbl_contentPane.rowWeights = new double[]{0.0, 0.0, 0.0, Double.MIN_VALUE};
	setLayout(gbl_contentPane);
		
	JLabel lblUsuario = new JLabel("Usuario");
	GridBagConstraints gbc_lblUsuario = new GridBagConstraints();
	gbc_lblUsuario.insets = new Insets(0, 0, 5, 5);
	gbc_lblUsuario.anchor = GridBagConstraints.EAST;
	gbc_lblUsuario.gridx = 0;
	gbc_lblUsuario.gridy = 0;
	add(lblUsuario, gbc_lblUsuario);
	
	comboBox = new JComboBox();
	GridBagConstraints gbc_comboBox = new GridBagConstraints();
	gbc_comboBox.anchor = GridBagConstraints.WEST;
	gbc_comboBox.insets = new Insets(0, 0, 5, 0);
	gbc_comboBox.gridx = 1;
	gbc_comboBox.gridy = 0;
	add(comboBox, gbc_comboBox);
	
	
	JButton btnJugar = new JButton("Jugar");
	btnJugar.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent e) {
			try{
			//CERRAMOS LA VENTANA LOGIN
			l.dispose();
			//HACEMOS EL SET DE J1 Y HACCEMOS VISIBLE LA VENTANA DE JUEGO
			v2.setJ1((Jugador)comboBox.getSelectedItem());
			v2.setVisible(true);
			}catch (Exception blow){
				System.out.println(blow);
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
	add(btnJugar, gbc_btnJugar);
	
	JButton btnReg = new JButton("Registrar nuevo usuario");
	btnReg.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent arg0) {
			try{
			//CERRAMOS LA VENTANA DE LOGIN Y ABRIMOS LA DE REGISTRO
			l.dispose();
			Registro r = new Registro(v2);
			r.setVisible(true);
			}catch (Exception blaw){
				System.out.println(blaw);
			}
			}
	});
	GridBagConstraints gbc_btnReg = new GridBagConstraints();
	gbc_btnReg.anchor = GridBagConstraints.SOUTH;
	gbc_btnReg.fill = GridBagConstraints.HORIZONTAL;
	gbc_btnReg.gridwidth = 2;
	gbc_btnReg.gridx = 0;
	gbc_btnReg.gridy = 2;
	add(btnReg, gbc_btnReg);
	
	//NOS CONECTAMOS A LA BBDD PARA RECOGER A LOS USUARIOS YA REGISTRADOS
	ConexionDDBB.getConexion();
	ConexionDDBB.getUsuarios(comboBox);
	}

}
