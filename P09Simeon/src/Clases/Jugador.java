package Clases;

public class Jugador {
	
	private String nombre;
	private String txt1Apellido;
	private String txt2Apellido;
	private int edad, id;

	public Jugador() {

	}

	
	//GETTERS
	public int getId() {
		return id;
	}
	
	public String getNombre() {
		return nombre;
	}

	public String get1Apellido() {
		return txt1Apellido;
	}
	public String get2Apellido() {
		return txt2Apellido;
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

	public void set1Apellido(String txt1Apellido) {
		if (txt1Apellido.length()<2){
			System.out.println("Apellidos invalidos, asignando apellido genérico");
			this.txt1Apellido="Garcia";
		}else{
		this.txt1Apellido = txt1Apellido;
		}
	}

	public void set2Apellido(String txt2Apellido) {
		if (txt2Apellido.length()<2){
			System.out.println("Apellidos invalidos, asignando apellido genérico");
			this.txt1Apellido="Gómez";
		}else{
		this.txt2Apellido = txt2Apellido;
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
		return this.id+"-"+this.nombre+" "+this.txt1Apellido;
	}
}
