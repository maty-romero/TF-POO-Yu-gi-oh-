package controlador;

import java.awt.Color;
import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JLabel;
import javax.swing.JPanel;

import modelo.Carta;
import modelo.CartaMonstruo;
import vista.VistaTablero;

public class MenuActivarHechizoCartaInvocada implements ActionListener {
	private HechizosInvocacion mouse;

	public MenuActivarHechizoCartaInvocada(HechizosInvocacion mouse) {
		this.mouse = mouse;
	}

	@Override
	public void actionPerformed(ActionEvent e) { // el e aquí es un boton JMenuItem, no el panel desde donde se hizo
													// click en el JMenuItem
//		System.out.println(this.mouse.getTc().getCampoHechizosJugador().size());
//		System.out.println(this.mouse.getTc().getManoHechizoJugador().size());

		if (this.mouse.getTc().getCampoHechizosJugador().size() < 3) {
			
			JPanel coincidencia = new JPanel();
			for (JPanel panelCampo : mouse.getTc().getVista().getPanelesHechizosCampoJugador()) {
				for (Component componente : panelCampo.getComponents()) {
					if (((JPanel) componente).equals(mouse.getPanelSeleccionado())) {
						coincidencia = panelCampo;
					}
				}
			}
			coincidencia.removeAll();
			coincidencia.setVisible(true);
			coincidencia.add(mouse.getPanelCartaBocaAbajo());
			System.out.println(this.mouse.getTc().getCampoHechizosJugador().size());
			this.mouse.getPanelSeleccionado().setBackground(Color.GRAY);
			System.out.println(this.mouse.getTc().getCampoHechizosJugador().size());

			mouse.getTc().getVista().mostrar();
			mouse.setBocaAbajo(false);
		}

	}

}