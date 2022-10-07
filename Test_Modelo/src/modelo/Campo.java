package modelo;

import java.util.ArrayList;

public class Campo {
	
	private ArrayList<CartaMonstruo> monstruos = new ArrayList<>(); 
	private ArrayList<CartaHechizo> hechizos = new ArrayList<>(); 
	
	public void invocarCarta(Carta carta) {
		if(carta.getEsMonstruo()) {
			this.getMonstruos().add((CartaMonstruo) carta); 
		}else {
			this.getHechizos().add((CartaHechizo) carta); 
		}
	}
	
	//Opcion que SI FUNCIONA
	
	public void invocarCarta2(Carta carta) {
		if(carta instanceof CartaMonstruo) {
			this.getMonstruos().add((CartaMonstruo) carta);
		}else {
			this.getHechizos().add((CartaHechizo) carta); 
		}
	}
	
	
	
	//Getters
	
	public ArrayList<CartaMonstruo> getMonstruos() {
		return monstruos;
	}

	public ArrayList<CartaHechizo> getHechizos() {
		return hechizos;
	}
	
	
	
	
}
