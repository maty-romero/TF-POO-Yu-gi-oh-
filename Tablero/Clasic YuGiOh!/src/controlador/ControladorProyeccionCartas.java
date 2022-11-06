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
	private Modelo modelo;
	private TableroController tc;
	private JPanel panelRelacionado;

	public ControladorProyeccionCartas(TableroController tc) {
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
			System.out.println("entre al proyectador");
			
			HashMap<JPanel, Carta> hashCartas = new HashMap<JPanel, Carta>();

			hashCartas.putAll(this.tc.getCampoMonstruosOponente());
			hashCartas.putAll(this.tc.getCampoMonstruosJugador());
			hashCartas.putAll(this.tc.getCampoHechizosJugador());
			hashCartas.putAll(this.tc.getManoMonstruoOponente());
			hashCartas.putAll(this.tc.getManoMonstruoJugador());
			hashCartas.putAll(this.tc.getManoHechizoOponente());
			hashCartas.putAll(this.tc.getManoHechizoJugador());

			this.tc.getVista().getManoJugador().setFocusable(true);
			this.tc.getVista().getManoBot().setFocusable(true);

			if (hashCartas.containsKey(e.getSource())) {
				String stringCarta = hashCartas.get(e.getSource()).getPathImagen();

				java.net.URL urlCarta = getClass().getResource(stringCarta);
				ImageIcon iconCarta = new ImageIcon(
						new ImageIcon(urlCarta).getImage().getScaledInstance(400, 380, Image.SCALE_DEFAULT));
				JLabel label = new JLabel(iconCarta);
				this.tc.getVista().getCartaSeleccionada().removeAll();
				this.tc.getVista().mostrar();

				this.tc.getVista().getCartaSeleccionada().add(label);
				this.tc.getVista().mostrar();
				this.tc.getVista().getCartaSeleccionada().setVisible(true);

			} else {

				String stringDefault = this.tc.getVista().getPathCartaDefault();

				java.net.URL urlCartaDefault = getClass().getResource(stringDefault);
				ImageIcon iconCartaDefault = new ImageIcon(
						new ImageIcon(urlCartaDefault).getImage().getScaledInstance(400, 380, Image.SCALE_DEFAULT));
				JLabel labelDefault = new JLabel(iconCartaDefault);
				this.tc.getVista().getCartaSeleccionada().removeAll();
				this.tc.getVista().mostrar();

				this.tc.getVista().getCartaSeleccionada().add(labelDefault);
				this.tc.getVista().mostrar();
				this.tc.getVista().getCartaSeleccionada().setVisible(true);

			}
		}
	}

	@Override
	public void mouseExited(MouseEvent e) {

	}

}