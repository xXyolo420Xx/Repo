package DDBB;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JComboBox;
import javax.swing.JTextField;
import Ventanas.Registro;
import Ventanas.VentanaPostLogin;
import Clases.Jugador;
public class ConexionDDBB {

		//DRIVER
		static final String sqlDriver = "com.mysql.jdbc.Driver";
		
		private static Connection conexion;
		private static ConexionDDBB con;

		public ConexionDDBB(){	
			try {
				//CARGA DRIVER
				Class.forName(sqlDriver);
				//CONECTARNOS A LA BBDD
				conexion = DriverManager.getConnection("jdbc:mysql://localhost/examen","root","");
				System.out.println("Conectado con éxito");
			}
			catch( SQLException excepcionSql ) 
			{
				System.out.println("Error en la conexión");
				System.out.println(excepcionSql);
			}
			 catch (ClassNotFoundException e) {
				System.out.println("Error en la conexión");
				System.out.println(e);
			}
		}
		
		public static Connection getConexion(){
			if(conexion==null){
				con = new ConexionDDBB();
			}
			return conexion;
		}
		
		//METODO PARA REGISTRAR NUEVOS USUARIOS
		public static Jugador insertar(String nombre, String apellido1, String apellido2, int edad){
			
			try {
				getConexion().createStatement().executeUpdate("INSERT INTO usuarios (Nombre, Apellido1, Apellido2, Edad, Puntos) VALUES ('"+nombre+"', '"+apellido1+"', '"+apellido2+"', "+edad+", 0)");
				System.out.println("Usuario registrado con éxito");
			} catch (SQLException e) {
				e.printStackTrace();
				System.out.println("Error en el registro");
			}
				Jugador j1 = new Jugador();
				j1.setNombre(nombre);
				j1.setApellido1(apellido1);
				j1.setApellido2(apellido2);
				j1.setEdad(edad);
				try{
				ResultSet c = getConexion().createStatement().executeQuery("SELECT ID FROM usuarios WHERE Nombre = '"+nombre+"'");
				while (c.next()){
				j1.setId(c.getInt("ID"));
				}
				} catch (SQLException e) {
					e.printStackTrace();
				}		return (Jugador)j1;
			}
		
			//METODO PARA COGER LOS USUARIOS DE LA BBDD
		public static void getUsuarios(JComboBox jc){
			try {
				ResultSet c = getConexion().createStatement().executeQuery("SELECT * FROM usuarios");
				while (c.next()){
				Jugador j1 = new Jugador();
				j1.setId(c.getInt("ID"));
				j1.setNombre(c.getString("Nombre"));
				j1.setApellido1(c.getString("Apellido1"));
				j1.setApellido2(c.getString("Apellido2"));
				j1.setEdad(c.getInt("Edad"));
				j1.setPuntos(c.getInt("Puntos"));
				jc.addItem(j1);
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}			
		}		
		
		public static void masPts(int puntos, int id) {
			try {
				getConexion().createStatement().executeUpdate("UPDATE usuarios SET Puntos = "+(puntos+5)+" WHERE ID = "+id);
			} catch (SQLException e) {
				System.out.println(e);;
			}
		}
		
		public static void actPerfil(String nombre, String apellido1, String apellido2, int edad, int id){
			try {
				getConexion().createStatement().executeUpdate("UPDATE usuarios SET Nombre = '"+nombre+
						"', Apellido1 = '"+apellido1+
						"', Apellido2 = '"+apellido2+
						"', Edad = "+edad+
						" WHERE ID = "+id);
			} catch (SQLException e) {
				System.out.println(e);
			}
		}
	}


