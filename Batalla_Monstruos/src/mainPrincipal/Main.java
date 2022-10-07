package mainPrincipal;

import modelo.*;
import controlador.TableroController;
import controlador.TableroController;
import vista.Vista_tablero;

public class Main {
	public static void main(String[] args) {
		try {
			new TableroController(); 
		} catch (Exception e) {
			e.printStackTrace();
		}
		


	}

}