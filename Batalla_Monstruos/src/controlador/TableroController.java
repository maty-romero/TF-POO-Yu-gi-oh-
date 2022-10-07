package controlador;


import modelo.*;
import vista.Vista_tablero;

public class TableroController implements Runnable{
	private Vista_tablero vista;
	private static Batalla batallla;
	private static Campo campoJugador, campoOponente; 
	private static Duelista duelistaJugador, duelistaOponente; 

	public TableroController() {
		this.vista = new Vista_tablero(this);
		this.inicializarVista();
	}

	
	@Override
	public void run() {
		// TODO Auto-generated method stub
		
	}

	
	
	
	private void inicializarVista() {
		this.vista.mostrar();
	}




	
	
	

}