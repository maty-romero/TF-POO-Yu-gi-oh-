
public class Tablero {

	/*
	 * Controla los estados de la partida???
	 * 
	 * Notificar fase de robo 
	 * Fase de invocacion
	 * Fase de pelea
	 * Cambio de turno --> Agregar un boton de pasar turno 
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
	
	
}
