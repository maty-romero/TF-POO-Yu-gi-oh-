package modelo;

import java.net.URL;

public class CartaMonstruo extends Carta{

	/*
	 * Falta la implementacion de la invocacion de cartas. 
	 */
	
	private Integer ataque, defensa; 
	private Boolean posicionAtaque, posicionDefensa;
	
	public CartaMonstruo(Integer id, String nombre, String descripcion, URL imagen, Integer ataque, Integer defensa) {
		super(id, nombre, descripcion, imagen);
		this.ataque = ataque;
		this.defensa = defensa;
	}

	
	

	
	
	
	
	
}
