package mainPrincipal;

import java.net.URLConnection;
import java.net.http.HttpResponse;

import mvc.Controlador;
//import mvc.ManoJugador;
import mvc.Modelo;
import mvc.Vista_tablero;

public class Main {
public static void main(String[] args) {
Modelo modelo = new Modelo();
Vista_tablero vista = new Vista_tablero();
Controlador controlador = new Controlador(modelo, vista);
//ManoJugador manoJug= new ManoJugador(vista);




}

}