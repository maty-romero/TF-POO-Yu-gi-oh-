package controlador;

import java.awt.Color;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.HashMap;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JPopupMenu;

import modelo.Carta;
import modelo.CartaMonstruo;
import modelo.Modelo;
import vista.VistaTablero;

public class MonstruosInvocacion implements MouseListener {
	private TableroController tc;
	private JPanel panelSeleccionado;
	private JPopupMenu pm;
	private JPanel panelCartaBocaAbajo;
	private Boolean bocaAbajo;
	private JLabel label;

	public MonstruosInvocacion(TableroController tc) {
		this.tc = tc;
	}

	@Override
	public void mouseClicked(MouseEvent e) {
	}

	@Override
	public void mousePressed(MouseEvent e) {
	}

	@Override
	public void mouseReleased(MouseEvent e) {
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// Grids Layouts
		this.tc.getVista().getManoJugador().setFocusable(true);
//		this.tc.getVista().getManoBot().setFocusable(true);

		JPanel panel = (JPanel) e.getSource(); // panel apunta a la posicion del panel que activó el mouselistener, no
												// es una copia del panel; es el panel mismo

		pm = new JPopupMenu();

		// create menuItems
		JMenuItem m1 = new JMenuItem("Invocar Ataque");
		JMenuItem m2 = new JMenuItem("Invocar defensa");
		JMenuItem m4 = new JMenuItem("VOLTEAR");

		this.setPanelSeleccionado(panel);

		if (this.tc.getManoMonstruoJugador().containsKey(panel)) {
			pm.add(m1);
			pm.add(m2);
			m1.addActionListener(new MenuInvocarAtaqueMonstruo(this));
			m2.addActionListener(new MenuInvocarDefensaMonstruo(this));
		} else if (this.tc.getCampoMonstruosJugador().containsKey(panel)) {

		} else if (bocaAbajo) {   
			pm.add(m4);
			m4.addActionListener(new MenuVoltearMonstruo(this));
		}

		pm.addSeparator();
		panel.setComponentPopupMenu(pm);
		pm.setBackground(Color.BLUE);
	}

	@Override
	public void mouseExited(MouseEvent e) {

	}

	public TableroController getTc() {
		return tc;
	}

	public void setTc(TableroController tc) {
		this.tc = tc;
	}

	public JPanel getPanelSeleccionado() {
		return panelSeleccionado;
	}

	public void setPanelSeleccionado(JPanel panelSeleccionado) {
		this.panelSeleccionado = panelSeleccionado;
	}

	public JPanel getPanelCartaBocaAbajo() {
		return panelCartaBocaAbajo;
	}

	public void setPanelCartaBocaAbajo(JPanel panelCartaBocaAbajo) {
		this.panelCartaBocaAbajo = panelCartaBocaAbajo;
	}

	public Boolean getBocaAbajo() {
		return bocaAbajo;
	}

	public void setBocaAbajo(Boolean bocaAbajo) {
		this.bocaAbajo = bocaAbajo;
	}

	public JLabel getLabel() {
		return label;
	}

	public void setLabel(JLabel label) {
		this.label = label;
	}

}
