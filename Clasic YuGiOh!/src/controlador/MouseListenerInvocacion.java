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

public class MouseListenerInvocacion implements MouseListener {
	private VistaTablero vista;
	private TableroController tc;
	private JPanel panelRelacionado;
	private JPopupMenu pm;
    private Boolean inv;
	
	public MouseListenerInvocacion(VistaTablero vista, TableroController tc) {
		this.vista = vista;
		this.tc = tc;
	    this.inv=false;

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
		
		JPanel panel = (JPanel)e.getSource();
		this.vista.getManoBot().setFocusable(true);
		this.vista.getManoJugador().setFocusable(true);
		this.vista.getManoBot().setFocusable(true);
		pm = new JPopupMenu();
		JMenuItem m1 = new JMenuItem("Invocar Ataque");
		JMenuItem m2 = new JMenuItem("Invocar defensa");
		JMenuItem m3 = new JMenuItem("ATACAR ");
		
		if (this.tc.getCampoMonstruosJugador().containsKey(panel)) {
			System.out.println("atacar");
			pm.add(m3);

		}
		if (this.tc.getManoMonstruoJugador().containsKey(panel)) {
			System.out.println("invocar");
			pm.add(m1);
			pm.add(m2);
			m1.addActionListener(new ControladorActionListenerInvocacionMonstruo(this, panel,
					this.tc.getManoMonstruoJugador().get(panel)  ));

		}

		pm.addSeparator();
		panel.setComponentPopupMenu(pm);

		/*HashMap<JPanel, CartaMonstruo> hashCartas = new HashMap();

		this.vista.getManoBot().setFocusable(true);

		hashCartas.putAll(this.tc.getManoMonstruoJugador());

		this.vista.getManoJugador().setFocusable(true);
		this.vista.getManoBot().setFocusable(true);
		
		for (JPanel key : hashCartas.keySet()) {
			if (e.getSource() == key) {
				pm = new JPopupMenu();

				// create menuItems
				JMenuItem m1 = new JMenuItem("Invocar Ataque");
				JMenuItem m2 = new JMenuItem("Invocar defensa");
				JMenuItem m3 = new JMenuItem("ATACAR ");

//				if(inv) {
//					System.out.println("invocado");
//					pm.add(m3);
//				}else {
//					System.out.println("no invocado");
//					pm.add(m1);
//					pm.add(m2);
//					m1.addActionListener(new ControladorActionListenerInvocacionMonstruo(this.vista, this, tc, key,
//							hashCartas.get(key)  ));
//				}
//				
				System.out.println(this.tc.getCampoMonstruosJugador().size());
				if (this.tc.getCampoMonstruosJugador().containsKey(key)) {
					System.out.println("atacar");
					pm.add(m3);

				}
				if (this.tc.getManoMonstruoJugador().containsKey(key)) {
					System.out.println("invocar");
					pm.add(m1);
					pm.add(m2);
					m1.addActionListener(new ControladorActionListenerInvocacionMonstruo(this, key,
							hashCartas.get(key)  ));

				}

				pm.addSeparator();
				key.setComponentPopupMenu(pm);
			}

		}*/

	}

	@Override
	public void mouseExited(MouseEvent e) {

	}

	public Boolean getInv() {
		return inv;
	}

	public void setInv(Boolean inv) {
		this.inv = inv;
	}

	public VistaTablero getVista() {
		return vista;
	}

	public void setVista(VistaTablero vista) {
		this.vista = vista;
	}

	public TableroController getTc() {
		return tc;
	}

	public void setTc(TableroController tc) {
		this.tc = tc;
	}
	
	

	
	
	
}
