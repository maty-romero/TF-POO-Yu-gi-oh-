import java.sql.ResultSet;
import java.sql.SQLException;

public class Main {

	public static void main(String[] args) {
		
		
		
		try {

			String query = "SELECT * from "; //para obtener las demas DB 
			
			ResultSet rs = ConexionDB.getInstance().query(query + "monstruos"); 
						
			//recorro filas, 
			while(rs.next()) { //recorre fila por fila asiganando
			
				Integer id = rs.getInt("id_carta");
				String nombre = rs.getString("nombre");
				String descripcion = rs.getString("descripcion");
				String url = rs.getString("imagen_url");
				Integer ataque = rs.getInt("ataque");
				Integer defensa = rs.getInt("defensa");
								
			}

		} catch (SQLException e) {
			e.printStackTrace();
		} 
		
		 
		
		
		

	}

}
