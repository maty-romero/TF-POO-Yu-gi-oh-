package exepciones;

import controlador.MenuFinalController;
import vista.MenuFinal;

public class PierdeLaPartida extends Exception{

	public PierdeLaPartida(String mensaje) {
		super(mensaje); 
		new MenuFinalController(mensaje); //inicio controlador y vista dando un mensaje. 
		
	}
	
}
