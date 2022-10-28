package modelo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ConexionDB {

	/*
	 * Conexion a una BD Postgresql utilizando Singleton
	 */

	private static ConexionDB db = null; 
	private Connection connection;
	private String url = "jdbc:postgresql://localhost/YUGIOH_DB";
	private String username = "postgres";
	private String password = "gatos123";
	 
	private ConexionDB() {
		try {
			this.setConnection(DriverManager.getConnection(url, username, password));
			System.out.println("Conexion establecida con la BD.");
			
		} catch(SQLException e) {
			System.out.println("Conexion con BD fallida. " + e.getMessage());
		}
	}
	
	//se devuelve ResultSet dado un query para mas flexibilidad 
	public ResultSet query(String query) {
		PreparedStatement ps = null;
		ResultSet rs = null;
		try {
			ps = getConnection().prepareStatement(query);
			rs = ps.executeQuery();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return rs; 
	}
	
	//retorno de una sola instancia - Singleton
	public static ConexionDB getInstance() throws SQLException {
		return db != null? db: new ConexionDB(); 
	}

	public Connection getConnection() {
		return connection;
	}

	private void setConnection(Connection connection) {
		this.connection = connection;
	}

	
	
  }

	
	

