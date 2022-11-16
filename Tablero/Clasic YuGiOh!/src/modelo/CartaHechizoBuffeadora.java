package modelo;

import java.util.HashMap;

import javax.swing.JPanel;

public class CartaHechizoBuffeadora extends CartaHechizo {

	public CartaHechizoBuffeadora(Integer id, String nombre, String descripcion, String pathImagen, Integer efecto) {
		super(id, nombre, descripcion, pathImagen, efecto);
	}

	public void aplicarEfectoMagicoAMonstruo(CartaHechizo cartaHechizo, CartaMonstruo cartaMonstruo) {
		Integer valorEfecto = cartaHechizo.getEfecto();

		Integer nuevoAtaque = cartaMonstruo.getAtaque();

		nuevoAtaque = nuevoAtaque + valorEfecto;
		cartaMonstruo.setAtaque(nuevoAtaque);

		try {
			Thread.sleep(2000);
		} catch (Exception e) {
		}

	}

}
