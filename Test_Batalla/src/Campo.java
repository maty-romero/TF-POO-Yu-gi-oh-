
import java.util.ArrayList;

public class Campo {

	private ArrayList<CartaMonstruo> monstruos = new ArrayList<>(); 
	private ArrayList<CartaHechizo> hechizos = new ArrayList<>(); 
	
	
	public void invocarMonstruo(CartaMonstruo c) {
		this.getMonstruos().add(c); 
	}

	public void eliminarMonstruo(CartaMonstruo c) {
		this.getMonstruos().remove(c); 
	}
	
	//terminar
	public void invocarHechizo(CartaHechizo c) {
		this.getHechizos().add(c); 
	}
	
	public void eliminarHechizo(CartaHechizo c) {
		this.getMonstruos().remove(c); 
	}

	//Getters
	
	public ArrayList<CartaMonstruo> getMonstruos() {
		return monstruos;
	}

	public ArrayList<CartaHechizo> getHechizos() {
		return hechizos;
	}
	
	
	
}
