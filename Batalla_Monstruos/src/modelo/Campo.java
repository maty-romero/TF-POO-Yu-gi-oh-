package modelo;

import java.util.ArrayList;

public class Campo {

	private ArrayList<Carta> monstruos; 
	private ArrayList<Carta> hechizos; 
	
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
	
	private ArrayList<Carta> getMonstruos() {
		return monstruos;
	}

	private ArrayList<Carta> getHechizos() {
		return hechizos;
	}
	
	
	
}
