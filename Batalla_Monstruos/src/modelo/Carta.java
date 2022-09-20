package modelo;

import java.net.URL;

public abstract class Carta {

	private Integer id; 
	private String nombre, tipo, descripcion; 
	private URL url_carta; //url local de carta 
	
	public Carta(Integer id, String nombre, String tipo, String descripcion, URL url_carta) {
		this.id = id;
		this.nombre = nombre;
		this.tipo = tipo;
		this.descripcion = descripcion;
		this.url_carta = url_carta;
	}

	//getters 
	
	public Integer getId() {
		return id;
	}

	public String getNombre() {
		return nombre;
	}

	public String getTipo() {
		return tipo;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public URL getUrl_carta() {
		return url_carta;
	}
	
	
	
	
	
}
