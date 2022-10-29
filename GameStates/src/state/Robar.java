package state;

import context.Referee;

public class Robar implements AccionState{

	@Override
	public void movimiento(Referee referee, Boolean turnoJugador) {
		if(turnoJugador) {
			referee.getDuelistaJugador().robarCarta();
		}else {
			referee.getDuelistaOponente().robarCarta();
		}
		
	}

	
	
	
}
