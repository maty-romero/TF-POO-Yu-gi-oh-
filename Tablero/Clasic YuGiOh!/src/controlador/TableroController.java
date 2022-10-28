package controlador;

import modelo.Batalla;
import modelo.Duelista;
import modelo.Modelo;
import vista.Vista_tablero;

public class TableroController {
	private Modelo modelo;
	private ControladorProyeccionCartas c;
	
	private static Duelista duelistaJugador, duelistaOponente; 
	private static Batalla batallaJugador, batallaOponente; //para los cambios de turno
	
	private Vista_tablero vista;
	
	public TableroController() {
//		vista = new Vista_tablero(this);
		Vista_tablero vista = new Vista_tablero();
		this.vista=vista;
		this.vista.mostrar();
		this.modelo = new Modelo();

		duelistaJugador = new Duelista("YUGI"); 
		duelistaOponente = new Duelista("KIRA"); 
		batallaJugador = new Batalla(duelistaJugador, duelistaOponente);
		batallaOponente = new Batalla(duelistaOponente, duelistaJugador);
	}
	
	//flujo de la partida 
	/*
	 * FASES: Robo, invocacion, batalla, invocacion, otro turno
	 */
	
	public void Partida() {
		
		// los duelistas roban 5 cartas --> Actualizar la vista. 
		for (int i = 0; i < 5; i++) {
			duelistaJugador.robarCarta();
			duelistaOponente.robarCarta();
		}
		
		//mientras ninguno pierda, sigue la partida. 
		while(duelistaJugador.getGanador() && duelistaOponente.getGanador()) {
			
		}
				 
		
		
	}
	
	
}
