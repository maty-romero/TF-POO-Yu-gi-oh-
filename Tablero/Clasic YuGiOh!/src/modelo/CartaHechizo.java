package modelo;

import java.util.HashMap;

import javax.swing.JPanel;

public abstract class CartaHechizo extends Carta {
	private Integer efecto;
//en particular, son cartas de hechizo que afectan a uno de tus monstruos.
	public CartaHechizo(Integer id, String nombre, String descripcion, String pathImagen, Integer efecto) {
		super(id, nombre, descripcion, pathImagen);
		this.efecto = efecto;
	}
	
//sus hijos implementan este metodo con estos parametros. en cambio, la CartaMonstruo no usa un metodo con estos parametros
	public abstract void aplicarEfectoMagicoAMonstruo(JPanel cartaMagica, JPanel cartaMonstruo,
			HashMap<JPanel, CartaHechizo> hashCartasMagicas, HashMap<JPanel, CartaMonstruo> hashCartasMonstruo);

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
