package modelo;

import java.util.ArrayList;

public class Campo {

	private ArrayList<Carta> monstruos; 
	private ArrayList<Carta> hechizos; 
	
	public void nuevoMonstruo(Carta c) {
		this.getMonstruos().add(c); 
	}

	public void nuevoHechizo(Carta c) {
		this.getHechizos().add(c); 
	}
	
	public void eliminarMonstruo(Carta c) {
		this.getMonstruos().remove(c); 
	}
	
	public void eliminarHechizo(Carta c) {
		this.getMonstruos().remove(c); 
	}
	
	//Getters
	
	public ArrayList<Carta> getMonstruos() {
		return monstruos;
	}

	public ArrayList<Carta> getHechizos() {
		return hechizos;
	}
	
	
	
}
