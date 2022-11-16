package modelo;

import java.util.LinkedList;
import java.util.Random;

import exepciones.PierdeLaPartida;

public class Duelista {

	private Deck deck;
	private Mano mano;
	private Cementerio cementerio;
	private Campo campo;
	private Integer vida;
	private String nombre;
	private Boolean ganador, invocoMonstruo;
	private Integer contadorDuelistaPierde;

	public Duelista(String nombre) {
		this.deck = Barajador.generaDeck(); // se obtiene un deck 'aleatorio' desde la BD
		this.deck.mezclarDeck();

		this.mano = new Mano();
		this.campo = new Campo();
		this.cementerio = new Cementerio();
		this.vida = 8000; // inicializacion de vida
		this.nombre = nombre;
		this.ganador = true; // los duelistas son ganadores hasta que uno de los dos pierda
		this.invocoMonstruo = false;
		// this.icono = iconoUrl;
	}

	public void recibirDanio(Integer dmg) {
		this.setVida(this.getVida() - dmg);
	}

	// saca una carta del mazo, la remueve y queda en la mano del Duelista
	// El robo de carta actua como una pila
	public void robarCarta() throws PierdeLaPartida {
		this.contadorDuelistaPierde = 0;
		if (new Random().nextBoolean()) {
			this.roboMonstruo();
		} else {
			this.roboHechizo();

		}
	}
	


	private void roboMonstruo() throws PierdeLaPartida {

		System.out.println("Se intenta robar un monstruo!");
		CartaMonstruo monstruo = this.getDeck().getMonstruo();
		if (monstruo == null) {
			this.contadorDuelistaPierde++;
			if (this.contadorDuelistaPierde == 2) {
				throw new PierdeLaPartida("El duelista " + this.getNombre() + " ha perdido");

			}
			this.roboHechizo();

		} else {

			this.getMano().agregarCarta(monstruo);
			monstruo.setConVida(true);
		}
	}

	private void roboHechizo() throws PierdeLaPartida {

		System.out.println("Se intenta robar un hechizo!");
		CartaHechizo hechizo = this.getDeck().getHechizo();
		if (hechizo == null) {
			this.contadorDuelistaPierde++;
			if (this.contadorDuelistaPierde == 2) {
				throw new PierdeLaPartida("El duelista " + this.getNombre() + " ha perdido");

			}
			this.roboMonstruo();
		} else {
			this.getMano().agregarCarta(hechizo);
		}
	}
	
	/*jugadorAtacante elimina la carta muerta, la suya o del oponente, pues es su turno 
	 *y él hace los movimientos, él toma la iniciativa.  
	 */
	public void eliminacionCartaMuerta(Duelista duelista, CartaMonstruo monstruo) {
		duelista.getCementerio().llevarMonstruoCementerio(monstruo);
		duelista.getCampo().eliminarCarta(monstruo);
		monstruo.setConVida(false);
	}

	// getters y setters

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

}
