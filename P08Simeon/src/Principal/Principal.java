package Principal;
import Ventanas.Juego;
import Ventanas.Registro;
import Ventanas.Perfil;
import Ventanas.VentanaPostLogin;

public class Principal {
	
	public static void main(String[] args) {
		
			//INVOCAMOS LA VENTANA JUEGO AUN OCULTA
		Ventanas.VentanaPostLogin v2 = new VentanaPostLogin();
		
		//INVOCAMOS LA VENTANA LOGIN
		Ventanas.Registro v1 = new Registro(v2);
		v1.setVisible(true);
		

	}

}
