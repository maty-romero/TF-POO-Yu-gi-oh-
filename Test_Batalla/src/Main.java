

import java.net.URL;
import java.util.LinkedList;

public class Main {

	public static void main(String[] args) { 

		Duelista duelistaJugador = new Duelista(HelperDatos.generaDeck(), "YUGI"); 
		Duelista duelistaOponente = new Duelista(HelperDatos.generaDeck(), "KIRA"); 
		 
		Batalla batallaMonstruos = new Batalla(duelistaJugador, duelistaOponente); 
		
		//los duelista roban 5 cartas
		for (int i = 0; i < 5; i++) {
			duelistaJugador.robarCarta(); 
			duelistaOponente.robarCarta();
		}
		
		duelistaJugador.getCampo().invocarMonstruo(duelistaJugador.getMano().getManoMonstruos().get(0));
		duelistaOponente.getCampo().invocarMonstruo(duelistaOponente.getMano().getManoMonstruos().get(0));
	
		batallaMonstruos.atacar(duelistaJugador.getCampo().getMonstruos().get(0), duelistaOponente.getCampo().getMonstruos().get(0));
		

		
		/* 					TEST COMBATE ENTRE CARTAS 
		
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
