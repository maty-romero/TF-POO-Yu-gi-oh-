
import java.net.URL;

public abstract class Carta {

	/*
	 * Falta la implementacion de la invocacion de cartas. 
	 */
	
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
