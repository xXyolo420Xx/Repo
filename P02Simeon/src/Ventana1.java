import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Ventana1 extends JFrame {

	private JPanel contentPane;
	private JTextField txtNombre;
	private JTextField txtApellidos;
	private JTextField txtEdad;
	private JLabel lblDatosNuevoJugador;
	private JTextField txtRes;

	//DEFINICION DE LA VENTANA
	public Ventana1() {
		//PROPIEDADES GENERALES VENTANA
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
		
		JLabel lblApellidos = new JLabel("Apellidos");
		lblApellidos.setBounds(10, 86, 86, 14);
		contentPane.add(lblApellidos);
		
		JLabel lblEdad = new JLabel("Edad");
		lblEdad.setBounds(10, 111, 46, 14);
		contentPane.add(lblEdad);
		
		lblDatosNuevoJugador = new JLabel("DATOS NUEVO JUGADOR");
		lblDatosNuevoJugador.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblDatosNuevoJugador.setBounds(121, 11, 192, 14);
		contentPane.add(lblDatosNuevoJugador);
		
		//TEXTFIELDS
		txtNombre = new JTextField();
		txtNombre.setBounds(106, 55, 118, 20);
		contentPane.add(txtNombre);
		txtNombre.setColumns(10);
		
		txtApellidos = new JTextField();
		txtApellidos.setColumns(10);
		txtApellidos.setBounds(106, 83, 244, 20);
		contentPane.add(txtApellidos);
		
		txtEdad = new JTextField();
		txtEdad.setColumns(10);
		txtEdad.setBounds(106, 108, 46, 20);
		contentPane.add(txtEdad);
		
		txtRes = new JTextField();
		txtRes.setEditable(false);
		txtRes.setBounds(73, 205, 288, 45);
		contentPane.add(txtRes);
		txtRes.setColumns(10);
		
		//BOTON
		JButton btnCrear = new JButton("Crear jugador");
		btnCrear.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				//COMPROBAMOS QUE TODOS LOS CAMPOS ESTEN RELLENADOS
				//CREAMOS 3 STRINGS PARA COMPROBAR SI SU LENGTH ES 0
				//HACEMOS ESTO EN VEZ DE UTILIZAR LOS GETTERS DE LA CLASE JUGADOR PORQUE LOS INTEGERS (EDAD) NO TIENEN LONGITUD
				//ADEMAS DE PORQUE ASIGNAMOS NOMBRES GENERICOS EN CASO DE EQUIVOCACION AL ESCRIBIR
				
				String lNom = txtNombre.getText();
				String lApe = txtApellidos.getText();
				String lEdad = txtEdad.getText();
				
				if (lNom.length()==0 || lApe.length()==0 || lEdad.length()==0){
					txtRes.setText("Falta algun campo por rellenar");
				}else{
				
				//SI TODOS LOS CAMPOS ESTAN RELLENOS CREAMOS EL JUGADOR AL PULSAR EL BOTÓN
				Jugador j1 = new Jugador();
								
				//DEFINIMOS SUS CARACTERISTICAS
				j1.setNombre(txtNombre.getText());
				j1.setApellidos(txtApellidos.getText());
				//PASAMOS EDAD A INTEGER
				String sEdad= txtEdad.getText();
				int intEdad = Integer.valueOf(sEdad);
				j1.setEdad(intEdad);
								
				//PASAMOS LAS CARACTERISTICAS A LA CAJA DE RESULTADO
				txtRes.setText("Creado el personaje "+j1.getNombre()+" "+j1.getApellidos()+" de "+j1.getEdad()+" años.");
				}
			}
		});
		btnCrear.setBounds(152, 159, 141, 23);
		contentPane.add(btnCrear);
		
	}

}
