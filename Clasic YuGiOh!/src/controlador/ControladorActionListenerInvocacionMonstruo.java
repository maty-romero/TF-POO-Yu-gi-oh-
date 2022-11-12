package controlador;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JLabel;
import javax.swing.JPanel;

import modelo.Carta;
import modelo.CartaMonstruo;
import vista.VistaTablero;

public class ControladorActionListenerInvocacionMonstruo implements ActionListener {
	private MouseListenerInvocacion mouse;
	private JPanel panel;
	private CartaMonstruo carta;

	public ControladorActionListenerInvocacionMonstruo( MouseListenerInvocacion mouse,
			JPanel panel, CartaMonstruo carta) {
		this.mouse = mouse;
		this.panel = panel;
		this.carta = carta;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (this.mouse.getTc().getCampoMonstruosJugador().size() < 3 && this.mouse.getTc().getManoMonstruoJugador().containsKey(panel)) {

			this.mouse.getVista().getPanelesMonstruosCampoJugador().get(this.mouse.getTc().getCampoMonstruosJugador().size()).add(panel);

			// this.vista.getTablero().getContentPane().add(vista.getPanelesMonstruosCampoJugador().get(1));
			// IMPORTANTE!!! SI AÑADIS AL TABLERO UN PANEL, LO QUE VA A PASAR ES QUE VA A
			// QUEDAR ABAJO DE LA IMAGEN DEL TABLERO. no le añadas nada al tablero. solo
			// cambia de lugar lo que ya tiene

//			this.vista.getPanelesMonstruosCampoOponente().get(this.tc.getCampoMonstruosJugador().size())
//					.setVisible(true);
//
//			this.vista.getPanelesMonstruosCampoOponente().get(this.tc.getCampoMonstruosJugador().size())
//					.setFocusable(true);

			panel.setVisible(true);
			panel.setFocusable(true);
			//System.out.println(this.mouse.getTc().getManoMonstruoJugador().containsKey(panel));
			
			this.mouse.getTc().getCampoMonstruosJugador().put(panel, this.mouse.getTc().getManoMonstruoJugador().remove(panel));

			this.mouse.getVista().getTablero().setVisible(true);

			System.out.println(this.mouse.getTc().getManoMonstruoJugador().containsKey(panel));
			this.mouse.setInv(true);
		}

	}

}
