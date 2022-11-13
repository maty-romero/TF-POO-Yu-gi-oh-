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
import vista.VistaTablero;

//cuando el bot use esta clase, va a hacer exactamente lo mismo, pero usando su hash de cartasOponente. El resto es lo mismo
public class HechizosInvocacion implements MouseListener {
	private TableroController tc;
	private JPanel panelSeleccionado; // panel que activó el mouselistener
	private JPanel panelCartaBocaAbajo; // panel de la carta que se invocó boca abajo (no es la carta por default boca
										// abajo)
	private JPopupMenu pm;
	private Boolean bocaAbajo;

	public HechizosInvocacion(TableroController tc, Boolean bocaAbajo) {
		this.tc = tc;
		this.bocaAbajo = bocaAbajo;
	}

	@Override
	public void mouseClicked(MouseEvent e) {
	}

	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseEntered(MouseEvent e) {

		this.tc.getVista().getManoBot().setFocusable(true);
		this.tc.getVista().getManoJugador().setFocusable(true);
		this.tc.getVista().getManoBot().setFocusable(true);

		JPanel panel = (JPanel) e.getSource(); 
		pm = new JPopupMenu();

		this.setPanelSeleccionado(panel);
		if (this.tc.getManoHechizoJugador().containsKey(panel)) {
			// create menuItems
			JMenuItem m1 = new JMenuItem("Activar hechizo");
			JMenuItem m2 = new JMenuItem("Invocar boca abajo");

			pm.add(m1);
			pm.add(m2);
			m1.addActionListener(new MenuActivarHechizoCartaNoInvocada(this));
			m2.addActionListener(new MenuInvocarBocaAbajoHechizo(this));

		} else if (bocaAbajo) {
			JMenuItem m3 = new JMenuItem("Activar hechizo");
			pm.add(m3);
			m3.addActionListener(new MenuActivarHechizoCartaInvocada(this));

		}
		pm.addSeparator();
		pm.setBackground(Color.CYAN);
		panel.setComponentPopupMenu(pm);

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

	public void setPanelSeleccionado(JPanel panelRelacionado) {
		this.panelSeleccionado = panelRelacionado;
	}

	public Boolean getBocaAbajo() {
		return bocaAbajo;
	}

	public void setBocaAbajo(Boolean bocaAbajo) {
		this.bocaAbajo = bocaAbajo;
	}

	public JPanel getPanelCartaBocaAbajo() {
		return panelCartaBocaAbajo;
	}

	public void setPanelCartaBocaAbajo(JPanel panelCartaBocaAbajo) {
		this.panelCartaBocaAbajo = panelCartaBocaAbajo;
	}

}
