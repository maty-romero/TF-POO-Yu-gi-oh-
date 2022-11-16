package controlador;

import java.awt.Component;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Random;

import javax.swing.JLabel;
import javax.swing.JPanel;

import exepciones.PierdeLaPartida;
import modelo.Carta;
import modelo.CartaHechizo;
import modelo.CartaMonstruo;

public class CerebroBot {

	private TableroController tc;
	private Random rnd = new Random();
	private CartaMonstruo monstruoAtacante;
	private CartaMonstruo monstruoObjetivo;
	private HashMap hash;

	String informeBot = ""; //para mostrar los resultados del turno del bot. 
	
	public CerebroBot(TableroController tc) {
		this.tc = tc;
	}

	// ROBAR CARTA

	public void robarCarta() throws PierdeLaPartida {
		this.informeBot += this.getTc().getDuelistaOponente().getNombre() + " ha robado una carta\n"; 
		
		this.getTc().getDuelistaOponente().robarCarta();
		// en el modelo ya se elimina y retorna una carta.

		System.out.println("");
		System.out.println(
				"Size mano monstruos Bot: " + this.getTc().getDuelistaOponente().getMano().getManoMonstruos().size());
		System.out.println(
				"Size mano hechizos Bot: " + this.getTc().getDuelistaOponente().getMano().getManoHechizos().size());

		this.getTc().getVista().getManoBot().removeAll();

		this.getTc().setManoBot();
		
		this.getTc().getVista().mostrar(); // Actualizo JFrame
	}

	// INVOCAR

	public void invocarCarta() {
		
		// Invocacion carta monstruo
		if (rnd.nextBoolean()) {

			// si hay cartas monstruo en la mano --> Invoco un monstruo
			if (this.getTc().getManoMonstruoOponente().size() >= 1) {
				
				// Obtengo una posicion vacia para invocar
				Integer posi = this.getTc().getReferee()
						.posVaciaCampo((this.getTc().getVista().getPanelesMonstruosCampoOponente()));
				if (posi != null) {
					this.informeBot += this.getTc().getDuelistaOponente().getNombre() + " ha invocado un monstruo\n"; 
					
					// obtengo un panel aleatorio de la mano
					JPanel panelAleatorio = panelAleatorio(this.getTc().getManoMonstruoOponente());
					panelAleatorio.setVisible(false);

					// remuevo el item asociado al keyPanel asociado y obtengo el monstruo
					CartaMonstruo monstruo = this.getTc().getManoMonstruoOponente().remove(panelAleatorio);
					// remuveme el monstruo del modelo -> Mano
					this.getTc().getDuelistaOponente().getMano().getManoMonstruos().remove(monstruo);
					monstruo.setPosicionAtaque(true);

					System.out.println("Monstruo por invocar - BOT: " + monstruo);

					// obtengo un panel con un label dado un monstruo.
					JPanel panelMonstruo = panelCustomizadoCarta(monstruo);

					this.getTc().getCampoMonstruosOponente().put(panelMonstruo, monstruo); // Se agrega al hash

					// se agrega una carta al campo Monstruo Oponente a la vista

					this.getTc().getVista().getPanelesMonstruosCampoOponente().get(posi).add(panelMonstruo);
				}
				this.getTc().getVista().mostrar(); // Actualizo JFrame
			}

		} else { // invocacion carta Hehizo

			// si hay cartas hechizo en la mano --> Invoco un monstruo
			if (this.getTc().getManoHechizoOponente().size() >= 1
					&& this.getTc().getCampoMonstruosOponente().size() >= 1) {

				// Obtengo una posicion vacia para invocar
				Integer posi = this.getTc().getReferee()
						.posVaciaCampo((this.getTc().getVista().getPanelesHechizosCampoOponente()));
				if (posi != null) {
					this.informeBot += this.getTc().getDuelistaOponente().getNombre() + " invocado un hechizo\n"; 
					
					// obtengo un panel aleatorio.
					JPanel panelAleatorio = panelAleatorio(this.getTc().getManoHechizoOponente());
					panelAleatorio.setVisible(false);

					// remuevo el item asociado al keyPanel asociado y obtengo el monstruo
					CartaHechizo hechizo = this.getTc().getManoHechizoOponente().remove(panelAleatorio);
					// remuveme el monstruo del modelo -> Mano
					this.getTc().getDuelistaOponente().getMano().getManoHechizos().remove(hechizo);
					this.getTc().getVista().mostrar();

					System.out.println("Hechizo por invocar - BOT: " + hechizo);

					// obtengo un panel con un label dado un hechizo.
					JPanel panelHechizo = panelCustomizadoCarta(hechizo);

					this.getTc().getCampoHechizosOponente().put(panelHechizo, hechizo); // Se agrega al hash

					// se agrega una carta al campo Monstruo Oponente a la vista
					this.getTc().getVista().getPanelesHechizosCampoOponente().get(posi).add(panelHechizo);

					this.getTc().getCampoHechizosOponente().get(panelHechizo).aplicarEfectoMagicoAMonstruo(hechizo,
							this.getTc().getCampoMonstruosOponente()
									.get((panelAleatorio(this.getTc().getCampoMonstruosOponente()))));

//					this.getTc().getReferee().remuevoPanelCampoHechizo(panelHechizo,
//							this.getTc().getCampoHechizosOponente(),
//							this.getTc().getVista().getPanelesHechizosCampoOponente());
					this.getTc().getVista().mostrar(); // Actualizo JFrame

				} else {
					this.getTc().getReferee().remuevoHechizosCampoDuelista(this.getTc().getCampoHechizosOponente(),
							this.getTc().getVista().getPanelesHechizosCampoOponente());
					this.getTc().getVista().mostrar(); // Actualizo JFrame

				}

			}
		}
	}

	// retorna un panel aleatorio, dado un hash map.
	private JPanel panelAleatorio(HashMap<JPanel, ?> hash) {
		List<JPanel> keysAsArray = new ArrayList<JPanel>(hash.keySet());
		JPanel panelAleatorio = keysAsArray.get(rnd.nextInt(keysAsArray.size())); // obtengo una clave aleatoria
		return panelAleatorio;
	}

	// devuelve un panel con un label dado un monstruo.
	private JPanel panelCustomizadoCarta(Carta carta) {
		// creo un label con la imagen del monstruo
		JLabel label = this.getTc().getVista().generoImagenCarta(carta);
		// lo focuseo y le agrego el label al panel
		JPanel panel = this.getTc().getVista().devuelvoPanelCampo(label);
		return panel;
	}

	/*
	 * Retorna la primera posicion del array en donde esta vacio, para poder invocar
	 * en el tablero.
	 */

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

	public void Batalla() throws PierdeLaPartida {

		// si hay monstruos en el campoMonstruosOponente es posible atacar
		if (this.getTc().getCampoMonstruosOponente().size() > 0) {

			// obtengo un panel y monstruo aleatorio del campo monstruo del BOT

			// obtengo un panel aleatorio del monstruo Atacante.
			JPanel panelMonstruoAtacante = panelAleatorio(this.getTc().getCampoMonstruosOponente());

			// obtengo el monstruo aleatorio
			this.monstruoAtacante = this.getTc().getCampoMonstruosOponente().get(panelMonstruoAtacante);

			// si no tiene monstruos el Jugador --> AtaqueDirecto
			if (this.getTc().getCampoMonstruosJugador().size() == 0) {
				
				System.out.println("El duelista Jugador no tiene Defensa! --> ATAQUE DIRECTO");
				monstruoAtacante.ataqueDirecto(this.getTc().getDuelistaJugador(), monstruoAtacante);
				actualizarVida();
				
				this.informeBot += this.getTc().getDuelistaOponente().getNombre() + " ha atacado con: "+ monstruoAtacante.getNombre()+ "\nDaño causado: " 
						+ monstruoAtacante.getAtaque() + "\n"; 

			} else {

				System.out.println("El duelista Jugador tiene Defensa! --> ATAQUE COMPUESTO");	
				
				// Obtengo el panelObjetivo y MonstruoObjetivo del Duelista Jugador

				// obtengo un panel aleatorio del monstruo Atacante.
				JPanel panelMonstruoObjetivo = panelAleatorio(this.getTc().getCampoMonstruosJugador());
				// obtengo el monstruo aleatorio
				this.monstruoObjetivo = this.getTc().getCampoMonstruosJugador().get(panelMonstruoObjetivo);
				if (monstruoObjetivo.getBocaAbajo() == true) {
					this.getTc().getReferee().rotarCartaMonstruo(panelMonstruoObjetivo);
				}
				Integer vidaAnterior = this.getTc().getDuelistaJugador().getVida(); //utilizado para el informe 
				
				monstruoAtacante.AccionCarta(monstruoObjetivo, this.getTc().getDuelistaOponente(),
						this.getTc().getDuelistaJugador());

				actualizarPanelesyHash(panelMonstruoAtacante, panelMonstruoObjetivo); // remover paneles de cartas
																						// muertas.

				actualizarVida(); // se actualiza la vida de los Duelistas
				
				this.informeBot += this.getTc().getDuelistaOponente().getNombre() + " ha atacado con: "+monstruoAtacante.getNombre()+ 
						"\nal monstruo: " +monstruoObjetivo.getNombre()+ "\nDaño causado: " + 
						(vidaAnterior - this.getTc().getDuelistaJugador().getVida()) + "\n"; 

			}

		}

	}

	// actualiza la vida de los duelistas.
	private void actualizarVida() throws PierdeLaPartida {

		// obtengo la vida vida de los duelistas en String --> Para el JLabel
		String vidaDuelistaJugador = String.valueOf(this.getTc().getDuelistaJugador().getVida());
		String vidaDuelistaOponente = String.valueOf(this.getTc().getDuelistaOponente().getVida());
		// seteo la nueva vida en la vista

		this.getTc().getVista().getContadorBot().setText(vidaDuelistaOponente);
		this.getTc().getVista().getContadorJug().setText(vidaDuelistaJugador);

		this.getTc().getVista().mostrar(); // actualizo JFrame.

		verificaDuelistasMuertos();

	}

	private void verificaDuelistasMuertos() throws PierdeLaPartida {

		if (this.getTc().getDuelistaJugador().getVida() <= 0) {
			throw new PierdeLaPartida("El duelista " + this.getTc().getDuelistaJugador().getNombre() + " ha perdido.");
		}
		if (this.getTc().getDuelistaOponente().getVida() <= 0) {
			throw new PierdeLaPartida("El duelista " + this.getTc().getDuelistaOponente().getNombre() + " ha perdido.");
		}

	}

	// actualiza los panales luego de la batalla (si necesitan ser removidos).
	private void actualizarPanelesyHash(JPanel panelAtacante, JPanel panelObjetivo) {

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
			this.getTc().getCampoMonstruosOponente().remove(panelAtacante);
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
			this.getTc().getCampoMonstruosJugador().remove(panelObjetivo);

		}

	}

	
	// Getters y setters
	public TableroController getTc() {
		return tc;
	}

	public void setTc(TableroController tc) {
		this.tc = tc;
	}

	public String getInformeBot() {
		return informeBot;
	}

	public void setInformeBot(String informeBot) {
		this.informeBot = informeBot;
	}

	
	
}
