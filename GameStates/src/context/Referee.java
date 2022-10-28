package context;

import modelo.Batalla;
import modelo.Duelista;
import state.AccionState;

public class Referee {

	private Duelista duelistaJugador, duelistaOponente; 
	private Batalla batallaTurnoJugador, batallaTurnoOponente;
	
	private AccionState state; 
	
	public Referee(Duelista duelistaJugador, Duelista duelistaOponente) {
		this.duelistaJugador = duelistaJugador;
		this.duelistaOponente = duelistaOponente;
		this.batallaTurnoJugador = new Batalla(duelistaJugador, duelistaOponente);
		this.batallaTurnoOponente = new Batalla(duelistaOponente, duelistaJugador);
	}
	
	
	
	
	
	//Getters 
	
	public Duelista getDuelistaJugador() {
		return duelistaJugador;
	}
	public Duelista getDuelistaOponente() {
		return duelistaOponente;
	}
	public Batalla getBatallaTurnoJugador() {
		return batallaTurnoJugador;
	}
	public Batalla getBatallaTurnoOponente() {
		return batallaTurnoOponente;
	} 
	
	
	
}
