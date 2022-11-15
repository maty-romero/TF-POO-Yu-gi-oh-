package controlador;

import java.awt.Color;
import java.awt.Component;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;

import modelo.Carta;
import modelo.CartaMonstruo;
import vista.VistaTablero;

public class MenuInvocarDefensaMonstruo implements ActionListener {
	private MonstruosInvocacion mouse;

	public MenuInvocarDefensaMonstruo(MonstruosInvocacion mouse) {
		this.mouse = mouse;
	}

	@Override
	public void actionPerformed(ActionEvent e) {

		if (this.mouse.getTc().getCampoMonstruosJugador().size() < 3) {

			this.mouse.getTc().getReferee().cartaDefaultBocaAbajo(mouse.getPanelSeleccionado());
			this.mouse.getTc().getVista().getPanelesMonstruosCampoJugador()
					.get(this.mouse.getTc().getCampoMonstruosJugador().size()).add(mouse.getPanelSeleccionado())
					.setFocusable(false);

			this.mouse.getTc().getCampoMonstruosJugador().put(mouse.getPanelSeleccionado(),
					this.mouse.getTc().getManoMonstruoJugador().get(mouse.getPanelSeleccionado()));

			this.mouse.getTc().getDuelistaJugador().getMano().getManoMonstruos()
					.remove(this.mouse.getTc().getManoMonstruoJugador().remove(mouse.getPanelSeleccionado()));

			this.mouse.getTc().getCampoMonstruosJugador().get(mouse.getPanelSeleccionado()).setPosicionAtaque(false);
			this.mouse.getTc().getCampoMonstruosJugador().get(mouse.getPanelSeleccionado()).setBocaAbajo(true);
			mouse.getPanelSeleccionado().addMouseListener(new MenuCartaInvocadaMonstruo(this.mouse.getTc()));
			mouse.getPanelSeleccionado().setVisible(true);
			mouse.getPanelSeleccionado().setFocusable(true);
			this.mouse.getPanelSeleccionado().setBackground(Color.GREEN);
			mouse.getTc().getVista().mostrar();

		}

	}

}
