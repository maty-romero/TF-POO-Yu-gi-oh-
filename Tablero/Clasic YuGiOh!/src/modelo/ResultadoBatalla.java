package modelo;

public class ResultadoBatalla {
	
	private Integer danioDuelistaJugador, danioDuelistaOponente; 
	private CartaMonstruo monstruoMuertoJugador, monstruoMuertoOponente;
	
	//getters 
	public Integer getDanioDuelistaJugador() {
		return danioDuelistaJugador;
	}
	public Integer getDanioDuelistaOponente() {
		return danioDuelistaOponente;
	}
	public CartaMonstruo getMonstruoMuertoJugador() {
		return monstruoMuertoJugador;
	}
	public CartaMonstruo getMonstruoMuertoOponente() {
		return monstruoMuertoOponente;
	}
	
	
	//setters 
	
	public void setDanioDuelistaJugador(Integer danioDuelistaJugador) {
		this.danioDuelistaJugador = danioDuelistaJugador;
	}
	
	public void setDanioDuelistaOponente(Integer danioDuelistaOponente) {
		this.danioDuelistaOponente = danioDuelistaOponente;
	}
	public void setMonstruoMuertoJugador(CartaMonstruo monstruoMuertoJugador) {
		this.monstruoMuertoJugador = monstruoMuertoJugador;
	}
	public void setMonstruoMuertoOponente(CartaMonstruo monstruoMuertoOponente) {
		this.monstruoMuertoOponente = monstruoMuertoOponente;
	}
	
	
	
	
	
}
