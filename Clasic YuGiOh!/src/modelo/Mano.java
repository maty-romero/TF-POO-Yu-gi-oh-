package modelo;
import java.util.ArrayList;

public class Mano {

	private ArrayList<CartaMonstruo> manoMonstruos = new ArrayList<>(); 
	private ArrayList<CartaHechizo> manoHechizos = new ArrayList<>(); 
	
	public void agregarCarta(CartaMonstruo carta) {
		this.getManoMonstruos().add(carta); 
	}		

	public void agregarCarta(CartaHechizo carta) {
		this.getManoHechizos().add(carta); 
	}

	public ArrayList<CartaMonstruo> getManoMonstruos() {
		return manoMonstruos;
	}

	public ArrayList<CartaHechizo> getManoHechizos() {
		return manoHechizos;
	}
	
	
	
	
	
	
	
}
