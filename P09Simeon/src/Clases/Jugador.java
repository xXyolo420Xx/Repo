package Clases;

public class Jugador {
	
	private String nombre;
	private String apellido1;
	private String apellido2;
	private int edad, id, puntos;

	public Jugador() {

	}

	//GETTERS
	public int getId() {
		return id;
	}
	
	public String getNombre() {
		return nombre;
	}

	public String getApellido1() {
		return apellido1;
	}
	public String getApellido2() {
		return apellido2;
	}

	public int getEdad() {
		return edad;
	}
	
	//SETTERS	
	public void setId(int id) {
	this.id = id;
}
	public void setNombre(String nombre) {
		
		if (nombre.length()<2){
			System.out.println("Nombre invalidos, asignando nombre genérico");
			this.nombre = "Player";
		}else{
		this.nombre = nombre;
		}
	}

	public void setApellido1(String Apellido1) {
		if (Apellido1.length()<2){
			System.out.println("Apellidos invalidos, asignando apellido genérico");
			this.apellido1="Garcia";
		}else{
		this.apellido1 = Apellido1;
		}
	}

	public void setApellido2(String Apellido2) {
		if (Apellido2.length()<2){
			System.out.println("Apellidos invalidos, asignando apellido genérico");
			this.apellido2="Gómez";
		}else{
		this.apellido2 = Apellido2;
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
	
	public String toString(){
		return this.id+"-"+this.nombre+" "+this.apellido2;
	}
}