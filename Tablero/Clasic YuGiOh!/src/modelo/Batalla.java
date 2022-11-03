package modelo;
public class Batalla {

	/*
	 * Cada turno se instancia un nuevo objeto Batalla con los duelistas
	 * correspondientes: duelistaJugador --> Duelista que esta en su turno
	 * duelistaOponente --> Duelista que se ataca
	 * 
	 * CartaAtacante --> pertenece al duelistaJugador CartaObjetivo --> pertence al
	 * duelistaOponente
	 * 
	 * Controlar desde afuera que el campo atacante tenga monstruos para utilizar el
	 * metodo Atacar() Caso contrario atacar al duelista de maenra directa
	 */

	private Duelista duelistaJugador;
	private Duelista duelistaOponente; 

//	  Luego de una Batalla se obtienen los monstruos que muerieron 
//	  De acuerdo a que duelista pertenece. 
	 
	private CartaMonstruo monstruoMuertoJugador, monstruoMuertoOponente;
	
	public Batalla(Duelista duelistaJugador, Duelista duelistaOponente) {
		this.duelistaJugador = duelistaJugador;
		this.duelistaOponente = duelistaOponente;
	}

	/*
	 * Ambas Cartas en posicion ataque:
	 * 
	 * dmg = cartaAtacante.getAtaque() - cartaObjetivo.getAtaque()
	 * 
	 * dmg > 0 --> cartaAtacante gano, duelista no recibe daño dmg < 0 -->
	 * cartaObjetivo gano, duelista recibe daño restante. dmg = 0 --> ambas cartas
	 * mueren, duelista no recibe daño.
	 * 
	 * Una carta en posicion de ataque y otra en defensa:
	 * 
	 * dmg = cartaAtacante.getAtaque() - cartaObjetivo.getAtaque()
	 * 
	 * dmg > 0 --> CartaObjetivo muere (ATK>DEF), nadie recibe daño dmg < 0 -->
	 * Ambas cartas sobreviven, duelista recibe daño igual a la diferencia entre ATK
	 * y DEF dmg = 0 --> Ninguna carta muere, sigue la partida
	 */

	public void atacar(CartaMonstruo cartaAtacante, CartaMonstruo cartaObjetivo) {
		
		if (cartaObjetivo.getPosicionAtaque()) { // Ambas Cartas en posicion ataque
			Integer dmg = cartaAtacante.getAtaque() - cartaObjetivo.getAtaque();
			if (dmg > 0) { // duelistaJugador
				System.out.println("cartaAtacante gano, duelista no recibe daño");
				this.getDuelistaOponente().getCementerio().llevarMonstruoCementerio(cartaObjetivo); // se lo lleva al // cementerio
				
				this.setMonstruoMuertoOponente(cartaObjetivo);  //registro de la batalla
				
				this.getDuelistaOponente().getCampo().eliminarCarta(cartaObjetivo); // se remueve el monstruo del campo
				
			}
			if (dmg < 0) {
				System.out.println("cartaObjetivo gano, duelista recibe daño restante");
				this.getDuelistaJugador().getCementerio().llevarMonstruoCementerio(cartaAtacante); // se lo lleva al // cementerio					
				
				this.setMonstruoMuertoJugador(cartaAtacante); //registro Batalla 
				
				this.getDuelistaJugador().getCampo().eliminarCarta(cartaAtacante); // se remueve el monstruo del campo
				
				this.getDuelistaJugador().recibirDanio(Math.abs(dmg)); // el duelistaJugador recibe el daño restante 
				
			}
			if (dmg == 0) {
				// Se mandan al cementerio y se elemina del campo las 2 cartas
				System.out.println("ambas cartas mueren, duelista no recibe daño.");
				this.getDuelistaJugador().getCementerio().llevarMonstruoCementerio(cartaAtacante);
				this.getDuelistaJugador().getCampo().eliminarCarta(cartaAtacante);
				
				this.setMonstruoMuertoJugador(cartaAtacante); //registro Batalla
				
				this.getDuelistaOponente().getCementerio().llevarMonstruoCementerio(cartaObjetivo);
				this.getDuelistaOponente().getCampo().eliminarCarta(cartaObjetivo);
				
				this.setMonstruoMuertoOponente(cartaObjetivo); //registro Batalla
			}

		} else { // Una carta en posicion de ataque y otra en defensa

			Integer dmg = cartaAtacante.getAtaque() - cartaObjetivo.getDefensa();
			if (dmg > 0) {
				// carta Objetivo muere y es retirada del campo.
				this.getDuelistaOponente().getCementerio().llevarMonstruoCementerio(cartaObjetivo);
				
				this.setMonstruoMuertoOponente(cartaObjetivo); //registro Batalla 
				
				this.getDuelistaOponente().getCampo().eliminarCarta(cartaObjetivo);
				
			} else { // dmg < 0
				// duelista jugador rebice daño, ninguna carta muere.
				this.getDuelistaJugador().recibirDanio(Math.abs(dmg));
				
			}
			// caso contrario (dmg = 0) --> no pasa nada y sigue la partida
			
			 
		}
	}

	//Si el duelista no tiene monstruos en el campo de batalla 
	public void ataqueDirecto(CartaMonstruo cartaAtacante) {
		this.duelistaOponente.recibirDanio(cartaAtacante.getAtaque());
	}
	
	
	//setters 
	
	public void setMonstruoMuertoJugador(CartaMonstruo monstruoMuertoJugador) {
		this.monstruoMuertoJugador = monstruoMuertoJugador;
	}
	public void setMonstruoMuertoOponente(CartaMonstruo monstruoMuertoOponente) {
		this.monstruoMuertoOponente = monstruoMuertoOponente;
	}
	
	//getters 
	
	public CartaMonstruo getMonstruoMuertoJugador() {
		return monstruoMuertoJugador;
	}
	public CartaMonstruo getMonstruoMuertoOponente() {
		return monstruoMuertoOponente;
	}
	
	public Duelista getDuelistaJugador() {
		return duelistaJugador;
	}

	public Duelista getDuelistaOponente() {
		return duelistaOponente;
	}

}
