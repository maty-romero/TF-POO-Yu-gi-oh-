package controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JLabel;
import javax.swing.JPanel;

import modelo.Carta;
import modelo.CartaMonstruo;
import vista.VistaTablero;

public class ControladorActionListenerInvocacionMonstruo implements ActionListener {
	private VistaTablero vista;
	private MouseListenerInvocacion mouse;
	private TableroController tc;
	private JPanel panel;
	private CartaMonstruo carta;

	public ControladorActionListenerInvocacionMonstruo(VistaTablero vista, MouseListenerInvocacion mouse,
			TableroController tc, JPanel panel, CartaMonstruo carta) {
		this.vista = vista;
		this.mouse = mouse;
		this.tc = tc;
		this.panel = panel;
		this.carta = carta;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (this.tc.getCampoMonstruosJugador().size()<3 && this.tc.getManoMonstruoJugador().containsKey(panel)) {
			this.vista.getPanelesMonstruosCampoJugador().get(this.tc.getCampoMonstruosJugador().size()).add(panel);
			;

			// this.vista.getTablero().getContentPane().add(vista.getPanelesMonstruosCampoJugador().get(1));
			// IMPORTANTE!!! SI AÑADIS AL TABLERO UN PANEL, LO QUE VA A PASAR ES QUE VA A
			// QUEDAR ABAJO DE LA IMAGEN DEL TABLERO. no le añadas nada al tablero. solo
			// cambia de lugar lo que ya tiene
			this.vista.getPanelesMonstruosCampoOponente().get(this.tc.getCampoMonstruosJugador().size())
					.setVisible(true);

			this.vista.getPanelesMonstruosCampoOponente().get(this.tc.getCampoMonstruosJugador().size())
					.setFocusable(true);
			panel.setVisible(true);
			panel.setFocusable(true);
			System.out.println(this.tc.getManoMonstruoJugador().size());
			this.tc.getCampoMonstruosJugador().put(panel, this.tc.getManoMonstruoJugador().remove(panel));
			System.out.println(this.tc.getManoMonstruoJugador().size());

			this.vista.getTablero().setVisible(true);

		}

	}

}
