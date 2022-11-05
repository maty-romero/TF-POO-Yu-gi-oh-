package controlador;

import java.awt.Color;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JPopupMenu;

public class MenuAtacar implements MouseListener{

	private TableroController tc; 
	private JPopupMenu pm;
	private JPanel panelMonstruoSeleccionado; //monstruo seleccionado por el Jugador 
	
	public MenuAtacar(TableroController tableroController) {
		this.tc = tableroController; 
	} 
	
	@Override
	public void mouseEntered(MouseEvent e) {
		
		JPanel panel = (JPanel) e.getSource();
		
		if(this.tc.getCampoMonstruosJugador().containsKey(panel)) {
			
			pm = new JPopupMenu();
			
//			this.setPanelMonstruoSeleccionado(panel);
			JMenuItem m1 = new JMenuItem("ATACAR");
			m1.addActionListener(new ControladorBatalla(this.tc));
			
			pm.add(m1);
			
		}
		
		pm.addSeparator();
		pm.setBackground(Color.CYAN);
		panel.setComponentPopupMenu(pm);
			
		
	}
	
	
	
	public JPanel getPanelMonstruoSeleccionado() {
		return panelMonstruoSeleccionado;
	}

	public void setPanelMonstruoSeleccionado(JPanel panelMonstruoSeleccionado) {
		this.panelMonstruoSeleccionado = panelMonstruoSeleccionado;
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
	public void mouseExited(MouseEvent e) {
	}

	
	
}
