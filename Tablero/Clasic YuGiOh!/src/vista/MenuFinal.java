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

public class MenuFinal extends JFrame {

	private JPanel contentPane;
	private JLabel fondoMenuFinal;
	private JLabel mensajeFinalPartida;

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MenuFinal frame = new MenuFinal();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public MenuFinal() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 792, 593);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		
		java.net.URL fondoURL = getClass().getResource("/fondo_tablero/FondoMenuFinal.png"); //
		ImageIcon iconFondoTablero = new ImageIcon(
				new ImageIcon(fondoURL).getImage().getScaledInstance(800, 800, Image.SCALE_DEFAULT));
		
		mensajeFinalPartida = new JLabel("");
		mensajeFinalPartida.setFont(new Font("Consolas", Font.PLAIN, 36));
		mensajeFinalPartida.setForeground(Color.WHITE);
		mensajeFinalPartida.setBounds(54, 31, 323, 76);
		contentPane.add(mensajeFinalPartida);
		
		fondoMenuFinal = new JLabel(iconFondoTablero);
		fondoMenuFinal.setBounds(0, 0, 776, 554);
		contentPane.add(fondoMenuFinal);
	}

	public JLabel getMensajeFinalPartida() {
		return mensajeFinalPartida;
	}

	public void setMensajeFinalPartida(JLabel mensajeFinalPartida) {
		this.mensajeFinalPartida = mensajeFinalPartida;
	}
	
	
	
}
