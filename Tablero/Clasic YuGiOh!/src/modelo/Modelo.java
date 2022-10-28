package modelo;

import java.awt.Color;
import java.awt.Image;
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

import controlador.TableroController;

public class Modelo {
	private TableroController controlador;

	
	//Genero la imagen de una carta cualquiera, la carta debe tener datos cargados desde la base de datos.
	public JLabel generoImagenCarta(Carta carta) {
		java.net.URL urlCarta = getClass().getResource(carta.getPathImagen());
		ImageIcon iconURL = new ImageIcon(
				new ImageIcon(urlCarta).getImage().getScaledInstance(150, 90, Image.SCALE_DEFAULT));
		JLabel imgCarta = new JLabel(iconURL);
		return imgCarta;
	}

}