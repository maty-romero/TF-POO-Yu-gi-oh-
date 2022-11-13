package controlador;

import vista.MenuFinal;

public class MenuFinalController {

	MenuFinal vista; 
	
	public MenuFinalController(String mensajeGanador) {
		this.vista = new MenuFinal();
		this.vista.setTitle("YUGIOH");
		this.vista.setResizable(false);
		this.vista.setVisible(true);
		this.vista.setLocationRelativeTo(null);
		
		this.vista.getMensajeFinalPartida().setText(mensajeGanador);
	}
	
}
