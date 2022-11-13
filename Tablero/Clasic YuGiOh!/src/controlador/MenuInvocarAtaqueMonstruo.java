package controlador;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashMap;
import java.util.List;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPopupMenu;

import modelo.Carta;
import modelo.CartaMonstruo;
import vista.VistaTablero;

public class MenuInvocarAtaqueMonstruo implements ActionListener {
	private MonstruosInvocacion mouse;
	private Integer variableControl;

	public MenuInvocarAtaqueMonstruo(MonstruosInvocacion mouse) {
		this.mouse = mouse;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (this.mouse.getTc().getCampoMonstruosJugador().size() < 3) {

			this.mouse.getTc().getVista().getPanelesMonstruosCampoJugador()
					.get(this.mouse.getTc().getCampoMonstruosJugador().size()).add(mouse.getPanelSeleccionado())
					.setFocusable(false);

			mouse.getPanelSeleccionado().setVisible(true);
			mouse.getPanelSeleccionado().setFocusable(true);

			/*
			 * Se agrega el controlador MenuAtacar ya que los que estan en TableroController
			 * no son los mismos paneles que hay en el HASH
			 */
			JPopupMenu pm = new JPopupMenu();
			MenuCartaInvocadaMonstruo ma = new MenuCartaInvocadaMonstruo(this.mouse.getTc());

			mouse.getPanelSeleccionado().addMouseListener(ma);

			this.mouse.getTc().getCampoMonstruosJugador().put(mouse.getPanelSeleccionado(),
					this.mouse.getTc().getManoMonstruoJugador().remove(mouse.getPanelSeleccionado()));
			this.mouse.getTc().getCampoMonstruosJugador().get(mouse.getPanelSeleccionado()).setPosicionAtaque(true);
			this.mouse.getTc().getCampoMonstruosJugador().get(mouse.getPanelSeleccionado()).setBocaAbajo(false);

			this.mouse.getPanelSeleccionado().setBackground(Color.GREEN);

			try {
				Thread.sleep(500);
				this.mouse.getTc().getVista().getManoJugador().setVisible(false);
				this.mouse.getTc().getVista().getManoJugador().setVisible(true);
				mouse.getPanelSeleccionado().setVisible(false);
				mouse.getPanelSeleccionado().setVisible(true);
			} catch (InterruptedException e1) {
				e1.printStackTrace();
			}

		}

	}

}
