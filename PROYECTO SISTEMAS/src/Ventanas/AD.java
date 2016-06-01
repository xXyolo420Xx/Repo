package Ventanas;

import javax.swing.JPanel;
import java.awt.GridBagLayout;
import javax.swing.JLabel;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import javax.swing.JTextField;

import DDBB.ConexionDDBB;

import javax.swing.JPasswordField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.awt.event.ActionEvent;

public class AD extends JPanel {
	private JTextField txtUser;
	private JPasswordField txtPass;
	private JButton btnJugar;
	private JTextField txtCon;

	public AD(VentanaPostLogin v2, Login l) {
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[]{91, 245, 86, 0};
		gridBagLayout.rowHeights = new int[]{117, 28, 47, 88, 0};
		gridBagLayout.columnWeights = new double[]{0.0, 1.0, 0.0, Double.MIN_VALUE};
		gridBagLayout.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		setLayout(gridBagLayout);
		
		JLabel lblUser = new JLabel("Usuario");
		GridBagConstraints gbc_lblUser = new GridBagConstraints();
		gbc_lblUser.anchor = GridBagConstraints.SOUTHEAST;
		gbc_lblUser.insets = new Insets(0, 0, 5, 5);
		gbc_lblUser.gridx = 0;
		gbc_lblUser.gridy = 0;
		add(lblUser, gbc_lblUser);
		
		txtUser = new JTextField();
		GridBagConstraints gbc_txtUser = new GridBagConstraints();
		gbc_txtUser.anchor = GridBagConstraints.SOUTH;
		gbc_txtUser.insets = new Insets(0, 0, 5, 5);
		gbc_txtUser.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtUser.gridx = 1;
		gbc_txtUser.gridy = 0;
		add(txtUser, gbc_txtUser);
		txtUser.setColumns(10);
		
		JLabel lblPass = new JLabel("Contrase\u00F1a");
		GridBagConstraints gbc_lblPass = new GridBagConstraints();
		gbc_lblPass.anchor = GridBagConstraints.EAST;
		gbc_lblPass.insets = new Insets(0, 0, 5, 5);
		gbc_lblPass.gridx = 0;
		gbc_lblPass.gridy = 1;
		add(lblPass, gbc_lblPass);
		
		txtPass = new JPasswordField();
		GridBagConstraints gbc_txtPass = new GridBagConstraints();
		gbc_txtPass.insets = new Insets(0, 0, 5, 5);
		gbc_txtPass.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtPass.gridx = 1;
		gbc_txtPass.gridy = 1;
		add(txtPass, gbc_txtPass);
		
		btnJugar = new JButton("Jugar");
		btnJugar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				ConexionDDBB.conActiv(txtUser.getText(),String.valueOf(txtPass.getPassword()), txtCon);
		
					try {
						if (ConexionDDBB.checkUser(txtUser.getText()) == true){
							v2.setJ1(ConexionDDBB.getJ1(txtUser.getText()));
							l.dispose();
							v2.setVisible(true);
						}else{
							Registro r = new Registro(v2);
							r.txtNombre.setEditable(false);
							r.txtNombre.setText(txtUser.getText());
							VentanaEmergente v3 = new VentanaEmergente(v2, r);
							l.dispose();
							v3.setVisible(true);
						}

					} catch (SQLException e) {
						e.printStackTrace();
					}
				}
			});
		GridBagConstraints gbc_btnJugar = new GridBagConstraints();
		gbc_btnJugar.insets = new Insets(0, 0, 5, 5);
		gbc_btnJugar.fill = GridBagConstraints.HORIZONTAL;
		gbc_btnJugar.gridx = 1;
		gbc_btnJugar.gridy = 2;
		add(btnJugar, gbc_btnJugar);
		
		txtCon = new JTextField();
		txtCon.setEditable(false);
		GridBagConstraints gbc_txtCon = new GridBagConstraints();
		gbc_txtCon.gridwidth = 3;
		gbc_txtCon.insets = new Insets(0, 0, 0, 5);
		gbc_txtCon.fill = GridBagConstraints.BOTH;
		gbc_txtCon.gridx = 0;
		gbc_txtCon.gridy = 3;
		add(txtCon, gbc_txtCon);
		txtCon.setColumns(10);

	}

}
