package batalla;

import java.net.URL;
import java.util.ArrayList;
import java.util.LinkedList;

public class Duelista {

	private LinkedList<Carta> deck; 
	private ArrayList<Carta> mano = new ArrayList<>();
	private ArrayList<Carta> cementerio = new ArrayList<>();; 
	private Integer vida; 
	private String nombre; 
	//private URL icono;
	
	//, URL icono
	public Duelista(LinkedList<Carta> deck, String nombre) {
		super();
		this.deck = deck;
		this.vida = 8000; //inicializacion de vida 
		this.nombre = nombre;
		//this.icono = icono;
	}

	
	public void recibirDanio(Integer dmg) {
		this.setVida(this.getVida() - dmg); 
	}
	
	//saca una carta del mazo, la remueve y queda en la mano del Duelista
	//El robo de carta actua como una pila 
	public void robarCarta() {
		this.getMano().add(this.getDeck().pop());
	}
	
	//agrega una carta al array cemeneterio; en el controlador se elimina del campo la carta muerta
	public void llevarACementerio(Carta carta) {
		this.getCementerio().add(carta); 
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
	
	public ArrayList<Carta> getCementerio() {
		return cementerio;
	}

	public String getNombre() {
		return nombre;
	}

//	public URL getIcono() {
//		return icono;
//	} 
	
	
	
	
	
}
