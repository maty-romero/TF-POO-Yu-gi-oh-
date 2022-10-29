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

import modelo.Carta;
import modelo.CartaMonstruo;
import modelo.Modelo;
import vista.VistaTablero;

public class ControladorProyeccionCartas implements MouseListener {
	private VistaTablero vista;
	private Modelo modelo;
	private TableroController tc;

	public ControladorProyeccionCartas(VistaTablero vista, TableroController tc) {
		this.vista = vista;
		modelo = new Modelo();
		this.tc = tc;
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		System.out.println("hola");
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
			HashMap<JPanel, CartaMonstruo> hashCartas = new HashMap<JPanel, CartaMonstruo>();
			System.out.println("entre");
			
			
			this.vista.getManoBot().setFocusable(true);
			hashCartas = this.tc.getManoMonstruoOponente();
			System.out.println(hashCartas);
			System.out.println(hashCartas.size());
			// HashMap<JPanel, String> hashCartas = this.vista.getCartasTablero() ;
			
			
			this.vista.getManoJugador().setFocusable(true);
			for (Integer i = 0; i < hashCartas.size(); i++) {
				// System.out.println(hashCartas);
				System.out.println("entreeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeee");

				for (JPanel key : hashCartas.keySet()) {
					if (e.getSource() == key) {
						String stringCarta = hashCartas.get(key).getPathImagen();
						// String stringCarta = hashCartas.get(key);

						java.net.URL urlCarta = getClass().getResource(stringCarta);
						ImageIcon iconCarta = new ImageIcon(
								new ImageIcon(urlCarta).getImage().getScaledInstance(400, 380, Image.SCALE_DEFAULT));
						JLabel label = new JLabel(iconCarta);
						vista.getCartaSeleccionada().removeAll();
					System.out.println("entre");
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