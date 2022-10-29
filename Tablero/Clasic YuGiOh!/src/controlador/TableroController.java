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
		ArrayList<CartaMonstruo> monstruos = duelistaOponente.getMano().getManoMonstruos();
		ArrayList<CartaHechizo> hechizos = duelistaJugador.getMano().getManoHechizos();

		monstruos.add(new CartaMonstruo(1, "hola", "jaja", "/boca_abajo_default/boca_abajo.jpg", 1, 1));
		monstruos.add(new CartaMonstruo(1, "hola", "jaja", "/boca_abajo_default/boca_abajo.jpg", 1, 1));

		hechizos.add(new CartaHechizo(1, "hola", "jaja", "/cartas/cambio_de_fidelidad.jpg"));
		hechizos.add(new CartaHechizo(1, "hola", "jaja", "/cartas/cambio_de_fidelidad.jpg"));

		System.out.println();
		// XXXXXXXXXXX
		try {
			this.envioImagenesManoMonstruoVista(monstruos, this.vista.getManoBot(), this.manoMonstruoOponente);
			Thread.sleep(330);
			this.envioImagenesHechizoVista(hechizos, this.vista.getManoJugador());
			this.envioImagenesManoMonstruoVista(monstruos, this.vista.getManoJugador(), this.manoMonstruoJugador);
			this.vista.getTablero().setVisible(true); // Actualizo el JFrame
		
		
		System.out.println(this.getManoMonstruoOponente());
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
	
//me sirve tener metodos separados; de monstruo y hechizo, porque luego en el hash de monstruos solo van a ir monstruos, y no cartas genericas del tipo Carta
	public void envioImagenesManoMonstruoVista(ArrayList<CartaMonstruo> monstruos, JPanel mano,
			HashMap<JPanel, CartaMonstruo> hashMano) {
		for (CartaMonstruo cartaMonstruo : monstruos) {
			JPanel panel = this.vista.agregoCartaManoBot(this.modelo.generoImagenCarta(cartaMonstruo), mano);
//			panel.addMouseListener(new ControladorProyeccionCartas(this.vista,this));


			panel.addMouseListener(c);
			panel.setVisible(true);
			panel.setFocusable(true);
			this.generoArrayMonstruo(panel, cartaMonstruo, hashMano);
			this.vista.getManoBot().setFocusable(true);
		}
		this.vista.getManoBot().setFocusable(true);

		this.vista.getTablero().setVisible(true);
		
//	this.vista.getManoBot().addMouseListener(c);
	}

//Si tengo 3 cartas hechizo en la mano, por ejemplo, se cargaran 3 imagenes.
	public void envioImagenesHechizoVista(ArrayList<CartaHechizo> cartas, JPanel mano) {
		for (Carta carta : cartas) {
			this.vista.agregoCartaManoBot(this.modelo.generoImagenCarta(carta), mano);
		}

	}

	public void generoArrayMonstruo(JPanel panel, CartaMonstruo monstruo, HashMap<JPanel, CartaMonstruo> monstruos) {
		monstruos.put(panel, monstruo);
		this.setManoMonstruoOponente(monstruos);
	}

	public void generoArrayHechizo(JPanel panel, CartaHechizo monstruo, HashMap<JPanel, CartaHechizo> hechizos) {
		hechizos.put(panel, monstruo);
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
