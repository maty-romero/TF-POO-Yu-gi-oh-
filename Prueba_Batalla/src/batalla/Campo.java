package batalla;

import java.util.ArrayList;

public class Campo {

	private ArrayList<CartaMonstruo> monstruos; 
	private ArrayList<Carta> hechizos; 
//	private ArrayList<Carta> campoCartas; 
	
//	public void invocarCarta(Carta c) {
//		this.getCampoCartas().add(c); 
//	}
//
//	public ArrayList<Carta> getCampoCartas() {
//		return campoCartas;
//	}
	
	
	
	public void invocarMonstruo(CartaMonstruo c) {
		this.getMonstruos().add(c); 
	}

	public void eliminarMonstruo(CartaMonstruo c) {
		this.getMonstruos().remove(c); 
	}
	
	//terminar
	public void invocarHechizo(Carta c) {
		this.getHechizos().add(c); 
	}
	
	public void eliminarHechizo(Carta c) {
		this.getMonstruos().remove(c); 
	}
	
	//Getters
	
	public ArrayList<CartaMonstruo> getMonstruos() {
		return monstruos;
	}

	public ArrayList<Carta> getHechizos() {
		return hechizos;
	}
	
	
	
}
