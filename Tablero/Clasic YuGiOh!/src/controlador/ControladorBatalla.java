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
import vista.VistaTablero;

public class ControladorBatalla implements MouseListener{

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
	
	public ControladorBatalla(VistaTablero vista, Modelo modelo, TableroController tableroControler) {
		this.vista = vista; 
		this.tControler = tableroControler;
		this.modelo = new Modelo();
	}
	
	//clikear y soltar = 1 click 
	@Override
	public void mouseClicked(MouseEvent e) {
		
//			HashMap<JPanel, CartaMonstruo> hashCartasCampo = new HashMap<JPanel, CartaMonstruo>();
//
//			this.vista.getManoBot().setFocusable(true);
//
//			hashCartasCampo.putAll(this.tControler.getCampoMonstruosJugador());
//		
//
//			this.vista.getManoJugador().setFocusable(true);
//			this.vista.getManoBot().setFocusable(true);
//			for (Integer i = 0; i < hashCartas.size(); i++) {
//
//				for (JPanel key : hashCartas.keySet()) {
//					if (e.getSource() == key) {
//						String stringCarta = hashCartas.get(key).getPathImagen();
//
//						java.net.URL urlCarta = getClass().getResource(stringCarta);
//						ImageIcon iconCarta = new ImageIcon(
//								new ImageIcon(urlCarta).getImage().getScaledInstance(400, 380, Image.SCALE_DEFAULT));
//						JLabel label = new JLabel(iconCarta);
//						vista.getCartaSeleccionada().removeAll();
//						vista.mostrar();
//
//						vista.getCartaSeleccionada().add(label);
//						vista.mostrar();
//						vista.getCartaSeleccionada().setVisible(true);
//					}
//
//				}
//
//			}
		
		
		
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
	
	
	
	
}
