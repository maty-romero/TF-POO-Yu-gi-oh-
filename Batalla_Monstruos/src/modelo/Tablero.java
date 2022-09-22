package modelo;

public class Tablero {

	private Cementerio cementerioJugador, cementerioOponente;
	private Duelista jugador, oponente; 
	private Campo campoJugador, campoOponente;
	
	public Tablero(Cementerio cementerioJugador, Cementerio cementerioOponente, Duelista jugador, Duelista oponente,
			Campo campoJugador, Campo campoOponente) {
		super();
		this.cementerioJugador = cementerioJugador;
		this.cementerioOponente = cementerioOponente;
		this.jugador = jugador;
		this.oponente = oponente;
		this.campoJugador = campoJugador;
		this.campoOponente = campoOponente;
	}
	
	
	//Getters 

	public Cementerio getCementerioJugador() {
		return cementerioJugador;
	}

	public Cementerio getCementerioOponente() {
		return cementerioOponente;
	}

	public Duelista getJugador() {
		return jugador;
	}

	public Duelista getOponente() {
		return oponente;
	}

	public Campo getCampoJugador() {
		return campoJugador;
	}

	public Campo getCampoOponente() {
		return campoOponente;
	} 
	
	
	
}
