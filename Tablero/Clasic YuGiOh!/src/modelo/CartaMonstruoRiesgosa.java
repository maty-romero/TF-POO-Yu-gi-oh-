package modelo;

import java.util.Random;

import exepciones.PierdeLaPartida;

public class CartaMonstruoRiesgosa extends CartaMonstruo {

	public CartaMonstruoRiesgosa(Integer id, String nombre, String descripcion, String pathImagen, Integer ataque,
			Integer defensa) {
		super(id, nombre, descripcion, pathImagen, ataque, defensa);
	}

	@Override
	public void AccionCarta(CartaMonstruo cartaObjetivo, Duelista duelistaAtacante, Duelista duelistaAtacado)
			throws PierdeLaPartida {

		if (new Random().nextBoolean()) {
			duelistaAtacado.eliminacionCartaMuerta(duelistaAtacado, cartaObjetivo);
			duelistaAtacado.recibirDanio(1000);
			duelistaAtacado.setVida(duelistaAtacado.getVida() / 2);

		} else {
			duelistaAtacante.eliminacionCartaMuerta(duelistaAtacante, this);
			duelistaAtacante.recibirDanio(1000);
			duelistaAtacante.setVida(duelistaAtacante.getVida() / 2);
		}

	}

}
