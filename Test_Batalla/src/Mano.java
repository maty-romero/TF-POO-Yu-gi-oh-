import java.util.ArrayList;

public class Mano {

	private ArrayList<CartaMonstruo> manoMonstruos = new ArrayList<>(); 
	private ArrayList<Carta> manoHechizos = new ArrayList<>(); 
	
	public void agregarMonstruo(CartaMonstruo carta) {
		manoMonstruos.add(carta); 
	}

	public void agregarHechizo(CartaHechizo carta) {
		manoHechizos.add(carta); 
	}

	public ArrayList<CartaMonstruo> getManoMonstruos() {
		return manoMonstruos;
	}

	public ArrayList<Carta> getManoHechizos() {
		return manoHechizos;
	}
	
	
	
	
	
	
	
}
