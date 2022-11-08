package controlador;

import java.awt.Color;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JPopupMenu;

public class MenuAtacar implements MouseListener {

	private TableroController tc;
	private JPanel panelSeleccionado;
	private JPopupMenu pm;
	
	public MenuAtacar(TableroController tc) {
		this.tc = tc;
	}

	@Override
	public void mouseEntered(MouseEvent e) {

		JPanel panel = (JPanel) e.getSource(); // panel apunta a la posicion del panel que activó el mouselistener, no
		
		pm = new JPopupMenu();

		//Focusear los paneles del Campo en la vista 
//		for (JPanel panelVista : this.getTc().getVista().getPanelesMonstruosCampoJugador()) {
//			panelVista.setFocusable(true);
//		}
		
		// create menuItems
		JMenuItem m1 = new JMenuItem("ATACAR");
		System.out.println("MENU ATACAR ENTERED!!!!");
		if (this.tc.getCampoMonstruosJugador().containsKey(panel)) {
			System.out.println("MENU ATACAR ACTIVADO!!!!");
			this.setPanelSeleccionado(panel);
			
			m1.addActionListener(new ControladorBatalla(this));
			pm.add(m1);
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

	@Override
	public void mouseExited(MouseEvent e) {
	}

}
