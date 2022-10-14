package modelo;


import java.util.LinkedList;
import java.util.Random;

public class Duelista {

	private Deck deck; 
	private Mano mano;   
	private Cementerio cementerio; 
	
	private Campo campo; 
	
	private Integer vida; 
	private String nombre; 
	
	private Boolean ganador, invocoMonstruo;
	//private URL icono;
	
	//, URL icono
	public Duelista(Deck deck, String nombre) {
		this.deck = deck;
		this.mano = new Mano();
		this.campo = new Campo(); 
		this.cementerio = new Cementerio(); 
		this.vida = 8000; //inicializacion de vida 
		this.nombre = nombre;
		this.ganador = true; //los duelistas son ganadores hasta que uno de los dos pierda
		this.invocoMonstruo = false; 
		
		//this.icono = icono;
	}

	public void recibirDanio(Integer dmg) {
		this.setVida(this.getVida() - dmg); 
	}
	
	//saca una carta del mazo, la remueve y queda en la mano del Duelista
	//El robo de carta actua como una pila 
	public void robarCarta() {
		try {
			if(new Random().nextBoolean()) { //Se obtiene un monstruo en la mano
				this.getMano().agregarCarta(this.getDeck().getMonstruo());
			}else {
				this.getMano().agregarCarta(this.getDeck().getHechizo());
			}
			
		}catch(IndexOutOfBoundsException e) {
			System.out.println("El duelista " + this.getNombre() + " ha perdido.");
			this.setGanador(false);
		}
		
	}
	
	
	
	//getters y setters 
	
	
	public Integer getVida() {
		return this.vida;
	}

	public Boolean getInvocoMonstruo() {
		return this.invocoMonstruo;
	}


	public void setInvocoMonstruo(Boolean invocoMonstruo) {
		this.invocoMonstruo = invocoMonstruo;
	}
	
	public Boolean getGanador() {
		return this.ganador;
	}


	public void setGanador(Boolean ganador) {
		this.ganador = ganador;
	}


	public Cementerio getCementerio() {
		return cementerio;
	}


	public Deck getDeck() {
		return this.deck;
	}

	public Mano getMano() {
		return this.mano;
	}

	public void setVida(Integer vida) {
		this.vida = vida;
	}

	public String getNombre() {
		return this.nombre;
	}

	public Campo getCampo() {
		return this.campo;
	}

//	public URL getIcono() {
//		return icono;
//	} 
	
	
	
	
	
}
