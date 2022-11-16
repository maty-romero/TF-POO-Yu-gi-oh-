package modelo;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;

public class Barajador {

	/*
	 * QUERY: SELECT * from monstruos WHERE RANDOM() <=0.5
	 * 
	 * Se obtiene aproximadamente el 50% de los datos de la tabla
	 */

	// se retorna un deck para los duelista
	public static Deck generaDeck() {

		// variables para los campos
		Integer id, ataque, defensa, efecto;
		String nombre, descripcion, url;

		Deck deck = new Deck();
		LinkedList<CartaMonstruo> monstruos = new LinkedList<>();
		LinkedList<CartaMonstruo> monstruosRiesgosos = new LinkedList<>();

		LinkedList<CartaHechizo> hechizos = new LinkedList<>();
		LinkedList<CartaHechizo> hechizosMultiplicadores = new LinkedList<>();

		try {
			// obtengo los resultSet de cada tabla.

			// Se obtiene aproximadamente el 50% de las filas de la tablas
			ResultSet rsCartaHMultiplicadora = ConexionDB.getInstance()
					.query("SELECT * from cartas c  WHERE  c.tipo = 'hechizo_multiplicadora'");

			ResultSet rsCartaH = ConexionDB.getInstance()
					.query("SELECT * from cartas c  WHERE  c.tipo = 'hechizo_buffeadora'");
			ResultSet rsCartaM = ConexionDB.getInstance()
					.query("SELECT * from cartas c WHERE c.tipo =  'monstruo_normal'");
			ResultSet rsCartaMRiesgoso = ConexionDB.getInstance()
					.query("SELECT * from cartas c WHERE c.tipo =  'monstruo_riesgoso'");

			ResultSet rsCartaHechizo_destructor = ConexionDB.getInstance()
					.query("SELECT * from cartas c WHERE c.tipo =  'hechizo_destructor'");
			// pregunta si hay filas.
			while (rsCartaH.next() && rsCartaM.next() && rsCartaHMultiplicadora.next() && rsCartaMRiesgoso.next()) { // recorre
																														// fila
																														// por
																														// fila
				// asiganando
				// se obtienen los monstruos y se añade al deck.

				id = rsCartaM.getInt("id_carta");
				nombre = rsCartaM.getString("nombre");
				descripcion = rsCartaM.getString("descripcion");
				url = rsCartaM.getString("pathImagen");
				ataque = rsCartaM.getInt("ataque");
				defensa = rsCartaM.getInt("defensa");

				monstruos.add(new CartaMonstruoNormal(id, nombre, descripcion, url, ataque, defensa));

				id = rsCartaMRiesgoso.getInt("id_carta");
				nombre = rsCartaMRiesgoso.getString("nombre");
				descripcion = rsCartaMRiesgoso.getString("descripcion");
				url = rsCartaMRiesgoso.getString("pathImagen");
				ataque = rsCartaMRiesgoso.getInt("ataque");
				defensa = rsCartaMRiesgoso.getInt("defensa");

				monstruosRiesgosos.add(new CartaMonstruoRiesgosa(id, nombre, descripcion, url, ataque, defensa));

				// se obtienen los hechizos y se añade al deck.

				id = rsCartaH.getInt("id_carta");
				nombre = rsCartaH.getString("nombre");
				descripcion = rsCartaH.getString("descripcion");
				url = rsCartaH.getString("pathImagen");
				efecto = rsCartaH.getInt("efecto");
				hechizos.add(new CartaHechizoBuffeadora(id, nombre, descripcion, url, efecto)); // agrego al deck
																								// hechizos

				id = rsCartaHMultiplicadora.getInt("id_carta");
				nombre = rsCartaHMultiplicadora.getString("nombre");
				descripcion = rsCartaHMultiplicadora.getString("descripcion");
				url = rsCartaHMultiplicadora.getString("pathImagen");
				efecto = rsCartaHMultiplicadora.getInt("efecto");
				hechizosMultiplicadores.add(new CartaHechizoMultiplicadoraRandom(id, nombre, descripcion, url, efecto)); // agrego
																															// al
																															// deck
				// hechizos

			}
//			while (rsCartaHMultiplicadora.next()) {
//				id = rsCartaH.getInt("id_carta");
//				nombre = rsCartaH.getString("nombre");
//				descripcion = rsCartaH.getString("descripcion");
//				url = rsCartaH.getString("pathImagen");
//				efecto = rsCartaH.getInt("efecto");
//				hechizosMultiplicadores.add(new CartaHechizoMultiplicadoraRandom(id, nombre, descripcion, url, efecto)); // agrego al deck
//																								// hechizos
//			}

		} catch (SQLException e) {
			e.printStackTrace();
		}

		// se retorna el deck obtenido
		monstruos.addAll(monstruosRiesgosos);
		deck.setMonstruos(monstruos);
		hechizos.addAll(hechizosMultiplicadores);
		deck.setHechizos(hechizos);

		System.out.println("size monstruos  XXXXXX" + monstruosRiesgosos.size());
		System.out.println("size monstruos" + hechizos);
		return deck;

	}

}
