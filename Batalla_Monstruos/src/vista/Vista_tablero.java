package vista;

import java.awt.Color;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

import javax.imageio.ImageIO;
import javax.print.DocFlavor.URL;
import javax.swing.*;
import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.GridLayout;

public class Vista_tablero {
//tablero
	private JFrame tablero;
	private JPanel manoJugador;
	private JPanel manoBot;
	private JPanel panel_Tablero;
	private JLabel imagenFondoTablero;
//Cartas de campo, de mano, cementerio y deck del bot
	private JPanel carta1_bot;
	private JPanel carta2_bot;
	private JPanel carta3_bot;
	private JPanel carta4_bot;
	private JPanel carta5_bot;

	private JLabel imagen_carta1Bot;
	private JLabel imagen_carta2Bot;
	private JLabel imagen_carta3Bot;
	private JLabel imagen_carta4Bot;
	private JLabel imagen_carta5Bot;

	private JPanel deck_bot;
	private JLabel imagen_DeckBot;

	private JPanel cem_bot;
	private JLabel imagenCemBot;

	private JPanel carta1Campo_bot;
	private JPanel carta2Campo_bot;
	private JPanel carta3Campo_bot;
	private JPanel carta4Campo_bot;
	private JPanel carta5Campo_bot;
	private JPanel carta6Campo_bot;

	private JLabel imagenCartaCampo1Bot;
	private JLabel imagenCartaCampo2Bot;
	private JLabel imagenCartaCampo3Bot;
	private JLabel imagenCartaCampo4Bot;
	private JLabel imagenCartaCampo5Bot;
	private JLabel imagenCartaCampo6Bot;

//Carta de campo, de mano, cementerio y deck del JUGADOR
	private JPanel carta1_jug;
	private JPanel carta2_jug;
	private JPanel carta3_jug;
	private JPanel carta4_jug;
	private JPanel carta5_jug;

	private JPanel deck_jug;
	private JPanel cem_jug;

	private JPanel carta1Campo_jug;
	private JPanel carta2Campo_jug;
	private JPanel carta3Campo_jug;
	private JPanel carta4Campo_jug;
	private JPanel carta5Campo_jug;
	private JPanel carta6Campo_jug;

	private JLabel imagenCarta1Jug;
	private JLabel imagenCarta2Jug;
	private JLabel imagenCarta3Jug;
	private JLabel imagenCarta4Jug;
	private JLabel imagenCarta5Jug;

	private JLabel imagenCartaCampo1Jug;
	private JLabel imagenCartaCampo2Jug;
	private JLabel imagenCartaCampo3Jug;
	private JLabel imagenCartaCampo4Jug;
	private JLabel imagenCartaCampo5Jug;
	private JLabel imagenCartaCampo6Jug;

//Descripcion completa de la carta seleccionada por el jugador

	private JPanel cartaSeleccionada;
	private JLabel imagenDescCarta;
	private JPanel descCartaSeleccionada;
	private JLabel descCarta;
//Botones descripcion del jugador 
	private JButton btnInvocacion;
	private JButton btnAtacar;
	private JButton btnDefender;

//Contador de vida del bot

	private JLabel contadorBot;
	private JLabel contadorJug;
// iconos 

	private JPanel iconoBot;
	private JLabel imagenIconoBot;
	private JPanel iconoJug;
	private JLabel imagenIconoJug;

// Array de cartas

	ArrayList<JPanel> cartas_tablero = new ArrayList<JPanel>();

	public Vista_tablero() {
		this.tablero = new JFrame("TABLERO");
		tablero.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.tablero.setSize(2000, 2000);

		this.generarTablero();

	}

	private void generarTablero() {

		java.net.URL url_carta1 = getClass().getResource("/cartas/cambio_de_fidelidad.jpg"); // imagen local relativa al
																								// projecto
		ImageIcon icon_URL = new ImageIcon(
				new ImageIcon(url_carta1).getImage().getScaledInstance(130, 90, Image.SCALE_DEFAULT));
		tablero.getContentPane().setLayout(null);

//contador vida bot
		this.contadorBot = new JLabel("8000");
		contadorBot.setBounds(1053, 10, 200, 57);
		contadorBot.setFont(new Font("Tahoma", Font.PLAIN, 30));
		contadorBot.setForeground(new Color(0, 0, 204));
		this.contadorBot.setBackground(new Color(0, 0, 153));
		tablero.getContentPane().add(this.contadorBot);

//Cartas de la mano del bot
		this.carta1_bot = new JPanel();
		carta1_bot.setBounds(310, 10, 74, 96);
		this.carta1_bot.setBackground(new Color(153, 0, 0));

		java.net.URL url_carta = getClass().getResource("/cartas/cambio_de_fidelidad.jpg"); // imagen local relativa al
																							// projecto
		ImageIcon icon1_URL = new ImageIcon(
				new ImageIcon(url_carta).getImage().getScaledInstance(150, 90, Image.SCALE_DEFAULT));
		this.imagen_carta1Bot = new JLabel(icon1_URL);
		this.carta1_bot.add(imagen_carta1Bot);

//tablero.getContentPane().add(this.carta1_bot);

		this.carta2_bot = new JPanel();
		carta2_bot.setBounds(310, 10, 74, 96);
		this.carta2_bot.setBackground(new Color(153, 0, 0));

		java.net.URL url_carta2 = getClass().getResource("/cartas/cambio_de_fidelidad.jpg"); // imagen local relativa al
																								// projecto
		ImageIcon icon2_URL = new ImageIcon(
				new ImageIcon(url_carta2).getImage().getScaledInstance(150, 90, Image.SCALE_DEFAULT));
		this.imagen_carta2Bot = new JLabel(icon2_URL);
		this.carta2_bot.add(imagen_carta2Bot);

//tablero.getContentPane().add(this.carta2_bot); //para añadir panel al frame tablero, sirve para pruebas

		this.carta3_bot = new JPanel();
		carta3_bot.setBounds(453, 10, 74, 96);
		this.carta3_bot.setBackground(new Color(153, 0, 0));

		java.net.URL url_carta3 = getClass().getResource("/cartas/cambio_de_fidelidad.jpg"); // imagen local relativa al
																								// projecto
		ImageIcon icon3_URL = new ImageIcon(
				new ImageIcon(url_carta3).getImage().getScaledInstance(150, 90, Image.SCALE_DEFAULT));
		this.imagen_carta3Bot = new JLabel(icon3_URL);
		this.carta3_bot.add(imagen_carta3Bot);

//tablero.getContentPane().add(this.carta3_bot);

		this.carta4_bot = new JPanel();
		carta4_bot.setBounds(605, 10, 74, 96);
		this.carta4_bot.setBackground(new Color(153, 0, 0));

		java.net.URL url_carta4 = getClass().getResource("/cartas/cambio_de_fidelidad.jpg"); // imagen local relativa al
																								// projecto
		ImageIcon icon4_URL = new ImageIcon(
				new ImageIcon(url_carta4).getImage().getScaledInstance(150, 90, Image.SCALE_DEFAULT));
		this.imagen_carta4Bot = new JLabel(icon4_URL);

		this.carta4_bot.add(imagen_carta4Bot); // Al Panel carta le añado la imagen

//tablero.getContentPane().add(this.carta4_bot);

		this.carta5_bot = new JPanel();
		carta5_bot.setBounds(749, 10, 74, 96);
		this.carta5_bot.setBackground(new Color(153, 0, 0));

		java.net.URL url_carta5 = getClass().getResource("/cartas/cambio_de_fidelidad.jpg"); // imagen local relativa al
																								// projecto
		ImageIcon icon5_URL = new ImageIcon(
				new ImageIcon(url_carta5).getImage().getScaledInstance(150, 90, Image.SCALE_DEFAULT));
		this.imagen_carta5Bot = new JLabel(icon5_URL);
		this.carta5_bot.add(imagen_carta5Bot);

//tablero.getContentPane().add(this.carta5_bot);

//MANO DEL JUGADOR Panel grid layout
		manoBot = new JPanel();
		manoBot.setBounds(94, 10, 726, 100);
		manoBot.setSize(730, 100);
		tablero.getContentPane().add(manoBot);
		manoBot.setLayout(new GridLayout(1, 10, 0, 0));
		manoBot.setVisible(true);

		manoBot.add(this.carta1_bot); // ATENCION; no admite duplicados. Es decir, si añadis la misma imagen_carta
										// entonces te ignorará la ultima que le pongas y solo añadirà una imagen
		manoBot.add(this.carta2_bot);
		manoBot.add(this.carta3_bot); // A VECES SALE ERROR, SIN RAZON. Es decir, a veces cuando ejecutas esta linea (
										// o las demas lineas manoBot.add(Carta) sale error, y otras veces no, cuidado).
										// Una posible solucion, algo más estable, es añadir al grid el JLabel imagen, y
										// no los paneles.
		manoBot.add(this.carta4_bot);
		manoBot.add(this.carta5_bot);

//deck del bot
		this.deck_bot = new JPanel();
		deck_bot.setBounds(10, 10, 74, 96);
		this.deck_bot.setForeground(new Color(204, 0, 0));
		this.deck_bot.setBackground(new Color(0, 0, 0));

		java.net.URL urlDeckBot = getClass().getResource("/boca_abajo_default/boca_abajo.jpg"); // imagen local relativa
																								// al projecto
		ImageIcon iconDeckBot = new ImageIcon(
				new ImageIcon(urlDeckBot).getImage().getScaledInstance(70, 100, Image.SCALE_DEFAULT));
		this.imagen_DeckBot = new JLabel(iconDeckBot);
		this.deck_bot.add(imagen_DeckBot);

		tablero.getContentPane().add(this.deck_bot);

//cementerio del bot
		this.cem_bot = new JPanel();
		cem_bot.setBounds(10, 172, 74, 96);
		this.cem_bot.setBackground(new Color(0, 0, 0));

		java.net.URL urlCemBot = getClass().getResource("/boca_abajo_default/boca_abajo.jpg"); // imagen local relativa
																								// al projecto
		ImageIcon IconCemBot = new ImageIcon(
				new ImageIcon(urlCemBot).getImage().getScaledInstance(70, 100, Image.SCALE_DEFAULT));
		this.imagenCemBot = new JLabel(IconCemBot);
		this.cem_bot.add(imagenCemBot);

		tablero.getContentPane().add(this.cem_bot);

//campo de batalla del bot
		this.carta1Campo_bot = new JPanel();
		carta1Campo_bot.setBounds(226, 249, 135, 96);
		this.carta1Campo_bot.setBackground(Color.BLACK);

		java.net.URL url_cartaCampo1 = getClass().getResource("/cartas/cambio_de_fidelidad.jpg"); // imagen local
																									// relativa al
																									// projecto
		ImageIcon iconCampo1_URL = new ImageIcon(
				new ImageIcon(url_cartaCampo1).getImage().getScaledInstance(150, 90, Image.SCALE_DEFAULT));
		this.imagenCartaCampo1Bot = new JLabel(iconCampo1_URL);
		this.carta1Campo_bot.add(imagenCartaCampo1Bot);

		tablero.getContentPane().add(this.carta1Campo_bot);

		this.carta2Campo_bot = new JPanel();
		carta2Campo_bot.setBounds(380, 249, 135, 96);
		this.carta2Campo_bot.setBackground(Color.BLACK);

		java.net.URL url_cartaCampo2 = getClass().getResource("/cartas/dark_magician.jpg"); // imagen local relativa al
																							// projecto
		ImageIcon iconCampo2_URL = new ImageIcon(
				new ImageIcon(url_cartaCampo2).getImage().getScaledInstance(150, 90, Image.SCALE_DEFAULT));
		this.imagenCartaCampo2Bot = new JLabel(iconCampo2_URL);
		this.carta2Campo_bot.add(imagenCartaCampo2Bot);

		tablero.getContentPane().add(this.carta2Campo_bot);

		this.carta3Campo_bot = new JPanel();
		carta3Campo_bot.setBounds(535, 249, 135, 96);
		this.carta3Campo_bot.setBackground(Color.BLACK);

		java.net.URL url_cartaCampo3 = getClass().getResource("/cartas/dark_magician.jpg"); // imagen local relativa al
																							// projecto
		ImageIcon iconCampo3_URL = new ImageIcon(
				new ImageIcon(url_cartaCampo3).getImage().getScaledInstance(150, 90, Image.SCALE_DEFAULT));
		this.imagenCartaCampo3Bot = new JLabel(iconCampo3_URL);
		this.carta3Campo_bot.add(imagenCartaCampo3Bot);

		tablero.getContentPane().add(this.carta3Campo_bot);

		this.carta4Campo_bot = new JPanel();
		carta4Campo_bot.setBounds(226, 117, 135, 96);
		this.carta4Campo_bot.setBackground(Color.BLACK);

		java.net.URL url_cartaCampo4 = getClass().getResource("/cartas/dark_magician.jpg"); // imagen local relativa al
																							// projecto
		ImageIcon iconCampo4_URL = new ImageIcon(
				new ImageIcon(url_cartaCampo4).getImage().getScaledInstance(150, 90, Image.SCALE_DEFAULT));
		this.imagenCartaCampo4Bot = new JLabel(iconCampo4_URL);
		this.carta4Campo_bot.add(imagenCartaCampo4Bot);

		tablero.getContentPane().add(this.carta4Campo_bot);

		this.carta5Campo_bot = new JPanel();
		carta5Campo_bot.setBounds(380, 117, 135, 96);
		this.carta5Campo_bot.setBackground(Color.BLACK);

		java.net.URL url_cartaCampo5 = getClass().getResource("/cartas/dark_magician.jpg"); // imagen local relativa al
																							// projecto
		ImageIcon iconCampo5_URL = new ImageIcon(
				new ImageIcon(url_cartaCampo5).getImage().getScaledInstance(150, 90, Image.SCALE_DEFAULT));
		this.imagenCartaCampo5Bot = new JLabel(iconCampo5_URL);
		this.carta5Campo_bot.add(imagenCartaCampo5Bot);

		tablero.getContentPane().add(this.carta5Campo_bot);

		this.carta6Campo_bot = new JPanel();
		carta6Campo_bot.setBounds(535, 117, 135, 96);
		this.carta6Campo_bot.setBackground(Color.BLACK);

		java.net.URL url_cartaCampo6 = getClass().getResource("/cartas/dark_magician.jpg"); // imagen local relativa al
																							// projecto
		ImageIcon iconCampo6_URL = new ImageIcon(
				new ImageIcon(url_cartaCampo6).getImage().getScaledInstance(150, 90, Image.SCALE_DEFAULT));
		this.imagenCartaCampo6Bot = new JLabel(iconCampo6_URL);
		this.carta6Campo_bot.add(imagenCartaCampo6Bot);

		tablero.getContentPane().add(this.carta6Campo_bot);

//Cartas de mano del jugador
		this.carta1_jug = new JPanel();
		carta1_jug.setBounds(10, 593, 74, 96);
		this.carta1_jug.setBackground(new Color(153, 0, 0));

		java.net.URL url_carta1jug = getClass().getResource("/cartas/dark_magician.jpg"); // imagen local relativa al
																							// projecto
		ImageIcon iconCampo1_URLjugador = new ImageIcon(
				new ImageIcon(url_carta1jug).getImage().getScaledInstance(150, 90, Image.SCALE_DEFAULT));
		this.imagenCarta1Jug = new JLabel(iconCampo1_URLjugador);
		this.carta1_jug.add(imagenCarta1Jug);

//tablero.getContentPane().add(this.carta1_jug);

		this.carta2_jug = new JPanel();
		carta2_jug.setBounds(138, 593, 74, 96);
		this.carta2_jug.setBackground(new Color(153, 0, 0));

		java.net.URL url_carta2jug = getClass().getResource("/cartas/dark_magician.jpg"); // imagen local relativa al
																							// projecto
		ImageIcon iconCampo2_URLjugador = new ImageIcon(
				new ImageIcon(url_carta2jug).getImage().getScaledInstance(150, 90, Image.SCALE_DEFAULT));
		this.imagenCarta2Jug = new JLabel(iconCampo2_URLjugador);
		this.carta2_jug.add(imagenCarta2Jug);

//tablero.getContentPane().add(this.carta2_jug);

		this.carta3_jug = new JPanel();
		carta3_jug.setBounds(310, 593, 74, 96);
		this.carta3_jug.setBackground(new Color(153, 0, 0));

		java.net.URL url_carta3jug = getClass().getResource("/cartas/dark_magician.jpg"); // imagen local relativa al
																							// projecto
		ImageIcon iconCampo3_URLjugador = new ImageIcon(
				new ImageIcon(url_carta3jug).getImage().getScaledInstance(150, 90, Image.SCALE_DEFAULT));
		this.imagenCarta3Jug = new JLabel(iconCampo3_URLjugador);
		this.carta3_jug.add(imagenCarta3Jug);

//tablero.getContentPane().add(this.carta3_jug);

		this.carta4_jug = new JPanel();
		carta4_jug.setBounds(453, 593, 74, 96);
		this.carta4_jug.setBackground(new Color(153, 0, 0));

		java.net.URL url_carta4jug = getClass().getResource("/cartas/dark_magician.jpg"); // imagen local relativa al
																							// projecto
		ImageIcon iconCampo4_URLjugador = new ImageIcon(
				new ImageIcon(url_carta4jug).getImage().getScaledInstance(150, 90, Image.SCALE_DEFAULT));
		this.imagenCarta4Jug = new JLabel(iconCampo4_URLjugador);
		this.carta4_jug.add(imagenCarta4Jug);

//tablero.getContentPane().add(this.carta4_jug);

		this.carta5_jug = new JPanel();
		carta5_jug.setBounds(605, 593, 74, 96);
		this.carta5_jug.setBackground(new Color(153, 0, 0));

		java.net.URL url_carta5jug = getClass().getResource("/cartas/dark_magician.jpg"); // imagen local relativa al
																							// projecto
		ImageIcon iconCampo5_URLjugador = new ImageIcon(
				new ImageIcon(url_carta5jug).getImage().getScaledInstance(150, 90, Image.SCALE_DEFAULT));
		this.imagenCarta5Jug = new JLabel(iconCampo5_URLjugador);
		this.carta5_jug.add(imagenCarta5Jug);

//tablero.getContentPane().add(this.carta5_jug);

//MANO DEL JUGADOR Panel grid layout que tiene adentro paneles con imagenes
		manoJugador = new JPanel();
		manoJugador.setBackground(Color.BLACK);
		manoJugador.setBounds(10, 589, 726, 100);
		manoJugador.setSize(730, 100);
		tablero.getContentPane().add(manoJugador);
		manoJugador.setLayout(new GridLayout(1, 0, 0, 0));
		this.manoJugador.add(this.carta1_jug);
		this.manoJugador.add(this.carta2_jug);
		this.manoJugador.add(this.carta3_jug);
		this.manoJugador.add(this.carta4_jug);
		this.manoJugador.add(this.carta5_jug);

//deck del jugador
		this.deck_jug = new JPanel();
		deck_jug.setBounds(749, 414, 74, 96);
		this.deck_jug.setForeground(new Color(153, 0, 0));
		this.deck_jug.setBackground(new Color(102, 102, 0));

		java.net.URL urlDeckJug = getClass().getResource("/boca_abajo_default/boca_abajo.jpg"); // imagen local relativa
																								// al projecto
		ImageIcon iconDeckJug = new ImageIcon(
				new ImageIcon(urlDeckJug).getImage().getScaledInstance(70, 100, Image.SCALE_DEFAULT));
		JLabel imagen_DeckJug = new JLabel(iconDeckJug);
		this.deck_jug.add(imagen_DeckJug);

		tablero.getContentPane().add(this.deck_jug);

//cementerio del jugador
		this.cem_jug = new JPanel();
		cem_jug.setBounds(749, 593, 74, 96);
		this.cem_jug.setForeground(new Color(0, 0, 0));
		this.cem_jug.setBackground(new Color(153, 102, 0));

		java.net.URL urlCemJug = getClass().getResource("/boca_abajo_default/boca_abajo.jpg"); // imagen local relativa
																								// al projecto
		ImageIcon iconCemJug = new ImageIcon(
				new ImageIcon(urlCemJug).getImage().getScaledInstance(70, 100, Image.SCALE_DEFAULT));
		JLabel imagenCemJug = new JLabel(iconCemJug);
		this.cem_jug.add(imagenCemJug);

		tablero.getContentPane().add(this.cem_jug);

//campo de batalla del jugador
		this.carta1Campo_jug = new JPanel();
		carta1Campo_jug.setBounds(226, 385, 135, 96);
		this.carta1Campo_jug.setBackground(Color.BLACK);

		java.net.URL url_cartaCampo1Jug = getClass().getResource("/cartas/cambio_de_fidelidad.jpg"); // imagen local
																										// relativa al
																										// projecto
		ImageIcon iconCampo1_URLjug = new ImageIcon(
				new ImageIcon(url_cartaCampo1Jug).getImage().getScaledInstance(150, 90, Image.SCALE_DEFAULT));
		this.imagenCartaCampo1Jug = new JLabel(iconCampo1_URLjug);
		this.carta1Campo_jug.add(imagenCartaCampo1Jug);

		tablero.getContentPane().add(this.carta1Campo_jug);

		this.carta2Campo_jug = new JPanel();
		carta2Campo_jug.setBounds(380, 385, 135, 96);
		this.carta2Campo_jug.setBackground(Color.BLACK);

		java.net.URL url_cartaCampo2Jug = getClass().getResource("/cartas/cambio_de_fidelidad.jpg"); // imagen local
																										// relativa al
																										// projecto
		ImageIcon iconCampo2_URLjug = new ImageIcon(
				new ImageIcon(url_cartaCampo2Jug).getImage().getScaledInstance(150, 90, Image.SCALE_DEFAULT));
		this.imagenCartaCampo2Jug = new JLabel(iconCampo2_URLjug);
		this.carta2Campo_jug.add(imagenCartaCampo2Jug);

		tablero.getContentPane().add(this.carta2Campo_jug);

		this.carta3Campo_jug = new JPanel();
		carta3Campo_jug.setBounds(535, 385, 135, 96);
		this.carta3Campo_jug.setBackground(Color.BLACK);

		java.net.URL url_cartaCampo3Jug = getClass().getResource("/cartas/cambio_de_fidelidad.jpg"); // imagen local
																										// relativa al
																										// projecto
		ImageIcon iconCampo3_URLjug = new ImageIcon(
				new ImageIcon(url_cartaCampo3Jug).getImage().getScaledInstance(150, 90, Image.SCALE_DEFAULT));
		this.imagenCartaCampo3Jug = new JLabel(iconCampo3_URLjug);
		this.carta3Campo_jug.add(imagenCartaCampo3Jug);

		tablero.getContentPane().add(this.carta3Campo_jug);

		this.carta4Campo_jug = new JPanel();
		carta4Campo_jug.setBounds(226, 492, 135, 96);
		this.carta4Campo_jug.setBackground(Color.BLACK);

		java.net.URL url_cartaCampo4Jug = getClass().getResource("/cartas/cambio_de_fidelidad.jpg"); // imagen local
																										// relativa al
																										// projecto
		ImageIcon iconCampo4_URLjug = new ImageIcon(
				new ImageIcon(url_cartaCampo4Jug).getImage().getScaledInstance(150, 90, Image.SCALE_DEFAULT));
		this.imagenCartaCampo4Jug = new JLabel(iconCampo4_URLjug);
		this.carta4Campo_jug.add(imagenCartaCampo4Jug);

		tablero.getContentPane().add(this.carta4Campo_jug);

		this.carta5Campo_jug = new JPanel();
		carta5Campo_jug.setBounds(380, 492, 135, 96);
		this.carta5Campo_jug.setBackground(Color.BLACK);

		java.net.URL url_cartaCampo5Jug = getClass().getResource("/cartas/cambio_de_fidelidad.jpg"); // imagen local
																										// relativa al
																										// projecto
		ImageIcon iconCampo5_URLjug = new ImageIcon(
				new ImageIcon(url_cartaCampo5Jug).getImage().getScaledInstance(150, 90, Image.SCALE_DEFAULT));
		this.imagenCarta5Jug = new JLabel(iconCampo5_URLjug);
		this.carta5Campo_jug.add(imagenCarta5Jug);

		tablero.getContentPane().add(this.carta5Campo_jug);

		this.carta6Campo_jug = new JPanel();
		carta6Campo_jug.setBounds(535, 492, 135, 96);
		this.carta6Campo_jug.setBackground(Color.BLACK);

		java.net.URL url_cartaCampo6Jug = getClass().getResource("/cartas/cambio_de_fidelidad.jpg"); // imagen local
																										// relativa al
																										// projecto
		ImageIcon iconCampo6_URLjug = new ImageIcon(
				new ImageIcon(url_cartaCampo6Jug).getImage().getScaledInstance(150, 90, Image.SCALE_DEFAULT));
		this.imagenCartaCampo6Jug = new JLabel(iconCampo6_URLjug);
		this.carta6Campo_jug.add(imagenCartaCampo6Jug);

		tablero.getContentPane().add(this.carta6Campo_jug);

//Descripcion completa de la carta seleccionada

		this.cartaSeleccionada = new JPanel();
		cartaSeleccionada.setBounds(862, 83, 391, 390);
		this.cartaSeleccionada.setBackground(Color.BLACK);
		tablero.getContentPane().add(this.cartaSeleccionada);

		java.net.URL url_descCarta = getClass().getResource("/cartas/dark_magician.jpg"); // imagen local relativa al
																							// projecto
		ImageIcon iconDescCart = new ImageIcon(
				new ImageIcon(url_descCarta).getImage().getScaledInstance(400, 380, Image.SCALE_DEFAULT));
		this.imagenDescCarta = new JLabel(iconDescCart);

		this.cartaSeleccionada.add(imagenDescCarta);

		this.descCartaSeleccionada = new JPanel();
//CAMBIO HECHO		
		descCartaSeleccionada.setBounds(862, 550, 391, 80); // cambio en posicion y altura de la descripcion
		this.descCartaSeleccionada.setBackground(Color.BLACK);
		this.descCarta = new JLabel("INSERTE DESCRIPCION DE LA CARTA AQUI");
		descCarta.setBackground(new Color(255, 255, 255));
		this.descCartaSeleccionada.add(descCarta);
		tablero.getContentPane().add(this.descCartaSeleccionada);

//BOTONES DESCRIPCION DE LA CARTA --> INVOCAR, ATACAR, DEFENDER 
		
		// Botton Invocacion
		this.btnInvocacion = new JButton("Invocar");
		btnInvocacion.setBounds(862, 500, 100, 30);
		tablero.getContentPane().add(this.btnInvocacion);

		// Botton Atacar
		this.btnAtacar = new JButton("Atacar");
		btnAtacar.setBounds(1010, 500, 100, 30);
		tablero.getContentPane().add(this.btnAtacar);
		
		// Botton Atacar
		this.btnDefender = new JButton("Defender");
		btnDefender.setBounds(1150, 500, 100, 30);
		tablero.getContentPane().add(this.btnDefender);

//Contador vida jugador
		this.contadorJug = new JLabel("8000");
		contadorJug.setBounds(1053, 632, 200, 57);
		contadorJug.setForeground(new Color(0, 0, 0));
		contadorJug.setFont(new Font("Tahoma", Font.PLAIN, 30));
		this.contadorJug.setIcon(null);
		this.contadorJug.setBackground(new Color(153, 0, 153));
		tablero.getContentPane().add(this.contadorJug);

//icono del bot
		iconoBot = new JPanel();
		iconoBot.setBounds(910, 10, 87, 62);
		iconoBot.setBackground(new Color(0, 0, 0));

		java.net.URL urlIconoBot = getClass().getResource("/IconoPersonajes/seto_kaiba.png"); // imagen local relativa
																								// al projecto
		ImageIcon imagenIconoBot = new ImageIcon(
				new ImageIcon(urlIconoBot).getImage().getScaledInstance(90, 90, Image.SCALE_DEFAULT));
		this.imagenIconoBot = new JLabel(imagenIconoBot);
		iconoBot.add(this.imagenIconoBot);

		tablero.getContentPane().add(iconoBot);

//icono del jugador
		JPanel iconoJug = new JPanel();
		iconoJug.setBounds(910, 632, 87, 62);

		java.net.URL urlIconoJug = getClass().getResource("/IconoPersonajes/yugi_moto.jpg"); // imagen local relativa al
																								// projecto
		ImageIcon imagenIconoJug = new ImageIcon(
				new ImageIcon(urlIconoJug).getImage().getScaledInstance(90, 90, Image.SCALE_DEFAULT));
		this.imagenIconoJug = new JLabel(imagenIconoJug);
		iconoJug.add(this.imagenIconoJug);

		tablero.getContentPane().add(iconoJug);

//seteo el fondo de pantalla ( imagen) agregandola al frame.
		java.net.URL fondoTableroURL = getClass().getResource("/fondo_tablero/yugi_milennium.jpg"); // imagen local
																									// relativa al
																									// projecto
		ImageIcon iconFondoTablero = new ImageIcon(
				new ImageIcon(fondoTableroURL).getImage().getScaledInstance(1400, 1400, Image.SCALE_DEFAULT));
		imagenFondoTablero = new JLabel(iconFondoTablero);
		imagenFondoTablero.setBounds(0, 0, 1283, 700);
		this.imagenFondoTablero.setBackground(new Color(153, 0, 0));

		this.tablero.getContentPane().add(this.imagenFondoTablero);

		
		
		
	//Getters y Setters 	

	}

	public JPanel getCarta1_bot() {
		return carta1_bot;
	}

	public void setCarta1_bot(JPanel carta1_bot) {
		this.carta1_bot = carta1_bot;
	}

	public JPanel getCarta2_bot() {
		return carta2_bot;
	}

	public void setCarta2_bot(JPanel carta2_bot) {
		this.carta2_bot = carta2_bot;
	}

	public JPanel getCarta3_bot() {
		return carta3_bot;
	}

	public void setCarta3_bot(JPanel carta3_bot) {
		this.carta3_bot = carta3_bot;
	}

	public JPanel getCarta4_bot() {
		return carta4_bot;
	}

	public void setCarta4_bot(JPanel carta4_bot) {
		this.carta4_bot = carta4_bot;
	}

	public JPanel getCarta5_bot() {
		return carta5_bot;
	}

	public void setCarta5_bot(JPanel carta5_bot) {
		this.carta5_bot = carta5_bot;
	}

	public void mostrar() {
		this.tablero.setVisible(true);
	}
}