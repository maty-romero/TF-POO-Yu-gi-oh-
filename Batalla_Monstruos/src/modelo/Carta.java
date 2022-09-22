package modelo;

import java.net.URL;

public abstract class Carta {

	/*
	 * Falta la implementacion de la invocacion de cartas. 
	 */
	
	private Integer id; 
	private String nombre, descripcion; 
	private URL imagen;
	
	public Carta(Integer id, String nombre, String descripcion, URL imagen) {
		this.id = id;
		this.nombre = nombre;
		this.descripcion = descripcion;
		this.imagen = imagen;
	}
 
	public void invocarCarta(Carta c) {
		
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

	public URL getImagen() {
		return imagen;
	} 
	
	
	
	
	
}
