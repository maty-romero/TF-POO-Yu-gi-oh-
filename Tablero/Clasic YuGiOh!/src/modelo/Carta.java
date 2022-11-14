package modelo;

import java.net.URL;

import javax.swing.JPanel;

public abstract class Carta {
	
	protected Integer id;  
	protected String nombre, descripcion;   
	protected Boolean bocaAbajo; 
	private String pathImagen;
	
	public Carta(Integer id, String nombre, String descripcion, String pathImagen) {
		this.id = id;
		this.nombre = nombre;
		this.descripcion = descripcion;
		this.pathImagen = pathImagen; 
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

	public String getPathImagen() {
		return pathImagen;
	}

	public void setPathImagen(String pathImagen) {
		this.pathImagen = pathImagen;
	}

	public Boolean getBocaAbajo() {
		return bocaAbajo;
	}

	public void setBocaAbajo(Boolean bocaAbajo) {
		this.bocaAbajo = bocaAbajo;
	}

	@Override
	public String toString() {
		return  "Carta: " + nombre + "\n\n"+ descripcion ;
	}

	
	

	
	
	
	
	
}
