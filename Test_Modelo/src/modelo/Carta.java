package modelo;

import java.net.URL;

public abstract class Carta {

	
	private Integer id; 
//	protected Boolean esMonstruo; //true = Monstruo; false = Hechizo 
	
	private String nombre, descripcion; 
//	private URL imagen;
	
	public Carta(Integer id, String nombre, String descripcion) {
		this.id = id;
		this.nombre = nombre;
		this.descripcion = descripcion;
//		this.imagen = imagen;
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

	public abstract Boolean getEsMonstruo(); 

	public abstract void setEsMonstruo(Boolean esMonstruo); 

	
//	public URL getImagen() {
//		return imagen;
//	}

	
	
	
	
	
	
}
