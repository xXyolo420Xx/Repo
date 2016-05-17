package DDBB;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JComboBox;
import javax.swing.JTextField;
import Ventanas.Registro;
import Clases.Jugador;
public class ConexionDDBB {

		//DRIVER
		static final String sqlDriver = "com.mysql.jdbc.Driver";
		
		private Registro r;
		
		private String host, bbdd, user, pass, url;
		public static Connection conexion;

		public ConexionDDBB(String HOST, String BBDD, String USER, String PASS){
			host = HOST;
			bbdd = BBDD;
			user = USER;
			pass = PASS;
			url = "jdbc:mysql://"+host+"/"+bbdd;
			
			conectar();
		
	}
		//METODO PARA CONECTAR A LA BBDD
		private void conectar(){
			try {
				//CARGA DRIVER
				Class.forName(sqlDriver);
				//CONECTARNOS A LA BBDD
				conexion = DriverManager.getConnection(url,user,pass);
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
		
		//METODO PARA REGISTRAR NUEVOS USUARIOS
		public static void insertar(String nombre, String apellido1, String apellido2, int edad){
			
			try {
				conexion.createStatement().executeUpdate("INSERT INTO usuarios (Nombre, Apellido1, Apellido2, Edad) VALUES ('"+nombre+"', '"+apellido1+"', '"+apellido2+"', "+edad+")");
				System.out.println("Usuario registrado con éxito");
			} catch (SQLException e) {
				e.printStackTrace();
				System.out.println("Error en el registro");
			}
			//CERRAMOS LA CONEXIÓN A LA BBDD
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
		
			//METODO PARA COGER LOS USUARIOS DE LA BBDD
		public static void getUsuarios(JComboBox jc){
			try {
				ResultSet c = conexion.createStatement().executeQuery("SELECT * FROM usuarios");
				while (c.next()){
				Jugador j1 = new Jugador();
				j1.setId(c.getInt("ID"));
				j1.setNombre(c.getString("Nombre"));
				j1.setApellido1(c.getString("Apellido1"));
				j1.setApellido2(c.getString("Apellido2"));
				j1.setEdad(c.getInt("Edad"));
				jc.addItem(j1);
				}
			} catch (SQLException e) {
			
				e.printStackTrace();
			}	
			
		}
		//CERRAMOS LA CONEXIÓN A LA BBDD
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

