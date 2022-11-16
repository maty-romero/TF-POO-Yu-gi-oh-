package controladoresMenu;

import controlador.TableroController;
import vista.MenuPrincipal;

public class MenuPrincipalController {

	MenuPrincipal vista; 
	
	public MenuPrincipalController() {
		this.vista = new MenuPrincipal();
		this.vista.setTitle("YUGIOH");
		this.vista.setResizable(false);
		this.vista.setVisible(true);
		this.vista.setLocationRelativeTo(null);
		
		this.vista.getBtnSalir().addActionListener(e->{System.exit(0);});
//		this.vista.getBtnOpciones().addActionListener(e->this.opciones());
		this.vista.getBtnNuevaPartida().addActionListener(e->this.nuevaPartida());
	}
	
//	private void opciones() {
//		this.vista.dispose();
//		new OpcionesController();
//	}
	
	private void nuevaPartida() {
		this.vista.dispose();
		new TableroController();
	}
	
}
