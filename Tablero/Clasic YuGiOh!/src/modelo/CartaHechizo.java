package modelo;

import java.util.HashMap;

import javax.swing.JPanel;

public abstract class CartaHechizo extends Carta {
	
	private Integer efecto;
	
	public CartaHechizo(Integer id, String nombre, String descripcion, String pathImagen, Integer efecto) {
		super(id, nombre, descripcion, pathImagen);
		this.efecto = efecto;
	}
	
	public abstract void aplicarEfectoMagicoAMonstruo(CartaHechizo hechizo, CartaMonstruo monstruo);

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
