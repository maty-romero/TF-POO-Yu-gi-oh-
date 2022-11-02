package controlador;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JLabel;
import javax.swing.JPanel;

import modelo.Carta;
import modelo.CartaMonstruo;
import vista.VistaTablero;

public class MenuInvocarBocaAbajoHechizo implements ActionListener {
	private HechizosInvocacion mouse;

	public MenuInvocarBocaAbajoHechizo(HechizosInvocacion mouse) {
		this.mouse = mouse;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		System.out.println(this.mouse.getTc().getCampoHechizosJugador().size());
		System.out.println(this.mouse.getTc().getManoHechizoJugador().size());

		if (this.mouse.getTc().getCampoHechizosJugador().size() < 3) {
			JPanel panel = new JPanel();
			panel = this.mouse.getTc().getVista().generoBocaAbajoDefault();
			this.mouse.getTc().getVista().getPanelesHechizosCampoJugador()
					.get(this.mouse.getTc().getCampoHechizosJugador().size()).add(panel).setFocusable(false);

			// this.vista.getTablero().getContentPane().add(vista.getPanelesMonstruosCampoJugador().get(1));
			// IMPORTANTE!!! SI AÑADIS AL TABLERO UN PANEL, LO QUE VA A PASAR ES QUE VA A
			// QUEDAR ABAJO DE LA IMAGEN DEL TABLERO. no le añadas nada al tablero. solo
			// cambia de lugar lo que ya tiene
			panel.setVisible(true);
			panel.setFocusable(true);

			this.mouse.getTc().getCampoHechizosJugador().put(mouse.getPanelRelacionado(),
					this.mouse.getTc().getManoHechizoJugador().remove(mouse.getPanelRelacionado()));

			this.mouse.getPanelRelacionado().setBackground(Color.GRAY);
			mouse.getTc().getVista().mostrar();
			
		}

	}

}