package modelo;

import java.util.HashMap;

import javax.swing.JPanel;

public class CartaHechizo extends Carta {
	private Integer efecto;

	public CartaHechizo(Integer id, String nombre, String descripcion, String pathImagen, Integer efecto) {
		super(id, nombre, descripcion, pathImagen);
		this.efecto = efecto;
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

	@Override
	public String toString() {
		return super.toString() + "\nEfecto: " + this.efecto;
	}

	public Integer getEfecto() {
		return efecto;
	}

	public void setEfecto(Integer efecto) {
		this.efecto = efecto;
	}

}
