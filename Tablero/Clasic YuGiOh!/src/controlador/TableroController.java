package controlador;

import java.util.ArrayList;

import modelo.Batalla;
import modelo.Carta;
import modelo.CartaHechizo;
import modelo.CartaMonstruo;
import modelo.Duelista;
import modelo.Modelo;
import vista.Vista_tablero;

public class TableroController {

	private static Duelista duelistaJugador, duelistaOponente; 
	private static Batalla batallaJugador, batallaOponente; //para los cambios de turno
	
	private Vista_tablero vista;	
	private Modelo modelo;
	public TableroController() {
  		vista = new Vista_tablero();
		duelistaJugador = new Duelista("YUGI"); 
		duelistaOponente = new Duelista("KIRA"); 
		batallaJugador = new Batalla(duelistaJugador, duelistaOponente);
		batallaOponente = new Batalla(duelistaOponente, duelistaJugador);
        
		
		/// XXXXXXXXXXXXXXX PRUEBA XXXXXXXXXXX
		ArrayList<CartaMonstruo> monstruos = duelistaOponente.getMano().getManoMonstruos();
		monstruos.add(new CartaMonstruo(1,"hola","jaja","/cartas/cambio_de_fidelidad.jpg", 12, 32 ) );		
		monstruos.add(new CartaMonstruo(1,"hola","jaja","/cartas/cambio_de_fidelidad.jpg", 12, 32 ) );		
		monstruos.add(new CartaMonstruo(1,"hola","jaja","/cartas/cambio_de_fidelidad.jpg", 12, 32 ) );		
		monstruos.add(new CartaMonstruo(1,"hola","jaja","/cartas/cambio_de_fidelidad.jpg", 12, 32 ) );		
		monstruos.add(new CartaMonstruo(1,"hola","jaja","/cartas/cambio_de_fidelidad.jpg", 12, 32 ) );		
		monstruos.add(new CartaMonstruo(1,"hola","jaja","/cartas/cambio_de_fidelidad.jpg", 12, 32 ) );		
		monstruos.add(new CartaMonstruo(1,"hola","jaja","/cartas/cambio_de_fidelidad.jpg", 12, 32 ) );		
		monstruos.add(new CartaMonstruo(1,"hola","jaja","/cartas/cambio_de_fidelidad.jpg", 12, 32 ) );		

		/// XXXXXXXXXXX

		this.envioImagenesMonstruoVista(monstruos);
		// this.generoImagenesHechizo(duelistaOponente.getMano().getManoHechizos());

	}

	public void envioImagenesMonstruoVista(ArrayList<CartaMonstruo> monstruos) {
		for (Carta carta : monstruos) {
			System.out.println("entre");
			this.vista.agregoCartaManoBot(this.modelo.generoImagenCarta(carta));
		}
	}

//Si tengo 3 cartas hechizo en la mano, por ejemplo, se cargaran 3 imagenes.
	public void generoImagenesHechizo(ArrayList<CartaHechizo> cartas) {
		for (Carta carta : cartas) {
			this.vista.agregoCartaManoBot(this.modelo.generoImagenCarta(carta));
		}

	}

	// flujo de la partida
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
