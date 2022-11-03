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

public class MenuVoltearMonstruo implements ActionListener {
	private MonstruosInvocacion mouse;

	public MenuVoltearMonstruo(MonstruosInvocacion mouse) {
		this.mouse = mouse;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (this.mouse.getTc().getCampoMonstruosJugador().size() < 4) { // el e aquí es un boton JMenuItem, no el panel
																		// desde donde se hizo
			JPanel coincidencia = new JPanel();

			for (JPanel panelCampo : mouse.getTc().getVista().getPanelesMonstruosCampoJugador()) {
				for (Component componente : panelCampo.getComponents()) {
					if (componente.equals(mouse.getPanelSeleccionado())) {
						coincidencia = panelCampo;
					}
				}
			}
			coincidencia.removeAll();

			// LO SIGUIENTE SIRVE PARA DIBUJAR UNA IMAGEN, PERO YO LA ESTOY DIBUJANDO DENTRO
			// DE ROTAR IMAGEN, ASÌ QUE NO PUEDO DIBUJARLA DOS VECES. SINO VOY A TENER UNA
			// IMAGEN CON 2 IMAGENES PINTADAS!!

//			 Get the icon
//			Icon ico = mouse.getLabel().getIcon();
//			// Create a buffered image
//			BufferedImage bimg = new BufferedImage(ico.getIconWidth(), ico.getIconHeight(), BufferedImage.TYPE_INT_RGB);
//			// Create the graphics context
//			Graphics g = bimg.createGraphics();
//			// Now paint the icon
//			ico.paintIcon(null, g, 0, 0);
//			g.dispose();

			JLabel label = null;
			try {
				BufferedImage original = ImageIO.read(getClass().getResource(
						mouse.getTc().getCampoMonstruosJugador().get(mouse.getPanelCartaBocaAbajo()).getPathImagen()));
				original = mouse.getTc().getVista().cambioTamaño(original, 90, 150);

				original = mouse.getTc().getVista().rotarImagenGrados(original, -90);

				label = new JLabel(new ImageIcon(original));

			} catch (IOException e1) {
				e1.printStackTrace();
			}

			mouse.getPanelCartaBocaAbajo().removeAll();
			mouse.getPanelCartaBocaAbajo().add(label);

			coincidencia.add(mouse.getPanelCartaBocaAbajo());

			coincidencia.setVisible(true);
			coincidencia.setFocusable(false);

			mouse.getPanelCartaBocaAbajo().setVisible(true);
			mouse.getPanelCartaBocaAbajo().setBackground(Color.black);
			mouse.getPanelCartaBocaAbajo().setFocusable(true);

			mouse.setBocaAbajo(false);
			mouse.getTc().getVista().mostrar();

		}

	}

}
