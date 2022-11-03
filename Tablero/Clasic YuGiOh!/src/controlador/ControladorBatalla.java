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
	
	private TableroController tc;
	
	//Se obtienen objetos y Paneles por separado con los mouseListener 
	private CartaMonstruo monstruoAtacante, monstruoObjetivo; 
	private JPanel panelMonstruoAtacante, panelMonstruoObjetivo;  
	
	public ControladorBatalla(TableroController tableroControler) {
		this.tc = tableroControler;
	}
	
	@Override //seleccion de monstruo Objetivo (Bot)
	public void mouseClicked(MouseEvent e) {
		JPanel panel = (JPanel) e.getSource();
		
		if(this.tc.getCampoMonstruosOponente().containsKey(panel)) {
			this.panelMonstruoObjetivo = (JPanel) e.getSource(); //panel que se selecciono 

			this.monstruoObjetivo = this.tc.getManoMonstruoOponente().get(this.panelMonstruoObjetivo); 
			
			System.out.println("CONTROLADOR BATALLA MOUSE CLICKED - SELECCION CARTA OBJETIVO");
			
			//si la carta estaboca abajo, se voltea sin rotar --> AGREGAR
			
			Batalla(); 
			aplicarResultadoBatalla(); 
		}
	}
	
	@Override //seleccion de monstruo Atacante (Jugador) 
	public void mouseEntered(MouseEvent e) {
		JPanel panel = (JPanel) e.getSource();
		
		if(this.tc.getCampoMonstruosJugador().containsKey(panel)) {
			
			this.panelMonstruoAtacante = (JPanel) e.getSource(); //panel que se apunta al monstruo Atacante

			this.monstruoAtacante = this.tc.getCampoMonstruosJugador().get(this.panelMonstruoAtacante); //obtengo el monstruo que coincida con el campo del Jugador
			
			System.out.println("CONTROLADOR BATALLA MOUSE ENTERED - SELECCION");
//			System.out.println("Monstruo atacante: " + this.monstruoAtacante.getNombre());
		}
	}
	
	
	public void Batalla() {
		//si no tiene monstruos el Bot --> AtaqueDirecto 
		if(this.tc.getCampoMonstruosOponente().size() == 0) {
			this.tc.getBatallaJugador().ataqueDirecto(this.monstruoAtacante);
		}else {
			tc.getBatallaJugador().atacar(this.monstruoAtacante, this.monstruoObjetivo); 
		}
	}
	
	/*
	 * Verifica si mueriron cartas, para eliminar paneles del tablero 
	 * Actualiza la vida de los duelistas en la vista. 
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
		if(this.tc.getBatallaJugador().getMonstruoMuertoJugador() != null) {
			this.tc.getCampoMonstruosJugador().remove(this.panelMonstruoAtacante); 
		}
		
		if(this.tc.getBatallaJugador().getMonstruoMuertoJugador() != null) {
			this.tc.getCampoMonstruosOponente().remove(this.panelMonstruoAtacante); 
		}
		
	}

	
	//Metodos sobrescritos que no se usan 
	
	//actionPerformed Vacio
	@Override
	public void actionPerformed(ActionEvent e) {
	}
	
	@Override
	public void mousePressed(MouseEvent e) {
	}
	
	@Override
	public void mouseReleased(MouseEvent e) {
	}
	
	@Override
	public void mouseExited(MouseEvent e) {
	}
	
	
	
	
}
