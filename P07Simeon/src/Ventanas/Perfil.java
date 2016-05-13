package Ventanas;

import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.ImageIcon;
import javax.swing.JLabel;

public class Perfil extends JPanel {
	
	JTextField txtNombre, txt2Apellido, txt1Apellido, txtEdad;

	public Perfil() {
		setLayout(null);
		
		ImageIcon avatar = new ImageIcon(getClass().getResource("/Ventanas/Azul/worm.jpg"));
		
		
		JLabel lblNewLabel = new JLabel("New label");
		lblNewLabel.setBounds(67, 49, 128, 128);
		add(lblNewLabel);
		lblNewLabel.setIcon(avatar);

		txtNombre = new JTextField();
		txtNombre.setEditable(false);
		txtNombre.setBounds(382, 83, 118, 20);
		add(txtNombre);
		txtNombre.setColumns(10);
		
		
		txt1Apellido = new JTextField();
		txt1Apellido.setEditable(false);
		txt1Apellido.setColumns(10);
		txt1Apellido.setBounds(382, 171, 159, 20);
		add(txt1Apellido);
		
		txt2Apellido = new JTextField();
		txt2Apellido.setEditable(false);
		txt2Apellido.setColumns(10);
		txt2Apellido.setBounds(382, 253, 244, 20);
		add(txt2Apellido);
		
		txtEdad = new JTextField();
		txtEdad.setEditable(false);
		txtEdad.setColumns(10);
		txtEdad.setBounds(382, 326, 46, 20);
		add(txtEdad);
		
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
		
	}

}
