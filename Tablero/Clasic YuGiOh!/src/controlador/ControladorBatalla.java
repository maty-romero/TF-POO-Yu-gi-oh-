package controlador;

import java.awt.Color;
import java.awt.Component;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;
import java.util.HashMap;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;

import exepciones.PierdeLaPartida;
import modelo.Carta;
import modelo.CartaMonstruo;
import modelo.Duelista;
import vista.VistaTablero;

//el que ataca es el jugador, con su carta atacante. siempre, porque este listener se activa con el click del jugador
public class ControladorBatalla implements ActionListener, MouseListener {

//	private menuAtacar menuAtacar;
	private MenuCartaInvocadaMonstruo menuAtacar;

	// monstruoAtacante --> Del jugador
	// monstruoObjetivo --> Del bot
	private CartaMonstruo monstruoAtacante;
	private CartaMonstruo monstruoObjetivo;
	private JPanel panelMonstruoAtacante = new JPanel();
	private JPanel panelMonstruoObjetivo = new JPanel();

	public ControladorBatalla(MenuCartaInvocadaMonstruo menuAtacar) {
		this.menuAtacar = menuAtacar;
	}

	// Seleccion de carta Atacante (Jugador)
	@Override
	public void actionPerformed(ActionEvent e) {

		this.panelMonstruoAtacante = this.menuAtacar.getPanelSeleccionado();
		this.monstruoAtacante = this.menuAtacar.getTc().getCampoMonstruosJugador().get(this.panelMonstruoAtacante); // obtengo
																													// el
																													// monstruo

		System.out.println("CONTROLADOR BATALLA ACTION PERFORMED - ACTIVADO");

		System.out.println("Monstruo Atacante: " + this.monstruoAtacante);
		System.out.println("Monstruo Atacante posAtaque: " + this.monstruoAtacante.getPosicionAtaque());
		// si no tiene monstruos el Bot --> AtaqueDirecto
		if (this.menuAtacar.getTc().getCampoMonstruosOponente().size() == 0) {
			this.monstruoAtacante.ataqueDirecto(this.menuAtacar.getTc().getDuelistaOponente(), monstruoAtacante);
			aplicarResultadoBatallaVida(); // solo se actualiza la vida del duelista atacado
		}

		// Se agregan listener a paneles Campo Oponente (Monstruos)
		for (JPanel panel : this.menuAtacar.getTc().getCampoMonstruosOponente().keySet()) {
			panel.addMouseListener(this);
		}
	}

	@Override // seleccion de monstruo Objetivo (Bot)
	public void mouseClicked(MouseEvent e) {

		JPanel panel = (JPanel) e.getSource();
		System.out.println(panel);
		System.out.println("CONTROLADOR BATALLA MOUSE CLICKED - ACTIVADO");

		// remuevo los listener para que no se puedan seleccionar.
		for (JPanel panelCampo : this.menuAtacar.getTc().getCampoMonstruosOponente().keySet()) {
			panelCampo.removeMouseListener(menuAtacar);
			panelCampo.removeMouseListener(this);
			System.out.println("REMUEVOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOO");
		}

//		if (this.menuAtacar.getTc().getCampoMonstruosOponente().containsKey(panel)) {

		// si la carta esta boca abajo, se voltea sin rotar --> AGREGAR
		// ***********************************

		System.out.println("CONTROLADOR BATALLA MOUSE CLICKED - SELECCION CARTA OBJETIVO");

		this.panelMonstruoObjetivo = panel; // panel que se selecciono
		this.monstruoObjetivo = this.menuAtacar.getTc().getCampoMonstruosOponente().get(panel);

		System.out.println("Monstruo objetivo: " + this.monstruoObjetivo.toString());

		this.monstruoAtacante.AccionCarta(monstruoObjetivo, this.menuAtacar.getTc().getDuelistaJugador(),
				this.menuAtacar.getTc().getDuelistaOponente());

		aplicarResultadoBatallaVida(); // actualizo la vida de los duelistas
		aplicarResultadoBatallaPaneles(); // remuevo paneles si es necesario.

//		}
	}

	/*
	 * Verifica si mueriron cartas, para eliminar paneles del tablero Actualiza la
	 * vida de los duelistas en la vista.
	 * 
	 * Tanto la actualizacion de la vida, como el remover paneles de monstruos
	 * muertos no Funciona
	 */

	private void aplicarResultadoBatallaVida() {

		System.out.println("Vida Duelista Jugador: " + this.menuAtacar.getTc().getDuelistaJugador().getVida());
		System.out.println("Vida Duelista Oponente: " + this.menuAtacar.getTc().getDuelistaOponente().getVida());
		// verificacion de vida de los duelistas

		// obtengo la vida vida de los duelistas en String --> Para el JLabel
		String vidaDuelistaJugador = String.valueOf(this.menuAtacar.getTc().getDuelistaJugador().getVida());
		String vidaDuelistaOponente = String.valueOf(this.menuAtacar.getTc().getDuelistaOponente().getVida());
		// seteo la nueva vida en la vista

		this.menuAtacar.getTc().getVista().getContadorBot().setText(vidaDuelistaOponente);
		this.menuAtacar.getTc().getVista().getContadorJug().setText(vidaDuelistaJugador);

		this.menuAtacar.getTc().getVista().mostrar();

		verificaDuelistasMuertos();

	}

	private void verificaDuelistasMuertos() {
		try {
			if (this.menuAtacar.getTc().getDuelistaJugador().getVida() <= 0) {
				throw new PierdeLaPartida(
						"El duelista " + this.menuAtacar.getTc().getDuelistaJugador().getNombre() + " ha perdido.");
			}
			if (this.menuAtacar.getTc().getDuelistaOponente().getVida() <= 0) {
				throw new PierdeLaPartida(
						"El duelista " + this.menuAtacar.getTc().getDuelistaOponente().getNombre() + " ha perdido.");
			}
		} catch (Exception e) {
			System.out.println(e.getMessage());
			this.menuAtacar.getTc().getVista().getTablero().dispose();
		}

	}

	private void aplicarResultadoBatallaPaneles() {

		// Se remueven paneles de monstruos muertos si es necesario (si hay muertos)

		if (!this.monstruoAtacante.getConVida()) {

			this.eliminarPanelCartaMuerta(this.menuAtacar.getTc().getVista().getPanelesMonstruosCampoJugador(),
					panelMonstruoAtacante, this.menuAtacar.getTc().getCampoMonstruosJugador());
		}

		if (monstruoObjetivo != null) {
			if (!monstruoObjetivo.getConVida()) {
				this.eliminarPanelCartaMuerta(this.menuAtacar.getTc().getVista().getPanelesMonstruosCampoOponente(),
						panelMonstruoObjetivo, this.menuAtacar.getTc().getCampoMonstruosOponente());
			}

			System.out.println("SE HAN APLICADO CAMBIOS EN LA VISTA");

		}
	}

	private void eliminarPanelCartaMuerta(ArrayList<JPanel> panelesMonstruo, JPanel panelRemover,
			HashMap<JPanel, CartaMonstruo> hashModificar) {

		// Eliminacion panel en la vista.

		JPanel coincidencia = new JPanel();
		for (JPanel panel : panelesMonstruo) {
			for (Component componente : panel.getComponents()) {
				if (componente == panelRemover) {
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
		hashModificar.remove(panelRemover);

		this.menuAtacar.getTc().getVista().mostrar();

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