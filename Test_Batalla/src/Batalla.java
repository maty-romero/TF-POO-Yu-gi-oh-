

public class Batalla {

	/* 
	 * Cada turno se instancia un nuevo objeto Batalla con los duelistas correspondientes:
	 * duelistaJugador --> Duelista que esta en su turno 
	 * duelistaOponente --> Duelista que se ataca
	 * 
	 * Controlar desde afuera que el campo atacante tenga monstruos para utilizar el metodo Atacar()
	 * Caso contrario atacar al duelista de maenra directa 
	 */
	
	private Duelista duelistaJugador; 
	private Duelista duelistaOponente;
	
	public Batalla(Duelista duelistaJugador, Duelista duelistaOponente) {
		this.duelistaJugador = duelistaJugador;
		this.duelistaOponente = duelistaOponente;
	}
	
	/* 
	 * Ambas Cartas en posicion ataque: 
	 * 	
	 *  dmg = cartaAtacante.getAtaque() - cartaObjetivo.getAtaque()
	 * 
	 * 	dmg > 0 --> cartaAtacante gano, duelista no recibe daño 
	 * 	dmg < 0 --> cartaObjetivo gano, duelista recibe daño restante. 
	 * 	dmg = 0 --> ambas cartas mueren, duelista no recibe daño. 
	 * 
	 * Una carta en posicion de ataque y otra en defensa --> Ningun duelista recibe daño.
	 * 	
	 *  dmg = cartaAtacante.getAtaque() - cartaObjetivo.getAtaque()
	 *   
	 * 	dmg >= 0 --> CartaObjetivo muere 
	 *  dmg < 0 --> Ninguna carta muere, sigue la partida 
	 */	 

	public void atacar(CartaMonstruo cartaAtacante, CartaMonstruo cartaObjetivo) {
		if (cartaObjetivo.getPosicionAtaque()) { // Ambas Cartas en posicion ataque
			Integer dmg = cartaAtacante.getAtaque() - cartaObjetivo.getAtaque(); 
			if(dmg > 0) { //duelistaJugador 
				this.getDuelistaOponente().getCementerio().llevarMonstruoCementerio(cartaObjetivo); 
			}else if(dmg < 0) { 
				this.getDuelistaJugador().getCementerio().llevarMonstruoCementerio(cartaAtacante);
				this.getDuelistaJugador().recibirDanio(Math.abs(dmg));
			}else { //dmg = 0
				this.getDuelistaJugador().getCementerio().llevarMonstruoCementerio(cartaAtacante);
				this.getDuelistaOponente().getCementerio().llevarMonstruoCementerio(cartaObjetivo);
			}
			
		// Una carta en posicion de ataque y otra en defensa
		} else { 
			Integer dmg = cartaAtacante.getAtaque() - cartaObjetivo.getDefensa(); 
			if(dmg >= 0 ) {
				this.getDuelistaOponente().getCementerio().llevarMonstruoCementerio(cartaObjetivo);
			}
			//caso contrario no pasa nada y sigue la partida
		}	
	}

	public Duelista getDuelistaJugador() {
		return duelistaJugador;
	}

	public Duelista getDuelistaOponente() {
		return duelistaOponente;
	}
	
}
