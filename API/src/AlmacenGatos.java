import java.util.ArrayList;

public class AlmacenGatos {

	private ArrayList<Gato> gatos = new ArrayList<>();

	public AlmacenGatos(Gato gato) {
		super();
		this.getGatos().add(gato); //añade un objeto gato al crear un objeto AlmacenGato
	}

	public ArrayList<Gato> getGatos() {
		return gatos;
	}

	public void setGatos(ArrayList<Gato> gatos) {
		this.gatos = gatos;
	} 
	
	
	
	
}
