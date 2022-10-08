
public class Tablero {

	/*
	 * Controla los estados de la partida???
	 * 
	 */
	
	private Duelista duelistaJugador, duelistaOponente; 
	private Campo campoJugador, campoOponente;
	
	public Tablero(Duelista duelistaJugador, Duelista duelistaOponente, Campo campoJugador, Campo campoOponente) {
		this.duelistaJugador = duelistaJugador;
		this.duelistaOponente = duelistaOponente;
		this.campoJugador = campoJugador;
		this.campoOponente = campoOponente;
	} 
	
	public void invocarMonstruo(CartaMonstruo carta) {
		campoJugador.invocarMonstruo(carta);
	}
	
}
