package controlador;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JPopupMenu;

public class MenuCartaInvocadaMonstruo implements MouseListener{

	private TableroController tc;
	private JPanel panelSeleccionado;
	private Boolean puedeAtacar; 
	
	public MenuCartaInvocadaMonstruo(TableroController tc) {
		this.tc = tc;
		this.puedeAtacar = false; 
		this.getTc().getVista().getBtnBatalla().addActionListener(e -> this.permisoMenuBatalla());
	}

	private void permisoMenuBatalla() {
		if(this.puedeAtacar) {
			this.puedeAtacar = false; 
		}else {
			this.puedeAtacar = true; 
		}
	}
	
	
	@Override
	public void mouseEntered(MouseEvent e) {
		System.out.println("Valor puedeAtacar = " + this.puedeAtacar);
		JPopupMenu pm = new JPopupMenu();
		JPanel panel = (JPanel) e.getSource(); // panel apunta a la posicion del panel que activó el mouselistener, no

		this.panelSeleccionado = panel;
		// create menuItems
		JMenuItem m1 = new JMenuItem("ATACAR");
		JMenuItem m2 = new JMenuItem("Rotar");

		m1.addActionListener(new ControladorBatalla(this));
		m2.addActionListener(new MenuRotarMonstruo(this));
		if (this.getTc().getCampoMonstruosJugador().get(panel).getBocaAbajo() == false 
				&& this.puedeAtacar && this.getTc().getCampoMonstruosJugador().get(panel).getPosicionAtaque()) {

			pm.add(m1);
			pm.add(m2);
		}
		else{
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

	public void setTc(TableroController tc) {
		this.tc = tc;
	}

	@Override
	public void mouseExited(MouseEvent e) {

	}

	

}
