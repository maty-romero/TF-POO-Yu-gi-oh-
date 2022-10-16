
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConexionDB {

	/*
	 * Conexion a una BD Postgresql utilizando Singleton
	 */

	private static ConexionDB instance;
	private Connection connection;
	private String url = "jdbc:postgresql://localhost:5432/jdbc";
	private String username = "root";
	private String password = "localhost";

	private ConexionDB() throws SQLException {
	        try {
	            Class.forName("org.postgresql.Driver");
	            this.connection = DriverManager.getConnection(url, username, password);
	        } catch (ClassNotFoundException ex) {
	            System.out.println("Conexion con BD fallida: " + ex.getMessage());
	        }
	    }

	public Connection getConnection() {
		return connection;
	}

	public static ConexionDB getInstance() throws SQLException {
		if (instance == null) {
			instance = new ConexionDB();
			
		} else if (instance.getConnection().isClosed()) {
			instance = new ConexionDB();
		}

		return instance;
	}
}
	
	

