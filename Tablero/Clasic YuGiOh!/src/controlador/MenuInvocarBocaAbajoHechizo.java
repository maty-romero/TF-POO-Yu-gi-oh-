package controlador;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JLabel;
import javax.swing.JPanel;

import modelo.Carta;
import modelo.CartaMonstruo;
import vista.VistaTablero;

public class MenuInvocarBocaAbajoHechizo implements ActionListener {
	private HechizosInvocacion mouse;

	public MenuInvocarBocaAbajoHechizo(HechizosInvocacion mouse) {
		this.mouse = mouse;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		System.out.println(this.mouse.getTc().getCampoHechizosJugador().size());
		System.out.println(this.mouse.getTc().getManoHechizoJugador().size());

		if (this.mouse.getTc().getCampoHechizosJugador().size() < 3) {
			JPanel panel = new JPanel();
			panel = this.mouse.getTc().getVista().generoBocaAbajoDefault();
			this.mouse.getTc().getVista().getPanelesHechizosCampoJugador()
					.get(this.mouse.getTc().getCampoHechizosJugador().size()).add(panel).setFocusable(false);

			panel.setVisible(true);
			panel.setFocusable(true);
			// el panel que acabo de crear, el de boca abajo default, tiene el mismo
			// controlador.
			panel.addMouseListener(mouse);
			mouse.setPanelCartaBocaAbajo(mouse.getPanelSeleccionado());
			// las cartas hechizo del campo del jugador van a tener 1 panel boca abajo, y el
			// panel que tiene la imagen de la carta. Ambos tienen clave a la carta pues
			// ambos estan relacionados a la carta.

			this.mouse.getTc().getCampoHechizosJugador().put(mouse.getPanelSeleccionado(),
					this.mouse.getTc().getManoHechizoJugador().remove(mouse.getPanelSeleccionado()));
            this.mouse.getTc().getVista().getManoJugador().remove(mouse.getPanelSeleccionado());
			this.mouse.getPanelSeleccionado().setBackground(Color.GRAY);
			this.mouse.setBocaAbajo(true);
			mouse.getTc().getVista().mostrar();

		}

	}

}