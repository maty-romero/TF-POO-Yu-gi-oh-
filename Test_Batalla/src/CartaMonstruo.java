


import java.net.URL;

public class CartaMonstruo extends Carta{

	/*
	 * Falta la implementacion de la invocacion de cartas. 
	 */
	
	private Integer ataque, defensa; 
	private Boolean posicionAtaque;
	
	public CartaMonstruo(Integer id, String nombre, String descripcion, Integer ataque, Integer defensa) {
		super(id, nombre, descripcion);
		this.ataque = ataque;
		this.defensa = defensa;
	}
	
	//Getters
	
	public Integer getAtaque() {
		return ataque;
	}

	public Integer getDefensa() {
		return defensa;
	}

	public Boolean getPosicionAtaque() {
		return posicionAtaque;
	}

	public void setPosicionAtaque(Boolean posicionAtaque) {
		this.posicionAtaque = posicionAtaque;
	}


	
	
	
	
	

	
	
	
	
	
}