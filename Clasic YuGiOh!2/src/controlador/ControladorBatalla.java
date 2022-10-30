package controlador;

import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.HashMap;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;

import modelo.Carta;
import modelo.CartaMonstruo;
import modelo.Modelo;
import vista.VistaTablero;

public class ControladorBatalla implements MouseListener, ActionListener{

	/*
	 * Al seleccionar una carta monstruo habilita boton Atacar 
	 * 
	 * Al presionar atacar verificar si el oponente tiene monstruos 
	 * 		no tiene --> ataque directo 
	 * 		tiene --> metodo atacar de Batalla
	 */
	
	private VistaTablero vista;
	private Modelo modelo;
	private TableroController tControler;
	
	private CartaMonstruo monstruoJugadorTurno; 
	
	
	public ControladorBatalla(VistaTablero vista, TableroController tableroControler) {
		this.vista = vista; 
		this.tControler = tableroControler;
		this.modelo = new Modelo();
	}
	
	@Override
	public void mousePressed(MouseEvent e) {
	}
	
	@Override
	public void mouseReleased(MouseEvent e) {
	}
	
	@Override
	public void mouseEntered(MouseEvent e) {

		
	}
	@Override
	public void mouseExited(MouseEvent e) {
		
	}
	
	//clikear y soltar = 1 click 
	@Override
	public void mouseClicked(MouseEvent e) {

		// si el evento es igual a alguno de los paneles del campo Monstruo Jugador, se activa el boton Atacar.
		
		if (e.getSource() == this.vista.getCarta1Campo_jug() || e.getSource() == this.vista.getCarta2Campo_jug()
				|| e.getSource() == this.vista.getCarta3Campo_jug()) {
			
			System.out.println("Campo Monstruos del Jugador seleccionado!!");
			this.vista.getBtnAtacar().setEnabled(true);
//				this.vista.getBtnAtacar().setVisible(true);
		}
		
		//Hago click y extraigo el objeto Montruo del Hash CampoJugador.
		//Recorro las claves (JPanel) del hash Campo 
		for (JPanel key : this.tControler.getCampoMonstruosJugador().keySet()) {
			if (e.getSource() == key) {
				//obtengo el monstruo Jugador y lo agrego al atributo
				monstruoJugadorTurno = this.tControler.getCampoMonstruosJugador().get(key); 
			}
		}
		
	}
	
	//Presiono el boton Atacar y el panel del monstruo Objetivo
	//	Recorro el hashMap y el que coincida usar la instancia de batalla atacar 

	@Override
	public void actionPerformed(ActionEvent e) {
		
		
	}
	
	
	
	
	
	
}
