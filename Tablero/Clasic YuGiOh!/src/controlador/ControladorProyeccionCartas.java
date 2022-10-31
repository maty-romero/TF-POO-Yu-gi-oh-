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
    private JPanel panelRelacionado;
	public ControladorProyeccionCartas(VistaTablero vista, TableroController tc) {
		this.vista = vista;
		modelo = new Modelo();
		this.tc = tc;
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
			HashMap<JPanel, Carta> hashCartas = new HashMap<JPanel, Carta>();

			this.vista.getManoBot().setFocusable(true);

			hashCartas.putAll(this.tc.getCampoMonstruosJugador());
			hashCartas.putAll(this.tc.getManoMonstruoOponente());
			hashCartas.putAll(this.tc.getManoMonstruoJugador());
			hashCartas.putAll(this.tc.getManoHechizoOponente());
			hashCartas.putAll(this.tc.getManoHechizoJugador());

			this.vista.getManoJugador().setFocusable(true);
			this.vista.getManoBot().setFocusable(true);
			for (Integer i = 0; i < hashCartas.size(); i++) {

				for (JPanel key : hashCartas.keySet()) {
					if (e.getSource() == key) {
						
						String stringCarta = hashCartas.get(key).getPathImagen();
                         
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