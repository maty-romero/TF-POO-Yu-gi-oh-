package controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import exepciones.PierdeLaPartida;

public class Boton implements ActionListener {
	private TableroController tc;

	public Boton(TableroController tc) {
		this.tc = tc;
	}

	public void actionPerformed(ActionEvent e) {
		try {
			System.out.println("entro boto");
			this.getTc().getVista().getBtnTerminarTurno().setEnabled(false);

			this.getTc().getVista().getBtnTerminarTurno().setEnabled(true);
			this.getTc().getControladorBot().robarCarta();
			this.getTc().getDuelistaJugador().robarCarta();
		} catch (PierdeLaPartida e1) {
			System.out.println(e1.getMessage());
			this.getTc().getVista().getTablero().dispose();
		}

	}

	public TableroController getTc() {
		return tc;
	}

	public void setTc(TableroController tc) {
		this.tc = tc;
	}

}
