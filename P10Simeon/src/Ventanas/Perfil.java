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
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import java.awt.Component;
import javax.swing.Box;
import java.awt.Dimension;

public class Perfil extends JPanel {
	
	JTextField txtNombre, txt2Apellido, txt1Apellido, txtEdad;
	static JTextField txtPuntos;
	private Jugador j1;
	private JTextField txtRes;
	public Perfil() {
		
		ImageIcon avatar = new ImageIcon(getClass().getResource("/Ventanas/Azul/worm.jpg"));
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[]{300, 401, 0, 0, 0, 0};
		gridBagLayout.rowHeights = new int[]{0, 20, 30, 0, 20, 30, 0, 20, 30, 0, 20, 30, 0, 20, 30, 0, 31, 0};
		gridBagLayout.columnWeights = new double[]{0.0, 0.0, 0.0, 1.0, 0.0, Double.MIN_VALUE};
		gridBagLayout.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		setLayout(gridBagLayout);
		
		Component rigidArea_2 = Box.createRigidArea(new Dimension(20, 20));
		GridBagConstraints gbc_rigidArea_2 = new GridBagConstraints();
		gbc_rigidArea_2.insets = new Insets(0, 0, 5, 5);
		gbc_rigidArea_2.gridx = 1;
		gbc_rigidArea_2.gridy = 0;
		add(rigidArea_2, gbc_rigidArea_2);
		
		//ETIQUETAS
		JLabel lblNombre = new JLabel("Nombre");
		GridBagConstraints gbc_lblNombre = new GridBagConstraints();
		gbc_lblNombre.anchor = GridBagConstraints.SOUTH;
		gbc_lblNombre.insets = new Insets(0, 0, 5, 5);
		gbc_lblNombre.gridx = 1;
		gbc_lblNombre.gridy = 1;
		add(lblNombre, gbc_lblNombre);
		
		txtNombre = new JTextField();
		GridBagConstraints gbc_txtNombre = new GridBagConstraints();
		gbc_txtNombre.anchor = GridBagConstraints.NORTH;
		gbc_txtNombre.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtNombre.insets = new Insets(0, 0, 5, 5);
		gbc_txtNombre.gridx = 1;
		gbc_txtNombre.gridy = 2;
		add(txtNombre, gbc_txtNombre);
		txtNombre.setColumns(10);
		
		txtRes = new JTextField();
		txtRes.setEditable(false);
		GridBagConstraints gbc_txtRes = new GridBagConstraints();
		gbc_txtRes.gridheight = 3;
		gbc_txtRes.fill = GridBagConstraints.BOTH;
		gbc_txtRes.insets = new Insets(0, 0, 5, 5);
		gbc_txtRes.gridx = 3;
		gbc_txtRes.gridy = 2;
		add(txtRes, gbc_txtRes);
		txtRes.setColumns(10);
		
		JLabel lblNewLabel = new JLabel("");
		GridBagConstraints gbc_lblNewLabel = new GridBagConstraints();
		gbc_lblNewLabel.anchor = GridBagConstraints.NORTH;
		gbc_lblNewLabel.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel.gridheight = 6;
		gbc_lblNewLabel.gridx = 0;
		gbc_lblNewLabel.gridy = 3;
		add(lblNewLabel, gbc_lblNewLabel);
		lblNewLabel.setIcon(avatar);
		
		Component rigidArea_4 = Box.createRigidArea(new Dimension(20, 20));
		GridBagConstraints gbc_rigidArea_4 = new GridBagConstraints();
		gbc_rigidArea_4.insets = new Insets(0, 0, 5, 5);
		gbc_rigidArea_4.gridx = 1;
		gbc_rigidArea_4.gridy = 3;
		add(rigidArea_4, gbc_rigidArea_4);
		
		JLabel lbl1Apellido = new JLabel("1r Apellido");
		GridBagConstraints gbc_lbl1Apellido = new GridBagConstraints();
		gbc_lbl1Apellido.anchor = GridBagConstraints.SOUTH;
		gbc_lbl1Apellido.insets = new Insets(0, 0, 5, 5);
		gbc_lbl1Apellido.gridx = 1;
		gbc_lbl1Apellido.gridy = 4;
		add(lbl1Apellido, gbc_lbl1Apellido);
		
		Component rigidArea = Box.createRigidArea(new Dimension(20, 20));
		GridBagConstraints gbc_rigidArea = new GridBagConstraints();
		gbc_rigidArea.gridheight = 16;
		gbc_rigidArea.insets = new Insets(0, 0, 0, 5);
		gbc_rigidArea.gridx = 2;
		gbc_rigidArea.gridy = 1;
		add(rigidArea, gbc_rigidArea);
		
		Component rigidArea_1 = Box.createRigidArea(new Dimension(20, 20));
		GridBagConstraints gbc_rigidArea_1 = new GridBagConstraints();
		gbc_rigidArea_1.gridheight = 16;
		gbc_rigidArea_1.gridx = 4;
		gbc_rigidArea_1.gridy = 1;
		add(rigidArea_1, gbc_rigidArea_1);
		
		txt1Apellido = new JTextField();
		txt1Apellido.setColumns(10);
		GridBagConstraints gbc_txt1Apellido = new GridBagConstraints();
		gbc_txt1Apellido.anchor = GridBagConstraints.NORTH;
		gbc_txt1Apellido.fill = GridBagConstraints.HORIZONTAL;
		gbc_txt1Apellido.insets = new Insets(0, 0, 5, 5);
		gbc_txt1Apellido.gridx = 1;
		gbc_txt1Apellido.gridy = 5;
		add(txt1Apellido, gbc_txt1Apellido);
		
		Component rigidArea_5 = Box.createRigidArea(new Dimension(20, 20));
		GridBagConstraints gbc_rigidArea_5 = new GridBagConstraints();
		gbc_rigidArea_5.insets = new Insets(0, 0, 5, 5);
		gbc_rigidArea_5.gridx = 1;
		gbc_rigidArea_5.gridy = 6;
		add(rigidArea_5, gbc_rigidArea_5);
		
		JLabel lbl2Apellido = new JLabel("2\u00BA Apellido");
		GridBagConstraints gbc_lbl2Apellido = new GridBagConstraints();
		gbc_lbl2Apellido.anchor = GridBagConstraints.SOUTH;
		gbc_lbl2Apellido.insets = new Insets(0, 0, 5, 5);
		gbc_lbl2Apellido.gridx = 1;
		gbc_lbl2Apellido.gridy = 7;
		add(lbl2Apellido, gbc_lbl2Apellido);
		
		txt2Apellido = new JTextField();
		txt2Apellido.setColumns(10);
		GridBagConstraints gbc_txt2Apellido = new GridBagConstraints();
		gbc_txt2Apellido.anchor = GridBagConstraints.NORTH;
		gbc_txt2Apellido.fill = GridBagConstraints.HORIZONTAL;
		gbc_txt2Apellido.insets = new Insets(0, 0, 5, 5);
		gbc_txt2Apellido.gridx = 1;
		gbc_txt2Apellido.gridy = 8;
		add(txt2Apellido, gbc_txt2Apellido);
		
		Component rigidArea_6 = Box.createRigidArea(new Dimension(20, 20));
		GridBagConstraints gbc_rigidArea_6 = new GridBagConstraints();
		gbc_rigidArea_6.insets = new Insets(0, 0, 5, 5);
		gbc_rigidArea_6.gridx = 1;
		gbc_rigidArea_6.gridy = 9;
		add(rigidArea_6, gbc_rigidArea_6);
		
		JLabel lblEdad = new JLabel("Edad");
		GridBagConstraints gbc_lblEdad = new GridBagConstraints();
		gbc_lblEdad.insets = new Insets(0, 0, 5, 5);
		gbc_lblEdad.gridx = 1;
		gbc_lblEdad.gridy = 10;
		add(lblEdad, gbc_lblEdad);
		
		txtEdad = new JTextField();
		txtEdad.setColumns(10);
		GridBagConstraints gbc_txtEdad = new GridBagConstraints();
		gbc_txtEdad.anchor = GridBagConstraints.NORTH;
		gbc_txtEdad.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtEdad.insets = new Insets(0, 0, 5, 5);
		gbc_txtEdad.gridx = 1;
		gbc_txtEdad.gridy = 11;
		add(txtEdad, gbc_txtEdad);
		
		Component rigidArea_7 = Box.createRigidArea(new Dimension(20, 20));
		GridBagConstraints gbc_rigidArea_7 = new GridBagConstraints();
		gbc_rigidArea_7.insets = new Insets(0, 0, 5, 5);
		gbc_rigidArea_7.gridx = 1;
		gbc_rigidArea_7.gridy = 12;
		add(rigidArea_7, gbc_rigidArea_7);
		
		JLabel lblPuntos = new JLabel("Puntos");
		GridBagConstraints gbc_lblPuntos = new GridBagConstraints();
		gbc_lblPuntos.insets = new Insets(0, 0, 5, 5);
		gbc_lblPuntos.gridx = 1;
		gbc_lblPuntos.gridy = 13;
		add(lblPuntos, gbc_lblPuntos);
		
		txtPuntos = new JTextField();
		txtPuntos.setEditable(false);
		txtPuntos.setColumns(10);
		GridBagConstraints gbc_txtPuntos = new GridBagConstraints();
		gbc_txtPuntos.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtPuntos.insets = new Insets(0, 0, 5, 5);
		gbc_txtPuntos.gridx = 1;
		gbc_txtPuntos.gridy = 14;
		add(txtPuntos, gbc_txtPuntos);
		
		JButton btnAct = new JButton("Actualizar datos");
		btnAct.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				ConexionDDBB.actPerfil(txt1Apellido.getText(), txt1Apellido.getText(), txt2Apellido.getText(), Integer.valueOf(txtEdad.getText()), Integer.valueOf(j1.getId()));
				txtRes.setText("Perfil Actualizado con éxito");
			}
		});
		
		Component rigidArea_3 = Box.createRigidArea(new Dimension(20, 20));
		GridBagConstraints gbc_rigidArea_3 = new GridBagConstraints();
		gbc_rigidArea_3.insets = new Insets(0, 0, 5, 5);
		gbc_rigidArea_3.gridx = 1;
		gbc_rigidArea_3.gridy = 15;
		add(rigidArea_3, gbc_rigidArea_3);
		GridBagConstraints gbc_btnAct = new GridBagConstraints();
		gbc_btnAct.anchor = GridBagConstraints.WEST;
		gbc_btnAct.insets = new Insets(0, 0, 0, 5);
		gbc_btnAct.gridx = 1;
		gbc_btnAct.gridy = 16;
		add(btnAct, gbc_btnAct);		
	}
	
	//SETTER DE j1
	public void setJ1(Jugador j1) {
	this.j1 = j1;
	}
	
	//METODO PARA ACTUALIZAR PUNTOS EN PANTALLA DE PERFIL
	public static void addPts(int lol){
		txtPuntos.setText(String.valueOf(lol));
	}

}
