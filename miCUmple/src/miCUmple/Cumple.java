package miCUmple;

public class Cumple {

	private String nombre;
	private int edad;
	private int dia;
	private int mes;
	private int a�o;
	
	public String getNombre() {
		return nombre;
	}
	public int getEdad() {
		return edad;
	}
	public int getDia() {
		return dia;
	}
	public int getMes() {
		return mes;
	}
	public int getA�o() {
		return a�o;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public void setEdad(int edad) {
		this.edad = edad;
	}
	public void setDia(int dia) {
		if (dia>31){
			this.dia=31;
		}else if (dia<1) {
			this.dia=1;
		}else{
			this.dia=dia;
		}
	}
	public void setMes(int mes) {
		if (mes>12){
			this.mes=12;
		} else if (mes<1){
			this.mes=1;
		}else {
			this.mes = mes;
		}
	}
	public void setA�o(int a�o) {
		if (a�o<1940){
			this.a�o = 1940;
		}else if (a�o>2015){
			this.a�o=2015;
		}else {
			this.a�o=a�o;
		}
	}
	
}
