package controlador;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

import modelo.Carta;
import modelo.CartaMonstruo;
import vista.VistaTablero;

public class MenuInvocarBocaArribaHechizo implements ActionListener, MouseListener {
	private ManuHechizos mouse;

	public MenuInvocarBocaArribaHechizo(ManuHechizos mouse) {
		this.mouse = mouse;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		System.out.println(this.mouse.getTc().getCampoHechizosJugador().size());
		System.out.println(this.mouse.getTc().getManoHechizoJugador().size());

		if (this.mouse.getTc().getCampoHechizosJugador().size() < 3) {
			this.mouse.getTc().getVista().getPanelesHechizosCampoJugador()
					.get(this.mouse.getTc().getCampoHechizosJugador().size()).add(mouse.getPanelSeleccionado())
					.setFocusable(false);

			mouse.getPanelSeleccionado().setVisible(true);
			mouse.getPanelSeleccionado().setFocusable(true);

			this.mouse.getTc().getCampoHechizosJugador().put(mouse.getPanelSeleccionado(),
					this.mouse.getTc().getManoHechizoJugador().get(mouse.getPanelSeleccionado()));
			this.mouse.getTc().getDuelistaJugador().getMano().getManoHechizos()
					.remove(this.mouse.getTc().getManoHechizoJugador().remove(mouse.getPanelSeleccionado()));

			this.mouse.getTc().getCampoHechizosJugador().get(mouse.getPanelSeleccionado()).setBocaAbajo(false);

			System.out.println(this.mouse.getTc().getCampoHechizosJugador().size());
			this.mouse.getPanelSeleccionado().setBackground(Color.GRAY);
			mouse.getTc().getVista().mostrar();
		}

	}

	@Override
	public void mouseClicked(MouseEvent e) {

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
