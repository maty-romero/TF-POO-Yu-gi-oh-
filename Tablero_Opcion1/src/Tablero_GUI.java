import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Image;
import java.net.URL;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JButton;
import java.awt.GridLayout;
import java.awt.CardLayout;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.SwingConstants;

public class Tablero_GUI extends JFrame {

	
	public Tablero_GUI() {
		
		
		getContentPane().setLayout(new BorderLayout(0, 0));
		
		JPanel panelInferior = new JPanel();
		getContentPane().add(panelInferior, BorderLayout.SOUTH);
		
		JButton btnNewButton_3 = new JButton("Mano Jugador");
		panelInferior.add(btnNewButton_3);
		
		JPanel panelSuperior = new JPanel();
		getContentPane().add(panelSuperior, BorderLayout.NORTH);
		
		JButton btnNewButton = new JButton("Mano Oponente");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon(Tablero_GUI.class.getResource("/img/carta1.jpg")));
		panelSuperior.add(lblNewLabel);
		panelSuperior.add(btnNewButton);
		
		
		URL urlIcon = getClass().getResource("/img/carta1.jpg"); //imagen local relativa al projecto
		ImageIcon icon1 = new ImageIcon(new ImageIcon(urlIcon).getImage().getScaledInstance(150, 200, Image.SCALE_DEFAULT));
		
		JPanel panelDerecho = new JPanel();
		getContentPane().add(panelDerecho, BorderLayout.EAST);
		panelDerecho.setLayout(new CardLayout(0, 0));
		
		JButton btnNewButton_4 = new JButton("Visualizador Carta");
		panelDerecho.add(btnNewButton_4, "name_329020141950400");
		
		JPanel panelCentral = new JPanel();
		getContentPane().add(panelCentral, BorderLayout.CENTER);
		panelCentral.setLayout(new BorderLayout(0, 0));
		
		JPanel panelSuperiorCentral = new JPanel();
		panelCentral.add(panelSuperiorCentral, BorderLayout.NORTH);
		
		JButton btnNewButton_1 = new JButton("Monstruos y hechizos Oponente");
		panelSuperiorCentral.add(btnNewButton_1);
		
		JPanel panelInferiorCentral = new JPanel();
		panelCentral.add(panelInferiorCentral, BorderLayout.SOUTH);
		
		JButton btnNewButton_2 = new JButton("Monstruos y hechizos Jugador");
		panelInferiorCentral.add(btnNewButton_2);
		
		JPanel panelIzquierdoCentral = new JPanel();
		panelCentral.add(panelIzquierdoCentral, BorderLayout.WEST);
		
		JButton btnNewButton_5 = new JButton("Cementerio Oponente");
		panelIzquierdoCentral.add(btnNewButton_5);
		
		JPanel panelDerechoCentral = new JPanel();
		panelCentral.add(panelDerechoCentral, BorderLayout.EAST);
		
		JButton btnNewButton_6 = new JButton("Cementerio Jugador");
		panelDerechoCentral.add(btnNewButton_6);
		
		JPanel panelCentral_Central = new JPanel();
		panelCentral.add(panelCentral_Central, BorderLayout.CENTER);
		
		JButton btnNewButton_8 = new JButton("Separacion entre Oponente Y jugador");
		panelCentral_Central.add(btnNewButton_8);
		
		JButton btnNewButton_7 = new JButton("Fases de la partida ");
		btnNewButton_7.setVerticalAlignment(SwingConstants.BOTTOM);
		panelCentral_Central.add(btnNewButton_7);
		
	}

	private Icon cambiarTamaño()
	
	
}
