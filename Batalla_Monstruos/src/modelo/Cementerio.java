package modelo;

import java.util.ArrayList;

public class Cementerio {

	private ArrayList<Carta> cementerio; 
	
	public void llevarACementerio(Carta c) {
		this.getCementerio().add(c); 
	}

	public ArrayList<Carta> getCementerio() {
		return cementerio;
	}
	
	
	
}
