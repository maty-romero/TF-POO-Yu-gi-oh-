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

			this.getTc().getVista().getBtnTerminarTurno().setEnabled(true);

			this.getTc().getDuelistaJugador().robarCarta();
//			this.getTc().getManoMonstruoJugador();
			this.getTc().getVista().getManoJugador().removeAll();

			this.getTc().setManoJugador();

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
