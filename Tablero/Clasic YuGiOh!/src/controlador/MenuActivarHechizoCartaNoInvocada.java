package controlador;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

import modelo.Carta;
import modelo.CartaMonstruo;
import vista.VistaTablero;

public class MenuActivarHechizoCartaNoInvocada implements ActionListener {
	private HechizosInvocacion mouse;

	public MenuActivarHechizoCartaNoInvocada(HechizosInvocacion mouse) {
		this.mouse = mouse;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		System.out.println(this.mouse.getTc().getCampoHechizosJugador().size());
		System.out.println(this.mouse.getTc().getManoHechizoJugador().size());

		if (this.mouse.getTc().getCampoHechizosJugador().size() < 3) {
			this.mouse.getTc().getVista().getPanelesHechizosCampoJugador()
					.get(this.mouse.getTc().getCampoHechizosJugador().size()).add(mouse.getPanelSeleccionado())
					.setFocusable(false);

			

			// this.vista.getTablero().getContentPane().add(vista.getPanelesMonstruosCampoJugador().get(1));
			// IMPORTANTE!!! SI AÑADIS AL TABLERO UN PANEL, LO QUE VA A PASAR ES QUE VA A
			// QUEDAR ABAJO DE LA IMAGEN DEL TABLERO. no le añadas nada al tablero. solo
			// cambia de lugar lo que ya tiene
			mouse.getPanelSeleccionado().setVisible(true);
			mouse.getPanelSeleccionado().setFocusable(true);
			this.mouse.getTc().getCampoHechizosJugador().put(mouse.getPanelSeleccionado(),
					this.mouse.getTc().getManoHechizoJugador().remove(mouse.getPanelSeleccionado()));
			System.out.println(this.mouse.getTc().getCampoHechizosJugador().size());
			this.mouse.getPanelSeleccionado().setBackground(Color.GRAY);
			mouse.getTc().getVista().mostrar();
		}
         
	}
	


}
