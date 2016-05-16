package Clases;

public class Jugador {
	
	private String nombre;
	private String Apellido1;
	private String Apellido2;
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
		return Apellido1;
	}
	public String getApellido2() {
		return Apellido2;
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
			this.Apellido1="Garcia";
		}else{
		this.Apellido1 = Apellido1;
		}
	}

	public void setApellido2(String Apellido2) {
		if (Apellido2.length()<2){
			System.out.println("Apellidos invalidos, asignando apellido genérico");
			this.Apellido2="Gómez";
		}else{
		this.Apellido2 = Apellido2;
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
		return this.id+"-"+this.nombre+" "+this.Apellido2;
	}
}