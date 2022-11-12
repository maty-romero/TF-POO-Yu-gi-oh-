package modelo;

public class Batalla {

	private Duelista duelistaAtacante; // Bot
	private Duelista duelistaAtacado; // Jugador
	private CartaMonstruo monstruoMuertoJugador = null, monstruoMuertoOponente = null;

	public Batalla(Duelista duelistaJugador, Duelista duelistaOponente) {
		this.duelistaAtacante = duelistaJugador;
		this.duelistaAtacado = duelistaOponente;
	}

	public void atacar(CartaMonstruo cartaAtacante, CartaMonstruo cartaObjetivo) {
		if (cartaObjetivo.getPosicionAtaque()) { // Ambas Cartas en posicion ataque
			Integer dmg = cartaAtacante.getAtaque() - cartaObjetivo.getAtaque();
			if (dmg > 0) {
				System.out.println("cartaAtacante gano, duelista no recibe daño");
				this.getDuelistaAtacado().getCementerio().llevarMonstruoCementerio(cartaObjetivo);
				this.setMonstruoMuertoOponente(cartaObjetivo);

				this.getDuelistaAtacado().getCampo().eliminarCarta(cartaObjetivo);
				this.getDuelistaAtacado().recibirDanio(Math.abs(dmg));

			}
			if (dmg < 0) {
				System.out.println("cartaObjetivo gano, duelista recibe daño restante");
				this.getDuelistaAtacante().getCementerio().llevarMonstruoCementerio(cartaAtacante);
				this.setMonstruoMuertoJugador(cartaAtacante); // registro Batalla

				this.getDuelistaAtacante().getCampo().eliminarCarta(cartaAtacante);
				this.getDuelistaAtacante().recibirDanio(Math.abs(dmg));
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

		} else {

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
