package batalla;

import java.util.LinkedList;
import java.util.Random;

public class HelperDatos {

	//Integer id, String nombre, String descripcion, Integer ataque, Integer defensa
	
	public static LinkedList<Carta> generaCartaMonstruo() {
		LinkedList<Carta> deck = new LinkedList<>(); 
		for (int i = 0; i < new Random().nextInt(10); i++) {
			deck.add(new CartaMonstruo(i, "Carta"+i, "Descripcion"+i, new Random().nextInt(10), new Random().nextInt(10)));
		}
		return deck;
	}
	
	
	
}
