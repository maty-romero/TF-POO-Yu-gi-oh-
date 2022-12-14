package vista;

import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

public class MenuPrincipal extends JFrame {

	private JPanel contentPane;
	private JLabel fondoMenuPpal;

	private JButton btnSalir;
	private JButton btnNuevaPartida;

	public MenuPrincipal() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 728, 716);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(null);
		setContentPane(contentPane);

		// Fondo Menu Principal
		java.net.URL fondoURL = getClass().getResource("/fondo_tablero/FondoMenuPrincipal.png"); //
		ImageIcon iconFondoTablero = new ImageIcon(
				new ImageIcon(fondoURL).getImage().getScaledInstance(700, 700, Image.SCALE_DEFAULT));

		// Boton Salir
		btnSalir = new JButton("Salir");
		btnSalir.setFont(new Font("Sitka Subheading", Font.BOLD, 17));
		btnSalir.setBounds(71, 365, 231, 51);
		contentPane.add(btnSalir);

		// Boton Nueva Partida
		btnNuevaPartida = new JButton("Nueva Partida");
		btnNuevaPartida.setFont(new Font("Sitka Subheading", Font.BOLD, 17));
		btnNuevaPartida.setBounds(71, 233, 231, 45);
		contentPane.add(btnNuevaPartida);

		this.fondoMenuPpal = new JLabel(iconFondoTablero);
		this.fondoMenuPpal.setBounds(0, 0, 724, 679);
		contentPane.add(fondoMenuPpal);

		this.fondoMenuPpal = new JLabel(iconFondoTablero);
		this.fondoMenuPpal.setBounds(0, 0, 698, 679);

		contentPane.add(fondoMenuPpal);

	}

	public JButton getBtnSalir() {
		return btnSalir;
	}

	public void setBtnSalir(JButton btnSalir) {
		this.btnSalir = btnSalir;
	}

	public JButton getBtnNuevaPartida() {
		return btnNuevaPartida;
	}

	public void setBtnNuevaPartida(JButton btnNuevaPartida) {
		this.btnNuevaPartida = btnNuevaPartida;
	}

}
