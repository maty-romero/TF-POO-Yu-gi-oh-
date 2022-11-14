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
		LinkedList<CartaHechizo> hechizos = new LinkedList<>();

		try {
			// obtengo los resultSet de cada tabla.

			// Se obtiene aproximadamente el 50% de las filas de la tablas
			ResultSet rsCartaH = ConexionDB.getInstance().query("SELECT * from cartas c  WHERE  c.tipo = 'hechizo'");
			ResultSet rsCartaM = ConexionDB.getInstance().query("SELECT * from cartas c WHERE c.tipo =  'monstruo' ");
			ResultSet rsCartaHechizo_destructor = ConexionDB.getInstance()
					.query("SELECT * from cartas c WHERE c.tipo =  'hechizo_destructor' ");
			// pregunta si hay filas.
			while (rsCartaH.next() && rsCartaM.next()) { // recorre fila por fila asiganando
				// se obtienen los monstruos y se añade al deck.

				id = rsCartaM.getInt("id_carta");
				nombre = rsCartaM.getString("nombre");
				descripcion = rsCartaM.getString("descripcion");
				url = rsCartaM.getString("pathImagen");
				ataque = rsCartaM.getInt("ataque");
				defensa = rsCartaM.getInt("defensa");

				monstruos.add(new CartaMonstruo(id, nombre, descripcion, url, ataque, defensa));

				// se obtienen los hechizos y se añade al deck.

				id = rsCartaH.getInt("id_carta");
				nombre = rsCartaH.getString("nombre");
				descripcion = rsCartaH.getString("descripcion");
				url = rsCartaH.getString("pathImagen");
				efecto = rsCartaH.getInt("efecto");
				hechizos.add(new CartaHechizo(id, nombre, descripcion, url, efecto)); // agrego al deck hechizos
				hechizos.add(new CartaHechizo(id, nombre, descripcion, url, efecto)); // agrego al deck hechizos
				hechizos.add(new CartaHechizo(id, nombre, descripcion, url, efecto)); // agrego al deck hechizos
//				hechizos.add(new CartaHechizo(id, nombre, descripcion, url, efecto)); // agrego al deck hechizos
//				hechizos.add(new CartaHechizo(id, nombre, descripcion, url, efecto)); // agrego al deck hechizos
//				hechizos.add(new CartaHechizo(id, nombre, descripcion, url, efecto)); // agrego al deck hechizos
//				hechizos.add(new CartaHechizo(id, nombre, descripcion, url, efecto)); // agrego al deck hechizos
//				hechizos.add(new CartaHechizo(id, nombre, descripcion, url, efecto)); // agrego al deck hechizos

			}

		} catch (SQLException e) {
			e.printStackTrace();
		}

		// se retorna el deck obtenido
		deck.setMonstruos(monstruos);
		deck.setHechizos(hechizos);
		System.out.println("size monstruos" + monstruos);
		System.out.println("size monstruos" + hechizos);
		return deck;

	}

}
