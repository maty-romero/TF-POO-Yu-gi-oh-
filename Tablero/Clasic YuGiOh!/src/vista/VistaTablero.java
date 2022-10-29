package vista;

import java.awt.Color;
import java.awt.Component;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;

import javax.imageio.ImageIO;
import javax.print.DocFlavor.URL;
import javax.swing.*;

import controlador.ControladorProyeccionCartas;
//import controlador.ControladorProyeccionCartas;
import controlador.TableroController;

import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.Button;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class VistaTablero {
	// Controlador
	private TableroController tableroController;
//tablero
	private JFrame tablero;
	private JPanel manoJugador;
	private JPanel manoBot;
	private JPanel panel_Tablero;
	private JLabel imagenFondoTablero;

	// Cartas de campo, de mano, cementerio y deck del bot
	private JPanel carta1ManoBot;
	private JPanel carta2ManoBot;
	private JPanel carta3ManoBot;
	private JPanel carta4ManoBot;
	private JPanel carta5ManoBot;

	private JLabel imagenCarta1ManoBot;
	private JLabel imagenCarta2ManoBot;
	private JLabel imagenCarta3ManoBot;
	private JLabel imagenCarta4ManoBot;
	private JLabel imagenCarta5ManoBot;

	private JPanel deck_bot;
	private JLabel imagen_DeckBot;

	private JPanel cem_bot;
	private JLabel imagenCemBot;

	private JPanel cartaCampo;
	private JPanel carta2CampoBot;
	private JPanel carta3CampoBot;
	private JPanel carta4CampoBot;
	private JPanel carta5CampoBot;
	private JPanel carta6CampoBot;

	private JLabel imagenCartaCampo1Bot;
	private JLabel imagenCartaCampo2Bot;
	private JLabel imagenCartaCampo3Bot;
	private JLabel imagenCartaCampo4Bot;
	private JLabel imagenCartaCampo5Bot;
	private JLabel imagenCartaCampo6Bot;
	/// STRINGS
	private String StringCarta1CampoBot;
	private String StringCarta2CampoBot;
	private String StringCarta3CampoBot;
	private String StringCarta4CampoBot;
	private String StringCarta5CampoBot;
	private String StringCarta6CampoBot;

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
//Contador de vida del bot

	private JLabel contadorBot;
	private JLabel contadorJug;
// iconos 

	private JPanel iconoBot;
	private JLabel imagenIconoBot;
	private JPanel iconoJug;
	private JLabel imagenIconoJug;

//Botones 
	private JButton btnAtacar;
	private JButton btnInvocar;

// Array de cartas

	private HashMap<JPanel, String> cartasTablero = new HashMap<JPanel, String>();

	public VistaTablero(TableroController tableroController) {
		this.setTableroController(tableroController);
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

		// MANO DEL JUGADOR Panel grid layout que tiene adentro paneles con imagenes
		manoJugador = new JPanel();
		manoJugador.setBackground(Color.BLACK);
		manoJugador.setBounds(10, 589, 726, 100);
		manoJugador.setSize(730, 100);
		tablero.getContentPane().add(manoJugador);

		manoJugador.setLayout(new GridLayout(1, 0, 0, 0));
		manoJugador.setFocusable(true);

		// MANO DEL BOT Panel grid layout
		manoBot = new JPanel();
		manoBot.setBounds(94, 10, 726, 100);
		manoBot.setSize(730, 100);
		tablero.getContentPane().add(manoBot);
		manoBot.setLayout(new GridLayout(1, 0, 0, 0));
		manoBot.setVisible(true);
		manoBot.setFocusable(true);
		manoBot.requestFocus();

//contador vida bot
		this.contadorBot = new JLabel("8000");
		contadorBot.setBounds(1053, 10, 200, 57);
		contadorBot.setFont(new Font("Tahoma", Font.PLAIN, 30));
		contadorBot.setForeground(new Color(0, 0, 204));
		this.contadorBot.setBackground(new Color(0, 0, 153));
		tablero.getContentPane().add(this.contadorBot);

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

//        this.cartaCampo = new JPanel();
//		cartaCampo.setBounds(226, 249, 135, 96);
//		this.cartaCampo.setBackground(Color.BLACK);
//		StringCarta1CampoBot = "/cartas/cambio_de_fidelidad.jpg";
//		java.net.URL url_cartaCampo1 = getClass().getResource(StringCarta1CampoBot); // imagen local
//																						// relativa al
//																						// projecto
//		ImageIcon iconCampo1_URL = new ImageIcon(
//				new ImageIcon(url_cartaCampo1).getImage().getScaledInstance(150, 90, Image.SCALE_DEFAULT));
//		this.imagenCartaCampo1Bot = new JLabel(iconCampo1_URL);
//		this.cartaCampo.add(imagenCartaCampo1Bot);
//
//		tablero.getContentPane().add(this.cartaCampo);
//
//		this.carta2CampoBot = new JPanel();
//		// this.carta2CampoBot.addMouseListener(new
//		// ControladorProyeccionCartas(this,tableroController));
//		carta2CampoBot.setBounds(380, 249, 135, 96);
//		this.carta2CampoBot.setBackground(Color.BLACK);
//
//		StringCarta2CampoBot = "/cartas/dark_magician.jpg";
//		java.net.URL url_cartaCampo2 = getClass().getResource(StringCarta2CampoBot); // imagen local relativa al
//																						// projecto
//		ImageIcon iconCampo2_URL = new ImageIcon(
//				new ImageIcon(url_cartaCampo2).getImage().getScaledInstance(150, 90, Image.SCALE_DEFAULT));
//		this.imagenCartaCampo2Bot = new JLabel(iconCampo2_URL);
//		this.carta2CampoBot.add(imagenCartaCampo2Bot);
//
//		tablero.getContentPane().add(this.carta2CampoBot);
//
//		this.carta3CampoBot = new JPanel();
//		// this.carta3CampoBot.addMouseListener(new
//		// ControladorProyeccionCartas(this,tableroController));
//		carta3CampoBot.setBounds(535, 249, 135, 96);
//		this.carta3CampoBot.setBackground(Color.BLACK);
//
//		StringCarta3CampoBot = "/cartas/dragonBlancoOjosAzules.jpg";
//
//		java.net.URL url_cartaCampo3 = getClass().getResource(StringCarta3CampoBot); // imagen local relativa al
//																						// projecto
//		ImageIcon iconCampo3_URL = new ImageIcon(
//				new ImageIcon(url_cartaCampo3).getImage().getScaledInstance(150, 90, Image.SCALE_DEFAULT));
//		this.imagenCartaCampo3Bot = new JLabel(iconCampo3_URL);
//		this.carta3CampoBot.add(imagenCartaCampo3Bot);
//
//		tablero.getContentPane().add(this.carta3CampoBot);
//
//		this.carta4CampoBot = new JPanel();
//		// this.carta4CampoBot.addMouseListener(new
//		// ControladorProyeccionCartas(this,tableroController));
//		carta4CampoBot.setBounds(226, 117, 135, 96);
//		this.carta4CampoBot.setBackground(Color.BLACK);
//
//		StringCarta4CampoBot = "/cartas/dragonBlancoOjosAzules.jpg";
//
//		java.net.URL url_cartaCampo4 = getClass().getResource(StringCarta4CampoBot); // imagen local relativa al
//																						// projecto
//		ImageIcon iconCampo4_URL = new ImageIcon(
//				new ImageIcon(url_cartaCampo4).getImage().getScaledInstance(150, 90, Image.SCALE_DEFAULT));
//		this.imagenCartaCampo4Bot = new JLabel(iconCampo4_URL);
//		this.carta4CampoBot.add(imagenCartaCampo4Bot);
//
////		tablero.getContentPane().add(this.carta4CampoBot);
//
//		this.carta5CampoBot = new JPanel();
//		// this.carta5CampoBot.addMouseListener(new
//		// ControladorProyeccionCartas(this,tableroController));
//		carta5CampoBot.setBounds(380, 117, 135, 96);
//		this.carta5CampoBot.setBackground(Color.BLACK);
//
//		StringCarta5CampoBot = "/cartas/darkMagicianGirl.jpg";
//
//		java.net.URL url_cartaCampo5 = getClass().getResource(StringCarta5CampoBot); // imagen local relativa al
//																						// projecto
//		ImageIcon iconCampo5_URL = new ImageIcon(
//				new ImageIcon(url_cartaCampo5).getImage().getScaledInstance(150, 90, Image.SCALE_DEFAULT));
//		this.imagenCartaCampo5Bot = new JLabel(iconCampo5_URL);
//		this.carta5CampoBot.add(imagenCartaCampo5Bot);
//
//		tablero.getContentPane().add(this.carta5CampoBot);
//
//		StringCarta6CampoBot = "/cartas/dark_magician.jpg";
//
//		this.carta6CampoBot = new JPanel();
//		// this.carta6CampoBot.addMouseListener(new
//		// ControladorProyeccionCartas(this,tableroController));
//		carta6CampoBot.setBounds(535, 117, 135, 96);
//		this.carta6CampoBot.setBackground(Color.BLACK);
//
//		java.net.URL url_cartaCampo6 = getClass().getResource(StringCarta6CampoBot); // imagen local relativa al
//																						// projecto
//		ImageIcon iconCampo6_URL = new ImageIcon(
//				new ImageIcon(url_cartaCampo6).getImage().getScaledInstance(150, 90, Image.SCALE_DEFAULT));
//		this.imagenCartaCampo6Bot = new JLabel(iconCampo6_URL);
//		this.carta6CampoBot.add(imagenCartaCampo6Bot);
//
//		tablero.getContentPane().add(this.carta6CampoBot);

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
///
		this.carta5Campo_jug = new JPanel();
		this.carta5Campo_jug.setBounds(380, 492, 135, 96);
		this.carta5Campo_jug.setBackground(Color.BLACK);

		java.net.URL url_cartaCampo5Jug = getClass().getResource("/cartas/cambio_de_fidelidad.jpg"); // imagen local
																										// relativa al
																										// projecto
		ImageIcon iconCampo5_URLjug = new ImageIcon(
				new ImageIcon(url_cartaCampo5Jug).getImage().getScaledInstance(150, 90, Image.SCALE_DEFAULT));
		this.imagenCarta5Jug = new JLabel(iconCampo5_URLjug);

		this.carta5Campo_jug.add(imagenCarta5Jug);

		tablero.getContentPane().add(this.carta5Campo_jug);
///

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
		cartaSeleccionada.setBounds(862, 78, 391, 390);
		this.cartaSeleccionada.setBackground(Color.BLACK);
		tablero.getContentPane().add(this.cartaSeleccionada);

		java.net.URL url_descCarta = getClass().getResource("/boca_abajo_default/boca_abajo.jpg"); // imagen local
																									// relativa al
		// projecto
		ImageIcon iconDescCart = new ImageIcon(
				new ImageIcon(url_descCarta).getImage().getScaledInstance(400, 380, Image.SCALE_DEFAULT));
		this.imagenDescCarta = new JLabel(iconDescCart);

		// this.cartaSeleccionada.add(imagenDescCarta);

		this.descCartaSeleccionada = new JPanel();
		descCartaSeleccionada.setBounds(862, 514, 391, 120);
		this.descCartaSeleccionada.setBackground(Color.BLACK);
		this.descCarta = new JLabel("INSERTE DESCRIPCION DE LA CARTA AQUI");
		descCarta.setBackground(new Color(255, 255, 255));
		this.descCartaSeleccionada.add(descCarta);
		tablero.getContentPane().add(this.descCartaSeleccionada);

//Contador vida jugador
		this.contadorJug = new JLabel("8000");
		contadorJug.setBounds(1053, 667, 200, 57);
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
		this.seteoPanelesCampo();
		java.net.URL fondoTableroURL = getClass().getResource("/fondo_tablero/yugi_milennium.jpg"); // imagen local
		// relativa al
		// projecto
		ImageIcon iconFondoTablero = new ImageIcon(
				new ImageIcon(fondoTableroURL).getImage().getScaledInstance(1400, 1400, Image.SCALE_DEFAULT));

		imagenFondoTablero = new JLabel(iconFondoTablero);
		imagenFondoTablero.setBounds(0, 0, 1283, 784);
		this.imagenFondoTablero.setBackground(new Color(153, 0, 0));

		this.tablero.getContentPane().add(this.imagenFondoTablero);

	}

	public JPanel agregoCartaMano(JLabel labelCarta, JPanel mano) {
		JPanel cartaPanel = new JPanel();
		cartaPanel.setBounds(605, 593, 74, 96);
		cartaPanel.setBackground(new Color(153, 0, 0));
		cartaPanel.addMouseListener(new ControladorProyeccionCartas(this, tableroController));
		cartaPanel.add(labelCarta);
		cartaPanel.setFocusable(true);
		cartaPanel.requestFocus();
		mano.add(cartaPanel);

		mano.setFocusable(true);
		return cartaPanel;
	}

	public JPanel agregoCartaCampo(JLabel labelCarta) {

		this.cartaCampo.add(imagenCartaCampo1Bot);
		this.cartaCampo.addMouseListener(new ControladorProyeccionCartas(this, tableroController));

		tablero.getContentPane().add(this.cartaCampo);
		return this.cartaCampo;

	}

	public ArrayList<JPanel> seteoPanelesCampo() {
		ArrayList<JPanel> panelesCampo = new ArrayList<>();

		JPanel carta1CampoOponente = new JPanel();
		carta1CampoOponente.setBounds(226, 249, 135, 96);
		carta1CampoOponente.setBackground(Color.BLACK);
		carta1CampoOponente.addMouseListener(new ControladorProyeccionCartas(this, tableroController));
		tablero.getContentPane().add(carta1CampoOponente);

		JPanel carta2CampoOponente = new JPanel();
		carta2CampoOponente.setBounds(380, 249, 135, 96);
		carta2CampoOponente.setBackground(Color.BLACK);
		carta2CampoOponente.addMouseListener(new ControladorProyeccionCartas(this, tableroController));
		tablero.getContentPane().add(carta2CampoOponente);

		JPanel carta3CampoOponente = new JPanel();
		carta3CampoOponente.setBounds(535, 249, 135, 96);
		carta3CampoOponente.setBackground(Color.BLACK);
		carta3CampoOponente.addMouseListener(new ControladorProyeccionCartas(this, tableroController));
		tablero.getContentPane().add(carta3CampoOponente);

		JPanel carta4CampoOponente = new JPanel();
		carta4CampoOponente.setBounds(226, 117, 135, 96);
		carta4CampoOponente.setBackground(Color.BLACK);
		carta4CampoOponente.addMouseListener(new ControladorProyeccionCartas(this, tableroController));
		tablero.getContentPane().add(carta4CampoOponente);

		JPanel carta5CampoOponente = new JPanel();
		carta5CampoOponente.setBounds(380, 117, 135, 96);
		carta5CampoOponente.setBackground(Color.BLACK);
		carta5CampoOponente.addMouseListener(new ControladorProyeccionCartas(this, tableroController));
		tablero.getContentPane().add(carta5CampoOponente);

		JPanel carta6CampoOponente = new JPanel();
		carta6CampoOponente.setBounds(535, 117, 135, 96);
		carta6CampoOponente.setBackground(Color.BLACK);
		carta6CampoOponente.addMouseListener(new ControladorProyeccionCartas(this, tableroController));
		tablero.getContentPane().add(carta6CampoOponente);

		return panelesCampo;
	}

	public JFrame getTablero() {
		return tablero;
	}

	public String getStringCarta1CampoBot() {
		return StringCarta1CampoBot;
	}

	public void setStringCarta1CampoBot(String stringCarta1CampoBot) {
		StringCarta1CampoBot = stringCarta1CampoBot;
	}

	public String getStringCarta2CampoBot() {
		return StringCarta2CampoBot;
	}

	public void setStringCarta2CampoBot(String stringCarta2CampoBot) {
		StringCarta2CampoBot = stringCarta2CampoBot;
	}

	public String getStringCarta3CampoBot() {
		return StringCarta3CampoBot;
	}

	public void setStringCarta3CampoBot(String stringCarta3CampoBot) {
		StringCarta3CampoBot = stringCarta3CampoBot;
	}

	public JLabel getImagenCartaCampo2Bot() {
		return imagenCartaCampo2Bot;
	}

	public void setImagenCartaCampo2Bot(JLabel imagenCartaCampo2Bot) {
		this.imagenCartaCampo2Bot = imagenCartaCampo2Bot;
	}

	public void setTablero(JFrame tablero) {
		this.tablero = tablero;
	}

	public void setImagenCarta1Bot(JLabel imagen_carta1Bot) {
		this.imagenCarta1ManoBot = imagen_carta1Bot;
	}

	public JLabel getImagenCarta2Bot() {
		return imagenCarta2ManoBot;
	}

	public JPanel getCarta2CampoBot() {
		return carta2CampoBot;
	}

	public void setCarta2Campo_bot(JPanel carta2Campo_bot) {
		this.carta2CampoBot = carta2Campo_bot;
	}

	public JPanel getCarta3CampoBot() {
		return carta3CampoBot;
	}

	public void setCarta3CampoBot(JPanel carta3CampoBot) {
		this.carta3CampoBot = carta3CampoBot;
	}

	public void setImagen_carta2Bot(JLabel imagen_carta2Bot) {
		this.imagenCarta2ManoBot = imagen_carta2Bot;
	}

	public JPanel getCartaSeleccionada() {
		return cartaSeleccionada;
	}

	public void setCartaSeleccionada(JPanel cartaSeleccionada) {
		this.cartaSeleccionada = cartaSeleccionada;
	}

	public JPanel getCarta1ManoBot() {
		return carta1ManoBot;
	}

	public void setCarta1ManoBot(JPanel carta1_bot) {
		this.carta1ManoBot = carta1_bot;
	}

	public JPanel getCarta2ManoBot() {
		return carta2ManoBot;
	}

	public void setCarta2ManoBot(JPanel carta2_bot) {
		this.carta2ManoBot = carta2_bot;
	}

	public JPanel getCarta3ManoBot() {
		return carta3ManoBot;
	}

	public void setCarta3ManoBot(JPanel carta3_bot) {
		this.carta3ManoBot = carta3_bot;
	}

	public JPanel getCarta4ManoBot() {
		return carta4ManoBot;
	}

	public void setCarta4ManoBot(JPanel carta4_bot) {
		this.carta4ManoBot = carta4_bot;
	}

	public JPanel getCarta5ManoBot() {
		return carta5ManoBot;
	}

	public void setCarta5ManoBot(JPanel carta5_bot) {
		this.carta5ManoBot = carta5_bot;
	}

	public JPanel getCarta1CampoBot() {
		return cartaCampo;
	}

	public JPanel getCarta4CampoBot() {
		return carta4CampoBot;
	}

	public void setCarta4CampoBot(JPanel carta4CampoBot) {
		this.carta4CampoBot = carta4CampoBot;
	}

	public JPanel getCarta5CampoBot() {
		return carta5CampoBot;
	}

	public void setCarta5CampoBot(JPanel carta5CampoBot) {
		this.carta5CampoBot = carta5CampoBot;
	}

	public JPanel getCarta6CampoBot() {
		return carta6CampoBot;
	}

	public void setCarta6CampoBot(JPanel carta6CampoBot) {
		this.carta6CampoBot = carta6CampoBot;
	}

	public void setCarta2CampoBot(JPanel carta2CampoBot) {
		this.carta2CampoBot = carta2CampoBot;
	}

	public void setCarta1CampoBot(JPanel carta1Campo_bot) {
		this.cartaCampo = carta1Campo_bot;
	}

	public JLabel getImagenCartaCampo1Bot() {
		return imagenCartaCampo1Bot;
	}

	public void setImagenCartaCampo1Bot(JLabel imagenCartaCampo1Bot) {
		this.imagenCartaCampo1Bot = imagenCartaCampo1Bot;
	}

	public String getStringCarta4CampoBot() {
		return StringCarta4CampoBot;
	}

	public void setStringCarta4CampoBot(String stringCarta4CampoBot) {
		StringCarta4CampoBot = stringCarta4CampoBot;
	}

	public String getStringCarta5CampoBot() {
		return StringCarta5CampoBot;
	}

	public void setStringCarta5CampoBot(String stringCarta5CampoBot) {
		StringCarta5CampoBot = stringCarta5CampoBot;
	}

	public String getStringCarta6CampoBot() {
		return StringCarta6CampoBot;
	}

	public void setStringCarta6CampoBot(String stringCarta6CampoBot) {
		StringCarta6CampoBot = stringCarta6CampoBot;
	}

	public void mostrar() {
		this.tablero.setVisible(true);
	}

	public HashMap<JPanel, String> getCartasTablero() {
		return cartasTablero;
	}

	public void setCartasTablero(HashMap<JPanel, String> cartasTablero) {
		this.cartasTablero = cartasTablero;
	}

	public JPanel getManoJugador() {
		return manoJugador;
	}

	public JPanel getManoBot() {
		return manoBot;
	}

	public TableroController getTableroController() {
		return tableroController;
	}

	public void setTableroController(TableroController tableroController) {
		this.tableroController = tableroController;
	}

}