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
		
		private Registro r;
		
		private String host, bbdd, user, pass, url;

		private static Jugador j1;
		private static Connection conexion;
		private static ConexionDDBB con;
		private VentanaPostLogin v2;
		public ConexionDDBB(){	
			try {
				//CARGA DRIVER
				Class.forName(sqlDriver);
				//CONECTARNOS A LA BBDD
				conexion = DriverManager.getConnection("jdbc:mysql://localhost/java","root","1234");
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
				conexion.createStatement().executeUpdate("INSERT INTO usuarios (Nombre, Apellido1, Apellido2, Edad, Puntos) VALUES ('"+nombre+"', '"+apellido1+"', '"+apellido2+"', "+edad+", 0)");
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
		
		//METODO DESCONEXION DE LA BBDD
		public static void desconectar(){
		try {
	
			if(ConexionDDBB.conexion!=null){
				ConexionDDBB.conexion.close();
				System.out.println("Desconectado de la bbdd");
			}
		} catch (SQLException z) {
			System.out.println(z);
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


