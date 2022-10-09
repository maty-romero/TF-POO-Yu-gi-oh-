

import java.net.URL;
import java.util.LinkedList;

public class Main {

	public static void main(String[] args) { 

		Duelista duelistaJugador = new Duelista(HelperDatos.generaDeck(), "YUGI"); 
		Duelista duelistaOponente = new Duelista(HelperDatos.generaDeck(), "KIRA"); 
		 
		Batalla batallaMonstruos = new Batalla(duelistaJugador, duelistaOponente); 
		
		//los duelistas roban 5 cartas
		for (int i = 0; i < 5; i++) {
			duelistaJugador.robarCarta(); 
			duelistaOponente.robarCarta();
		}
		
		System.out.println("Size manoMonstruos duelistaJugador: " + duelistaJugador.getMano().getManoMonstruos().size());
		System.out.println("Size manoMonstruos duelistaOponente: " + duelistaOponente.getMano().getManoMonstruos().size());
		
		//invocacion de monstruos 
		duelistaJugador.getCampo().invocarMonstruo(duelistaJugador.getMano().getManoMonstruos().get(0));
		duelistaOponente.getCampo().invocarMonstruo(duelistaOponente.getMano().getManoMonstruos().get(0));
	
		//Seteo de valores de posicion ataque o defensa para las cartas. 
		duelistaJugador.getCampo().getMonstruos().get(0).setPosicionAtaque(true);
		duelistaOponente.getCampo().getMonstruos().get(0).setPosicionAtaque(true);
		
		//Informacion de las cartas, antes de la batalla 
		System.out.println("CARTA ATACANTE");
		System.out.println("Ataque: "+ duelistaJugador.getCampo().getMonstruos().get(0).getAtaque());
		System.out.println("Defensa: "+ duelistaJugador.getCampo().getMonstruos().get(0).getDefensa());
		System.out.println("\nCARTA OBJETIVO");
		System.out.println("Ataque: "+ duelistaOponente.getCampo().getMonstruos().get(0).getAtaque());
		System.out.println("Defensa: "+ duelistaOponente.getCampo().getMonstruos().get(0).getDefensa());
		System.out.println("");
		
		System.out.println("Size campo Jugador antes de la batalla: " + duelistaJugador.getCampo().getMonstruos().size());
		System.out.println("Size campo Oponente antes de la batalla: " + duelistaJugador.getCampo().getMonstruos().size());
		
		//Batalla entre cartas 
		batallaMonstruos.atacar(duelistaJugador.getCampo().getMonstruos().get(0), duelistaOponente.getCampo().getMonstruos().get(0));
		
		//Resultados de la batalla
		
		System.out.println("DATOS DEL DUELISTA JUGADOR: ");
		System.out.println("Vida duelista: " + duelistaJugador.getVida());
		System.out.println("Cemeneterio size: " + duelistaJugador.getCementerio().getMonstruos().size());
		System.out.println("");
		System.out.println("DATOS DEL DUELISTA OPONENTE: ");
		System.out.println("Vida duelista: " + duelistaOponente.getVida());
		System.out.println("Cemeneterio size: " + duelistaOponente.getCementerio().getMonstruos().size());
		
		System.out.println("Size campo Jugador luego de la batalla: " + duelistaJugador.getCampo().getMonstruos().size());
		System.out.println("Size campo Oponente luego de la batalla: " + duelistaJugador.getCampo().getMonstruos().size());
		
		
		/* 					TEST SOLO COMBATE ENTRE CARTAS 
		
		System.out.println(duelistaJugador.getCementerio().size());
		
		CartaMonstruo monster1 = new CartaMonstruo(1, "Dark Magician", "descripcion1", 30, 20); 
		CartaMonstruo monster2 = new CartaMonstruo(2, "Dragon Blanco", "descripcion2", 30, 20);
		
		monster1.setPosicionAtaque(true);
		monster2.setPosicionAtaque(false);
		
		
		batallaMonstruos.atacar(monster1, monster2);
		
		System.out.println(duelistaJugador.getCementerio().size());
		System.out.println(duelistaOponente.getCementerio().size());
		
		*/
	
		
	
	}

}
