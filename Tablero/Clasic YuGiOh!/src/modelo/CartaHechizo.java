package modelo;

import javax.swing.JPanel;

public class CartaHechizo extends Carta {
	private Integer efecto;

	public CartaHechizo(Integer id, String nombre, String descripcion, String pathImagen, Integer efecto) {
		super(id, nombre, descripcion, pathImagen);
		this.efecto = efecto;
	}

	@Override
	public String toString() {
		return "CartaHechizo [id=" + super.getId() + ", nombre=" + super.getNombre() + ", descripcion="
				+ super.getDescripcion() + "pathImagen= " + super.getPathImagen() + "]";
	}

	public Integer getEfecto() {
		return efecto;
	}

	public void setEfecto(Integer efecto) {
		this.efecto = efecto;
	}

}
