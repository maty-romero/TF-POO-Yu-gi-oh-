package modelo;

import java.net.URL;
import javax.swing.JPanel;

public class CartaMonstruo extends Carta {

	private Integer ataque, defensa;
	private Boolean posicionAtaque;

	public CartaMonstruo(Integer id, String nombre, String descripcion, String urlImagen, Integer ataque, Integer defensa) {
		super(id, nombre, descripcion, urlImagen);
		this.ataque = ataque;
		this.defensa = defensa;
	}

	// Getters

	public Integer getAtaque() {
		return ataque;
	}

	public Integer getDefensa() {
		return defensa;
	}

	public Boolean getPosicionAtaque() {
		return posicionAtaque;
	}

	public void setPosicionAtaque(Boolean posicionAtaque) {
		this.posicionAtaque = posicionAtaque;
	}


}
