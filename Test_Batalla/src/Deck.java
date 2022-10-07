import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;

public class Deck {

	private LinkedList<CartaMonstruo> monstruos = new LinkedList<>(); 
	private LinkedList<CartaHechizo> hechizos = new LinkedList<>(); 
	
	public void mezclarDeck() {
		Collections.shuffle(monstruos);
		Collections.shuffle(hechizos);
	}
	
	public CartaMonstruo getMonstruo() {
		return monstruos.pollLast();
	}
	
	public CartaHechizo getHechizo() {
		return hechizos.pollLast();
	}

	public void setMonstruos(LinkedList<CartaMonstruo> monstruos) {
		this.monstruos = monstruos;
	}

	public void setHechizos(LinkedList<CartaHechizo> hechizos) {
		this.hechizos = hechizos;
	}
	
	
	
	
}
