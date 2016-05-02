package miCUmple;

public class Cumple {

	private String nombre;
	private int edad;
	private int dia;
	private int mes;
	private int año;
	
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
	public int getAño() {
		return año;
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
	public void setAño(int año) {
		if (año<1940){
			this.año = 1940;
		}else if (año>2015){
			this.año=2015;
		}else {
			this.año=año;
		}
	}
	
}
