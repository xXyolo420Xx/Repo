package DDBB;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import javax.swing.JTextField;

import Ventanas.Registro;

public class ConexionDDBB {

		//DRIVER
		static final String sqlDriver = "com.mysql.jdbc.Driver";
		
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
		
		public static void insertar(String nombre, String apellido1, String apellido2, int edad){
			
			try {
				conexion.createStatement().executeUpdate("INSERT INTO usuarios (Nombre, Apellido1, Apellido2, Edad) VALUES ('"+nombre+"', '"+apellido1+"', '"+apellido2+"', "+edad+")");
				System.out.println("Usuario registrado con éxito");
			} catch (SQLException e) {
				e.printStackTrace();
				System.out.println("Error en el registro");
			}
		}
			
		}

