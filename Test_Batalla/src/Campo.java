
import java.util.ArrayList;

import javax.swing.JPanel;

public class Campo {

	private ArrayList<CartaMonstruo> monstruos = new ArrayList<>(); 
	private ArrayList<CartaHechizo> hechizos = new ArrayList<>(); 
	
	public void invocarMonstruo(CartaMonstruo c, Boolean posAtaque) {
		c.setPosicionAtaque(true);
		this.getMonstruos().add(c); 
	}

	public void invocarHechizo(CartaHechizo c) {
		this.getHechizos().add(c); 
	}
	
	public void eliminarCarta(CartaMonstruo c) {
		this.getMonstruos().remove(c); 
	}
	
	public void eliminarCarta(CartaHechizo c) {
		this.getMonstruos().remove(c); 
	}

	//Getters
	
	public ArrayList<CartaMonstruo> getMonstruos() {
		return this.monstruos;
	}

	public ArrayList<CartaHechizo> getHechizos() {
		return this.hechizos;
	}
	
	
	
}
