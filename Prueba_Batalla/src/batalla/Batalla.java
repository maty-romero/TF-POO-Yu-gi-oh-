package batalla;

public class Batalla {

	private Duelista duelistaJugador; 
	private Duelista duelistaOponente;
	
	public Batalla(Duelista duelistaJugador, Duelista duelistaOponente) {
		this.duelistaJugador = duelistaJugador;
		this.duelistaOponente = duelistaOponente;
	}
	
	/* 
	 * Ambas Cartas en posicion ataque: 
	 * 	dmg > 0 --> cartaAtacante gano, duelista no recibe daño 
	 * 	dmg < 0 --> cartaObjetivo gano, duelista recibe daño restante. 
	 * 	dmg = 0 --> ambas cartas mueren, duelista no recibe daño. 
	 * 
	 * Una carta en posicion de ataque y otra en defensa --> Ningun duelista recibe daño. 
	 * dmg = ataque - defensa: 
	 * 	dmg >= 0 --> CartaObjetivo muere 
	 *  dmg < 0 --> Ninguna carta muere
	 */	
	
	//cartaAtacante --> duelistaJugador
	//cartaObjetivo --> duelistaOponente
	

	public void atacar(CartaMonstruo cartaAtacante, CartaMonstruo cartaObjetivo) {
		if (cartaObjetivo.getPosicionAtaque()) { // Ambas Cartas en posicion ataque
			Integer dmg = cartaAtacante.getAtaque() - cartaObjetivo.getAtaque(); 
			if(dmg > 0) { //duelistaJugador 
				this.getDuelistaJugador().llevarACementerio(cartaObjetivo);
			}else if(dmg < 0) {
				this.getDuelistaOponente().llevarACementerio(cartaAtacante);
				this.getDuelistaJugador().recibirDanio(dmg);
			}else { //dmg = 0
				this.getDuelistaJugador().llevarACementerio(cartaAtacante);
				this.duelistaOponente.llevarACementerio(cartaObjetivo);
			}
			
			 // daño que se le hace al duelista que recibe el ataque

		} else { // Una carta en posicion de ataque y otra en defensa
			Integer dmg = cartaAtacante.getAtaque() - cartaObjetivo.getDefensa(); 
			if(dmg >= 0 ) {
				this.getDuelistaJugador().llevarACementerio(cartaAtacante);
			}else {
				this.getDuelistaOponente().llevarACementerio(cartaObjetivo);
			}
				
	}
			
}

	public Duelista getDuelistaJugador() {
		return duelistaJugador;
	}

	public Duelista getDuelistaOponente() {
		return duelistaOponente;
	}
	
}
