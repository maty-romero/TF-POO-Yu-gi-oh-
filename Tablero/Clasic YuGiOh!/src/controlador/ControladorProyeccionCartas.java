package controlador;

import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Image;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Random;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;

import modelo.Modelo;
import vista.Vista_tablero;

public class ControladorProyeccionCartas implements MouseListener {
	private Vista_tablero vista;
	private Modelo modelo;
	private JLabel imagenCarta4Jug;

	public ControladorProyeccionCartas(Vista_tablero vista) {
		this.vista = vista;
		modelo = new Modelo();
		//this.vista.mostrar();  NO ACTIVAR O SALE PANTALLA LAGEADA
 	}

	@Override
	public void mouseClicked(MouseEvent e) {
	}

	@Override
	public void mousePressed(MouseEvent e) {

	}

	@Override
	public void mouseReleased(MouseEvent e) {
	}

	@Override
	public void mouseEntered(MouseEvent e) {

		{
			HashMap<JPanel, String> hashCartas = this.vista.getCartasTablero();

			for (Integer i = 0; i < hashCartas.size(); i++) {

				for (JPanel key : hashCartas.keySet()) {
					if (e.getSource() == key) {
						String stringCarta = hashCartas.get(key);

						java.net.URL urlCarta = getClass().getResource(stringCarta);
						ImageIcon iconCarta = new ImageIcon(
								new ImageIcon(urlCarta).getImage().getScaledInstance(400, 380, Image.SCALE_DEFAULT));
						JLabel label = new JLabel(iconCarta);
						vista.getCartaSeleccionada().removeAll();
						vista.mostrar();

						vista.getCartaSeleccionada().add(label);
						vista.mostrar();
						vista.getCartaSeleccionada().setVisible(true);
					}

				}

			}
		}

	}

	@Override
	public void mouseExited(MouseEvent e) {

	}

}