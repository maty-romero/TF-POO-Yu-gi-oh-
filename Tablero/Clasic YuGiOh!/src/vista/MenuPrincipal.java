package vista;

import java.awt.BorderLayout;
import java.awt.EventQueue;
<<<<<<< Updated upstream
=======
import java.awt.Image;
import java.awt.Window;
>>>>>>> Stashed changes

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import controlador.TableroController;

import javax.swing.JButton;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class MenuPrincipal extends JFrame {

	private JPanel contentPane;
<<<<<<< Updated upstream

	
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
=======
	private JLabel fondoMenuPpal;
	private JButton btnSalir;
	private JButton btnNuevaPartida;
>>>>>>> Stashed changes


	public MenuPrincipal() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
<<<<<<< Updated upstream
	}

=======
		contentPane.setLayout(null);
		
		//Fondo Menu Principal
		java.net.URL fondoURL = getClass().getResource("/fondo_tablero/FondoMenuPrincipal.jpg"); // 
		ImageIcon iconFondoTablero = new ImageIcon(
				new ImageIcon(fondoURL).getImage().getScaledInstance(700, 700, Image.SCALE_DEFAULT));
		
		btnSalir = new JButton("Salir");
		btnSalir.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnSalir.setBounds(300, 397, 119, 34);
		contentPane.add(btnSalir);
		
		btnNuevaPartida = new JButton("Nueva Partida");
		btnNuevaPartida.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnNuevaPartida.setBounds(300, 277, 119, 34);
		contentPane.add(btnNuevaPartida);

		
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
	
	
>>>>>>> Stashed changes
}
