package modelo;

import java.net.URL;
import javax.swing.JPanel;

import exepciones.PierdeLaPartida;

public abstract class CartaMonstruo extends Carta {

	private Integer ataque, defensa;
	private Boolean posicionAtaque;
	private Boolean conVida;
	private Boolean puedeRotar;

	public CartaMonstruo(Integer id, String nombre, String descripcion, String pathImagen, Integer ataque,
			Integer defensa) {
		super(id, nombre, descripcion, pathImagen);
		this.ataque = ataque;
		this.defensa = defensa;
		this.conVida = true;
	}

	public abstract void AccionCarta(CartaMonstruo cartaObjetivo, Duelista duelistaAtacante, 
			Duelista duelistaAtacado) throws PierdeLaPartida;

	// Si el duelista no tiene monstruos en el campo de batalla, la carta monstruo
	// ataca al duelista
	public void ataqueDirecto(Duelista duelista, CartaMonstruo cartaAtacante) {
		duelista.recibirDanio(cartaAtacante.getAtaque());
	}

	
	// Getters y setters 

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

	public void setAtaque(Integer ataque) {
		this.ataque = ataque;
	}

	public void setDefensa(Integer defensa) {
		this.defensa = defensa;
	}

	public Boolean getConVida() {
		return conVida;
	}

	public void setConVida(Boolean conVida) {
		this.conVida = conVida;
	}

	@Override
	public String toString() {
		return super.toString() + "\n\nAtaque: " + ataque + "\nDefensa: " + defensa;
	}

}
