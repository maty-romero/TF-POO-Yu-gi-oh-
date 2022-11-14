package controlador;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.image.BufferedImage;
import java.util.ArrayList;
import java.util.HashMap;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JPopupMenu;

import modelo.Carta;
import modelo.CartaHechizo;
import modelo.CartaMonstruo;
import modelo.Duelista;
import vista.VistaTablero;

public class TableroController {
	private ControladorProyeccionCartas controladorProyeccionCartas;

	private ControladorBatalla controladorBatalla;
	private CerebroBot controladorBot;
	private Referee referee;
	private Duelista duelistaJugador, duelistaOponente;

	private HashMap<JPanel, CartaMonstruo> manoMonstruoOponente = new HashMap<JPanel, CartaMonstruo>();
	private HashMap<JPanel, CartaHechizo> manoHechizoOponente = new HashMap<JPanel, CartaHechizo>();
	private HashMap<JPanel, CartaMonstruo> manoMonstruoJugador = new HashMap<JPanel, CartaMonstruo>();
	private HashMap<JPanel, CartaHechizo> manoHechizoJugador = new HashMap<JPanel, CartaHechizo>();

	// cartas del campo del jugador
	private HashMap<JPanel, CartaMonstruo> campoMonstruosJugador = new HashMap<JPanel, CartaMonstruo>();
	private HashMap<JPanel, CartaHechizo> campoHechizosJugador = new HashMap<JPanel, CartaHechizo>();

	// cartas del campo del Oponente
	private HashMap<JPanel, CartaMonstruo> campoMonstruosOponente = new HashMap<JPanel, CartaMonstruo>();
	private HashMap<JPanel, CartaHechizo> campoHechizosOponente = new HashMap<JPanel, CartaHechizo>();

	private JPanel panelCarta;
	private VistaTablero vista;
//	private JPopupMenu pm;
//	private MouseListener mouse;

//	private MouseListener mouseBatalla; 

	public TableroController() {

		VistaTablero vista = new VistaTablero(this);
		this.vista = vista;

//		mouse = new MonstruosInvocacion(this);
		this.controladorProyeccionCartas = new ControladorProyeccionCartas(this);
		this.referee = new Referee(this);
		this.duelistaJugador = new Duelista("YUGI", 1);
		this.duelistaOponente = new Duelista("KIRA", 2);

//		duelistaJugador.robarCarta();
//		duelistaJugador.robarCarta();
//		duelistaOponente.robarCarta();
//		duelistaOponente.robarCarta();
//
//		this.duelistaJugador.robarCarta();
//		this.duelistaJugador.robarCarta();

		// MONSTRUO JUGADOR
// 		ArrayList<CartaMonstruo> monstruosJugador = duelistaJugador.getMano().getManoMonstruos();
//		monstruosJugador.add(new CartaMonstruo(20, "20", "20", "/hechizos/dark_magician.jpg", 1000, 1000));
//		ArrayList<CartaHechizo> hechizo = duelistaJugador.getMano().getManoHechizos();
//		hechizo.add(new CartaHechizo(12, "hola", "carta bufeadora", "/hechizos/messenger_of_peace.jpg", 10000));

//		this.duelistaJugador.robarCarta();
//		this.duelistaJugador.robarCarta();
//		this.duelistaJugador.robarCarta();

		// Monstruo BOT prueba
//
//		System.out.println("COLOCO CARTAS EN CAMPO DEL BOT Y EN EL HASH");
//		CartaMonstruo monstruo1 = new CartaMonstruo(1, "hola", "jaja", "/monstruos/Acid_Crawler_04_.jpg", 300, 300);
//		monstruo1.setPosicionAtaque(true); // SETEO POS ATQUE

		// JLabel label1 = this.getVista().generoImagenCarta(monstruo1);
		// JPanel panel1 = this.getVista().devuelvoPanelCampo(label1); // lo focuseo y
		// le agrego el label al panel

		// Se agrega al hash
		// this.campoMonstruosOponente.put(panel1, monstruo1);
		// se agrega una carta al campo Monstruo Oponente a la vista
		// this.getVista().getPanelesMonstruosCampoOponente().get(0).add(panel1);
		this.controladorBot = new CerebroBot(this);

		try {
			this.duelistaJugador.robarCarta();
			this.duelistaJugador.robarCarta();
			this.duelistaJugador.robarCarta();
			this.duelistaJugador.robarCarta();
			this.duelistaJugador.robarCarta();
			this.duelistaJugador.robarCarta();
			this.duelistaJugador.robarCarta();
			// setteo monstruos usando HashMap
			this.setManoMonstruoOponente(this.envioImagenesManoMonstruoVista(
					duelistaOponente.getMano().getManoMonstruos(), this.vista.getManoBot()));
			Thread.sleep(330);
			this.setManoMonstruoJugador(this.envioImagenesManoMonstruoVista(
					duelistaJugador.getMano().getManoMonstruos(), this.vista.getManoJugador()));

			// setteo hechizos usando HashMap
			this.setManoHechizoOponente(this.envioImagenesManoHechizoVista(duelistaOponente.getMano().getManoHechizos(),
					this.vista.getManoBot()));
			this.setManoHechizoJugador(this.envioImagenesManoHechizoVista(duelistaJugador.getMano().getManoHechizos(),
					this.vista.getManoJugador()));

			this.aniadoMouseListenerMonstruo(this.manoMonstruoJugador);
			this.aniadoMouseListenerHechizo(this.manoHechizoJugador);

			this.vista.getTablero().setVisible(true); // Actualizo el JFrame
			System.out.println(
					"Size Deck Monstruos - BOT: " + this.getDuelistaOponente().getDeck().getMonstruos().size());
			System.out
					.println("Size Deck Hechizos - BOT: " + this.getDuelistaOponente().getDeck().getHechizos().size());

//			//INVOCACION POR FUERZA - MONSTRUO EN CAMPO JUGADOR --> CartaObjetivo

//			System.out.println("COLOCO CARTAS EN CAMPO DEL JUGADOR Y EN EL HASH");
//			CartaMonstruo monstruo2 = new CartaMonstruo(2, "hola", "jaja", "/monstruos/Acid_Crawler_04_.jpg", 1200, 1200); 
//			monstruo2.setPosicionAtaque(true); //SETEO POS ATQUE 
//			
//			JLabel label2 = this.getVista().generoImagenCarta(monstruo2); 
//			JPanel panel2 = this.getVista().devuelvoPanelCampo(label2);  //lo focuseo y le agrego el label al panel 
//		
//			//Se agrega al hash 
//			this.campoMonstruosJugador.put(panel2, monstruo2); 
//			//se agrega una carta al campo Monstruo Oponente a la vista 
//			this.getVista().getPanelesMonstruosCampoJugador().get(0).add(panel2); 

			try {
//				
				this.duelistaJugador.robarCarta();
				this.controladorBot.robarCarta();
//				Thread.sleep(1000);
				this.controladorBot.robarCarta();
//				Thread.sleep(1000);

				this.controladorBot.robarCarta();
				this.controladorBot.robarCarta();
				this.controladorBot.robarCarta();
				this.controladorBot.robarCarta();
				this.controladorBot.robarCarta();
				this.controladorBot.robarCarta();
				this.controladorBot.robarCarta();
				this.controladorBot.robarCarta();
				this.controladorBot.robarCarta();

////				Thread.sleep(1000);
//			//----------

//				Thread.sleep(1000);
//			//-----
//				this.controladorBot.robarCarta();
//				Thread.sleep(1000);
//
//				this.controladorBot.robarCarta();
//				Thread.sleep(1000);
//			//-----	
				this.controladorBot.invocarCarta();
				this.controladorBot.invocarCarta();
				this.controladorBot.invocarCarta();
				this.controladorBot.invocarCarta();
//				Thread.sleep(1000);
//				this.controladorBot.invocarCarta();


//				this.controladorBot.Batalla();
			} catch (Exception e) {
				e.printStackTrace();
			}

//			System.out.println("Fin ejecucion Bot");

		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	/*
	 * traigo las cartas cargadas con informacion desde base de datos, y las asocio
	 * con un panel que creo a partir traer una imagen desde el modelo y cargar esa
	 * imagen en el panel en la vista. Luego traigo ese panel y lo asocio a la carta
	 * de la cual saqué esa imagen
	 * 
	 * me sirve tener metodos separados; de monstruo y hechizo, porque luego en el
	 * hash de monstruos solo van a ir monstruos, y no cartas genericas del tipo
	 * Carta
	 */

	public HashMap<JPanel, CartaMonstruo> envioImagenesManoMonstruoVista(ArrayList<CartaMonstruo> monstruos,
			JPanel mano) {
		HashMap<JPanel, CartaMonstruo> hashAuxiliar = new HashMap<JPanel, CartaMonstruo>();
		for (CartaMonstruo cartaMonstruo : monstruos) {
			// Genero la imagen de esa cartaMonstruo en el modelo, y junto al panel mano que
			// traigo directo desde la vista, mando ambos a la vista para que me asocie esa
			// imagen a esa mano (meto en el panel mano, el otro panel que le inserté esa
			// imagen traida desde el modelo)
			panelCarta = this.vista.agregoCartaMano(this.vista.generoImagenCarta(cartaMonstruo), mano);
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
			panelCarta = this.vista.agregoCartaMano(this.vista.generoImagenCarta(cartaHechizo), mano);
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

			// Turno Jugador

			// Turno BOT
			this.controladorBot.robarCarta();
			this.controladorBot.invocarCarta();
			this.controladorBot.Batalla();

			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}

		}

	}

	private void aniadoMouseListenerMonstruo(HashMap<JPanel, CartaMonstruo> hash) {
		for (JPanel cartaPanel : hash.keySet()) {
			cartaPanel.addMouseListener(new MonstruosInvocacion(this));
		}
	}

	private void aniadoMouseListenerHechizo(HashMap<JPanel, CartaHechizo> hash) {
		for (JPanel cartaPanel : hash.keySet()) {
			cartaPanel.addMouseListener(new ManuHechizos(this));
		}
	}

	public VistaTablero getVista() {
		return vista;
	}

	public void setVista(VistaTablero vista) {
		this.vista = vista;
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

	// CAMPO JUGADOR
	public HashMap<JPanel, CartaMonstruo> getCampoMonstruosJugador() {
		return campoMonstruosJugador;
	}

	public void setCampoMonstruosJugador(HashMap<JPanel, CartaMonstruo> campoMonstruosJugador) {
		this.campoMonstruosJugador = campoMonstruosJugador;
	}

	public HashMap<JPanel, CartaHechizo> getCampoHechizosJugador() {
		return campoHechizosJugador;
	}

	public void setCampoHechizosJugador(HashMap<JPanel, CartaHechizo> campoHechizosJugador) {
		this.campoHechizosJugador = campoHechizosJugador;
	}

	public HashMap<JPanel, CartaMonstruo> getCampoMonstruosOponente() {
		return campoMonstruosOponente;
	}

	public void setCampoMonstruosOponente(HashMap<JPanel, CartaMonstruo> campoMonstruosOponente) {
		this.campoMonstruosOponente = campoMonstruosOponente;
	}

	public HashMap<JPanel, CartaHechizo> getCampoHechizosOponente() {
		return campoHechizosOponente;
	}

	public void setCampoHechizosOponente(HashMap<JPanel, CartaHechizo> campoHechizosOponente) {
		this.campoHechizosOponente = campoHechizosOponente;
	}

	public Duelista getDuelistaJugador() {
		return duelistaJugador;
	}

	public void setDuelistaJugador(Duelista duelistaJugador) {
		this.duelistaJugador = duelistaJugador;
	}

	public Duelista getDuelistaOponente() {
		return duelistaOponente;
	}

	public void setDuelistaOponente(Duelista duelistaOponente) {
		this.duelistaOponente = duelistaOponente;
	}

	public Referee getReferee() {
		return referee;
	}

	public void setReferee(Referee referee) {
		this.referee = referee;
	}

}
