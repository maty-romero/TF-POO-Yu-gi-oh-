package modelo;

import java.util.HashMap;

import javax.swing.JPanel;

public class CartaHechizoBuffeadora extends CartaHechizo {

	public CartaHechizoBuffeadora(Integer id, String nombre, String descripcion, String pathImagen, Integer efecto) {
		super(id, nombre, descripcion, pathImagen, efecto);
	}

	public void aplicarEfectoMagicoAMonstruo(JPanel cartaMagica, JPanel cartaMonstruo,
			HashMap<JPanel, CartaHechizo> hashCartasMagicas, HashMap<JPanel, CartaMonstruo> hashCartasMonstruo) {
		Integer valorEfecto = hashCartasMagicas.get(cartaMagica).getEfecto();

		Integer nuevoAtaque = hashCartasMonstruo.get(cartaMonstruo).getAtaque();

		nuevoAtaque = nuevoAtaque + valorEfecto;
		hashCartasMonstruo.get(cartaMonstruo).setAtaque(nuevoAtaque);

		try {
			Thread.sleep(2000);
		} catch (Exception e) {
		}

	}

}