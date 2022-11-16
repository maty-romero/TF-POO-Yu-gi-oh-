package controlador;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.image.BufferedImage;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JPopupMenu;

import exepciones.PierdeLaPartida;
import modelo.Carta;
import modelo.CartaHechizo;
import modelo.CartaMonstruo;
import modelo.CartaMonstruoNormal;
import modelo.Duelista;
import vista.VistaTablero;

public class TableroController {
	private Boolean partidaFinalizada;

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

	public TableroController() {

		VistaTablero vista = new VistaTablero(this);
		this.vista = vista;
		this.controladorProyeccionCartas = new ControladorProyeccionCartas(this);
		this.duelistaJugador = new Duelista("YUGI");
		this.duelistaOponente = new Duelista("SETTO");

		this.controladorBot = new CerebroBot(this);
		this.referee = new Referee(this);

		try {
			this.duelistaJugador.robarCarta();
			this.duelistaJugador.robarCarta();
			this.duelistaJugador.robarCarta();
			this.duelistaJugador.robarCarta();
			this.duelistaJugador.robarCarta();

            this.controladorBot.robarCarta();
            this.controladorBot.robarCarta();
            this.controladorBot.robarCarta();
            this.controladorBot.robarCarta();
            this.controladorBot.robarCarta();

            this.setManoJugador();
			this.vista.getTablero().setVisible(true); // Actualizo el JFrame

			System.out.println(
					"Size Deck Monstruos - BOT: " + this.getDuelistaOponente().getDeck().getMonstruos().size());
			System.out
					.println("Size Deck Hechizos - BOT: " + this.getDuelistaOponente().getDeck().getHechizos().size());

			// INICIO DE PARTIDA
			Boton boton = new Boton(this);
			this.getVista().getBtnTerminarTurno().addActionListener(boton);

		} catch (PierdeLaPartida e1) {
			System.out.println(e1.getMessage());
			this.getVista().getTablero().dispose();
		}

	}

	public void setManoJugador() {
		this.setManoMonstruoJugador(this.envioImagenesManoMonstruoVista(duelistaJugador.getMano().getManoMonstruos(),
				this.vista.getManoJugador()));
		this.setManoHechizoJugador(this.envioImagenesManoHechizoVista(duelistaJugador.getMano().getManoHechizos(),
				this.vista.getManoJugador()));

		this.aniadoMouseListenerMonstruo(this.manoMonstruoJugador);
		this.aniadoMouseListenerHechizo(this.manoHechizoJugador);
	}

	public void setManoBot() {
		this.setManoMonstruoOponente(this.envioImagenesManoMonstruoVista(duelistaOponente.getMano().getManoMonstruos(),
				this.vista.getManoBot()));
		this.setManoHechizoOponente(this.envioImagenesManoHechizoVista(duelistaOponente.getMano().getManoHechizos(),
				this.vista.getManoBot()));
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
		if (mano == this.vista.getManoJugador()) {
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
		} else {
			for (CartaMonstruo cartaMonstruo : monstruos) {
				// Genero la imagen de esa cartaMonstruo en el modelo, y junto al panel mano que
				// traigo directo desde la vista, mando ambos a la vista para que me asocie esa
				// imagen a esa mano (meto en el panel mano, el otro panel que le inserté esa
				// imagen traida desde el modelo)
				panelCarta = this.getVista().agregoCartaManoDefault(this.vista.generoBocaAbajoDefault(), mano);

				panelCarta.setVisible(true);
				panelCarta.setFocusable(true);
				hashAuxiliar.put(panelCarta, cartaMonstruo);

				this.vista.getManoBot().setFocusable(true);
			}
			this.vista.getManoBot().setFocusable(true);

			this.vista.getTablero().setVisible(true);
			return hashAuxiliar;
		}

	}

	public HashMap<JPanel, CartaHechizo> envioImagenesManoHechizoVista(ArrayList<CartaHechizo> hechizos, JPanel mano) {
		HashMap<JPanel, CartaHechizo> hashAuxiliar = new HashMap<JPanel, CartaHechizo>();
		if (mano == this.vista.getManoJugador()) {
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
		} else {
			for (CartaHechizo cartaHechizo : hechizos) {
				// Genero la imagen de esa cartaMonstruo en el modelo, y junto al panel mano que
				// traigo directo desde la vista, mando ambos a la vista para que me asocie esa
				// imagen a esa mano (meto en el panel mano, el otro panel que le inserté esa
				// imagen traida desde el modelo)
				panelCarta = this.getVista().agregoCartaManoDefault(this.vista.generoBocaAbajoDefault(), mano);
				panelCarta.setVisible(true);
				panelCarta.setFocusable(true);

				hashAuxiliar.put(panelCarta, cartaHechizo);

				this.vista.getManoBot().setFocusable(true);
			}
			this.vista.getManoBot().setFocusable(true);

			this.vista.getTablero().setVisible(true);
			return hashAuxiliar;

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

	public Boolean getPartidaFinalizada() {
		return partidaFinalizada;
	}

	public void setPartidaFinalizada(Boolean partidaFinalizada) {
		this.partidaFinalizada = partidaFinalizada;
	}

	public CerebroBot getControladorBot() {
		return controladorBot;
	}

	public void setControladorBot(CerebroBot controladorBot) {
		this.controladorBot = controladorBot;
	}

	public Referee getReferee() {
		return referee;
	}

	public void setReferee(Referee referee) {
		this.referee = referee;
	}

}
