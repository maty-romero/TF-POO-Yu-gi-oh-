package modelo;

import java.util.HashMap;
import java.util.Random;

import javax.swing.JPanel;

//multiplica por 2 o 3 el monstruo elegido, segun el numero en el efecto que tengan.
public class CartaHechizoMultiplicadoraRandom extends CartaHechizo {

	public CartaHechizoMultiplicadoraRandom(Integer id, String nombre, String descripcion, String pathImagen,
			Integer efecto) {
		super(id, nombre, descripcion, pathImagen, efecto);
	}

	@Override
	public void aplicarEfectoMagicoAMonstruo(JPanel cartaMagica, JPanel cartaMonstruo,
			HashMap<JPanel, CartaHechizo> hashCartasMagicas, HashMap<JPanel, CartaMonstruo> hashCartasMonstruo) {

		Integer nuevoAtaque = hashCartasMonstruo.get(cartaMonstruo).getAtaque();
	
		if(new Random().nextBoolean()) {
			nuevoAtaque = nuevoAtaque * super.getEfecto();
			hashCartasMonstruo.get(cartaMonstruo).setAtaque(nuevoAtaque);
			
		}else {
			nuevoAtaque = nuevoAtaque / super.getEfecto();
			hashCartasMonstruo.get(cartaMonstruo).setAtaque(nuevoAtaque);
		
		}

		try {
			Thread.sleep(2000);
		} catch (Exception e) {
		}

	}

}
