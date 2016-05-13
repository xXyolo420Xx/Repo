package Principal;
import Ventanas.Juego;
import Ventanas.Login;
import Ventanas.Perfil;
import Ventanas.VentanaPostLogin;

public class Principal {
	
	public static void main(String[] args) {
		
			//INVOCAMOS LA VENTANA JUEGO AUN OCULTA
		Ventanas.VentanaPostLogin v2 = new VentanaPostLogin();
		
		//INVOCAMOS LA VENTANA LOGIN
		Ventanas.Login v1 = new Login(v2);
		v1.setVisible(true);
		

	}

}
