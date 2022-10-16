
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ConexionDB {

	/*
	 * Conexion a una BD Postgresql utilizando Singleton
	 */

	private static ConexionDB instance;
	private Connection connection;
	private String url = "jdbc:postgresql://localhost/YUGIOH_DB";
	private String username = "postgres";
	private String password = "gatos123";
	
	private PreparedStatement ps = null; 
	private ResultSet rs = null; 

	private ConexionDB() {
		try {
			Class.forName("org.postgresql.Driver");
			this.connection = DriverManager.getConnection(url, username, password);
			System.out.println("Conexion establecida con la BD.");
			
		} catch (ClassNotFoundException e) {
			System.out.println("Conexion con BD fallida: " + e.getMessage());
		} catch(SQLException e) {
			System.out.println("Consulta SQL Fallida. " + e.getMessage());
			e.printStackTrace();
		}
	}
	
	public ResultSet query(String query) {
		try {
			ps = getConnection().prepareStatement(query);
			rs = ps.executeQuery();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return rs; 

	}
	
	//Imprime en consola el ResultSet
	public void ImpresionCompleta(ResultSet rs) {
		try {
			while (rs.next()) {
				System.out.println(rs.getInt("id_carta"));
				System.out.println(rs.getString("nombre"));
				System.out.println(rs.getString("descripcion"));
				System.out.println(rs.getString("imagen_url"));
				System.out.println(rs.getString("ataque"));
				System.out.println(rs.getString("defensa"));

				System.out.println("");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}
	
	public CartaMonstruo getInstanceMonstruo(ResultSet rs) {
		
		
		return new CartaMonstruo(); 
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

	
	

