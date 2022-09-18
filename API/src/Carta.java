import com.google.gson.annotations.SerializedName;

public class Carta {

	@SerializedName("data")
	private String nombre; 
	private String imagenes;
	
	
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	
	
//	public String[] getImagenes() {
//		return imagenes;
//	}
//	public void setImagenes(String[] imagenes) {
//		this.imagenes = imagenes;
//	} 
	
	
	
	
}
