package Clases;

public class Jugador {
	
	private String nombre;
	private String apellidos;
	private int edad;

	public Jugador() {

	}

	
	//GETTERS
	public String getNombre() {
		return nombre;
	}

	public String getApellidos() {
		return apellidos;
	}

	public int getEdad() {
		return edad;
	}

	
	//SETTERS
	public void setNombre(String nombre) {
		
		if (nombre.length()<2){
			System.out.println("Nombre invalidos, asignando nombre genérico");
			this.nombre = "Player";
		}else{
		this.nombre = nombre;
		}
	}

	public void setApellidos(String apellidos) {
		if (apellidos.length()<2){
			System.out.println("Apellidos invalidos, asignando apellido genérico");
			this.apellidos="Garcia";
		}else{
		this.apellidos = apellidos;
		}
	}

	public void setEdad(int edad) {
		if (edad<1){
			this.edad=10;
		}else if (edad>140){
			this.edad=140;
		}else
		this.edad = edad;
	}

}
