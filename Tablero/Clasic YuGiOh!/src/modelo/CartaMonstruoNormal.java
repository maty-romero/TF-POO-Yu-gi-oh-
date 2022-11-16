package modelo;

public class CartaMonstruoNormal extends CartaMonstruo {

	public CartaMonstruoNormal(Integer id, String nombre, String descripcion, String pathImagen, Integer ataque,
			Integer defensa) {
		super(id, nombre, descripcion, pathImagen, ataque, defensa);
	}

	@Override
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
			if (dmg < 0) {
				duelistaAtacante.recibirDanio(Math.abs(dmg));
			}
			// dmg = 0 no pasa nada

		}

	}

}
