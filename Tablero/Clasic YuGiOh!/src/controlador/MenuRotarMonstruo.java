package controlador;

import java.awt.Color;
import java.awt.Component;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

import modelo.Carta;
import modelo.CartaMonstruo;
import vista.VistaTablero;

public class MenuRotarMonstruo implements ActionListener {
	private MenuCartaInvocada mouse;

	public MenuRotarMonstruo(MenuCartaInvocada mouse) {
		this.mouse = mouse;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (this.mouse.getTc().getCampoMonstruosJugador().size() < 4) {

			// Si invoco en posicion de ataque a la carta que tiene este listener,
			// basicamente no tiene un panelCartaBocaAbajo, asi que es null este atributo
			if (mouse.getPanelCartaBocaAbajo() != null) {
				if (mouse.getTc().getCampoMonstruosJugador().get(mouse.getPanelCartaBocaAbajo())
						.getBocaAbajo() == true) {
					mouse.getTc().getCampoMonstruosJugador().get(mouse.getPanelCartaBocaAbajo()).setBocaAbajo(false);
					mouse.getTc().getCampoMonstruosJugador().get(mouse.getPanelCartaBocaAbajo())
							.setPosicionAtaque(true);

					JPanel coincidencia = new JPanel();

					for (JPanel panelCampo : mouse.getTc().getVista().getPanelesMonstruosCampoJugador()) {
						for (Component componente : panelCampo.getComponents()) {
							if (componente.equals(mouse.getPanelSeleccionado())) {
								coincidencia = panelCampo;
							}
						}
					}

					coincidencia.removeAll();

					JLabel label = new JLabel();

					BufferedImage original = this.mouse.getTc().getVista()
							.leoImagen(mouse.getTc().getCampoMonstruosJugador().get(mouse.getPanelCartaBocaAbajo()));
					original = mouse.getTc().getVista().cambioTamaño(original, 120, 90);

					label = new JLabel(new ImageIcon(original));

					mouse.getPanelCartaBocaAbajo().removeAll();
					mouse.getPanelCartaBocaAbajo().add(label);

					coincidencia.add(mouse.getPanelCartaBocaAbajo()); // Añado la carta invisible que esta en el campo

					original = mouse.getTc().getVista().rotarImagenGrados(original, 0);

					mouse.getPanelCartaBocaAbajo().setVisible(true);
					mouse.getPanelCartaBocaAbajo().setBackground(Color.black);
					mouse.getPanelCartaBocaAbajo().setFocusable(true);

				}
			}
		}
//si bien pasa a estar en posicion de defensa, tenía bocaAbajo==false, y sigue estando en false
		if (mouse.getTc().getCampoMonstruosJugador().get(mouse.getPanelSeleccionado()).getPosicionAtaque() == true) {
			System.out.println("ROTAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAR");
			mouse.getTc().getCampoMonstruosJugador().get(mouse.getPanelSeleccionado()).setPosicionAtaque(false);

			JLabel label = new JLabel();

			BufferedImage original = this.mouse.getTc().getVista()
					.leoImagen(mouse.getTc().getCampoMonstruosJugador().get(mouse.getPanelSeleccionado()));
			original = mouse.getTc().getVista().cambioTamaño(original, 120, 90);
			original = mouse.getTc().getVista().rotarImagenGrados(original, -90);
			label = new JLabel(new ImageIcon(original));
			mouse.getPanelSeleccionado().removeAll();
			mouse.getPanelSeleccionado().add(label);

			original = mouse.getTc().getVista().rotarImagenGrados(original, 90);
			mouse.getPanelSeleccionado().setVisible(true);
			mouse.getPanelSeleccionado().setFocusable(true);
		}

		// If(la carta está boca arriba y en posicion de defensa)
		else if (mouse.getTc().getCampoMonstruosJugador().get(mouse.getPanelSeleccionado()).getBocaAbajo() == false
				&& mouse.getTc().getCampoMonstruosJugador().get(mouse.getPanelSeleccionado())
						.getPosicionAtaque() == false) {
			mouse.getTc().getCampoMonstruosJugador().get(mouse.getPanelSeleccionado()).setPosicionAtaque(true);

			mouse.getTc().getCampoMonstruosJugador().get(mouse.getPanelSeleccionado()).setPosicionAtaque(false);

			JLabel label = new JLabel();

			BufferedImage original = this.mouse.getTc().getVista()
					.leoImagen(mouse.getTc().getCampoMonstruosJugador().get(mouse.getPanelSeleccionado()));
			original = mouse.getTc().getVista().cambioTamaño(original, 120, 90);

			original = mouse.getTc().getVista().rotarImagenGrados(original, 0);
			label = new JLabel(new ImageIcon(original));
			mouse.getPanelSeleccionado().removeAll();

			mouse.getPanelSeleccionado().add(label);
			mouse.getTc().getCampoMonstruosJugador().get(mouse.getPanelSeleccionado()).setPosicionAtaque(true);
			mouse.getPanelSeleccionado().setVisible(true);
			mouse.getPanelSeleccionado().setFocusable(true);

		}

		mouse.getTc().getVista().mostrar();

	}

}
