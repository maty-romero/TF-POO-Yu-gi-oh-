package modelo;
import javax.swing.JPanel;

public class CartaHechizo extends Carta {

	public CartaHechizo(Integer id, String nombre, String descripcion, String pathImagen) {
		super(id, nombre, descripcion, pathImagen);
	}

	@Override
	public String toString() {
		return "CartaHechizo [id=" + super.getId() + ", nombre=" + super.getNombre() + ", descripcion=" 
				+ super.getDescripcion() + "pathImagen= " + super.getPathImagen() + "]";
	}

	

}
