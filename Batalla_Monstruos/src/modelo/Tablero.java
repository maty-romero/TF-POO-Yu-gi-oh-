package modelo;

import java.util.ArrayList;
import java.util.LinkedList;

public class Tablero {

	/*	Consideraciones: 
	 * Falta agregar funcionalidades con cartas magicas 
	 * Falta considerar los limites de cada array. 
	 * El deck del Jugador y Oponente deberia de conectarse con el atributo Deck de la clase Duelista
	 
	 * Pendiente: 
	 */
	
	
//	private final Integer cartasCampo = 6;  (Limitar de acuerdo al array ?) 

	
	private ArrayList<Carta> manoJugador, manoOponente;
	private ArrayList<Carta> cementerioJugador, cementerioOponente;
	private LinkedList<Carta> deckJugador, deckOponente; //uso de la funcion Pop() como una pila 
	private ArrayList<Carta> CampoJugadorMonstruos, campoOponenteMonstruos;
	//private ArrayList<Carta> campoJugadorMagicas, campoOponenteMagicas; 
	
	
	
	/* 
	 * Eliminacion de monstruos en el campo 
	 
	 	Se indica la posicion del panel del tablero 
	 	se translada esa carta al cementerio y luego se elimina la carta del campo   
	 */
	
	public void eliminacionMonstruoJugador(Carta carta, Integer posicion) {
		this.getCementerioJugador().add(carta); 
		this.getCampoJugadorMonstruos().remove(posicion); 	
	}
	
	public void eliminacionMonstruoOponente(Carta carta, Integer posicion) {
		this.getCementerioOponente().add(carta); 
		this.getCampoOponenteMonstruos().remove(posicion); 
	}
	
	//Faltaria eliminacion con cartas Magicas 
	
	
	/*
	 * Robado de carta del deck 
	 
	   Se saca la ultima carta del deck (pop) y se agrega a la mano 
	 */
	
	public void robarCartaJugador() {
		Carta nuevaCarta = this.getDeckJugador().pop(); 
		this.getManoJugador().add(nuevaCarta); 
	}
	
	public void robarCartaOponente() {
		Carta nuevaCarta = this.getDeckOponente().pop(); 
		this.getManoOponente().add(nuevaCarta); 
	}
	
	/* 
	 	Invocacion de una carta al tablero 
	 
	 *	Se invoca una carta de la mano hacia el tablero. La carta utilizada se elimina de la mano 
	 *	La carta pasada por parametro sera a traves de un evento en el Tablero 
	 */
	
	public void invocarCartaJugador(Carta carta) {
		this.getCampoJugadorMonstruos().add(carta); 
		this.getManoJugador().remove(carta); //remueve el objeto 
	}
	
	public void invocarCartaOponente(Carta carta) {
		this.getCampoOponenteMonstruos().add(carta); 
		this.getManoOponente().remove(carta); //remueve el objeto 
	}
	
	/* 
		Pelea entre cartas (Monstruo) 
		
		Si las 2 cartas estan en posicion de ataque nos interesa el ataque o daño de esas cartas. 
		
		Desde el jugador hacia Oponente y viceversa
		Se 
	 */
	
	//El oponente ataca a una carta del jugador en el campo 
	public void AtacarCartaJugador(Carta cartaAtacante, Carta cartaObjetivo) {
		
	}
	
	//Getters 
	
	public ArrayList<Carta> getManoJugador() {
		return manoJugador;
	}
	public ArrayList<Carta> getManoOponente() {
		return manoOponente;
	}
	public ArrayList<Carta> getCementerioJugador() {
		return cementerioJugador;
	}
	public ArrayList<Carta> getCementerioOponente() {
		return cementerioOponente;
	}
	public LinkedList<Carta> getDeckJugador() {
		return deckJugador;
	}
	public LinkedList<Carta> getDeckOponente() {
		return deckOponente;
	}

	public ArrayList<Carta> getCampoJugadorMonstruos() {
		return CampoJugadorMonstruos;
	}

	public ArrayList<Carta> getCampoOponenteMonstruos() {
		return campoOponenteMonstruos;
	}
	

	
	
	
}
