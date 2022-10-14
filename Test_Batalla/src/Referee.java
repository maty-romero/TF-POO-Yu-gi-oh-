import java.util.Arrays;
import java.util.List;

public class Referee {

	/*
	 * Controla los estados de la partida???
	 * 
	 * Notificar fase de robo 
	 * Fase de invocacion
	 * Fase de pelea
	 * Cambio de turno --> Agregar un boton de pasar turno 
	 * 
	 * 
	 * PENDIENTE: 
	 * 	Como selecciono la carta especifica del duelista para las batallas? 
	 * 	
	 *
	 */
	
	private List<String> estadosPartida = Arrays.asList("ROBO DE CARTAS", "INVOCACION", "BATALLA");  
	private Duelista duelistaJugador, duelistaOponente;
	
	private Batalla batallaTurnoJugador, batallaTurnoOponente; //para los cambios de turno 
	
	public Referee(Duelista duelistaJugador, Duelista duelistaOponente) {
		this.duelistaJugador = duelistaJugador;
		this.duelistaOponente = duelistaOponente;
		
		this.batallaTurnoJugador = new Batalla(duelistaJugador, duelistaOponente); 
		this.batallaTurnoOponente = new Batalla(duelistaOponente, duelistaJugador); 
	}
	
	//se devuelve el duelista que perdió 
	public Duelista partida() {
		while(this.duelistaJugador.getGanador() && this.duelistaOponente.getGanador()) {
			
			//necesario?? 
			for (String fase : estadosPartida) {
				System.out.println(fase); //se notifica que fase estamos de la partida 				
			}
		 
			if(this.duelistaOponente.getCampo().getMonstruos().size() == 0) {
				batallaTurnoJugador.ataqueDirecto(null); //?? Como selecciono la carta especifica del campo? 
			}
			
			
			
		}
		return duelistaJugador;
	}
	
	
	
}
