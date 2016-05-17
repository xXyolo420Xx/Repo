package Ventanas;

import javax.swing.JPanel;
import javax.swing.JTextField;

import Clases.Jugador;
import DDBB.ConexionDDBB;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.awt.event.ActionEvent;

public class Perfil extends JPanel {
	
	JTextField txtNombre, txt2Apellido, txt1Apellido, txtEdad, txtPuntos;
	Jugador j1;
	public Perfil() {
		setLayout(null);
		
		ImageIcon avatar = new ImageIcon(getClass().getResource("/Ventanas/Azul/worm.jpg"));
		
		JLabel lblNewLabel = new JLabel("New label");
		lblNewLabel.setBounds(67, 49, 128, 128);
		add(lblNewLabel);
		lblNewLabel.setIcon(avatar);

		txtNombre = new JTextField();
		txtNombre.setBounds(382, 83, 118, 20);
		add(txtNombre);
		txtNombre.setColumns(10);
				
		txt1Apellido = new JTextField();
		txt1Apellido.setColumns(10);
		txt1Apellido.setBounds(382, 171, 159, 20);
		add(txt1Apellido);
		
		txt2Apellido = new JTextField();
		txt2Apellido.setColumns(10);
		txt2Apellido.setBounds(382, 253, 244, 20);
		add(txt2Apellido);
		
		txtEdad = new JTextField();
		txtEdad.setColumns(10);
		txtEdad.setBounds(382, 326, 46, 20);
		add(txtEdad);
		
		txtPuntos = new JTextField();
		txtPuntos.setEditable(false);
		txtPuntos.setColumns(10);
		txtPuntos.setBounds(382, 376, 46, 20);
		add(txtPuntos);
		
		//ETIQUETAS
		JLabel lblNombre = new JLabel("Nombre");
		lblNombre.setBounds(298, 86, 74, 14);
		add(lblNombre);
		
		JLabel lbl1Apellido = new JLabel("1r Apellido");
		lbl1Apellido.setBounds(298, 174, 72, 14);
		add(lbl1Apellido);
		
		JLabel lblEdad = new JLabel("Edad");
		lblEdad.setBounds(298, 329, 46, 14);
		add(lblEdad);
		
		JLabel lbl2Apellido = new JLabel("2\u00BA Apellido");
		lbl2Apellido.setBounds(298, 256, 72, 14);
		add(lbl2Apellido);
		
		JLabel lblPuntos = new JLabel("Puntos");
		lblPuntos.setBounds(298, 379, 46, 14);
		add(lblPuntos);
		
		JButton btnAct = new JButton("Actualizar datos");
		btnAct.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try {
					ConexionDDBB.getConexion().createStatement().executeUpdate("UPDATE usuarios SET Nombre = '"+txtNombre.getText()+
							"', Apellido1 = '"+txt1Apellido.getText()+
							"', Apellido2 = '"+txt2Apellido.getText()+
							"', Edad = "+txtEdad.getText()+
							" WHERE ID = "+j1.getId());
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		});
		btnAct.setBounds(715, 82, 147, 33);
		add(btnAct);		
	}
	
	//SETTER DE j1
	public void setJ1(Jugador j1) {
	this.j1 = j1;
	}
}
