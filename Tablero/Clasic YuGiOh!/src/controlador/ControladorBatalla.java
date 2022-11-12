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

//	private menuAtacar menuAtacar;
	private MenuAtacar menuAtacar;

	// monstruoAtacante --> Del jugador
	// monstruoObjetivo --> Del bot
	private CartaMonstruo monstruoAtacante, monstruoObjetivo;
	private JPanel panelMonstruoAtacante = new JPanel();
	private JPanel panelMonstruoObjetivo = new JPanel();

	private Boolean batallaFinalizada = false;

	public ControladorBatalla(MenuAtacar menuAtacar) {
		this.menuAtacar = menuAtacar;
	}

	// Seleccion de carta Atacante (Jugador)
	@Override
	public void actionPerformed(ActionEvent e) {

		this.panelMonstruoAtacante = this.menuAtacar.getPanelSeleccionado();
		this.monstruoAtacante = this.menuAtacar.getTc().getCampoMonstruosJugador()
				.get(this.panelMonstruoAtacante); // obtengo el monstruo

		System.out.println("CONTROLADOR BATALLA ACTION PERFORMED - ACTIVADO");

		System.out.println("Monstruo Atacante: " + this.monstruoAtacante);
		System.out.println("Monstruo Atacante posAtaque: " + this.monstruoAtacante.getPosicionAtaque());

		// si no tiene monstruos el Bot --> AtaqueDirecto
		if (this.menuAtacar.getTc().getCampoMonstruosOponente().size() == 0) {
			this.menuAtacar.getTc().getBatallaJugador().ataqueDirecto(this.monstruoAtacante);
			aplicarResultadoBatalla();
		}

		// Se agregan listener a paneles Campo Oponente (Monstruos)
		for (JPanel panel : this.menuAtacar.getTc().getCampoMonstruosOponente().keySet()) {
			panel.addMouseListener(this);
		}
	}

	@Override // seleccion de monstruo Objetivo (Bot)
	public void mouseClicked(MouseEvent e) {

		JPanel panel = (JPanel) e.getSource();

		System.out.println("CONTROLADOR BATALLA MOUSE CLICKED - ACTIVADO");

		if (this.menuAtacar.getTc().getCampoMonstruosOponente().containsKey(panel)) {

			// si la carta esta boca abajo, se voltea sin rotar --> AGREGAR
			// ***********************************

			System.out.println("CONTROLADOR BATALLA MOUSE CLICKED - SELECCION CARTA OBJETIVO");

			this.panelMonstruoObjetivo = panel; // panel que se selecciono
			this.monstruoObjetivo = this.menuAtacar.getTc().getCampoMonstruosOponente().get(panel);

			System.out.println("Monstruo objetivo: " + this.monstruoObjetivo.toString());

			this.menuAtacar.getTc().getBatallaJugador().atacar(this.monstruoAtacante, this.monstruoObjetivo); // BATALLA

			aplicarResultadoBatalla();

			// remuevo los listener para que no se puedan seleccionar.
			for (JPanel panelCampo : this.menuAtacar.getTc().getCampoMonstruosOponente().keySet()) {
				panel.removeMouseListener(this);
			}

		}
	}

	public void Batalla() {

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

		System.out.println("Vida Duelista Jugador: " + this.menuAtacar.getTc().getDuelistaJugador().getVida());
		System.out
				.println("Vida Duelista Oponente: " + this.menuAtacar.getTc().getDuelistaOponente().getVida());
		// verificacion de vida de los duelistas

		// obtengo la vida vida de los duelistas en String --> Para el JLabel
		String vidaDuelistaJugador = String.valueOf(this.menuAtacar.getTc().getDuelistaJugador().getVida());
		String vidaDuelistaOponente = String.valueOf(this.menuAtacar.getTc().getDuelistaOponente().getVida());
		// seteo la nueva vida en la vista

		this.menuAtacar.getTc().getVista().getContadorBot().setText(vidaDuelistaOponente);
		this.menuAtacar.getTc().getVista().getContadorJug().setText(vidaDuelistaJugador);

		this.menuAtacar.getTc().getVista().mostrar();

		// ------------------------------

		// Se remueven paneles de monstruos muertos si es necesario (si hay muertos)

		if (this.menuAtacar.getTc().getBatallaJugador().getMonstruoMuertoJugador() != null) {
			System.out.println("**ELIMINACION CARTA JUGADOR EN EL CAMPO**");

			// Eliminacion panel en la vista.

			JPanel coincidencia = new JPanel();
			for (JPanel panel : this.menuAtacar.getTc().getVista().getPanelesMonstruosCampoJugador()) {
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
			this.menuAtacar.getTc().getVista().mostrar();
			this.menuAtacar.getTc().getVista().getTablero().setVisible(true);

			System.out.println("PANEL MONSTRUO ATACANTE: " + this.panelMonstruoAtacante);

			// elinimacion del hash
			this.menuAtacar.getTc().getCampoMonstruosJugador().remove(this.panelMonstruoAtacante);

			this.menuAtacar.getTc().getVista().mostrar();
		}

		if (this.menuAtacar.getTc().getBatallaJugador().getMonstruoMuertoOponente() != null) {

			// Eliminacion panel en la vista.

			JPanel coincidencia = new JPanel();
			for (JPanel panel : this.menuAtacar.getTc().getVista().getPanelesMonstruosCampoOponente()) {
				for (Component componente : panel.getComponents()) {
					if (componente == this.panelMonstruoObjetivo) {
						coincidencia = panel;
						componente.setVisible(false);
						System.out.println("hubo coincidencia AAAAAAAAAAAAAAAA");
						break;
					}
				}
			}
			coincidencia.removeAll();
			coincidencia.setVisible(true);
			this.menuAtacar.getTc().getVista().mostrar();
			this.menuAtacar.getTc().getVista().getTablero().setVisible(true);

			// elinimacion del hash
			this.menuAtacar.getTc().getCampoMonstruosOponente().remove(this.panelMonstruoObjetivo);

			this.menuAtacar.getTc().getVista().mostrar();

		}

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
