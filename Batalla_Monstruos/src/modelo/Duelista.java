package modelo;

import java.net.URL;
import java.util.ArrayList;
import java.util.LinkedList;

public class Duelista {

	private LinkedList<Carta> deck; 
	private ArrayList<Carta> mano; 
	private Integer vida; 
	private String nombre; 
	private URL icono;
	
	public Duelista(LinkedList<Carta> deck, Integer vida, String nombre, URL icono) {
		super();
		this.deck = deck;
		this.vida = vida;
		this.nombre = nombre;
		this.icono = icono;
	}

	
	public void recibirDanio(Integer dmg) {
		this.setVida(this.getVida() - dmg);
	}
	
	//saca una carta del mazo, la remueve y queda en la mano del Duelista
	//Actua como una pila el robo de carta 
	public void robarCarta() {
		this.getMano().add(this.getDeck().pop());
	}
	
	
	//getters y setters 
	
	public Integer getVida() {
		return vida;
	}

	public void setVida(Integer vida) {
		this.vida = vida;
	}

	public LinkedList<Carta> getDeck() {
		return deck;
	}

	public ArrayList<Carta> getMano() {
		return mano;
	}

	public String getNombre() {
		return nombre;
	}

	public URL getIcono() {
		return icono;
	} 
	
	
	
	
	
}
