

import java.util.LinkedList;
import java.util.Random;

public class HelperDatos {

	//Integer id, String nombre, String descripcion, Integer ataque, Integer defensa
	
	public static LinkedList<CartaMonstruo> generaDeckMonstruos() {
		LinkedList<CartaMonstruo> deckMonstruos = new LinkedList<>(); 
		for (int i = 0; i < new Random().nextInt(10); i++) {
			deckMonstruos.add(new CartaMonstruo(i, "Monstruo"+i, "Descripcion"+i, new Random().nextInt(10), new Random().nextInt(10)));
		}
		return deckMonstruos;
	}
	
	//Genera monstruos y lo agrega en un array 
	public static Deck generaDeck() {
		Deck deck = new Deck();
		LinkedList<CartaMonstruo> monstruos = new LinkedList<>(); 
		LinkedList<CartaHechizo> hechizos = new LinkedList<>(); 
		for (int i = 0; i < new Random().nextInt(10, 20); i++) {
			monstruos.add(new CartaMonstruo(i, "Monstruo"+i, "Descripcion"+i, new Random().nextInt(10), new Random().nextInt(10)));
			hechizos.add(new CartaHechizo(i,"nombre"+i, "descripcion"+i));
		}
		deck.setMonstruos(monstruos);
		deck.setHechizos(hechizos);
		return deck;
	}
	
	
	
}
