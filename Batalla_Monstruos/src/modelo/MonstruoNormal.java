package modelo;

import java.net.URL;

public class MonstruoNormal extends Carta{

	private Integer ataque, defensa; 
	private Boolean posicion_ataque, posicion_defensa;
	
	public MonstruoNormal(Integer id, String nombre, String tipo, String descripcion, URL url_carta, Integer ataque,
			Integer defensa, Boolean posicion_ataque, Boolean posicion_defensa) {
		super(id, nombre, tipo, descripcion, url_carta);
		this.ataque = ataque;
		this.defensa = defensa;
		this.posicion_ataque = posicion_ataque;
		this.posicion_defensa = posicion_defensa;
	}

	//Getters 
	
	public Integer getAtaque() {
		return ataque;
	}

	public Integer getDefensa() {
		return defensa;
	}

	public Boolean getPosicion_ataque() {
		return posicion_ataque;
	}

	public Boolean getPosicion_defensa() {
		return posicion_defensa;
	}
	
	

	 
	
	
	
}
