package vista;

import java.awt.EventQueue;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

public class MenuPrincipal extends JFrame {

	private JPanel contentPane;
	private JLabel fondoMenuPpal;

	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MenuPrincipal frame = new MenuPrincipal();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}


	public MenuPrincipal() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 708, 718);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		
		//Fondo Menu Principal
		java.net.URL fondoURL = getClass().getResource("/fondo_tablero/FondoMenuPrincipal.jpg"); // 
		ImageIcon iconFondoTablero = new ImageIcon(
				new ImageIcon(fondoURL).getImage().getScaledInstance(700, 700, Image.SCALE_DEFAULT));

		
		this.fondoMenuPpal = new JLabel(iconFondoTablero);
		this.fondoMenuPpal.setBounds(0, 0, 698, 679);
		
		contentPane.add(fondoMenuPpal);
	}
}
