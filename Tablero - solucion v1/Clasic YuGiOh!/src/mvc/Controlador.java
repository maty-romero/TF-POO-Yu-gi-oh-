package mvc;

import java.net.URL;

public class Controlador {
private Vista_tablero vista;
private Modelo modelo;
public Controlador(Modelo modelo, Vista_tablero vista) {
this.modelo = modelo;
this.vista = vista;
this.inicializarVista();

}


private void inicializarVista() {
	this.vista.mostrar();	
}

//public describirCarta() {
//	
//}



}