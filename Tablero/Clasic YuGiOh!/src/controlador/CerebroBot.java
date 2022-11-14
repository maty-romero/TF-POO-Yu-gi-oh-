package controlador;

import java.awt.Component;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import javax.swing.JLabel;
import javax.swing.JPanel;

import exepciones.PierdeLaPartida;
import modelo.CartaHechizo;
import modelo.CartaMonstruo;

public class CerebroBot {

	private TableroController tc;
	private Random rnd = new Random();
	private CartaMonstruo monstruoAtacante;
	private CartaMonstruo monstruoObjetivo;
	/*
	 * Los sleeps pueden estar en el metodo Partida de TableroController o en cada
	 * metodo del Bot.
	 */

	public CerebroBot(TableroController tc) {
		this.tc = tc;
	}

	// ROBAR CARTA

	public void robarCarta() {
		try {
			
			System.out.println("BOT Roba una carta");
			this.getTc().getDuelistaOponente().robarCarta(); // en el modelo ya se elimina y retorna una carta.
			
			System.out.println("");
			System.out.println(
					"Size mano monstruos Bot: " + this.getTc().getDuelistaOponente().getMano().getManoMonstruos().size());
			System.out.println(
					"Size mano hechizos Bot: " + this.getTc().getDuelistaOponente().getMano().getManoHechizos().size());

			this.getTc().getVista().getManoBot().removeAll();

			// se setean los hash.
			this.getTc().setManoMonstruoOponente(this.getTc().envioImagenesManoMonstruoVista(
					this.getTc().getDuelistaOponente().getMano().getManoMonstruos(), this.getTc().getVista().getManoBot()));

			this.getTc().setManoHechizoOponente(this.getTc().envioImagenesManoHechizoVista(
					this.getTc().getDuelistaOponente().getMano().getManoHechizos(), this.getTc().getVista().getManoBot()));

			 this.getTc().getVista().mostrar(); //Actualizo JFrame
			
			
		} catch (PierdeLaPartida e) {
			System.out.println(e.getMessage());
			this.getTc().getVista().getTablero().dispose();
		}
		
		

		
		
	}

	// INVOCAR

	// --> Consistir desde el flujo de partida si es posible realizar una
	// invocacion.

	public void invocarCarta() {

		// Invocacion carta monstruo
		if (rnd.nextBoolean()) {

			if(this.getTc().getManoMonstruoOponente().size() >= 1) {
				// sacar un monstruo de un elemento del hash y eliminar el item del hash

				//Convierto las claves en una lista 
				List<JPanel> keysAsArray = new ArrayList<JPanel>(this.getTc().getManoMonstruoOponente().keySet()); 
				JPanel panelAleatorio = keysAsArray.get(rnd.nextInt(keysAsArray.size())); // obtengo una clave aleatoria

				panelAleatorio.setVisible(false);

				// remuevo el item asociado al keyPanel asociado y obtengo el monstruo
				CartaMonstruo monstruo = this.getTc().getManoMonstruoOponente().remove(panelAleatorio);
				monstruo.setPosicionAtaque(rnd.nextBoolean()); // XXXXXXXXXXXXXXXXXXXXX
				
				System.out.println("Monstruo por invocar - BOT: " + monstruo);

				JLabel label = this.getTc().getVista().generoImagenCarta(monstruo); // creo un label con la imagen del
																					// monstruo
				JPanel panel = this.getTc().getVista().devuelvoPanelCampo(label); // lo focuseo y le agrego el label al
																					// panel

				this.getTc().getCampoMonstruosOponente().put(panel, monstruo); // Se agrega al hash

				// Obtengo una posicion vacia para invocar
				Integer posi = posVaciaCampo(this.getTc().getVista().getPanelesMonstruosCampoOponente());

				// se agrega una carta al campo Monstruo Oponente a la vista
				this.getTc().getVista().getPanelesMonstruosCampoOponente().get(posi).add(panel);

				this.getTc().getVista().mostrar(); // Actualizo JFrame
			}
			

			// invocacion carta Hehizo
		} else {

			if(this.getTc().getManoHechizoOponente().size() >= 1) {
				// convierto las claves en una lista. 
				List<JPanel> keysAsArray = new ArrayList<JPanel>(this.getTc().getManoHechizoOponente().keySet()); 
				JPanel panelAleatorio = keysAsArray.get(rnd.nextInt(keysAsArray.size())); // obtengo una clave aleatoria

				panelAleatorio.setVisible(false);

				// remuevo el item asociado al keyPanel asociado y obtengo el monstruo
				CartaHechizo hechizo = this.getTc().getManoHechizoOponente().remove(panelAleatorio);

				System.out.println("Hechizo por invocar - BOT: " + hechizo);

				JLabel label = this.getTc().getVista().generoImagenCarta(hechizo); // creo un label con la imagen del
																					// monstruo
				JPanel panel = this.getTc().getVista().devuelvoPanelCampo(label); // lo focuseo y le agrego el label al
																					// panel
				this.getTc().getCampoHechizosOponente().put(panel, hechizo); // Se agrega al hash

				// Obtengo una posicion vacia para invocar
				Integer posi = posVaciaCampo(this.getTc().getVista().getPanelesHechizosCampoOponente());

				// se agrega una carta al campo Monstruo Oponente a la vista
				this.getTc().getVista().getPanelesHechizosCampoOponente().get(posi).add(panel);

				this.getTc().getVista().mostrar(); // Actualizo JFrame
			}
			
		}

	}

	
	// Retorna la primera posicion del array en donde esta vacio, para poder invocar
	// en el tablero.
	private Integer posVaciaCampo(ArrayList<JPanel> paneles) {
		Integer posicion = null;
		for (int i = 0; i < paneles.size(); i++) {
			if (paneles.get(i) != null) {
				posicion = i;
			}
		}
		return posicion;
	}

	// BATALLA

	/*
	 * Turno del Bot:
	 * 
	 * monstruoMuertoJugador --> Bot monstruoMuertoOponente --> Jugador
	 * 
	 * Lo siguiente esta escrito desde nuestra perspectiva.
	 * 
	 * CartaJug posAtaque = true
	 * 
	 * dmg > 0 -> CartaJugador muere, recibe dmg restante el Jugador dmg < 0 ->
	 * CartaBot muere, Bot recibe dmg restante dmg = 0 -> ambas cartas mueren, no
	 * hay dmg restante
	 * 
	 * CartaJug posAtaque = false dmg > 0 -> CartaJugador muere dmg < 0 -> Bot
	 * recibe dmg restante.
	 * 
	 * 
	 */

	public void Batalla() {


		// si hay monstruos en el campoMonstruosOponente es posible atacar
		if (this.getTc().getCampoMonstruosOponente().size() > 0) {

			// obtengo un panel y monstruo aleatorio del campo monstruo del BOT
			
			// convierto las claves en una lista.
			List<JPanel> keysBot = new ArrayList<JPanel>(this.getTc().getCampoMonstruosOponente().keySet()); 
			JPanel panelMonstruoAtacante = keysBot.get(rnd.nextInt(keysBot.size())); // obtengo una clave aleatoria

			//obtengo el monstruo aleatorio
			this.monstruoAtacante = this.getTc().getCampoMonstruosOponente().get(panelMonstruoAtacante); 

			// si no tiene monstruos el Jugador --> AtaqueDirecto
			if (this.getTc().getCampoMonstruosJugador().size() == 0) {
				System.out.println("El duelista Jugador no tiene Defensa! --> ATAQUE DIRECTO");
				monstruoAtacante.ataqueDirecto(this.getTc().getDuelistaJugador(), monstruoAtacante);
				actualizarVida();

			} else { 

				System.out.println("El duelista Jugador tiene Defensa! --> ATAQUE COMPUESTO");

				// Obtengo el panelObjetivo y MonstruoObjetivo del Duelista Jugador
				
				// convierto las claves en una lista.
				List<JPanel> keysJugador = new ArrayList<JPanel>(this.getTc().getCampoMonstruosJugador().keySet()); 
				JPanel panelMonstruoObjetivo = keysJugador.get(rnd.nextInt(keysJugador.size())); // obtengo una clave
																									// aleatoria

				this.monstruoObjetivo = this.getTc().getCampoMonstruosJugador().get(panelMonstruoObjetivo); // obtengo
																														// el
																														// monstruo
																														// aleatorio

				monstruoAtacante.AccionCarta(monstruoObjetivo, this.getTc().getDuelistaOponente(),
						this.getTc().getDuelistaJugador());

				actualizarVida(); // se actualiza la vida de los Duelistas

				actualizarPaneles(panelMonstruoAtacante, panelMonstruoObjetivo); // remover paneles de cartas muertas.

			}

		}

	}

	// actualiza la vida de los duelistas.
	private void actualizarVida() {

		// obtengo la vida vida de los duelistas en String --> Para el JLabel
		String vidaDuelistaJugador = String.valueOf(this.getTc().getDuelistaJugador().getVida());
		String vidaDuelistaOponente = String.valueOf(this.getTc().getDuelistaOponente().getVida());
		// seteo la nueva vida en la vista

		this.getTc().getVista().getContadorBot().setText(vidaDuelistaOponente);
		this.getTc().getVista().getContadorJug().setText(vidaDuelistaJugador);

		this.getTc().getVista().mostrar(); // actualizo JFrame.
		
		verificaDuelistasMuertos();

	}

	private void verificaDuelistasMuertos() {
		try {
			if(this.getTc().getDuelistaJugador().getVida() <= 0) {
				throw new PierdeLaPartida("El duelista " + this.getTc().getDuelistaJugador().getNombre() + " ha perdido.");
			}
			if(this.getTc().getDuelistaOponente().getVida() <= 0) {
				throw new PierdeLaPartida("El duelista " + this.getTc().getDuelistaOponente().getNombre() + " ha perdido.");
			}
		} catch (Exception e) {
			System.out.println(e.getMessage());
			this.getTc().getVista().getTablero().dispose();
		}
		
	}
	
	/*
	 * EN BATALLA --> Turno del Bot
	 * 
	 * Monstruo muerto Jugador --> Pertence al bot Monstruo muerto Oponente -->
	 * Pertenece al Jugador
	 * 
	 * panelAtacante --> panel del Bot panelObjetivo --> panel del Jugador
	 * 
	 */

	// actualiza los panales luego de la batalla (si necesitan ser removidos).
	private void actualizarPaneles(JPanel panelAtacante, JPanel panelObjetivo) {

		// eliminacion panel monstruo del bot (monstruoAtacante)
		if (!this.monstruoAtacante.getConVida()) {
			System.out.println("Eliminacion Carta Bot");
			// Eliminacion panel en la vista.

			JPanel coincidencia = new JPanel();
			for (JPanel panel : this.getTc().getVista().getPanelesMonstruosCampoOponente()) {
				for (Component componente : panel.getComponents()) {
					if (componente == panelAtacante) {
						coincidencia = panel;
						componente.setVisible(false);
						System.out.println("Coincidencia - Eliminacion panel del BOT");
						break;
					}
				}
			}
			coincidencia.removeAll();
			coincidencia.setVisible(true);
			this.getTc().getVista().mostrar();
			this.getTc().getVista().getTablero().setVisible(true);
		}

		// eliminacion panel monstruo del Jugador (monstruoObjetivo)
		if (!this.monstruoObjetivo.getConVida()) {
			System.out.println("Eliminacion Carta Jugador");
			// Eliminacion panel en la vista.

			JPanel coincidencia = new JPanel();
			for (JPanel panel : this.getTc().getVista().getPanelesMonstruosCampoJugador()) {
				for (Component componente : panel.getComponents()) {
					if (componente == panelObjetivo) {
						coincidencia = panel;
						componente.setVisible(false);
						System.out.println("Coincidencia - Eliminacion panel del Jugador");
						break;
					}
				}
			}
			coincidencia.removeAll();
			coincidencia.setVisible(true);
			this.getTc().getVista().mostrar();
			this.getTc().getVista().getTablero().setVisible(true);
		}

	}

	// Getters y setters
	public TableroController getTc() {
		return tc;
	}

	public void setTc(TableroController tc) {
		this.tc = tc;
	}

}
