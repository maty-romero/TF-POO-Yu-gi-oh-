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

public class MenuActivarHechizo implements ActionListener, MouseListener {
	private ManuHechizos mouse;

	public MenuActivarHechizo(ManuHechizos mouse) {
		this.mouse = mouse;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (this.mouse.getTc().getCampoHechizosJugador().size() < 4) {
			if (this.mouse.getTc().getCampoHechizosJugador().get(mouse.getPanelSeleccionado()).getBocaAbajo() == true) {
				this.mouse.getTc().getReferee().voltearCartaMagica(mouse.getPanelSeleccionado());
			}
			for (JPanel panelMonstruo : this.mouse.getTc().getCampoMonstruosJugador().keySet()) {
				panelMonstruo.addMouseListener(this);
			}

			if (this.mouse.getTc().getCampoMonstruosJugador().size() == 0) {
				this.mouse.getTc().getReferee().remuevoPanelCampoHechizo(mouse.getPanelSeleccionado(),
						this.mouse.getTc().getCampoHechizosJugador(),
						this.mouse.getTc().getVista().getPanelesHechizosCampoJugador());
			}
		}
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		JPanel panelAplicarEfecto = (JPanel) e.getSource();

		this.mouse.getTc().getReferee().AplicarEfectoMagicoAMonstruo(this.mouse.getPanelSeleccionado(),
				panelAplicarEfecto, this.mouse.getTc().getCampoHechizosJugador(),
				this.mouse.getTc().getCampoMonstruosJugador());

		this.mouse.getTc().getReferee().remuevoPanelCampoHechizo(mouse.getPanelSeleccionado(),
				this.mouse.getTc().getCampoHechizosJugador(),
				this.mouse.getTc().getVista().getPanelesHechizosCampoJugador());
		for (JPanel panelMonstruo : this.mouse.getTc().getCampoMonstruosJugador().keySet()) {
			panelMonstruo.removeMouseListener(this);
		}

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
