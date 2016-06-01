package Ventanas;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JTextPane;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import java.awt.Font;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class VentanaEmergente extends JFrame {

	private JPanel contentPane;
	private VentanaEmergente em;
	
	public VentanaEmergente(VentanaPostLogin v2, Registro r) {
		setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		setBounds(100, 100, 479, 173);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		GridBagLayout gbl_contentPane = new GridBagLayout();
		gbl_contentPane.columnWidths = new int[]{451, 0};
		gbl_contentPane.rowHeights = new int[]{0, 53, 41, 0};
		gbl_contentPane.columnWeights = new double[]{0.0, Double.MIN_VALUE};
		gbl_contentPane.rowWeights = new double[]{0.0, 0.0, 0.0, Double.MIN_VALUE};
		contentPane.setLayout(gbl_contentPane);
		
		JLabel lblElUsuarioIntroducido = new JLabel("El usuario introducido no esta registrado");
		lblElUsuarioIntroducido.setFont(new Font("Tahoma", Font.BOLD, 18));
		GridBagConstraints gbc_lblElUsuarioIntroducido = new GridBagConstraints();
		gbc_lblElUsuarioIntroducido.insets = new Insets(0, 0, 5, 0);
		gbc_lblElUsuarioIntroducido.gridx = 0;
		gbc_lblElUsuarioIntroducido.gridy = 0;
		contentPane.add(lblElUsuarioIntroducido, gbc_lblElUsuarioIntroducido);
		
		JLabel lblSeProcederA = new JLabel("Se proceder\u00E1 al registro");
		lblSeProcederA.setFont(new Font("Tahoma", Font.BOLD, 18));
		GridBagConstraints gbc_lblSeProcederA = new GridBagConstraints();
		gbc_lblSeProcederA.insets = new Insets(0, 0, 5, 0);
		gbc_lblSeProcederA.anchor = GridBagConstraints.NORTH;
		gbc_lblSeProcederA.gridx = 0;
		gbc_lblSeProcederA.gridy = 1;
		contentPane.add(lblSeProcederA, gbc_lblSeProcederA);
		
		em = this;
		
		JButton btnAceptar = new JButton("Aceptar");
		btnAceptar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				
				
				r.setVisible(true);
				em.dispose();
				
			}
		});
		btnAceptar.setFont(new Font("Tahoma", Font.BOLD, 18));
		GridBagConstraints gbc_btnAceptar = new GridBagConstraints();
		gbc_btnAceptar.fill = GridBagConstraints.BOTH;
		gbc_btnAceptar.gridx = 0;
		gbc_btnAceptar.gridy = 2;
		contentPane.add(btnAceptar, gbc_btnAceptar);
	}

}
