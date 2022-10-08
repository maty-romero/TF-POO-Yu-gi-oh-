

import java.util.LinkedList;
import java.util.Random;

public class Duelista {

	private Deck deck; 
	private Mano mano;   
	private Cementerio cementerio; 
	
	private Campo campo; 
	
	
	private Integer vida; 
	private String nombre; 
	//private URL icono;
	
	//, URL icono
	public Duelista(Deck deck, String nombre) {
		super();
		this.deck = deck;
		this.mano = new Mano();
		this.campo = new Campo(); 
		this.cementerio = new Cementerio(); 
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
		if(new Random().nextBoolean()) { //Se obtiene un monstruo en la mano
			this.getMano().agregarMonstruo(this.getDeck().getMonstruo());
		}else {
			this.getMano().agregarHechizo(this.getDeck().getHechizo());
		}
	}
	
	
	
	//getters y setters 
	
	
	
	public Integer getVida() {
		return vida;
	}

	public Cementerio getCementerio() {
		return cementerio;
	}


	public Deck getDeck() {
		return deck;
	}


	public Mano getMano() {
		return mano;
	}


	public void setVida(Integer vida) {
		this.vida = vida;
	}

	public String getNombre() {
		return nombre;
	}


	public Campo getCampo() {
		return campo;
	}

//	public URL getIcono() {
//		return icono;
//	} 
	
	
	
	
	
}
