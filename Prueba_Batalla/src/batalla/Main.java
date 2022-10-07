package batalla;

import java.net.URL;
import java.util.LinkedList;

public class Main {

	public static void main(String[] args) { 

		Duelista duelistaJugador = new Duelista(HelperDatos.generaCartaMonstruo(), "YUGI"); 
		Duelista duelistaOponente = new Duelista(HelperDatos.generaCartaMonstruo(), "BAKUGO"); 
		
		Batalla batallaMonstruos = new Batalla(duelistaJugador, duelistaOponente); 
		
		Campo campoJugador = new Campo(); 
		Campo campoOponente = new Campo(); 
		
		duelistaJugador.robarCarta(); 
		duelistaOponente.robarCarta();
		
//		campoJugador.invocarMonstruo(duelistaJugador.getMano().get(0));
//		campoOponente.invocarCarta(duelistaOponente.getMano().get(0));
		

		//Mejorar el modelo planteado para poder atacar entre cartas. 
//		batallaMonstruos.atacar(campoJugador.getCampoCartas().get(0), campoOponente.getCampoCartas().get(0));
		
//		batallaMonstruos.atacar(campoJugador.getMonstruos().get(0), campoOponente.getMonstruos().get(0));
	
		
	
	}

}
