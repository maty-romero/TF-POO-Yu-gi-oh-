package mvc;

import java.net.URL;

public class Controlador {
	private Vista vista;
	private Modelo modelo;

	public Controlador(Modelo modelo, Vista vista) {
		this.modelo = modelo;
		this.vista = vista;
		this.inicializarVista();

	}

	private void inicializarVista() {
		this.vista.mostrar();

	}

//private void inicializarVista() {
//this.vista.getBotonGenerar().addActionListener( e -> this.generarContraseña() );
//this.vista.mostrar();
//}
//private void generarContraseña() {
//this.modelo.generarContraseña();
//this.vista.getInputContraseña().setText( this.modelo.getContraseña() );
//}
}