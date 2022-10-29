package controlador;

import java.awt.Image;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;
import java.util.HashMap;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;

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
	private HashMap<JPanel, CartaMonstruo> manoMonstruoOponente = new HashMap<JPanel, CartaMonstruo>();
	private HashMap<JPanel, CartaHechizo> manoHechizoOponente = new HashMap<JPanel, CartaHechizo>();
	private HashMap<JPanel, CartaMonstruo> manoMonstruoJugador = new HashMap<JPanel, CartaMonstruo>();
	private HashMap<JPanel, CartaHechizo> manoHechizoJugador = new HashMap<JPanel, CartaHechizo>();
	private JPanel panelCarta;
	private VistaTablero vista;

	public TableroController() {
		VistaTablero vista = new VistaTablero(this);
		this.vista = vista;
		this.modelo = new Modelo();
		this.c = new ControladorProyeccionCartas(this.vista, this);

		duelistaJugador = new Duelista("YUGI");
		duelistaOponente = new Duelista("KIRA");
		batallaJugador = new Batalla(duelistaJugador, duelistaOponente);
		batallaOponente = new Batalla(duelistaOponente, duelistaJugador);

		/// XXXXXXXXXXXXXXX PRUEBA XXXXXXXXXXX DEBERÌA TRAER CARTAS DESDE EL DECK DEL
		/// DUELISTA, UNA VEZ LO TENGA CARGADO ASÌ NO GENERO DATOS EN ESTE CONTROLADOR
		ArrayList<CartaMonstruo> monstruosOponente = duelistaOponente.getMano().getManoMonstruos();
		ArrayList<CartaMonstruo> monstruosJugador = duelistaJugador.getMano().getManoMonstruos();
		ArrayList<CartaHechizo> hechizosJugador = duelistaJugador.getMano().getManoHechizos();
		ArrayList<CartaHechizo> hechizosOponente = duelistaOponente.getMano().getManoHechizos();
		monstruosJugador.add(new CartaMonstruo(1, "hola", "jaja", "/boca_abajo_default/boca_abajo.jpg", 1, 1));
		monstruosJugador.add(new CartaMonstruo(1, "hola", "jaja", "/cartas/dark_magician.jpg", 1, 1));
		monstruosJugador.add(new CartaMonstruo(1, "hola", "jaja", "/cartas/dark_magician.jpg", 1, 1));
		monstruosJugador.add(new CartaMonstruo(1, "hola", "jaja", "/IconoPersonajes/yugi_moto.jpg", 1, 1));

		monstruosOponente.add(new CartaMonstruo(1, "hola", "jaja", "/cartas/cambio_de_fidelidad.jpg", 1, 1));
		monstruosOponente.add(new CartaMonstruo(1, "hola", "jaja", "/boca_abajo_default/boca_abajo.jpg", 1, 1));
		monstruosOponente.add(new CartaMonstruo(1, "hola", "jaja", "/cartas/cambio_de_fidelidad.jpg", 1, 1));

		hechizosJugador.add(new CartaHechizo(1, "hola", "jaja", "/hechizos/tifon_espacio_mistico.jpg"));
		hechizosJugador.add(new CartaHechizo(1, "hola", "jaja", "/hechizos/monstruo_renacido.jpg"));
		hechizosOponente.add(new CartaHechizo(1, "hola", "jaja", "/hechizos/monstruo_renacido.jpg"));
		hechizosOponente.add(new CartaHechizo(1, "hola", "jaja", "/hechizos/tifon_espacio_mistico.jpg"));

////XXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXX///////////////

		try {
			this.setManoMonstruoOponente(
					this.envioImagenesManoMonstruoVista(monstruosOponente, this.vista.getManoBot()));
			Thread.sleep(330);
			this.setManoMonstruoJugador(
					this.envioImagenesManoMonstruoVista(monstruosJugador, this.vista.getManoJugador()));
			this.setManoHechizoOponente(this.envioImagenesManoHechizoVista(hechizosOponente, this.vista.getManoBot()));
			this.setManoHechizoJugador(
					this.envioImagenesManoHechizoVista(hechizosJugador, this.vista.getManoJugador()));

			this.vista.getTablero().setVisible(true); // Actualizo el JFrame
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

//traigo las cartas cargadas con informacion desde base de datos, y las asocio con un panel que creo a partir traer una imagen desde el modelo y cargar esa imagen en el panel en la vista. Luego traigo ese panel y lo asocio a la carta de la cual saqué esa imagen
//me sirve tener metodos separados; de monstruo y hechizo, porque luego en el hash de monstruos solo van a ir monstruos, y no cartas genericas del tipo Carta
	public HashMap<JPanel, CartaMonstruo> envioImagenesManoMonstruoVista(ArrayList<CartaMonstruo> monstruos,
			JPanel mano) {
		HashMap<JPanel, CartaMonstruo> hashAuxiliar = new HashMap<JPanel, CartaMonstruo>();
		for (CartaMonstruo cartaMonstruo : monstruos) {
			// Genero la imagen de esa cartaMonstruo en el modelo, y junto al panel mano que
			// traigo directo desde la vista, mando ambos a la vista para que me asocie esa
			// imagen a esa mano (meto en el panel mano, el otro panel que le inserté esa
			// imagen traida desde el modelo)
			panelCarta = this.vista.agregoCartaManoBot(this.modelo.generoImagenCarta(cartaMonstruo), mano);
			panelCarta.setVisible(true);
			panelCarta.setFocusable(true);

			hashAuxiliar.put(panelCarta, cartaMonstruo);

			this.vista.getManoBot().setFocusable(true);
		}
		this.vista.getManoBot().setFocusable(true);

		this.vista.getTablero().setVisible(true);
		return hashAuxiliar;
	}

	public HashMap<JPanel, CartaHechizo> envioImagenesManoHechizoVista(ArrayList<CartaHechizo> hechizos, JPanel mano) {
		HashMap<JPanel, CartaHechizo> hashAuxiliar = new HashMap<JPanel, CartaHechizo>();
		for (CartaHechizo cartaHechizo : hechizos) {
			// Genero la imagen de esa cartaMonstruo en el modelo, y junto al panel mano que
			// traigo directo desde la vista, mando ambos a la vista para que me asocie esa
			// imagen a esa mano (meto en el panel mano, el otro panel que le inserté esa
			// imagen traida desde el modelo)
			panelCarta = this.vista.agregoCartaManoBot(this.modelo.generoImagenCarta(cartaHechizo), mano);
			panelCarta.setVisible(true);
			panelCarta.setFocusable(true);

			hashAuxiliar.put(panelCarta, cartaHechizo);

			this.vista.getManoBot().setFocusable(true);
		}
		this.vista.getManoBot().setFocusable(true);

		this.vista.getTablero().setVisible(true);
		return hashAuxiliar;
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

	public HashMap<JPanel, CartaMonstruo> getManoMonstruoOponente() {
		return manoMonstruoOponente;
	}

	public void setManoMonstruoOponente(HashMap<JPanel, CartaMonstruo> manoMonstruoOponente) {
		this.manoMonstruoOponente = manoMonstruoOponente;
	}

	public HashMap<JPanel, CartaHechizo> getManoHechizoOponente() {
		return manoHechizoOponente;
	}

	public void setManoHechizoOponente(HashMap<JPanel, CartaHechizo> manoHechizoOponente) {
		this.manoHechizoOponente = manoHechizoOponente;
	}

	public HashMap<JPanel, CartaMonstruo> getManoMonstruoJugador() {
		return manoMonstruoJugador;
	}

	public void setManoMonstruoJugador(HashMap<JPanel, CartaMonstruo> manoMonstruoJugador) {
		this.manoMonstruoJugador = manoMonstruoJugador;
	}

	public HashMap<JPanel, CartaHechizo> getManoHechizoJugador() {
		return manoHechizoJugador;
	}

	public void setManoHechizoJugador(HashMap<JPanel, CartaHechizo> manoHechizoJugador) {
		this.manoHechizoJugador = manoHechizoJugador;
	}

}
