package controlador;

import java.awt.Color;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JPopupMenu;

public class MenuCartaInvocada implements MouseListener {

	private TableroController tc;
	private JPanel panelSeleccionado;
	private Boolean puedoRotar; // debería poder rotar 1 sola vez por turno a cualquier carta monstruo del campo

	public MenuCartaInvocada(TableroController tc) {
		this.tc = tc;
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		JPopupMenu pm = new JPopupMenu();
		JPanel panel = (JPanel) e.getSource(); // panel apunta a la posicion del panel que activó el mouselistener, no

		this.panelSeleccionado = panel;
		// create menuItems
		JMenuItem m1 = new JMenuItem("ATACAR");
		JMenuItem m2 = new JMenuItem("Rotar");

		m1.addActionListener(new ControladorBatalla(this));
		m2.addActionListener(new MenuRotarMonstruo(this));
		if ((this.getTc().getCampoMonstruosJugador().get(panel).getBocaAbajo() == false)) {
			pm.add(m1);
			pm.add(m2);
		}
		if ((this.getTc().getCampoMonstruosJugador().get(panel).getBocaAbajo() == true)) {
			pm.add(m2);
		}

		pm.addSeparator();
		this.getPanelSeleccionado().setComponentPopupMenu(pm);
		pm.setBackground(Color.BLUE);

	}

	public JPanel getPanelSeleccionado() {
		return panelSeleccionado;
	}

	public void setPanelSeleccionado(JPanel panelSeleccionado) {
		this.panelSeleccionado = panelSeleccionado;
	}

	public TableroController getTc() {
		return tc;
	}

	// Metodos que no se utilizan
	@Override
	public void mouseClicked(MouseEvent e) {
	}

	@Override
	public void mousePressed(MouseEvent e) {
	}

	@Override
	public void mouseReleased(MouseEvent e) {

	}

	public Boolean getPuedoRotar() {
		return puedoRotar;
	}

	public void setPuedoRotar(Boolean puedoRotar) {
		this.puedoRotar = puedoRotar;
	}

	public void setTc(TableroController tc) {
		this.tc = tc;
	}

	@Override
	public void mouseExited(MouseEvent e) {

	}

}
