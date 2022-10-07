package modelo;


import java.util.Collections;
import java.util.LinkedList;
import java.util.Random;

public class HelperDatos {

	//Integer id, String nombre, String descripcion, Integer ataque, Integer defensa
	
	public static LinkedList<Carta> generaDeck() {
		LinkedList<Carta> deck = new LinkedList<>(); 
		for (int i = 0; i < new Random().nextInt(10); i++) {
			deck.add(new CartaMonstruo(i, "Monstruo"+i, "Descripcion"+i, new Random().nextInt(10), new Random().nextInt(10)));
			deck.add(new CartaHechizo(i, "Hechizo"+i, "Descripcion"+i));
		}
		Collections.shuffle(deck); 
		return deck;
	}
	
	/*
	 
	//Genera monstruos y lo agrega en un array 
	public static Deck generaDeck() {
		Deck deck = new Deck();
		LinkedList<CartaMonstruo> monstruos = new LinkedList<>(); 
		LinkedList<CartaMonstruo> hechizos = new LinkedList<>(); 
		for (int i = 0; i < new Random().nextInt(10); i++) {
			monstruos.add(new CartaMonstruo(i, "Monstruo"+i, "Descripcion"+i, new Random().nextInt(10), new Random().nextInt(10)));
			hechizos.add(new CartaMonstruo(i, "Hechizo"+i, "Descripcion"+i, new Random().nextInt(10), new Random().nextInt(10)));
		}
		deck.setMonstruos(monstruos);
		deck.setMonstruos(hechizos);
		return deck;
	}
	 */
	
	
}
