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
	private JPanel panelRelacionado;
	private JPopupMenu pm;

	public MonstruosInvocacion(TableroController tc) {
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

		this.tc.getVista().getManoBot().setFocusable(true);
		this.tc.getVista().getManoJugador().setFocusable(true);
		this.tc.getVista().getManoBot().setFocusable(true);

		JPanel panel = (JPanel) e.getSource(); // panel apunta a la posicion del panel que activó el mouselistener, no
												// es una copia del panel; es el panel mismo

		pm = new JPopupMenu();

		// create menuItems
		JMenuItem m1 = new JMenuItem("Invocar Ataque");
		JMenuItem m2 = new JMenuItem("Invocar defensa");
		JMenuItem m3 = new JMenuItem("ATACAR CAPO");

		/*
		 * Cuando haces el for(jpanel key this.tc.getmanomonstruoJugador.keyset(){
		 * if(e.getsource==key){ if(this.tc.getManoMonstruoJugador().containsKey(key)) {
		 * pm.add(m1); pm.add(m2); m1.addActionListener(new
		 * ControladorActionListenerInvocacionMonstruo(this)); } else if {
		 * this.tc.getCampoMonstruosJugador().containsKey(key); pm.add(m3); } } } nunca
		 * detecta que yo cambié anteriormente ambos hash; uno eliminandole algo y al
		 * otro insertandole algo, nunca me detecta eso, sólo me detecta la version
		 * vieja del objeto. Como si ese objeto viejo estuviera en una posicion de
		 * memoria distinta a la del objeto que deberia ser, como si lo copiara en algun
		 * lado enves de trabajar con el objeto que viene por parametro, tc.
		 * 
		 * Cuando elimino el bucle for y trabajo con el panel directamente que viene con
		 * e.getSource, magicamente sí me detecta que el objeto tc ahora tiene un
		 * hashManomonstruosjugador, con 1 carta menos, y que el hash
		 * cartaMonstruosCampoJugador tiene 1 carta mas. Anda bien, de diez(como se ve
		 * en la clase) .Todo esto concluye en que hay que saber usar un mouselistener y
		 * no hacer lo que a uno se le ocurra que tiene logica; para evitar estos
		 * errores sin sentido, hay que saber las practicas comunes con estas clases muy
		 * complejas, y lo recomendado, no empezar a hacer cualquier cosa porque
		 * pensamos que tiene logica, porque puede aparecer un error como estos que
		 * nuestra logica nos avisa que estamos haciendo todo bien, pero en realidad
		 * salió un bug inesperado por no usar la clase mouselistener como se suponia.
		 */

		if (this.tc.getManoMonstruoJugador().containsKey(panel)) {
			pm.add(m1);
			pm.add(m2);
			this.setPanelRelacionado(panel);
			System.out.println("invocar");
			m1.addActionListener(new MenuInvocacionMonstruo(this));
		} else if (this.tc.getCampoMonstruosJugador().containsKey(panel)) {
			System.out.println("invocado");
			pm.add(m3);
		}

		pm.addSeparator();
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

	public JPanel getPanelRelacionado() {
		return panelRelacionado;
	}

	public void setPanelRelacionado(JPanel panelRelacionado) {
		this.panelRelacionado = panelRelacionado;
	}

}
