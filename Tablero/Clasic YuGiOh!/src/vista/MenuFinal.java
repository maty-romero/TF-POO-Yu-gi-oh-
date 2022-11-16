package vista;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Color;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JButton;

public class MenuFinal extends JFrame {

	private JPanel contentPane;
	private JLabel fondoMenuFinal;
	private JLabel mensajeFinalPartida;
	
	private JButton btnVueltaMenuPpal;
	private JButton btnSalir;

	public MenuFinal() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 799, 662);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		
		java.net.URL fondoURL = getClass().getResource("/fondo_tablero/FondoFinal3.jpg"); //
		ImageIcon iconFondoTablero = new ImageIcon(
				new ImageIcon(fondoURL).getImage().getScaledInstance(800, 800, Image.SCALE_SMOOTH));
		
		btnSalir = new JButton("Salir");
		btnSalir.setFont(new Font("Sitka Subheading", Font.BOLD, 17));
		btnSalir.setBounds(313, 350, 157, 42);
		contentPane.add(btnSalir);
		
		mensajeFinalPartida = new JLabel("PRUEBAA");
		mensajeFinalPartida.setHorizontalAlignment(SwingConstants.CENTER);
		mensajeFinalPartida.setFont(new Font("Sitka Subheading", Font.BOLD, 36));
		mensajeFinalPartida.setForeground(new Color(255, 255, 255));
		mensajeFinalPartida.setBounds(62, 45, 670, 76);
		contentPane.add(mensajeFinalPartida);
		
		btnVueltaMenuPpal = new JButton("Menu Principal");
		btnVueltaMenuPpal.setFont(new Font("Sitka Subheading", Font.BOLD, 17));
		btnVueltaMenuPpal.setBounds(313, 270, 157, 42);
		contentPane.add(btnVueltaMenuPpal);
		
		fondoMenuFinal = new JLabel(iconFondoTablero);
		fondoMenuFinal.setBounds(0, 0, 783, 625);
		contentPane.add(fondoMenuFinal);
	}

	
	
	//Getters y Setters 
	
	public JLabel getMensajeFinalPartida() {
		return mensajeFinalPartida;
	}

	public JButton getBtnVueltaMenuPpal() {
		return btnVueltaMenuPpal;
	}

	public void setBtnVueltaMenuPpal(JButton btnVueltaMenuPpal) {
		this.btnVueltaMenuPpal = btnVueltaMenuPpal;
	}

	public JButton getBtnSalir() {
		return btnSalir;
	}

	public void setBtnSalir(JButton btnSalir) {
		this.btnSalir = btnSalir;
	}

	public void setMensajeFinalPartida(JLabel mensajeFinalPartida) {
		this.mensajeFinalPartida = mensajeFinalPartida;
	}
}
