package mainPrincipal;

import modelo.Modelo;
import controlador.Controlador;

import vista.Vista_tablero;

public class Main {
	public static void main(String[] args) {
		Modelo modelo = new Modelo();
		Vista_tablero vista = new Vista_tablero();
		Controlador controlador = new Controlador(modelo, vista);
//ManoJugador manoJug= new ManoJugador(vista);

	}

}