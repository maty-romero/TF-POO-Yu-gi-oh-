package controlador;

import java.awt.Color;
import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JLabel;
import javax.swing.JPanel;

import modelo.Carta;
import modelo.CartaMonstruo;
import vista.VistaTablero;

public class MenuActivarHechizoBocaAbajo implements ActionListener, MouseListener {
	private ManuHechizos mouse;

	public MenuActivarHechizoBocaAbajo(ManuHechizos mouse) {
		this.mouse = mouse;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (this.mouse.getTc().getCampoHechizosJugador().size() < 4) {
			this.mouse.getTc().getReferee().voltearCartaMagica(mouse.getPanelSeleccionado());
			for (JPanel panelMonstruo : this.mouse.getTc().getCampoMonstruosJugador().keySet()) {
				panelMonstruo.addMouseListener(this);
			}

		}
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		JPanel panelAplicarEfecto = (JPanel) e.getSource();
		Integer valorEfecto = this.mouse.getTc().getCampoHechizosJugador().get(this.mouse.getPanelSeleccionado())
				.getEfecto();

		Integer nuevoAtaque = this.mouse.getTc().getCampoMonstruosJugador().get(panelAplicarEfecto).getAtaque();

		nuevoAtaque = nuevoAtaque + valorEfecto;
		this.mouse.getTc().getCampoMonstruosJugador().get(panelAplicarEfecto).setAtaque(nuevoAtaque);
		JPanel coincidencia = new JPanel();

		// Remuevo VISUALMENTE el componente de panel
		// getVista().panelesHechizosCampoJugador, no uno de esos 3 paneles sino su
		// componente
		for (JPanel panel : this.mouse.getTc().getVista().getPanelesHechizosCampoJugador()) {
			for (Component componente : panel.getComponents()) {
				if (componente == mouse.getPanelSeleccionado()) {
					coincidencia = panel;
					componente.setVisible(false);
					break;
				}
			}
		}
		this.mouse.getTc().getCampoHechizosJugador().remove(this.mouse.getPanelSeleccionado());

		coincidencia.removeAll();
		coincidencia.setVisible(true);
		mouse.getTc().getVista().getTablero().setVisible(true);

		this.mouse.getTc().getVista().mostrar();
	}

	@Override
	public void mousePressed(MouseEvent e) {

	}

	@Override
	public void mouseReleased(MouseEvent e) {
	}

	@Override
	public void mouseEntered(MouseEvent e) {
	}

	@Override
	public void mouseExited(MouseEvent e) {
	}
}
