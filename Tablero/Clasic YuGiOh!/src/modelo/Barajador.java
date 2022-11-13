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
		Integer id, ataque, defensa;
		String nombre, descripcion, url;

		Deck deck = new Deck();
		LinkedList<CartaMonstruo> monstruos = new LinkedList<>();
		LinkedList<CartaHechizo> hechizos = new LinkedList<>();

		try {
			// obtengo los resultSet de cada tabla.

			// Se obtiene aproximadamente el 50% de las filas de la tablas
			ResultSet rsMonstruos = ConexionDB.getInstance().query("SELECT * from monstruos WHERE RANDOM() <=0.5");
			ResultSet rsHechizos = ConexionDB.getInstance().query("SELECT * from hechizos WHERE RANDOM() <=0.5");

			// pregunta si hay filas.
			while (rsMonstruos.next() && rsHechizos.next()) { // recorre fila por fila asiganando

				// se obtienen los monstruos y se añade al deck.

				id = rsMonstruos.getInt("id_monstruo");
				nombre = rsMonstruos.getString("nombre");
				descripcion = rsMonstruos.getString("descripcion");
				url = rsMonstruos.getString("pathImagen");
				ataque = rsMonstruos.getInt("ataque");
				defensa = rsMonstruos.getInt("defensa");

				monstruos.add(new CartaMonstruo(id, nombre, descripcion, url, ataque, defensa)); // agrego al deck
																									// monstruos

				// se obtienen los hechizos y se añade al deck.

				id = rsHechizos.getInt("id_hechizo");
				nombre = rsHechizos.getString("nombre");
				descripcion = rsHechizos.getString("descripcion");
				url = rsHechizos.getString("pathImagen");

				hechizos.add(new CartaHechizo(id, nombre, descripcion, url, 100)); // agrego al deck hechizos
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}

		// se retorna el deck obtenido
		deck.setMonstruos(monstruos);
		deck.setHechizos(hechizos);

		return deck;

	}

}
