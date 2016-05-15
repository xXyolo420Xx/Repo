package Ventanas;
import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import Clases.Jugador;
import DDBB.ConexionDDBB;

import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.awt.event.ActionEvent;

public class Registro extends JFrame {

	private JPanel contentPane;
	private JTextField txtNombre, txt2Apellido, txt1Apellido, txtEdad;
	private JLabel lblDatosNuevoJugador;
	private JTextField txtRes;
	//PASAMOS REFERENCIAS DE AMBAS VENTANAS
	private Registro v1;
	private VentanaPostLogin v2;
	//REFERENCIA DE LA CONEXION
	private ConexionDDBB con;
	
	//DEFINICION DE LA VENTANA
	public Registro(VentanaPostLogin v2) {
	
		//PROPIEDADES GENERALES
		setTitle("Nuevo jugador");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		//ETIQUETAS
		JLabel lblNombre = new JLabel("Nombre");
		lblNombre.setBounds(10, 58, 46, 14);
		contentPane.add(lblNombre);
		
		JLabel lbl1Apellido = new JLabel("1r Apellido");
		lbl1Apellido.setBounds(10, 86, 72, 14);
		contentPane.add(lbl1Apellido);
		
		JLabel lblEdad = new JLabel("Edad");
		lblEdad.setBounds(10, 145, 46, 14);
		contentPane.add(lblEdad);
		
		JLabel lbl2Apellido = new JLabel("2\u00BA Apellido");
		lbl2Apellido.setBounds(10, 117, 72, 14);
		contentPane.add(lbl2Apellido);
		
		lblDatosNuevoJugador = new JLabel("DATOS NUEVO JUGADOR");
		lblDatosNuevoJugador.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblDatosNuevoJugador.setBounds(121, 11, 192, 14);
		contentPane.add(lblDatosNuevoJugador);
		
		//TEXTFIELDS
		txtNombre = new JTextField();
		txtNombre.setBounds(106, 55, 118, 20);
		contentPane.add(txtNombre);
		txtNombre.setColumns(10);
		
		txt1Apellido = new JTextField();
		txt1Apellido.setColumns(10);
		txt1Apellido.setBounds(106, 83, 244, 20);
		contentPane.add(txt1Apellido);
		
		txt2Apellido = new JTextField();
		txt2Apellido.setColumns(10);
		txt2Apellido.setBounds(106, 114, 244, 20);
		contentPane.add(txt2Apellido);
		
		txtEdad = new JTextField();
		txtEdad.setColumns(10);
		txtEdad.setBounds(106, 139, 46, 20);
		contentPane.add(txtEdad);
		
		txtRes = new JTextField();
		txtRes.setEditable(false);
		txtRes.setBounds(73, 205, 288, 45);
		contentPane.add(txtRes);
		txtRes.setColumns(10);
		
		//HACEMOS REFERENCIA A LA VENTANA DE LOGIN CON V1
		v1=this;
		
		//BOTON
		JButton btnCrear = new JButton("Jugar");
		btnCrear.setBounds(121, 171, 141, 23);
		contentPane.add(btnCrear);
		btnCrear.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				//COMPROBAMOS QUE TODOS LOS CAMPOS ESTEN RELLENADOS
				//CREAMOS 3 STRINGS PARA COMPROBAR SI SU LENGTH ES 0
				//HACEMOS ESTO EN VEZ DE UTILIZAR LOS GETTERS DE LA CLASE JUGADOR PORQUE LOS INTEGERS (EDAD) NO TIENEN LONGITUD
				//ADEMAS DE PORQUE ASIGNAMOS NOMBRES GENERICOS EN CASO DE EQUIVOCACION AL ESCRIBIR
		
					try {
				
				String lNom = txtNombre.getText();
				String lApe = txt1Apellido.getText();
				String lEdad = txtEdad.getText();
				
				if (lNom.length()==0 || lApe.length()==0 || lEdad.length()==0){
					txtRes.setText("Falta algun campo por rellenar");
				}else{
				
				//SI TODOS LOS CAMPOS ESTAN RELLENOS CREAMOS EL JUGADOR AL PULSAR EL BOTÓN
				Jugador j1 = new Jugador();
								
				//DEFINIMOS SUS CARACTERISTICAS
				j1.setNombre(txtNombre.getText());
				j1.set1Apellido(txt1Apellido.getText());
				j1.set2Apellido(txt2Apellido.getText());
				//PASAMOS EDAD A INTEGER
				String sEdad= txtEdad.getText();
				int intEdad = Integer.valueOf(sEdad);
				j1.setEdad(intEdad);
				
				//CONEXION A LA BBDD
				con = new ConexionDDBB("localhost", "java", "root", "1234");
				if (ConexionDDBB.conexion == null){
					txtRes.setText("Error en la conexion a la BBDD");
				}
			
				//AGREGAMOS EL NUEVO JUGADOR A LA BBDD
				ConexionDDBB.insertar(j1.getNombre(), j1.get1Apellido(), j1.get2Apellido(), j1.getEdad());
				
				//UNA VEZ HECHAS LAS REFERENCIAS CERRAMOS Login Y ABRIMOS LA VENTANA Juego
				v1.dispose();
				v2.setVisible(true);
				v2.setJ1(j1);
				}
			} catch (Exception asd){
				System.out.println("Error: " +asd);
			}finally{
				//DESCONECTAMOS DE LA BBDD
				try {
					if(ConexionDDBB.conexion!=null){
						ConexionDDBB.conexion.close();
						System.out.println("Desconectado de la bbdd");
					}
				} catch (SQLException e) {
					System.out.println(e);
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
		}
		});	
	}
}
