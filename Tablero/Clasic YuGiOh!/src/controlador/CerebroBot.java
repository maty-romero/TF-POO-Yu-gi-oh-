package controlador;

import java.util.ArrayList;
import java.util.Random;

import javax.swing.JLabel;
import javax.swing.JPanel;

import modelo.Carta;
import modelo.CartaHechizo;
import modelo.CartaMonstruo;

public class CerebroBot {

	private TableroController tc;
	private Random rnd = new Random(); 
	
	
	public CerebroBot(TableroController tc) {
		this.tc = tc;
	} 
	
	public void robarCarta() {
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		this.getTc().getDuelistaOponente().robarCarta();  //en el modelo ya se elimina y retorna una carta.  
		
		//se setean los hash. 
		this.getTc().setManoMonstruoOponente(this.getTc().envioImagenesManoMonstruoVista(
				this.getTc().getDuelistaOponente().getMano().getManoMonstruos(), this.getTc().getVista().getManoBot()));
		
		this.getTc().setManoHechizoOponente(this.getTc().envioImagenesManoHechizoVista(
				this.getTc().getDuelistaOponente().getMano().getManoHechizos(), this.getTc().getVista().getManoBot()));
	
		this.getTc().getVista().mostrar(); //Actualizo JFrame
	}

	
	
	//INVOCAR --> Consistir desde el flujo de partida si es posible realizar una invocacion. 
	public void invocarCarta() { 
		
		//Invocacion carta monstruo
		if(rnd.nextBoolean()) {
			//sacar un monstruo de un elemento del hash y eliminar el item del hash 
			Object[] panlesKeys = this.getTc().getManoMonstruoOponente().keySet().toArray(); //convierto las claves en un array. 
			Object keyPanel = panlesKeys[new Random().nextInt(panlesKeys.length)]; //obtengo una clave aleatoria 
			
			//remuevo el item asociado al keyPanel asociado y obtengo el monstruo 
			CartaMonstruo monstruo = this.getTc().getManoMonstruoOponente().remove(keyPanel); 
			  
			System.out.println("Monstruo por invocar - BOT: " + monstruo);
			
			JLabel label =  this.getTc().getVista().generoImagenCarta(monstruo); //creo un label con la imagen del monstruo 
			JPanel panel = this.getTc().getVista().devuelvoPanelCampo(label);  //lo focuseo y le agrego el label al panel 

			this.getTc().getCampoMonstruosOponente().put(panel, monstruo); //Se agrega al hash
			
			//Obtengo una posicion vacia para invocar 
			Integer posi = posVaciaCampo(this.getTc().getVista().getPanelesMonstruosCampoOponente());
			
			//se agrega una carta al campo Monstruo Oponente a la vista 
			this.getTc().getVista().getPanelesMonstruosCampoOponente().get(posi).add(panel);
			
		//invocacion carta Hehizo	
		}else {
			
			//sacar un monstruo de un elemento del hash y eliminar el item del hash 
			Object[] panlesKeys = this.getTc().getManoHechizoOponente().keySet().toArray(); //convierto las claves en un array. 
			Object keyPanel = panlesKeys[new Random().nextInt(panlesKeys.length)]; //obtengo una clave aleatoria 
			
			//remuevo el item asociado al keyPanel asociado y obtengo el monstruo 
			CartaHechizo hechizo = this.getTc().getManoHechizoOponente().remove(keyPanel); 
			  
			System.out.println("Hechizo por invocar - BOT: " + hechizo);
			
			JLabel label =  this.getTc().getVista().generoImagenCarta(hechizo); //creo un label con la imagen del monstruo 
			JPanel panel = this.getTc().getVista().devuelvoPanelCampo(label);  //lo focuseo y le agrego el label al panel 

			this.getTc().getCampoHechizosOponente().put(panel, hechizo); //Se agrega al hash
			
			//Obtengo una posicion vacia para invocar 
			Integer posi = posVaciaCampo(this.getTc().getVista().getPanelesHechizosCampoOponente()); 
			
			//se agrega una carta al campo Monstruo Oponente a la vista 
			this.getTc().getVista().getPanelesHechizosCampoOponente().get(posi).add(panel);
			
			
		}
		
		this.getTc().getVista().mostrar(); //Actualizo JFrame
		
		
	}
	
	//Retorna la primera posicion del array en donde esta vacio, para poder invocar en el tablero. 
	private Integer posVaciaCampo(ArrayList<JPanel> paneles) {
		Integer posicion = null; 
		for (int i = 0; i < paneles.size(); i++) {
			if(paneles.get(i) != null) {
				posicion = i; 
			}
		}
		return posicion; 
	}
	
	
	//BATALLA
	
	
	
	
	//Getters y setters 
	public TableroController getTc() {
		return tc;
	}

	public void setTc(TableroController tc) {
		this.tc = tc;
	}
	
}
