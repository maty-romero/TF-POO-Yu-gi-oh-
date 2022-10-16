import java.sql.ResultSet;
import java.sql.SQLException;

public class Main {

	public static void main(String[] args) {
		
		try {
			ConexionDB db = ConexionDB.getInstance();
			
			ConexionDB.getInstance().ImpresionCompleta(
					ConexionDB.getInstance().query("SELECT * FROM monstruos")
					);
			

			
		} catch (SQLException e) {
			e.printStackTrace();
		} 
		
		 
		
		
		

	}

}
