
import java.util.ArrayList;

public class Campo {

	private ArrayList<CartaMonstruo> monstruos = new ArrayList<>(); 
	private ArrayList<CartaHechizo> hechizos = new ArrayList<>(); 
	
	/* 
	 * Se implementa de esta manera el invocar ya que las cartas de la Mano del duelista son de tipo Carta
	 * Por lo que no es posible pasar por parametro cartas de tipo Monstruo o Hechizo. 
	 */
	
	/* 
	 * No deberia utilizarse de esta forma 
	 * 
	public void invocarCartaCampo(Carta carta) {
		if(carta instanceof CartaMonstruo) {
			this.getMonstruos().add(carta);
		}else {
			this.getHechizos().add(carta); 
		}
		
	}
	
	//idem invocacion 
	public void elminarCartaCampo(Carta carta) {
		if(carta instanceof CartaMonstruo) {
			this.getMonstruos().remove(carta);
		}else {
			this.getHechizos().remove(carta); 
		}
	}
	*/
	
	
	public void invocarMonstruo(CartaMonstruo c) {
		this.getMonstruos().add(c); 
	}

	public void eliminarMonstruo(CartaMonstruo c) {
		this.getMonstruos().remove(c); 
	}
	
	//terminar
	public void invocarHechizo(CartaHechizo c) {
		this.getHechizos().add(c); 
	}
	
	public void eliminarHechizo(CartaHechizo c) {
		this.getMonstruos().remove(c); 
	}

	//Getters
	
	public ArrayList<CartaMonstruo> getMonstruos() {
		return monstruos;
	}

	public ArrayList<CartaHechizo> getHechizos() {
		return hechizos;
	}
	
	
	
}
