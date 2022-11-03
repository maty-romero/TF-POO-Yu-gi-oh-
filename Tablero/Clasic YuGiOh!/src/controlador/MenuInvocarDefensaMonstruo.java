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
			JPanel panel = new JPanel();
			panel = this.mouse.getTc().getVista().generoBocaAbajoDefault();

			this.mouse.getTc().getVista().getPanelesMonstruosCampoJugador()
					.get(this.mouse.getTc().getCampoMonstruosJugador().size()).add(panel).setFocusable(false);
		
			this.mouse.getTc().getCampoMonstruosJugador().put(mouse.getPanelSeleccionado(),
					this.mouse.getTc().getManoMonstruoJugador().remove(mouse.getPanelSeleccionado()));
	
			
			panel.setVisible(true);
			panel.setFocusable(true);
			panel.addMouseListener(mouse);
            mouse.setLabel((JLabel) mouse.getPanelSeleccionado().getComponent(0));
			mouse.setPanelCartaBocaAbajo(mouse.getPanelSeleccionado());


			mouse.getPanelSeleccionado().setBackground(Color.black);
			
			this.mouse.getTc().getVista().getManoJugador().remove(mouse.getPanelSeleccionado());
			this.mouse.getPanelSeleccionado().setBackground(Color.GREEN);
			this.mouse.setBocaAbajo(true);
			mouse.getTc().getVista().mostrar();

		}

	}

}
