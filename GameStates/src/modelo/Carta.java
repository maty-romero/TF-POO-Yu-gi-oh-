package modelo;

import java.net.URL;

import javax.swing.JPanel;

public abstract class Carta {
	
	protected Integer id;  
	protected String nombre, descripcion;   
	
	private String urlImagen;
	
	public Carta(Integer id, String nombre, String descripcion, String urlImagen) {
		this.id = id;
		this.nombre = nombre;
		this.descripcion = descripcion;
		this.urlImagen = urlImagen; 
	} 
	
	//Getters 
	
	public Integer getId() {
		return id;
	}

	public String getNombre() {
		return nombre;
	}

	public String getDescripcion() {
		return descripcion;
	}

	private String getUrlImagen() {
		return urlImagen;
	}


	
	
	
	
	
}
