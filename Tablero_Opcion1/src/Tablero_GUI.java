import java.awt.EventQueue;
import java.awt.FlowLayout;
import java.awt.Image;
import java.net.URL;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

public class Tablero_GUI extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Tablero_GUI frame = new Tablero_GUI();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public Tablero_GUI() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 701, 538);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		
		//Se agrega un fondo al JPanel
		URL urlIcon = getClass().getResource("/img/fondo_tablero.jpg"); //imagen local relativa al projecto
		ImageIcon icon1 = new ImageIcon(new ImageIcon(urlIcon).getImage().getScaledInstance(150, 200, Image.SCALE_DEFAULT));
		
		
		setContentPane(contentPane);
		
		
		contentPane.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
	}

}
