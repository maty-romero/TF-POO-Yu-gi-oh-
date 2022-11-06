package controlador;

import java.awt.Color;
import java.awt.Component;
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

public class ControladorBatalla implements ActionListener, MouseListener {

	private MonstruosInvocacion monstruosInvocacion;

	// monstruoAtacante --> Del jugador
	// monstruoObjetivo --> Del bot
	private CartaMonstruo monstruoAtacante, monstruoObjetivo;
	private JPanel panelMonstruoAtacante = new JPanel();
	private JPanel panelMonstruoObjetivo = new JPanel();

	private Boolean batallaFinalizada = false;

	public ControladorBatalla(MonstruosInvocacion monstruosInvocacion) {
		this.monstruosInvocacion = monstruosInvocacion;
	}

	// Seleccion de carta Atacante (Jugador)
	@Override
	public void actionPerformed(ActionEvent e) {

		this.panelMonstruoAtacante = this.monstruosInvocacion.getPanelSeleccionado();
		this.monstruoAtacante = this.monstruosInvocacion.getTc().getCampoMonstruosJugador()
				.get(this.panelMonstruoAtacante); // obtengo el monstruo

		System.out.println("CONTROLADOR BATALLA ACTION PERFORMED - ACTIVADO");

		System.out.println("Monstruo Atacante: " + this.monstruoAtacante);
		System.out.println("Monstruo Atacante posAtaque: " + this.monstruoAtacante.getPosicionAtaque());

		for (JPanel panel : this.monstruosInvocacion.getTc().getCampoMonstruosOponente().keySet()) {
			panel.addMouseListener(this);
		}
	}

	@Override // seleccion de monstruo Objetivo (Bot)
	public void mouseClicked(MouseEvent e) {

		JPanel panel = (JPanel) e.getSource();

		System.out.println("CONTROLADOR BATALLA MOUSE CLICKED - ACTIVADO");

		if (this.monstruosInvocacion.getTc().getCampoMonstruosOponente().containsKey(panel)) {

			// si la carta esta boca abajo, se voltea sin rotar --> AGREGAR
			// ***********************************

			System.out.println("CONTROLADOR BATALLA MOUSE CLICKED - SELECCION CARTA OBJETIVO");

			this.panelMonstruoObjetivo = panel; // panel que se selecciono
			this.monstruoObjetivo = this.monstruosInvocacion.getTc().getCampoMonstruosOponente().get(panel);

			System.out.println("Monstruo objetivo: " + this.monstruoObjetivo.toString());

			Batalla();
			aplicarResultadoBatalla();

			for (JPanel panelCampo : this.monstruosInvocacion.getTc().getCampoMonstruosOponente().keySet()) {
				panel.removeMouseListener(this);
			}

		}
	}

	public void Batalla() {

		// si no tiene monstruos el Bot --> AtaqueDirecto
		if (this.monstruosInvocacion.getTc().getCampoMonstruosOponente().size() == 0) {
			this.monstruosInvocacion.getTc().getBatallaJugador().ataqueDirecto(this.monstruoAtacante);

		} else {
			this.monstruosInvocacion.getTc().getBatallaJugador().atacar(this.monstruoAtacante, this.monstruoObjetivo);
		}
	}

	/*
	 * Verifica si mueriron cartas, para eliminar paneles del tablero Actualiza la
	 * vida de los duelistas en la vista.
	 * 
	 * Tanto la actualizacion de la vida, como el remover paneles de monstruos
	 * muertos no Funciona
	 */

	public void aplicarResultadoBatalla() {

		System.out.println("SE APLICA RESULTADOS BATALLA");

		System.out.println("Vida Duelista Jugador: " + this.monstruosInvocacion.getTc().getDuelistaJugador().getVida());
		System.out
				.println("Vida Duelista Oponente: " + this.monstruosInvocacion.getTc().getDuelistaOponente().getVida());
		// verificacion de vida de los duelistas

		// obtengo la vida vida de los duelistas en String --> Para el JLabel
		String vidaDuelistaJugador = String.valueOf(this.monstruosInvocacion.getTc().getDuelistaJugador().getVida());
		String vidaDuelistaOponente = String.valueOf(this.monstruosInvocacion.getTc().getDuelistaOponente().getVida());
		// seteo la nueva vida en la vista


		this.monstruosInvocacion.getTc().getVista().getContadorBot().setText(vidaDuelistaOponente);
		this.monstruosInvocacion.getTc().getVista().getContadorJug().setText(vidaDuelistaJugador);
		
		this.monstruosInvocacion.getTc().getVista().mostrar();
		
		// Se remueven paneles de monstruos muertos si es necesario (si hay muertos)
		if (this.monstruosInvocacion.getTc().getBatallaJugador().getMonstruoMuertoJugador() != null) {
			System.out.println("ELIMINACION CARTA JUGADOR EN EL CAMPO");

			System.out.println("Size array panelesMonstruoJugador - ANTES: "
					+ this.monstruosInvocacion.getTc().getVista().getPanelesMonstruosCampoJugador().size());

			// recorro el array de paneles de la vista para eliminacion

			// ========================================

			// Obtener JPanel del hash
//
//			for (int i = 0; i < this.monstruosInvocacion.getTc().getVista().getPanelesMonstruosCampoJugador()
//					.size(); i++) {
//
//				System.out.println("FOR PANELES, PANEL: "
//						+ this.monstruosInvocacion.getTc().getVista().getPanelesMonstruosCampoJugador().get(i));
//
//				if (this.monstruosInvocacion.getTc().getVista().getPanelesMonstruosCampoJugador().get(i)
//						.equals(this.panelMonstruoAtacante)) {
//
//					this.monstruosInvocacion.getTc().getVista().getPanelesMonstruosCampoJugador().remove(i);
//				}
//			}
			JPanel coincidencia = new JPanel();
			for (JPanel panel : this.monstruosInvocacion.getTc().getVista().getPanelesMonstruosCampoJugador()) {
				for (Component componente : panel.getComponents()) {
					if (componente == this.panelMonstruoAtacante) {
						coincidencia = panel;
						componente.setVisible(false);
						System.out.println(
								"hubo coincidencia AAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAA");
						break;
					}
				}
			}
			coincidencia.removeAll();
			coincidencia.setVisible(true);
			this.monstruosInvocacion.getTc().getVista().mostrar();
			this.monstruosInvocacion.getTc().getVista().getTablero().setVisible(true);
			;

			System.out.println("PANEL MONSTRUO ATACANTE: " + this.panelMonstruoAtacante);

			// No funciona
//			JPanel coincidencia = new JPanel();
//
//			for (JPanel panelCampo : this.monstruosInvocacion.getTc().getVista().getPanelesMonstruosCampoJugador()) {
//				for (Component componente : panelCampo.getComponents()) {
//					if (componente == this.panelMonstruoAtacante) {
//						panelCampo.removeAll();
//					}
//				}
//			}
//			coincidencia.removeAll();
//			coincidencia.setVisible(true);

			// ========================================

			this.monstruosInvocacion.getTc().getVista().mostrar();
			System.out.println("Size array panelesMonstruoJugador - DESPUES: "
					+ this.monstruosInvocacion.getTc().getVista().getPanelesMonstruosCampoJugador().size());

			// elinimacion del hash
			System.out.println("Size Hash MonstruosJugador - ANTES: "
					+ this.monstruosInvocacion.getTc().getCampoMonstruosJugador().size());
			this.monstruosInvocacion.getTc().getCampoMonstruosJugador().remove(this.panelMonstruoAtacante);

			System.out.println("Size Hash MonstruosJugador - DESPUES: "
					+ this.monstruosInvocacion.getTc().getCampoMonstruosJugador().size());

			this.monstruosInvocacion.getTc().getVista().mostrar();
		}

//		if (this.monstruosInvocacion.getTc().getBatallaJugador().getMonstruoMuertoOponente() != null) {
//			System.out.println("ELIMINACION CARTA OPONENTE EN EL CAMPO");
//			
//			//elinimacion del hash
//			this.monstruosInvocacion.getTc().getCampoMonstruosOponente().remove(this.panelMonstruoAtacante);
//			//recorro el array de paneles de la vista para eliminacion
//			for (int i = 0; i < this.monstruosInvocacion.getTc().getVista().getPanelesMonstruosCampoJugador().size(); i++) {
//				if(this.monstruosInvocacion.getTc().getVista().getPanelesMonstruosCampoOponente().get(i) == this.panelMonstruoObjetivo) { 
//					this.monstruosInvocacion.getTc().getVista().getPanelesMonstruosCampoOponente().remove(i); 
//				}
//			}
//		}

		System.out.println("SE HAN APLICADO CAMBIOS EN LA VISTA");
	}

	// Metodos sobrescritos que no se usan

	@Override
	public void mousePressed(MouseEvent e) {
	}

	@Override
	public void mouseReleased(MouseEvent e) {
	}

	@Override
	public void mouseExited(MouseEvent e) {
	}

	@Override // seleccion de monstruo Atacante (Jugador)
	public void mouseEntered(MouseEvent e) {
	}

}
