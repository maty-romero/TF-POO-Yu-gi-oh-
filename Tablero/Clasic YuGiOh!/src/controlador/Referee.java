package controlador;

import java.awt.Color;
import java.awt.Component;
import java.awt.image.BufferedImage;
import java.util.ArrayList;
import java.util.HashMap;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;

import modelo.CartaHechizo;
import modelo.CartaMonstruo;

/* Esta clase realiza algunas acciones sobre el tablero ( no todas) . la idea es que haya
 * un controlador accesible por el bot y el jugador, y que TableroController no haga todo esto
 */

public class Referee {
	private TableroController tc;

	public Referee(TableroController tc) {
		this.tc = tc;
	}

	public Integer posVaciaCampo(ArrayList<JPanel> paneles) {
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

	// el panel que le mandes, ahora se ve distinto; como boca abajo
	public void cartaDefaultBocaAbajo(JPanel panelCarta) {

		panelCarta.removeAll();

		JLabel label = new JLabel();

		BufferedImage original = this.getTc().getVista().leoImagen(this.getTc().getVista().getPathCartaDefault());
		original = this.getTc().getVista().cambioTamaño(original, 120, 90);

		label = new JLabel(new ImageIcon(original));
		panelCarta.add(label);
	}

	// si el bot quiere rotar una carta del jugador, debe enviar ese panel aquí. Si
	// queremos que el bot rote sus cartas,
	// solo tenemos que agregar unos if más para chequear la posicion de ataque y
	// boca abajo de las cartas modelo del bot
	public void rotarCartaMonstruo(JPanel panelARotar) {
		BufferedImage buferCarta;
		JLabel label;
		if (this.getTc().getCampoMonstruosJugador().get(panelARotar).getBocaAbajo() == true
				&& this.getTc().getCampoMonstruosJugador().get(panelARotar).getPosicionAtaque() == false) {
			buferCarta = this.getTc().getVista()
					.leoImagenCarta(this.getTc().getCampoMonstruosJugador().get(panelARotar));
			buferCarta = this.getTc().getVista().cambioTamaño(buferCarta, 120, 120);
			buferCarta = this.getTc().getVista().rotarImagenGrados(buferCarta, -90);
			label = new JLabel(new ImageIcon(buferCarta));
			(panelARotar).removeAll();
			this.getTc().getCampoMonstruosJugador().get((panelARotar)).setPosicionAtaque(false);
			this.getTc().getCampoMonstruosJugador().get((panelARotar)).setBocaAbajo(false);
			(panelARotar).add(label);
			this.getTc().getVista().mostrar();
		} else if (this.getTc().getCampoMonstruosJugador().get(panelARotar).getPosicionAtaque() == true) {
			buferCarta = this.getTc().getVista()
					.leoImagenCarta(this.getTc().getCampoMonstruosJugador().get(panelARotar));
			buferCarta = this.getTc().getVista().cambioTamaño(buferCarta, 120, 120);
			buferCarta = this.getTc().getVista().rotarImagenGrados(buferCarta, -90);
			label = new JLabel(new ImageIcon(buferCarta));
			panelARotar.removeAll();
			panelARotar.add(label);

			buferCarta = this.getTc().getVista().rotarImagenGrados(buferCarta, 90);
			this.getTc().getCampoMonstruosJugador().get(panelARotar).setPosicionAtaque(false);
			panelARotar.setVisible(true);
			panelARotar.setFocusable(true);
			this.getTc().getVista().mostrar();

		} else if (this.getTc().getCampoMonstruosJugador().get(panelARotar).getPosicionAtaque() == false) {
			buferCarta = this.getTc().getVista()
					.leoImagenCarta(this.getTc().getCampoMonstruosJugador().get(panelARotar));
			buferCarta = this.getTc().getVista().cambioTamaño(buferCarta, 120, 120);
			buferCarta = this.getTc().getVista().rotarImagenGrados(buferCarta, 0);
			label = new JLabel(new ImageIcon(buferCarta));
			panelARotar.removeAll();
			panelARotar.add(label);

			buferCarta = this.getTc().getVista().rotarImagenGrados(buferCarta, 90);
			this.getTc().getCampoMonstruosJugador().get(panelARotar).setPosicionAtaque(true);
			panelARotar.setVisible(true);
			panelARotar.setFocusable(true);
			this.getTc().getVista().mostrar();
		}

	}

	public void voltearCartaMagica(JPanel panelAVoltear) {
		BufferedImage buferCarta;
		JLabel label;
		if (this.getTc().getCampoHechizosJugador().get(panelAVoltear).getBocaAbajo() == true) {
			buferCarta = this.getTc().getVista()
					.leoImagenCarta(this.getTc().getCampoHechizosJugador().get(panelAVoltear));
			buferCarta = this.getTc().getVista().cambioTamaño(buferCarta, 120, 120);
			label = new JLabel(new ImageIcon(buferCarta));
			(panelAVoltear).removeAll();
			this.getTc().getCampoHechizosJugador().get((panelAVoltear)).setBocaAbajo(false);
			(panelAVoltear).add(label);
			this.getTc().getVista().mostrar();
		}
	}


	public void remuevoPanelCampoHechizo(JPanel panelMagico, HashMap<JPanel, CartaHechizo> hashHechizos,
			ArrayList<JPanel> panelesCampoHechizos) {

		JPanel coincidencia = new JPanel();

		// Remuevo VISUALMENTE el componente de panel
		// getVista().panelesHechizosCampoJugador, no uno de esos 3 paneles sino su
		// componente
		for (JPanel panel : panelesCampoHechizos) {
			for (Component componente : panel.getComponents()) {
				if (componente == panelMagico) {
					coincidencia = panel;
					componente.setVisible(false);
					break;
				}
			}
		}

		hashHechizos.remove(panelMagico);

		coincidencia.removeAll();
		coincidencia.setVisible(true);
		this.getTc().getVista().getTablero().setVisible(true);

		this.getTc().getVista().mostrar();

	}

	public void remuevoHechizosCampoDuelista(HashMap<JPanel, CartaHechizo> hashHechizosCampoOponente,
			ArrayList<JPanel> panelesHechizosCampo) {
		hashHechizosCampoOponente.clear();

		for (JPanel panel : panelesHechizosCampo) {
			panel.removeAll();
			panel.setVisible(false);

			panel.setVisible(true);
		}
		this.getTc().getVista().mostrar();
	}
	
	
	//getters 
	
	public TableroController getTc() {
		return tc;
	}

	public void setTc(TableroController tc) {
		this.tc = tc;
	}

}
