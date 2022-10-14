package modelo;

import java.net.URL;

import javax.swing.JPanel;

public abstract class Carta {
	
	protected Integer id;  
	protected String nombre, descripcion;   
	
	//private URL imagen;
	
	public Carta(Integer id, String nombre, String descripcion) {
		this.id = id;
		this.nombre = nombre;
		this.descripcion = descripcion;
		//this.imagen = imagen;
		
		
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

//	public URL getImagen() {
//		return imagen;
//	} 
	
	
	
	
	
}
