package controlador;

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
	private Modelo modelo;
	private TableroController tc;
	private JPanel panelRelacionado;
	private JPopupMenu pm;

	public MouseListenerInvocacion(VistaTablero vista, TableroController tc) {
		this.vista = vista;
		modelo = new Modelo();
		this.tc = tc;
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

		HashMap<JPanel, CartaMonstruo> hashCartas = new HashMap();

		this.vista.getManoBot().setFocusable(true);

		hashCartas.putAll(this.tc.getManoMonstruoJugador());

		this.vista.getManoJugador().setFocusable(true);
		this.vista.getManoBot().setFocusable(true);
		
		for (Integer i = 0; i < hashCartas.size(); i++) {
				for (JPanel key : hashCartas.keySet()) {
					if (e.getSource() == key) {
						pm = new JPopupMenu();

						// create menuItems
						JMenuItem m1 = new JMenuItem("Invocar Ataque");
						JMenuItem m2 = new JMenuItem("Invocar defensa");
						JMenuItem m3 = new JMenuItem("ATACAR CAPO");

						m1.addActionListener(new ControladorActionListenerInvocacionMonstruo(this.vista, this, tc, key,
								hashCartas.get(key)));
						m2.addActionListener(new ControladorActionListenerInvocacionMonstruo(this.vista, this, tc, key,
								hashCartas.get(key)));

						pm.add(m1);
						pm.add(m2);
						pm.add(m3);
						pm.addSeparator();
						key.setComponentPopupMenu(pm);

					}

				}

			}
		}


	@Override
	public void mouseExited(MouseEvent e) {

	}

}
