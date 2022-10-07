package modelo;

import java.util.ArrayList;

public class Campo {

//	private ArrayList<Carta> entidades; 
	private ArrayList<CartaMonstruo> monstruos = new ArrayList<>(); 
	private ArrayList<CartaHechizo> hechizos = new ArrayList<>(); 
	
	public void invocarCarta(Carta carta) {
		if(carta.getEsMonstruo()) {
			this.getMonstruos().add((CartaMonstruo) carta); 
		}else {
			this.getHechizos().add((CartaHechizo) carta); 
		}
	}

	public ArrayList<CartaMonstruo> getMonstruos() {
		return monstruos;
	}

	public ArrayList<CartaHechizo> getHechizos() {
		return hechizos;
	}
	
//	public void reposicionCampo() {
//		try {
//			monstruos.add((CartaMonstruo) entidades.get(0)); 
//		} catch (Exception e) {
//			hechizos.add((CartaHechizo) entidades.get(0)); 
//		}
//	}
	
	
//	public void invocarMonstruo(CartaMonstruo c) {
//		this.getMonstruos().add(c); 
//	}
//
//	public void eliminarMonstruo(CartaMonstruo c) {
//		this.getMonstruos().remove(c); 
//	}
//	
//	//terminar
//	public void invocarHechizo(CartaHechizo c) {
//		this.getHechizos().add(c); 
//	}
//	
//	public void eliminarHechizo(CartaHechizo c) {
//		this.getMonstruos().remove(c); 
//	}
	
	//Getters
	
	
	
	
	
}
