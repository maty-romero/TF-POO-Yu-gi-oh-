package controlador;

import java.awt.Component;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Random;

import javax.swing.JLabel;
import javax.swing.JPanel;

import modelo.Carta;
import modelo.CartaHechizo;
import modelo.CartaMonstruo;

public class CerebroBot {

	private TableroController tc;
	private Random rnd = new Random();
	private CartaMonstruo monstruoAtacante;
	private CartaMonstruo monstruoObjetivo;
	private HashMap hash;

	public CerebroBot(TableroController tc) {
		this.tc = tc;
	}

	// ROBAR CARTA

	public void robarCarta() {

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

		this.getTc().getVista().mostrar(); // Actualizo JFrame
	}

	// INVOCAR

	// --> Consistir desde el flujo de partida si es posible realizar una
	// invocacion.

	public void invocarCarta() {

		// Invocacion carta monstruo
		if (rnd.nextBoolean()) {

			// si hay cartas monstruo en la mano --> Invoco un monstruo
			if (this.getTc().getManoMonstruoOponente().size() >= 1) {

				// obtengo un panel aleatorio.
				JPanel panelAleatorio = panelAleatorio(this.getTc().getManoMonstruoOponente());
				panelAleatorio.setVisible(false);

				// remuevo el item asociado al keyPanel asociado y obtengo el monstruo
				CartaMonstruo monstruo = this.getTc().getManoMonstruoOponente().remove(panelAleatorio);
				monstruo.setPosicionAtaque(true);

				System.out.println("Monstruo por invocar - BOT: " + monstruo);

				// obtengo un panel con un label dado un monstruo.
				JPanel panelMonstruo = panelCustomizadoCarta(monstruo);

				this.getTc().getCampoMonstruosOponente().put(panelMonstruo, monstruo); // Se agrega al hash

				// Obtengo una posicion vacia para invocar
				Integer posi = posVaciaCampo(this.getTc().getVista().getPanelesMonstruosCampoOponente());

				// se agrega una carta al campo Monstruo Oponente a la vista
				this.getTc().getVista().getPanelesMonstruosCampoOponente().get(posi).add(panelMonstruo);

				this.getTc().getVista().mostrar(); // Actualizo JFrame

			}

		} else { // invocacion carta Hehizo

			// si hay cartas hechizo en la mano --> Invoco un monstruo
			if (this.getTc().getManoHechizoOponente().size() >= 1
					&& this.getTc().getCampoMonstruosOponente().size() >= 1) {
				// obtengo un panel aleatorio.
				JPanel panelAleatorio = panelAleatorio(this.getTc().getManoHechizoOponente());
				panelAleatorio.setVisible(false);

				// remuevo el item asociado al keyPanel asociado y obtengo el monstruo
				CartaHechizo hechizo = this.getTc().getManoHechizoOponente().remove(panelAleatorio);
				this.getTc().getVista().mostrar();

				System.out.println("Hechizo por invocar - BOT: " + hechizo);

				// obtengo un panel con un label dado un hechizo.
				JPanel panelHechizo = panelCustomizadoCarta(hechizo);

				this.getTc().getCampoHechizosOponente().put(panelHechizo, hechizo); // Se agrega al hash

				// Obtengo una posicion vacia para invocar
				Integer posi = posVaciaCampo(this.getTc().getVista().getPanelesHechizosCampoOponente());

				// se agrega una carta al campo Monstruo Oponente a la vista
				this.getTc().getVista().getPanelesHechizosCampoOponente().get(posi).add(panelHechizo);
				try {
					// HAY VECES DONDE LOS 3 SEGUNDOS LOS HACE EN 0.1 SEGUNDOS, NO ES BUG
					Thread.sleep(4500);
				} catch (Exception e) {
				}

				this.getTc().getReferee().AplicarEfectoMagicoAMonstruo(panelHechizo,
						panelAleatorio(this.getTc().getCampoMonstruosOponente()),
						this.getTc().getCampoHechizosOponente(), this.getTc().getCampoMonstruosOponente());

				this.getTc().getReferee().remuevoPanelCampoHechizo(panelHechizo,
						this.getTc().getCampoHechizosOponente(),
						this.getTc().getVista().getPanelesHechizosCampoOponente());
				this.getTc().getVista().mostrar(); // Actualizo JFrame

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

	private Integer posVaciaCampo(ArrayList<JPanel> paneles) {
		Integer posicion = null;
		for (int i = 0; i < paneles.size(); i++) {
			// Si no hay ningun componente en ese panel, retorna la posicion.
			if (paneles.get(i).getComponentCount() == 0) {
				posicion = i;
				break;
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

			// obtengo un panel aleatorio del monstruo Atacante.
			JPanel panelMonstruoAtacante = panelAleatorio(this.getTc().getCampoMonstruosOponente());

			// obtengo el monstruo aleatorio
			this.monstruoAtacante = this.getTc().getCampoMonstruosOponente().get(panelMonstruoAtacante);

			// si no tiene monstruos el Jugador --> AtaqueDirecto
			if (this.getTc().getCampoMonstruosJugador().size() == 0) {
				System.out.println("El duelista Jugador no tiene Defensa! --> ATAQUE DIRECTO");
				monstruoAtacante.ataqueDirecto(this.getTc().getDuelistaJugador(), monstruoAtacante);
				actualizarVida();

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

	}

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
