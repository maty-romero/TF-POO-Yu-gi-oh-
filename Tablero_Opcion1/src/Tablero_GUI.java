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

public class Tablero_GUI extends JFrame {

	
	public Tablero_GUI() {
		getContentPane().setLayout(new BorderLayout(0, 0));
		
		JPanel panelInferior = new JPanel();
		getContentPane().add(panelInferior, BorderLayout.SOUTH);
		
		JPanel panelSuperior = new JPanel();
		getContentPane().add(panelSuperior, BorderLayout.NORTH);
		
		JLabel carta1 = new JLabel("");
		carta1.setFont(new Font("Tahoma", Font.PLAIN, 5));
		
		
		URL urlIcon = getClass().getResource("/img/carta1.jpg"); //imagen local relativa al projecto
		ImageIcon icon1 = new ImageIcon(new ImageIcon(urlIcon).getImage().getScaledInstance(150, 200, Image.SCALE_DEFAULT)); 
		
		carta1.setIcon(icon1);
		
		panelSuperior.add(carta1);
		
		JLabel carta2 = new JLabel("");
		panelSuperior.add(carta2);
		
		JLabel lblNewLabel_2 = new JLabel("New label");
		panelSuperior.add(lblNewLabel_2);
		
		JPanel panelDerecho = new JPanel();
		getContentPane().add(panelDerecho, BorderLayout.EAST);
		panelDerecho.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		
	}

}
