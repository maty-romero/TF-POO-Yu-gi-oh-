package controlador;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JLabel;
import javax.swing.JPanel;

import modelo.Carta;
import modelo.CartaMonstruo;
import vista.VistaTablero;

public class MenuInvocarAtaqueMonstruo implements ActionListener {
	private MonstruosInvocacion mouse;

	public MenuInvocarAtaqueMonstruo(MonstruosInvocacion mouse) {
		this.mouse = mouse;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (this.mouse.getTc().getCampoMonstruosJugador().size() < 3) {
			this.mouse.getTc().getVista().getPanelesMonstruosCampoJugador()
					.get(this.mouse.getTc().getCampoMonstruosJugador().size()).add(mouse.getPanelSeleccionado())
					.setFocusable(false);

			// this.vista.getTablero().getContentPane().add(vista.getPanelesMonstruosCampoJugador().get(1));
			// IMPORTANTE!!! SI AÑADIS AL TABLERO UN PANEL, LO QUE VA A PASAR ES QUE VA A
			// QUEDAR ABAJO DE LA IMAGEN DEL TABLERO. no le añadas nada al tablero. solo
			// cambia de lugar lo que ya tiene

			mouse.getPanelSeleccionado().setVisible(true);
			mouse.getPanelSeleccionado().setFocusable(true);
			this.mouse.getTc().getCampoMonstruosJugador().put(mouse.getPanelSeleccionado(),
					this.mouse.getTc().getManoMonstruoJugador().remove(mouse.getPanelSeleccionado()));
			this.mouse.getPanelSeleccionado().setBackground(Color.GREEN);
			mouse.getTc().getVista().mostrar();

		}

	}
	



}
