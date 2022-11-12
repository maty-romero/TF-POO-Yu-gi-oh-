package modelo;
import java.util.ArrayList;

public class Cementerio {

	private ArrayList<CartaMonstruo> monstruos = new ArrayList<>(); 
	private ArrayList<CartaHechizo> hechizos = new ArrayList<>(); 
	
	public void llevarMonstruoCementerio(CartaMonstruo carta) {
		monstruos.add(carta); 
	}
	
	public void llevarHechizoCementerio(CartaHechizo carta) {
		hechizos.add(carta); 
	}

	public ArrayList<CartaMonstruo> getMonstruos() {
		return monstruos;
	}

	public ArrayList<CartaHechizo> getHechizos() {
		return hechizos;
	}
	
	
}
