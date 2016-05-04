package Principal;
import Ventanas.Juego;
import Ventanas.Login;

public class Principal {
	
	public static void main(String[] args) {
		//INVOCAMOS LA VENTANA JUEGO AUN OCULTA
		Ventanas.Juego jueg = new Juego();
		
		//INVOCAMOS LA VENTANA LOGIN
		Ventanas.Login v1 = new Login(jueg);
		v1.setVisible(true);
	}

}
