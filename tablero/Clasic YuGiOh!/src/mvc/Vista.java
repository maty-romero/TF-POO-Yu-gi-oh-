package mvc;

import java.awt.Color;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.BorderLayout;

public class Vista {

	private JFrame frame;
	private JPanel panelInferior;
	private JButton botonGenerar;
//private ImageIcon Card;
	private JLabel carta;
	private JPanel panel1;
	private JPanel panel2;
	private JPanel panel3;
	private JLabel fondo_panel;
	private JLabel carta_1;
	private JLabel carta_2;
	private JLabel carta_3;
	private JPanel panel_Tablero;
	private JLabel carta_4;

	ArrayList<JPanel> cartas_tablero = new ArrayList<JPanel>();
	private JLabel lblNewLabel;
	private JPanel panel_1;
	private JPanel panel_2;
	private JPanel panel_3;
	private JLabel fondo;

	public Vista() {
		this.frame = new JFrame("TABLERO");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.frame.setSize(2000, 2000);

		this.generarPanelSuperior();

//this.generarPanelInferior();

	}

	private void generarPanelSuperior() {

//accedo a carta_1 y creo el label
		BufferedImage img = null;
		try {
			img = ImageIO.read(new File("dark_magician.jpg"));
		} catch (IOException e) {
			e.printStackTrace(); // si no encuentra el archivo, lo dirà
		}
		Image dimg = img.getScaledInstance(150, 150, Image.SCALE_SMOOTH);
		ImageIcon imageIcon = new ImageIcon(dimg);

//accedo a carta_2 y creo el label
		BufferedImage img2 = null;
		try {
			img2 = ImageIO.read(new File("dark_magician.jpg"));
		} catch (IOException e) {
			e.printStackTrace(); // si no encuentra el archivo, lo dirà
		}
		Image dimg2 = img2.getScaledInstance(150, 150, Image.SCALE_SMOOTH);
		ImageIcon imageIco2 = new ImageIcon(dimg2);

//accedo a carta_3 y creo el label
		BufferedImage img3 = null;
		try {
			img3 = ImageIO.read(new File("Cambio_de_fidelidad.jpg"));
		} catch (IOException e) {
			e.printStackTrace(); // si no encuentra el archivo, lo dirà
		}
		Image dimg3 = img3.getScaledInstance(150, 150, Image.SCALE_SMOOTH);
		ImageIcon imageIco3 = new ImageIcon(dimg3);

//Creo la imagen del fondo del tablero, la plantilla.
		BufferedImage img4 = null;
		try {
			img4 = ImageIO.read(new File("yugi_milennium.jpg"));
		} catch (IOException e) {
			e.printStackTrace(); // si no encuentra el archivo, lo dirà
		}
		Image dimg4 = img4.getScaledInstance(1500, 1500, Image.SCALE_SMOOTH);
		ImageIcon imageIco4 = new ImageIcon(dimg4);

//cartas de mano del bot

		JPanel carta1_bot = new JPanel();
		carta1_bot.setBackground(Color.BLACK);
		carta1_bot.setBounds(226, 121, 74, 96);
		frame.getContentPane().add(carta1_bot);

		JPanel carta2_bot = new JPanel();
		carta2_bot.setBackground(Color.BLACK);
		carta2_bot.setBounds(380, 121, 74, 96);
		frame.getContentPane().add(carta2_bot);

		JPanel carta3_bot = new JPanel();
		carta3_bot.setBackground(Color.BLACK);
		carta3_bot.setBounds(535, 121, 74, 96);
		frame.getContentPane().add(carta3_bot);

		JPanel carta4_bot = new JPanel();
		carta4_bot.setBackground(Color.BLACK);
		carta4_bot.setBounds(226, 249, 74, 96);
		frame.getContentPane().add(carta4_bot);

		JPanel carta5_bot = new JPanel();
		carta5_bot.setBackground(Color.BLACK);
		carta5_bot.setBounds(380, 249, 74, 96);
		frame.getContentPane().add(carta5_bot);

//deck del bot
		JPanel deck_bot = new JPanel();
		deck_bot.setForeground(new Color(204, 0, 0));
		deck_bot.setBackground(new Color(204, 153, 0));
		deck_bot.setBounds(10, 164, 74, 96);
		frame.getContentPane().add(deck_bot);

//deck del bot
		JPanel cem_bot = new JPanel();
		cem_bot.setBackground(new Color(255, 215, 0));
		cem_bot.setBounds(10, 10, 74, 96);
		frame.getContentPane().add(cem_bot);

//campo de batalla del bot
		JPanel carta1Campo_bot = new JPanel();
		carta1Campo_bot.setBackground(Color.BLACK);
		carta1Campo_bot.setBounds(138, 10, 74, 96);
		frame.getContentPane().add(carta1Campo_bot);

		JPanel carta2Campo_bot = new JPanel();
		carta2Campo_bot.setBackground(Color.BLACK);
		carta2Campo_bot.setBounds(294, 10, 74, 96);
		frame.getContentPane().add(carta2Campo_bot);

		JPanel carta3Campo_bot = new JPanel();
		carta3Campo_bot.setBackground(Color.BLACK);
		carta3Campo_bot.setBounds(453, 10, 74, 96);
		frame.getContentPane().add(carta3Campo_bot);

		JPanel carta4Campo_bot = new JPanel();
		carta4Campo_bot.setBackground(Color.BLACK);
		carta4Campo_bot.setBounds(605, 10, 74, 96);
		frame.getContentPane().add(carta4Campo_bot);

		JPanel carta5Campo_bot = new JPanel();
		carta5Campo_bot.setBackground(Color.BLACK);
		carta5Campo_bot.setBounds(535, 249, 74, 96);
		frame.getContentPane().add(carta5Campo_bot);

		JPanel carta6Campo_bot = new JPanel();
		carta6Campo_bot.setBackground(Color.BLACK);
		carta6Campo_bot.setBounds(749, 10, 74, 96);
		frame.getContentPane().add(carta6Campo_bot);

//Cartas de mano del jugador
		JPanel carta1_jug = new JPanel();
		carta1_jug.setBackground(Color.BLACK);
		carta1_jug.setBounds(10, 593, 74, 96);
		frame.getContentPane().add(carta1_jug);

		JPanel carta2_jug = new JPanel();
		carta2_jug.setBackground(Color.BLACK);
		carta2_jug.setBounds(138, 593, 74, 96);
		frame.getContentPane().add(carta2_jug);

		JPanel carta3_jug = new JPanel();
		carta3_jug.setBackground(Color.BLACK);
		carta3_jug.setBounds(310, 593, 74, 96);
		frame.getContentPane().add(carta3_jug);

		JPanel carta4_jug = new JPanel();
		carta4_jug.setBackground(Color.BLACK);
		carta4_jug.setBounds(453, 593, 74, 96);
		frame.getContentPane().add(carta4_jug);

		JPanel carta5_jug = new JPanel();
		carta5_jug.setBackground(Color.BLACK);
		carta5_jug.setBounds(605, 593, 74, 96);
		frame.getContentPane().add(carta5_jug);

//deck del jugador
		JPanel deck_jug = new JPanel();
		deck_jug.setForeground(new Color(153, 0, 0));
		deck_jug.setBackground(new Color(204, 153, 0));
		deck_jug.setBounds(749, 414, 74, 96);
		frame.getContentPane().add(deck_jug);

//cementerio del jugador
		JPanel cem_jug = new JPanel();
		cem_jug.setForeground(new Color(0, 0, 0));
		cem_jug.setBackground(new Color(255, 215, 0));
		cem_jug.setBounds(749, 593, 74, 96);
		frame.getContentPane().add(cem_jug);

//campo de batalla del jugador
		JPanel carta1Campo_jug = new JPanel();
		carta1Campo_jug.setBackground(Color.BLACK);
		carta1Campo_jug.setBounds(226, 385, 74, 96);
		frame.getContentPane().add(carta1Campo_jug);

		JPanel carta2Campo_jug = new JPanel();
		carta2Campo_jug.setBackground(Color.BLACK);
		carta2Campo_jug.setBounds(380, 385, 74, 96);
		frame.getContentPane().add(carta2Campo_jug);

		JPanel carta3Campo_jug = new JPanel();
		carta3Campo_jug.setBackground(Color.BLACK);
		carta3Campo_jug.setBounds(535, 385, 74, 96);
		frame.getContentPane().add(carta3Campo_jug);

		JPanel carta4Campo_jug = new JPanel();
		carta4Campo_jug.setBackground(Color.BLACK);
		carta4Campo_jug.setBounds(226, 492, 74, 96);
		frame.getContentPane().add(carta4Campo_jug);

		JPanel carta5Campo_jug = new JPanel();
		carta5Campo_jug.setBackground(Color.BLACK);
		carta5Campo_jug.setBounds(380, 492, 74, 96);
		frame.getContentPane().add(carta5Campo_jug);

		JPanel carta6Campo_jug = new JPanel();
		carta6Campo_jug.setBackground(Color.BLACK);
		carta6Campo_jug.setBounds(535, 492, 74, 96);
		frame.getContentPane().add(carta6Campo_jug);

//Descripcion completa de la carta seleccionada

		JPanel cartaSeleccionada = new JPanel();
		cartaSeleccionada.setBackground(Color.BLACK);
		frame.getContentPane().add(cartaSeleccionada);
		cartaSeleccionada.setBounds(935, 414, 289, 132);

		JPanel descCartaSeleccionada = new JPanel();
		descCartaSeleccionada.setBackground(Color.BLACK);
		frame.getContentPane().add(descCartaSeleccionada);
		descCartaSeleccionada.setBounds(935, 95, 289, 311);

//Contador vida jugador
		JLabel contadorJug = new JLabel("8000");
		contadorJug.setIcon(null);
		contadorJug.setBackground(new Color(153, 0, 153));
		contadorJug.setBounds(1041, 593, 200, 57);
		frame.getContentPane().add(contadorJug);

//contador vida bot
		JLabel contadorBot = new JLabel("8000");
		contadorBot.setBackground(new Color(153, 0, 153));
		contadorBot.setBounds(1041, 28, 200, 57);
		frame.getContentPane().add(contadorBot);

//icono del bot

//icono del jugador

//seteo el fondo de pantalla del tablero, la plantilla ( skin)
		frame.getContentPane().setLayout(null);
		fondo = new JLabel(imageIco4);
		fondo.setBounds(0, 0, 1283, 700);
		frame.getContentPane().add(fondo);

	}

	private void generarPanelInferior() {
		this.panelInferior = new JPanel();
		this.botonGenerar = new JButton("Generar");
		this.panelInferior.add(this.botonGenerar);
	}

	public void mostrar() {
		this.frame.setVisible(true);
	}
}