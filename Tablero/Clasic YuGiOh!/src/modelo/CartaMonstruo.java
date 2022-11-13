package modelo;

import java.net.URL;
import javax.swing.JPanel;

public class CartaMonstruo extends Carta {

	private Integer ataque, defensa;
	private Boolean posicionAtaque;
	private Boolean conVida;

	public CartaMonstruo(Integer id, String nombre, String descripcion, String pathImagen, Integer ataque,
			Integer defensa) {
		super(id, nombre, descripcion, pathImagen);
		this.ataque = ataque;
		this.defensa = defensa;
		this.conVida = true; 
	}

//sé que el duelistaJugador (sea true o false) es el que ataca al duelistaAtacado
	public void AccionCarta(CartaMonstruo cartaObjetivo, Duelista duelistaAtacante, Duelista duelistaAtacado) {
		if (cartaObjetivo.getPosicionAtaque()) { // Ambas Cartas en posicion ataque
			Integer dmg = this.getAtaque() - cartaObjetivo.getAtaque();
			if (dmg > 0) {
				// Según la accion de la carta, le ordeno al duelista perdedor que lleve a su
				// carta al cementerio y saque de su mano, y yo como carta le hago danio directo
				// a la vida del oponente
				duelistaAtacado.recibirDanio(Math.abs(dmg));
				duelistaAtacado.eliminacionCartaMuerta(duelistaAtacado, cartaObjetivo);
			}
			if (dmg < 0) {
				System.out.println("cartaObjetivo gano, duelista recibe daño restante");
				duelistaAtacante.recibirDanio(Math.abs(dmg));
				duelistaAtacante.eliminacionCartaMuerta(duelistaAtacante, this);
			}
			if (dmg == 0) {
				duelistaAtacante.eliminacionCartaMuerta(duelistaAtacante, this);
				duelistaAtacado.eliminacionCartaMuerta(duelistaAtacado, cartaObjetivo);
			}

		} else { // Carta Objetivo en defensa.

			Integer dmg = this.getAtaque() - cartaObjetivo.getDefensa();
			if (dmg > 0) {
				duelistaAtacado.eliminacionCartaMuerta(duelistaAtacado, cartaObjetivo);
			}
			if(dmg < 0) {
				duelistaAtacante.recibirDanio(Math.abs(dmg));
			}
			//dmg = 0 no pasa nada 

		}
	}

	// Si el duelista no tiene monstruos en el campo de batalla, la carta monstruo ataca al duelista
	public void ataqueDirecto(Duelista duelista, CartaMonstruo cartaAtacante) {
		duelista.recibirDanio(cartaAtacante.getAtaque());
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
		return super.toString() + "\n\nataque: " + ataque + "\ndefensa: " + defensa;
	}

	

}
