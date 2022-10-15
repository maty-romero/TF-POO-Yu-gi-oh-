import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Conexion {

	/* 
	 * Conexion a una BD Postgresql utilizando Singleton
	 */
	
	private Connection conn;
	private static Database db = null; 
	private final String USER = "";
	private final String PSW = "";
	private final String DBNAME= "";
	private final String PORT = "";
	private final String HOST = "";
	
	private Conexion() {
		try {
			this.setConn(DriverManager.getConnection("jdbc:postgresql://" + HOST + ":" + PORT + "/" + DBNAME, USER, PSW));
		}catch (SQLException e){
			e.printStackTrace(); 
		}
	}

	public static Database getInstance() {
		return db !== null? db: new Conexion(); 
	}
	
	public ResultSet query(String query) {
		try {
			ResultSet rs = null; 
			rs = getConn().createStatement().executeQuery(query); 
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}
	
	private Connection getConn() {
		return conn;
	}

	private void setConn(Connection conn) {
		this.conn = conn;
	}
	
	
	
}
