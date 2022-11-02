package controlador;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JLabel;
import javax.swing.JPanel;

import modelo.Carta;
import modelo.CartaMonstruo;
import vista.VistaTablero;

public class MenuInvocacionHechizo implements ActionListener {
	private HechizosInvocacion mouse;

	public MenuInvocacionHechizo(HechizosInvocacion mouse) {
		this.mouse = mouse;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (this.mouse.getTc().getCampoMonstruosJugador().size() < 3
				&& this.mouse.getTc().getManoMonstruoJugador().containsKey(mouse.getPanelRelacionado())) {
			this.mouse.getTc().getVista().getPanelesMonstruosCampoJugador()
					.get(this.mouse.getTc().getCampoMonstruosJugador().size()).add(mouse.getPanelRelacionado())
					.setFocusable(false);

			// this.vista.getTablero().getContentPane().add(vista.getPanelesMonstruosCampoJugador().get(1));
			// IMPORTANTE!!! SI AÑADIS AL TABLERO UN PANEL, LO QUE VA A PASAR ES QUE VA A
			// QUEDAR ABAJO DE LA IMAGEN DEL TABLERO. no le añadas nada al tablero. solo
			// cambia de lugar lo que ya tiene

			mouse.getPanelRelacionado().setVisible(true);
			mouse.getPanelRelacionado().setFocusable(true);
			this.mouse.getTc().getCampoMonstruosJugador().put(mouse.getPanelRelacionado(),
					this.mouse.getTc().getManoMonstruoJugador().remove(mouse.getPanelRelacionado()));
			this.mouse.getPanelRelacionado().setBackground(Color.GREEN);
			mouse.getTc().getVista().getTablero().setVisible(true);

		}

	}

}
