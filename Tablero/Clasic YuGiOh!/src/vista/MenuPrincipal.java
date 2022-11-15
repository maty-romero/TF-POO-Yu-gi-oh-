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
	private JButton btnOpciones;

	public MenuPrincipal() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 715, 712);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(null);
		setContentPane(contentPane);

		// Fondo Menu Principal
		java.net.URL fondoURL = getClass().getResource("/fondo_tablero/FondoMenuPrincipal.jpg"); //
		ImageIcon iconFondoTablero = new ImageIcon(
				new ImageIcon(fondoURL).getImage().getScaledInstance(700, 700, Image.SCALE_DEFAULT));

		// Boton Salir
		btnSalir = new JButton("Salir");
		btnSalir.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnSalir.setBounds(300, 397, 119, 34);
		contentPane.add(btnSalir);

		// Boton Opciones
		btnOpciones = new JButton("Opciones");
		btnOpciones.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnOpciones.setBounds(300, 337, 119, 34);
		contentPane.add(btnOpciones);

		// Boton Nueva Partida
		btnNuevaPartida = new JButton("Nueva Partida");
		btnNuevaPartida.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnNuevaPartida.setBounds(300, 277, 119, 34);
		contentPane.add(btnNuevaPartida);

		this.fondoMenuPpal = new JLabel(iconFondoTablero);
		this.fondoMenuPpal.setBounds(0, 0, 698, 679);
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
