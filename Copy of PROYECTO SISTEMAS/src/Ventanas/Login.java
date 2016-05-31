package Ventanas;

import java.awt.BorderLayout;
import java.awt.CardLayout;
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
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;

public class Login extends JFrame {

	private JPanel contentPane;
	private JComboBox comboBox;
	private Login l;
	private AWS aws;
	final static String AWS = "Amazon Web Services";
	final static String AD = "Active Directory";
	
	public Login(VentanaPostLogin v2) {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 350, 281);
		
		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		
		JMenu mnOpciones = new JMenu("Opciones");
		menuBar.add(mnOpciones);
		
		JMenuItem mntmAmazonWebServices = new JMenuItem("Amazon Web Services");
		mntmAmazonWebServices.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				CardLayout c2 = (CardLayout)(contentPane.getLayout());
			    c2.show(contentPane, AWS);
			}
		});
		mnOpciones.add(mntmAmazonWebServices);
		
		JMenuItem mntmActiveDirectory = new JMenuItem("Active Directory");
		mntmActiveDirectory.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				CardLayout c2 = (CardLayout)(contentPane.getLayout());
			    c2.show(contentPane, AD);
			}
		});
		mnOpciones.add(mntmActiveDirectory);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new CardLayout(0, 0));
		
		l=this;
		
		AWS aws = new AWS(v2, l);
		AD ad = new AD(v2, l);
		
		contentPane.add(aws,AWS);
		contentPane.add(ad,AD);
	}

}
