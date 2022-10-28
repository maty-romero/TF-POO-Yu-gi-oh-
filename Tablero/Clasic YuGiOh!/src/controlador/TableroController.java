package controlador;

import java.util.ArrayList;

import modelo.Batalla;
import modelo.Carta;
import modelo.CartaHechizo;
import modelo.CartaMonstruo;
import modelo.Duelista;
import modelo.Modelo;
import vista.VistaTablero;

public class TableroController {
	private Modelo modelo;
	private ControladorProyeccionCartas c;

	private static Duelista duelistaJugador, duelistaOponente;
	private static Batalla batallaJugador, batallaOponente; // para los cambios de turno

	private VistaTablero vista;

	public TableroController() {
		VistaTablero vista = new VistaTablero();
		this.vista = vista;
		this.vista.mostrar();
		this.modelo = new Modelo();

		duelistaJugador = new Duelista("YUGI");
		duelistaOponente = new Duelista("KIRA");
		batallaJugador = new Batalla(duelistaJugador, duelistaOponente);
		batallaOponente = new Batalla(duelistaOponente, duelistaJugador);

		this.generoImagenesMonstruo(duelistaJugador.getMano().getManoMonstruos());
		this.generoImagenesMonstruo(duelistaJugador.getMano().getManoMonstruos());

	}

	public void generoImagenesMonstruo(ArrayList<CartaMonstruo> cartas) {
		for (Carta carta : cartas) {
			this.modelo.generoImagenCarta(carta);
		}
	}

	public void generoImagenesHechizo(ArrayList<CartaHechizo> cartas) {
		for (Carta carta : cartas) {
			this.modelo.generoImagenCarta(carta);
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

		// mientras ninguno pierda, sigue la partida.
		while (duelistaJugador.getGanador() && duelistaOponente.getGanador()) {

		}

	}

}
