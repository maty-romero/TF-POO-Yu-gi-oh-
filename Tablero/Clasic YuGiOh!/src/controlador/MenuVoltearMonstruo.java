package controlador;

import java.awt.Color;
import java.awt.Component;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;

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

			// Get the icon
			Icon ico = mouse.getLabel().getIcon();
			// Create a buffered image
			BufferedImage bimg = new BufferedImage(ico.getIconWidth(), ico.getIconHeight(), BufferedImage.TYPE_INT_RGB);
			// Create the graphics context
			Graphics g = bimg.createGraphics();
			// Now paint the icon
			ico.paintIcon(null, g, 0, 0);
			g.dispose();

	
			coincidencia.removeAll();

			//al panel del campo le añado el panel de la carta boca abajo que tiene una imagen rotada y cambiada de tamaño
			coincidencia.add(mouse.getPanelCartaBocaAbajo().add(new JLabel(new ImageIcon(mouse.getTc().getVista()
					.rotarImagenGrados(this.mouse.getTc().getVista().cambioTamaño(bimg, 130, 130), 90)))));
								

			coincidencia.setVisible(true);
			coincidencia.setFocusable(false);
					
			
			mouse.getPanelCartaBocaAbajo().setVisible(true);
			mouse.getPanelCartaBocaAbajo().setFocusable(true);
	
			coincidencia.addMouseListener(new ControladorProyeccionCartas (this.mouse.getTc()));

			//mouse.getPanelCartaBocaAbajo().addMouseListener(new ControladorProyeccionCartas (this.mouse.getTc()));

			mouse.getTc().getVista().mostrar();
			mouse.setBocaAbajo(false);
			
		}

	}

}
