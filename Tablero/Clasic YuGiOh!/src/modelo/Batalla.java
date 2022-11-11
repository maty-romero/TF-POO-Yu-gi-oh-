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

	private Duelista duelistaAtacante; // Bot
	private Duelista duelistaAtacado; // Jugador

//	  Luego de una Batalla se obtienen los monstruos que muerieron 
//	  De acuerdo a que duelista pertenece segun el turno. 

	private CartaMonstruo monstruoMuertoJugador = null, monstruoMuertoOponente = null;

	public Batalla(Duelista duelistaJugador, Duelista duelistaOponente) {
		this.duelistaAtacante = duelistaJugador;
		this.duelistaAtacado = duelistaOponente;
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
				this.getDuelistaAtacado().getCementerio().llevarMonstruoCementerio(cartaObjetivo); // se lo lleva al //
																									// cementerio

				this.setMonstruoMuertoOponente(cartaObjetivo); // registro de la batalla

				this.getDuelistaAtacado().getCampo().eliminarCarta(cartaObjetivo); // se remueve el monstruo del campo

				this.getDuelistaAtacado().recibirDanio(Math.abs(dmg)); // duelista recibe el daño restante del
																		// enfrentamiento

			}
			if (dmg < 0) {
				System.out.println("cartaObjetivo gano, duelista recibe daño restante");
				this.getDuelistaAtacante().getCementerio().llevarMonstruoCementerio(cartaAtacante); // se lo lleva al //
																									// cementerio

				this.setMonstruoMuertoJugador(cartaAtacante); // registro Batalla

				this.getDuelistaAtacante().getCampo().eliminarCarta(cartaAtacante); // se remueve el monstruo del campo

				this.getDuelistaAtacante().recibirDanio(Math.abs(dmg)); // el duelistaJugador recibe el daño restante

			}
			if (dmg == 0) {
				// Se mandan al cementerio y se elemina del campo las 2 cartas
				System.out.println("ambas cartas mueren, duelista no recibe daño.");
				this.getDuelistaAtacante().getCementerio().llevarMonstruoCementerio(cartaAtacante);
				this.getDuelistaAtacante().getCampo().eliminarCarta(cartaAtacante);

				this.setMonstruoMuertoJugador(cartaAtacante); // registro Batalla

				this.getDuelistaAtacado().getCementerio().llevarMonstruoCementerio(cartaObjetivo);
				this.getDuelistaAtacado().getCampo().eliminarCarta(cartaObjetivo);

				this.setMonstruoMuertoOponente(cartaObjetivo); // registro Batalla
			}

		} else { // Una carta en posicion de ataque y otra en defensa

			Integer dmg = cartaAtacante.getAtaque() - cartaObjetivo.getDefensa();
			if (dmg > 0) {
				// carta Objetivo muere y es retirada del campo.
				this.getDuelistaAtacado().getCementerio().llevarMonstruoCementerio(cartaObjetivo);

				this.setMonstruoMuertoOponente(cartaObjetivo); // registro Batalla

				this.getDuelistaAtacado().getCampo().eliminarCarta(cartaObjetivo);

			} else { // dmg < 0
				// duelista jugador rebice daño, ninguna carta muere.
				this.getDuelistaAtacante().recibirDanio(Math.abs(dmg));

			}
			// caso contrario (dmg = 0) --> no pasa nada y sigue la partida

		}
	}

	public void cambiarDuelistaAtacante(Duelista duelistaAtacante) {
		this.duelistaAtacado = this.duelistaAtacante;
		this.duelistaAtacante = duelistaAtacante;
	}

	// Duelista Jugador recibe ataque.
	public void recibirAtaque(CartaMonstruo cartaAtacante, CartaMonstruo cartaObjetivo) {

	}

	// lleva al cemeneterio del duelista y remueve del campo.
	private void eliminacionCartaMuerta(Duelista duelista, CartaMonstruo monstruo) {
		duelista.getCementerio().llevarMonstruoCementerio(monstruo);
		duelista.getCampo().eliminarCarta(monstruo);
	}

	// a un duelista cualquiera lo hace recibit danio
	private void recibirDanioDuelista(Duelista duelista, Integer dmg) {
		duelista.recibirDanio(Math.abs(dmg));
	}

	// Si el duelista no tiene monstruos en el campo de batalla
	public void ataqueDirecto(CartaMonstruo cartaAtacante) {
		this.duelistaAtacado.recibirDanio(cartaAtacante.getAtaque());
	}

	// setters

	public void setMonstruoMuertoJugador(CartaMonstruo monstruoMuertoJugador) {
		this.monstruoMuertoJugador = monstruoMuertoJugador;
	}

	public void setMonstruoMuertoOponente(CartaMonstruo monstruoMuertoOponente) {
		this.monstruoMuertoOponente = monstruoMuertoOponente;
	}

	// getters

	public CartaMonstruo getMonstruoMuertoJugador() {
		return monstruoMuertoJugador;
	}

	public CartaMonstruo getMonstruoMuertoOponente() {
		return monstruoMuertoOponente;
	}

	public Duelista getDuelistaAtacante() {
		return duelistaAtacante;
	}

	public Duelista getDuelistaAtacado() {
		return duelistaAtacado;
	}

}
