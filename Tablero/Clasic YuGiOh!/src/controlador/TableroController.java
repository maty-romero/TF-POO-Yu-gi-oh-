package controlador;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
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
import modelo.Duelista;
import vista.VistaTablero;

public class TableroController {
	private ControladorProyeccionCartas controladorProyeccionCartas;

	private ControladorBatalla controladorBatalla;
	private CerebroBot controladorBot;

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

	public TableroController(){

		VistaTablero vista = new VistaTablero(this);
		this.vista = vista;

//		mouse = new MonstruosInvocacion(this);
		this.controladorProyeccionCartas = new ControladorProyeccionCartas(this);

		this.duelistaJugador = new Duelista("YUGI", 1);
		this.duelistaOponente = new Duelista("KIRA", 2);

		this.controladorBot = new CerebroBot(this);
		
//		duelistaJugador.robarCarta();
//		duelistaJugador.robarCarta();
//		duelistaOponente.robarCarta();
//		duelistaOponente.robarCarta();
//
//		this.duelistaJugador.robarCarta();
//		this.duelistaJugador.robarCarta();
		
		//MONSTRUO JUGADOR 
		ArrayList<CartaMonstruo> monstruosJugador = duelistaJugador.getMano().getManoMonstruos();
		monstruosJugador.add(new CartaMonstruo(20, "20", "20", "/cartas/dark_magician.jpg", 1000, 20));
		
		
		
		try {
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

			
			
			//INICIO DE PARTIDA 
			
//			// los duelistas roban 5 cartas --> Actualizar la vista.
//			for (int i = 0; i < 2; i++) {
//				duelistaJugador.robarCarta();
//				this.controladorBot.robarCarta();
//			}
			
			duelistaJugador.robarCarta();
			 
		
			/*
			 * Al quedarse sin cartas o que la vida de los duelistas llegan a cero, 
			 * deberia de saltar una exepcion que termine la ejecucion del hilo principal y salte a la pantalla final. 
			 */
			
			HiloTurnoBot bot = new HiloTurnoBot(controladorBot);
			
			//Listener de btn Terminar Turno --> Comienza la ejecucion del hilo Bot
			this.getVista().getBtnTerminarTurno().addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					try {
						bot.start();
						bot.join();
						
						
					} catch (InterruptedException e1) {
						e1.printStackTrace();
					}
					
					try {
						duelistaJugador.robarCarta(); //se roba el turno y se le sede la ejecucion.
					} catch (PierdeLaPartida e1) {
						System.out.println(e1.getMessage());
						getVista().getTablero().dispose(); 
					} 
					
						
					 
				}
			});
			
//			this.Partida(); //Comienza la partida. 
			
			

		} catch (InterruptedException e) {
			e.printStackTrace();
		} catch (PierdeLaPartida e1) {
			System.out.println(e1.getMessage());
			this.getVista().getTablero().dispose(); 
		}
	}
	
	
	
	// flujo de la partida
		/*
		 * FASES: Robo, invocacion, batalla, invocacion, otro turno
		 * 
		 * 
		 */
	
//		private void Partida() {
//
//			List<String> fasesPartida = Arrays.asList("DRAW PHASE",  "MAIN PHASE" , "BATTLE PHASE"); 
//			
//			
//			
//////			List<String> fasesPartida = Arrays.asList("DRAW PHASE",  "MAIN PHASE" , "BATTLE PHASE");
////			System.out.println("afuera del while .");
////			
////			// mientras ninguno pierda, sigue la partida.
////				System.out.println("adentro del while . ");
//				// Turno Jugador
//				duelistaJugador.robarCarta();
//				
//			
//
//		}

//		private void turnoBot() {
//			
//			this.controladorBot.robarCarta();
//			this.controladorBot.invocarCarta();
//			
//			if(this.campoMonstruosOponente.size() > 0) {
//				this.controladorBot.Batalla();
//			}
//			
//
//			try {
//				Thread.sleep(1000);
//			} catch (InterruptedException e) {
//				e.printStackTrace();
//			}
//			
//			Partida(); //vuelve al flujo. 
//			
//			
//		}
	
	
	
	
	
	
	
	
	
	

	
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
	
	
	private void aniadoMouseListenerMonstruo(HashMap<JPanel, CartaMonstruo> hash) {
		for (JPanel cartaPanel : hash.keySet()) {
			cartaPanel.addMouseListener(new MonstruosInvocacion(this));

		}
	}

	private void aniadoMouseListenerHechizo(HashMap<JPanel, CartaHechizo> hash) {
		for (JPanel cartaPanel : hash.keySet()) {
			cartaPanel.addMouseListener(new HechizosInvocacion(this, false));
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


}
