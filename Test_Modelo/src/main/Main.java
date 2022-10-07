package main;

import modelo.Batalla;
import modelo.Campo;
import modelo.Duelista;
import modelo.HelperDatos;

public class Main {

	public static void main(String[] args) {

		Duelista duelistaJugador = new Duelista(HelperDatos.generaDeck(), "YUGI"); 
		Duelista duelistaOponente = new Duelista(HelperDatos.generaDeck(), "KIRA"); 
		 
		Batalla batallaMonstruos = new Batalla(duelistaJugador, duelistaOponente); 

		Campo campoJugador = new Campo(); 
		Campo campoOponente = new Campo(); 
		
		//ambos duelsitas roban 5 cartas 
		for (int i = 0; i < 5; i++) {
			duelistaJugador.robarCarta();
			duelistaOponente.robarCarta();
		}
		
		System.out.println("ManoJugador size: " +duelistaJugador.getMano().size());
		System.out.println("ManoOponente size: " +duelistaOponente.getMano().size());
		
		//se invocan todas las cartas de la mano a los campos correspondientes 
		
		//invocarCarta() no Funciona. 
		
		for (int i = 0; i < 5; i++) {
			campoJugador.invocarCarta2(duelistaJugador.getMano().get(i));
			campoOponente.invocarCarta2(duelistaOponente.getMano().get(i));
		}
		
		//Se comprueba el size de los campos 
		
		System.out.println("CampoJugador monstruos size: " +campoJugador.getMonstruos().size());
		System.out.println("CampoJugador hechizos size: " +campoJugador.getHechizos().size());
		System.out.println("");
		System.out.println("CampoOponente monstruos size: " +campoOponente.getMonstruos().size());
		System.out.println("CampoOponente hechizos size: " +campoOponente.getHechizos().size());
		
		campoJugador.getMonstruos().get(0).setPosicionAtaque(true);
		campoOponente.getMonstruos().get(0).setPosicionAtaque(true);
		
		System.out.println("Ataque carta1: " + campoJugador.getMonstruos().get(0).getAtaque());
		System.out.println("Ataque carta2: " + campoOponente.getMonstruos().get(0).getAtaque());
		
		batallaMonstruos.atacar(campoJugador.getMonstruos().get(0), campoOponente.getMonstruos().get(0));
		
				
	}

}
