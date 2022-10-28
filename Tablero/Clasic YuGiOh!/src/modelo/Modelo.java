package modelo;

import java.awt.Color;
import java.awt.Image;
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

import controlador.TableroController;

public class Modelo {
	private TableroController controlador;

	
	
//Devuelvo la imagen de la carta, gracias a que el objeto carta tiene una ruta de archivo.
	public JLabel generoImagenCarta(Carta carta) {
		java.net.URL urlCarta = getClass().getResource(carta.getPathImagen());
		ImageIcon iconURL = new ImageIcon(
				new ImageIcon(urlCarta).getImage().getScaledInstance(150, 90, Image.SCALE_DEFAULT));
		System.out.println("envio un label al controlador");
		return new JLabel(iconURL);

	}

}