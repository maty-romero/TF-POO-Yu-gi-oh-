package controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashMap;

import javax.swing.JPanel;

import exepciones.PierdeLaPartida;

public class Boton implements ActionListener {
	private TableroController tc;

	public Boton(TableroController tc) {
		this.tc = tc;
	}

	//Boton "Terminar Turno" 
	public void actionPerformed(ActionEvent e) {
		try {
			this.getTc().getVista().getBtnTerminarTurno().setEnabled(false);

			this.getTc().getControladorBot().robarCarta();
			this.getTc().getControladorBot().invocarCarta();
			this.getTc().getControladorBot().Batalla();

			this.getTc().getVista().getBtnTerminarTurno().setEnabled(true);

			//Vuelve a turno jugador
			
			//agrego listeners antes del turno del jugador 
			agregarListenersCampo(this.getTc().getCampoMonstruosJugador());
			
			//Se muestra en la vista las acciones que realizo el bot en su turno. 
			this.getTc().getVista().informarTurnoBot(this.getTc().getControladorBot().getInformeBot());
			//Se limpia el string para posteriores turnos del bot
			this.getTc().getControladorBot().setInformeBot(""); 
			
			this.getTc().getDuelistaJugador().robarCarta();
			this.getTc().getVista().getManoJugador().removeAll();

			this.getTc().setManoJugador();
			

		} catch (PierdeLaPartida e1) {
			System.out.println(e1.getMessage());
			this.getTc().getVista().getTablero().dispose();
			
		}

	}

	private void agregarListenersCampo(HashMap<JPanel, ?> map) {
		for (JPanel panelAux : map.keySet()) {
			panelAux.addMouseListener(new MenuCartaInvocadaMonstruo(this.getTc()));
		}
	}
	
	
	//getters 
	
	public TableroController getTc() {
		return tc;
	}

	public void setTc(TableroController tc) {
		this.tc = tc;
	}

}
