package modelo;

import java.util.ArrayList;
import java.util.LinkedList;

public class Duelista {

	/* 
	 * Representa al jugador o al Oponente --> Se tendria que instanciar hijos 
	 * Tambien esto puede ser una clase base para posteriores modificaciones 
	 */
	
	private String nombre; 
	private Integer vida; 
	private LinkedList<Carta> deck = new LinkedList();
	
	public Duelista(String nombre, LinkedList<Carta> deck) {
		super();
		this.nombre = nombre;
		this.vida = 8000;
		this.deck = deck;
	}

	public void recibeDanio(Integer danio) {
		this.setVida(this.getVida() - danio);
	}
	
	public Integer getVida() {
		return vida;
	}

	public void setVida(Integer vida) {
		this.vida = vida;
	}

	public String getNombre() {
		return nombre;
	}

	public LinkedList<Carta> getDeck() {
		return deck;
	} 
	
	
	
	
}
