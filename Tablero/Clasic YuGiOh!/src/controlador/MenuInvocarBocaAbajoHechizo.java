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
	private ManuHechizos mouse;

	public MenuInvocarBocaAbajoHechizo(ManuHechizos mouse) {
		this.mouse = mouse;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		System.out.println(this.mouse.getTc().getCampoHechizosJugador().size());
		System.out.println(this.mouse.getTc().getManoHechizoJugador().size());

		Integer posi = this.mouse.getTc().getReferee()
				.posVaciaCampo((this.mouse.getTc().getVista().getPanelesHechizosCampoJugador()));
		if (posi != null) {
			this.mouse.getTc().getReferee().cartaDefaultBocaAbajo(mouse.getPanelSeleccionado());
			this.mouse.getTc().getVista().getPanelesHechizosCampoJugador()
					.get(posi).add(mouse.getPanelSeleccionado())
					.setFocusable(false);

			this.mouse.getTc().getCampoHechizosJugador().put(mouse.getPanelSeleccionado(),
					this.mouse.getTc().getManoHechizoJugador().get(mouse.getPanelSeleccionado()));
			this.mouse.getTc().getDuelistaJugador().getMano().getManoHechizos()
					.remove(this.mouse.getTc().getManoHechizoJugador().remove(mouse.getPanelSeleccionado()));

			this.mouse.getTc().getCampoHechizosJugador().get(mouse.getPanelSeleccionado()).setBocaAbajo(true);
			mouse.getPanelSeleccionado().addMouseListener(new ManuHechizos(this.mouse.getTc()));
			mouse.getPanelSeleccionado().setVisible(true);
			mouse.getPanelSeleccionado().setFocusable(true);
			this.mouse.getPanelSeleccionado().setBackground(Color.GREEN);
			mouse.getTc().getVista().mostrar();

		}
	}

}