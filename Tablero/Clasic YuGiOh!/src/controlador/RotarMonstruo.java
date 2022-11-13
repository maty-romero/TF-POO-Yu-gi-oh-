package controlador;
//NO ME CONVIENE USAR ROTARCARTAMONSTRUO COMO UN LISTENER Y POR EL OTRO LADO MENUATACAR COMO OTRO LISTENER,PUES
//BASICAMENTE EL POPUPMENU NO ANDA SOBRE EL MISMO PANEL, TAMPOCO ANDA SI AL POPUPMENU LO HACES VARIABLE GLOBAL., hay errores
import java.awt.Color;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JPopupMenu;

public class RotarMonstruo implements MouseListener {
	private JPanel panelCartaBocaAbajo;
	private TableroController tc;
	private JPanel panelSeleccionado;
	private Boolean puedoRotar; // debería poder rotar 1 sola vez por turno a cualquier carta monstruo del campo

	public RotarMonstruo(TableroController tc) {
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

	}

	@Override
	public void mouseExited(MouseEvent e) {

	}

	public JPanel getPanelCartaBocaAbajo() {
		return panelCartaBocaAbajo;
	}

	public void setPanelCartaBocaAbajo(JPanel panelCartaBocaAbajo) {
		this.panelCartaBocaAbajo = panelCartaBocaAbajo;
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


}
