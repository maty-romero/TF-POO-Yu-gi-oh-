package controlador;

import java.awt.Image;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.HashMap;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;

import modelo.Carta;
import modelo.CartaMonstruo;
import modelo.Modelo;
import modelo.ResultadoBatalla;
import vista.VistaTablero;

public class ControladorBatalla implements MouseListener{

	/*
	 * Al seleccionar una carta monstruo habilita boton Atacar 
	 * 
	 * Al presionar atacar verificar si el oponente tiene monstruos 
	 * 		no tiene --> ataque directo 
	 * 		tiene --> metodo atacar de Batalla
	 */
	
	private TableroController tc;
	
	//Se obtienen objetos y Paneles por separado con los mouseListener 
	private CartaMonstruo monstruoAtacante, monstruoObjetivo; 
	private JPanel panelMonstruoAtacante, panelMonstruoObjetivo; 

	private ResultadoBatalla resultadoBatalla; 
	
	public ControladorBatalla(TableroController tableroControler) {
		this.tc = tableroControler;
	}
	
	//clikear y soltar = 1 click 
	@Override
	public void mouseClicked(MouseEvent e) {
		this.panelMonstruoObjetivo = (JPanel) e.getSource(); //panel que se selecciono 
		
		this.monstruoObjetivo = this.tc.getManoMonstruoOponente().get(this.panelMonstruoObjetivo); 
		
		Batalla(); 
		aplicarResultadoBatalla(); 
	}
	
	@Override
	public void mousePressed(MouseEvent e) {
	}
	
	@Override
	public void mouseReleased(MouseEvent e) {
	}
	
	@Override
	public void mouseEntered(MouseEvent e) {
		this.panelMonstruoAtacante = (JPanel) e.getSource(); //panel que se apunta al monstruo Atacante
		
		this.monstruoAtacante = this.tc.getCampoMonstruosJugador().get(this.panelMonstruoAtacante); //obtengo el monstruo que coincida con el campo del Jugador
	}
	
	@Override
	public void mouseExited(MouseEvent e) {
	}
	
	public void Batalla() {
		//si no tiene monstruos el Bot --> AtaqueDirecto 
		if(this.tc.getCampoMonstruosOponente().size() == 0) {
			this.tc.getBatallaJugador().ataqueDirecto(this.monstruoAtacante);
		}else {
			this.resultadoBatalla = tc.getBatallaJugador().atacar(this.monstruoAtacante, this.monstruoObjetivo); 
		}
	}
	
	/*
	 * Verifica si mueriron cartas, para eliminar paneles del tablero 
	 * Verifica y actualiza la vida de los duelistas en la vista. 
	 */
	
	public void aplicarResultadoBatalla() {
		//verificacion de vida de los duelistas 
		
		//obtengo la vida vida de los duelistas en String --> Para el JLabel
		String vidaDuelistaJugador = String.valueOf(tc.getDuelistaJugador().getVida());
		String vidaDuelistaOponente = String.valueOf(tc.getDuelistaOponente().getVida());
		//seteo la nueva vida la vista
		this.tc.getVista().setContadorJug(new JLabel(vidaDuelistaJugador));
		this.tc.getVista().setContadorBot(new JLabel(vidaDuelistaOponente));
		
		//Se remueven paneles de monstruos muertos si es necesario (si hay muertos)
		if(this.resultadoBatalla.getMonstruoMuertoJugador() != null) {
			this.tc.getCampoMonstruosJugador().remove(this.panelMonstruoAtacante); 
		}
		
		if(this.resultadoBatalla.getMonstruoMuertoOponente() != null) {
			this.tc.getCampoMonstruosOponente().remove(this.panelMonstruoAtacante); 
		}
		
	}
	
	
	
}
