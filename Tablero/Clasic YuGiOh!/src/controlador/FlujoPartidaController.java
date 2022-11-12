package controlador;

import java.util.Arrays;
import java.util.List;

public class FlujoPartidaController {

	//Flujo de la partida --> Jugador 
	
	private TableroController tc;
	private List<String> fasesPartida = Arrays.asList("DRAW PHASE",  "MAIN PHASE" , "BATTLE PHASE");   
	
	private Boolean turnoJugador; //false --> Turno Bot
	
	
	private Integer faseActual;
	
	public FlujoPartidaController(TableroController tc) {
		this.tc = tc;
		this.fasesPartida = Arrays.asList("DRAW PHASE",  "MAIN PHASE" , "BATTLE PHASE"); 
	
		this.tc.getVista().getBtnSiguienteFase().addActionListener(e->this.siguienteFase());
	} 
	
	public void siguienteFase() {
		
		while() {
			
		}
		this.faseActual = this.fasesPartida.get(0); 
		
		
		
	}
	
	
	
	
	
	
}
