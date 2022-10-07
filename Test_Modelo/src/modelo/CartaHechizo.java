package modelo;

import java.net.URL;

public class CartaHechizo extends Carta{ 
	
	public CartaHechizo(Integer id, String nombre, String descripcion) {
		super(id, nombre, descripcion);
		this.setEsMonstruo(false);
	}

	@Override
	public Boolean getEsMonstruo() {
		return this.esMonstruo;
	}

	@Override
	public void setEsMonstruo(Boolean esMonstruo) {
		this.esMonstruo = esMonstruo; 
		
	}

	
	

}
