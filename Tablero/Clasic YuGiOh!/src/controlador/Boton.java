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
			System.out.println("BOT JUGANGO");
			
//			this.getTc().getReferee().remuevoPanelCampoHechizo(panelHechizo,
//			this.getTc().getCampoHechizosOponente(),
//			this.getTc().getVista().getPanelesHechizosCampoOponente());

			this.getTc().getVista().getBtnTerminarTurno().setEnabled(false);

			this.getTc().getControladorBot().robarCarta();
//			this.getTc().getVista().getManoBot().removeAll();
//			this.getTc().setManoBot();

			this.getTc().getControladorBot().invocarCarta();
//			this.getTc().getControladorBot().invocarCarta();

			System.out.println("XXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXX");
			this.getTc().getControladorBot().Batalla();
			this.getTc().getControladorBot().Batalla();

			this.getTc().getVista().getBtnTerminarTurno().setEnabled(true);

			//Vuelve a turno jugador
			
			//agrego listeners antes del turno del jugador 
			agregarListenersMano(this.getTc().getManoMonstruoJugador());
			agregarListenersCampo(this.getTc().getCampoMonstruosJugador());
			
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
	
	private void agregarListenersMano(HashMap<JPanel, ?> map) {
		for (JPanel panel : map.keySet()) {
			panel.removeMouseListener(new MonstruosInvocacion(this.getTc()));
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
