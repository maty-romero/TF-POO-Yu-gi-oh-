package vista;

import java.awt.Color;
import java.awt.Component;
import java.awt.Image;
import java.awt.RenderingHints;
import java.awt.Shape;
import java.awt.image.BufferedImage;
import java.awt.image.ImageObserver;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;

import javax.imageio.ImageIO;
import javax.print.DocFlavor.URL;
import javax.swing.*;

import controlador.ControladorBatalla;
import controlador.ControladorProyeccionCartas;
import controlador.ManuHechizos;
import controlador.MenuCartaInvocadaMonstruo;
//import controlador.ControladorProyeccionCartas;
import controlador.TableroController;
import modelo.Carta;

import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.GridLayout;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.geom.AffineTransform;
import java.awt.Button;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.SystemColor;

public class VistaTablero implements ImageObserver {
	// Controlador
	private TableroController tableroController;
//tablero
	private JFrame tablero;
	private JPanel manoJugador; // Grid Layout
	private JPanel manoBot; // Grid Layout
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

	private JPanel cartaCampo; // carta1CampoBot
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

	private JPanel deck_jug;
	private JPanel cem_jug;

	private JPanel carta1CampoJug;
	private JPanel carta2CampoJug;
	private JPanel carta3CampoJug;
	private JPanel carta4CampoJug;
	private JPanel carta5CampoJug;
	private JPanel carta6CampoJug;

//Descripcion completa de la carta seleccionada por el jugador

	private JPanel cartaSeleccionada;
	private JLabel imagenDescCarta;
//Contador de vida del bot y Jugador

	private JLabel contadorBot;
	private JLabel contadorJug;
// iconos 

	private JPanel iconoBot;
	private JLabel imagenIconoBot;
	private JPanel iconoJug;
	private JLabel imagenIconoJug;

//Botones 
	private JButton btnTerminarTurno;
	private JButton btnBatalla;
//TextAreas para proyecciones 
	private JTextArea textAreaDescripcion;
	private JTextArea textAreaBot;
	
//genero panel carta boca abajo default
	private Carta cartaDefault;
	private String pathCartaDefault;

// Array de cartas
	private ArrayList<JPanel> panelesMonstruosCampoJugador = new ArrayList<JPanel>();
	private ArrayList<JPanel> panelesHechizosCampoJugador = new ArrayList<JPanel>();
	private ArrayList<JPanel> panelesMonstruosCampoOponente = new ArrayList<JPanel>();
	private ArrayList<JPanel> panelesHechizosCampoOponente = new ArrayList<JPanel>();
	
	public VistaTablero(TableroController tableroController) {
		this.setTableroController(tableroController);
		this.tablero = new JFrame("YUGIOH");
		tablero.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.tablero.setSize(1390, 1004);
		this.tablero.setResizable(false);
		this.generarTablero();
	}

	private void generarTablero() {

		this.pathCartaDefault = "/boca_abajo_default/boca_abajo.jpg";

		// MANO DEL JUGADOR Panel grid layout que tiene adentro paneles con imagenes
		manoJugador = new JPanel();
		manoJugador.setBackground(new Color(102, 51, 102));
		tablero.getContentPane().setLayout(null);
		
		manoJugador.setBounds(97, 700, 730, 100);
		manoJugador.setSize(730, 100);
		tablero.getContentPane().add(manoJugador);

		manoJugador.setLayout(new GridLayout(1, 0, 0, 0));
		manoJugador.setFocusable(true);
		
		// MANO DEL BOT Panel grid layout
		manoBot = new JPanel();
		manoBot.setBounds(148, 6, 730, 100);
		manoBot.setSize(730, 100);
		manoBot.setBackground(new Color(0, 0, 0));
		manoBot.setVisible(true);

		tablero.getContentPane().add(manoBot);
		manoBot.setLayout(new GridLayout(1, 0, 0, 0));
		manoBot.setVisible(true);
		manoBot.setFocusable(true);
		manoBot.requestFocus();
		
		//Boton Siguiente Fase
		btnBatalla = new JButton("Batalla");
		btnBatalla.setFont(new Font("Sitka Subheading", Font.BOLD, 17));
		btnBatalla.setBounds(97, 534, 205, 36);
		tablero.getContentPane().add(btnBatalla);
		//Boton Terminar Turno
		btnTerminarTurno = new JButton("Terminar Turno");
		btnTerminarTurno.setFont(new Font("Sitka Subheading", Font.BOLD, 17));
		btnTerminarTurno.setBounds(97, 592, 205, 36);
		tablero.getContentPane().add(btnTerminarTurno);
		
		
		
		
		// Contador vida jugador
		this.contadorJug = new JLabel();
		this.contadorJug.setText("8000");
		contadorJug.setBounds(1077, 715, 192, 70);
		contadorJug.setFont(new Font("Sitka Subheading", Font.BOLD, 45));
		contadorJug.setForeground(Color.WHITE);
		this.contadorJug.setBackground(new Color(255, 255, 255));
		tablero.getContentPane().add(this.contadorJug);

//contador vida bot
		this.contadorBot = new JLabel("8000");
		contadorBot.setBounds(1084, 25, 200, 57);
		contadorBot.setFont(new Font("Sitka Subheading", Font.BOLD, 45));
		contadorBot.setForeground(Color.WHITE);
		this.contadorBot.setBackground(new Color(0, 0, 153));
		tablero.getContentPane().add(this.contadorBot);

//deck del bot
		this.deck_bot = new JPanel();
		deck_bot.setBounds(21, 6, 80, 100);
		this.deck_bot.setForeground(new Color(204, 0, 0));
		this.deck_bot.setBackground(new Color(0, 0, 0));

		java.net.URL urlDeckBot = getClass().getResource(this.pathCartaDefault); // imagen local relativa
																					// al projecto
		ImageIcon iconDeckBot = new ImageIcon(
				new ImageIcon(urlDeckBot).getImage().getScaledInstance(70, 100, Image.SCALE_DEFAULT));
		this.imagen_DeckBot = new JLabel(iconDeckBot);
		this.deck_bot.add(imagen_DeckBot);

		tablero.getContentPane().add(this.deck_bot);

//cementerio del bot
		this.cem_bot = new JPanel();
		cem_bot.setBounds(21, 135, 80, 96);
		this.cem_bot.setBackground(new Color(0, 0, 0));

		java.net.URL urlCemBot = getClass().getResource(this.pathCartaDefault); // imagen local relativa
																				// al projecto
		ImageIcon IconCemBot = new ImageIcon(
				new ImageIcon(urlCemBot).getImage().getScaledInstance(70, 100, Image.SCALE_DEFAULT));
		this.imagenCemBot = new JLabel(IconCemBot);
		this.cem_bot.add(imagenCemBot);

		tablero.getContentPane().add(this.cem_bot);

//deck del jugador
		this.deck_jug = new JPanel();
		deck_jug.setBounds(853, 522, 87, 121);
		this.deck_jug.setForeground(new Color(153, 0, 0));
		this.deck_jug.setBackground(new Color(0, 0, 0));

		java.net.URL urlDeckJug = getClass().getResource(this.pathCartaDefault); // imagen local relativa
																					// al projecto
		ImageIcon iconDeckJug = new ImageIcon(
				new ImageIcon(urlDeckJug).getImage().getScaledInstance(70, 100, Image.SCALE_DEFAULT));
		JLabel imagen_DeckJug = new JLabel(iconDeckJug);
		this.deck_jug.add(imagen_DeckJug);

		tablero.getContentPane().add(this.deck_jug);

//cementerio del jugador
		this.cem_jug = new JPanel();
		cem_jug.setBounds(853, 700, 87, 100);
		this.cem_jug.setForeground(new Color(0, 0, 0));
		this.cem_jug.setBackground(new Color(0, 0, 0));

		java.net.URL urlCemJug = getClass().getResource(this.pathCartaDefault); // imagen local relativa
																				// al projecto
		ImageIcon iconCemJug = new ImageIcon(
				new ImageIcon(urlCemJug).getImage().getScaledInstance(70, 100, Image.SCALE_DEFAULT));
		JLabel imagenCemJug = new JLabel(iconCemJug);
		this.cem_jug.add(imagenCemJug);

		tablero.getContentPane().add(this.cem_jug);
		
//Proyeccion de Carta		
		this.cartaSeleccionada = new JPanel();
		cartaSeleccionada.setBounds(948, 97, 391, 395);
		this.cartaSeleccionada.setBackground(Color.BLACK);
		tablero.getContentPane().add(this.cartaSeleccionada);
		
		//Proyeccion de Descripcion 
		JPanel descripcionProyeccion = new JPanel();
		descripcionProyeccion.setBackground(Color.DARK_GRAY);
		descripcionProyeccion.setBounds(948, 499, 391, 180);
		tablero.getContentPane().add(descripcionProyeccion);
		descripcionProyeccion.setLayout(null);
		
		JScrollPane scrollPaneDescripcion = new JScrollPane();
		scrollPaneDescripcion.setBounds(10, 11, 371, 158);
		descripcionProyeccion.add(scrollPaneDescripcion);
		
		textAreaDescripcion = new JTextArea();
		textAreaDescripcion.setEditable(false);
		textAreaDescripcion.setFont(new Font("Sitka Subheading", Font.BOLD, 17));
		scrollPaneDescripcion.setViewportView(textAreaDescripcion);
	
//Proyeccion Informacion del Turno del Bot	
		JPanel informeTurnoBot = new JPanel();
		informeTurnoBot.setBackground(new Color(0, 0, 0));
		informeTurnoBot.setBounds(21, 253, 339, 270);
		tablero.getContentPane().add(informeTurnoBot);
		informeTurnoBot.setLayout(null);
		
		JScrollPane scrollPaneBot = new JScrollPane();
		scrollPaneBot.setBounds(10, 11, 319, 248);
		informeTurnoBot.add(scrollPaneBot);
		
		textAreaBot = new JTextArea();
		textAreaBot.setEditable(false);
		textAreaBot.setFont(new Font("Sitka Subheading", Font.BOLD, 17));
		scrollPaneBot.setViewportView(textAreaBot);

//icono del bot
		iconoBot = new JPanel();
		iconoBot.setBounds(948, 6, 87, 80);
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
		iconoJug.setBounds(950, 704, 93, 80);

		java.net.URL urlIconoJug = getClass().getResource("/IconoPersonajes/yugi_moto.jpg"); // imagen local relativa al
																								// projecto
		ImageIcon imagenIconoJug = new ImageIcon(
				new ImageIcon(urlIconoJug).getImage().getScaledInstance(90, 90, Image.SCALE_DEFAULT));
		this.imagenIconoJug = new JLabel(imagenIconoJug);
		iconoJug.add(this.imagenIconoJug);

		tablero.getContentPane().add(iconoJug);

//seteo el fondo de pantalla ( imagen) agregandola al frame.
		this.seteoPanelesCampo();
		java.net.URL fondoTableroURL = getClass().getResource("/fondo_tablero/FondoTablero2.jpg"); // imagen local
		// relativa al
		// projecto
		ImageIcon iconFondoTablero = new ImageIcon(
				new ImageIcon(fondoTableroURL).getImage().getScaledInstance(1400, 1200, Image.SCALE_DEFAULT));

		imagenFondoTablero = new JLabel(iconFondoTablero);
		imagenFondoTablero.setBounds(-108, 0, 1573, 978);
		this.imagenFondoTablero.setBackground(new Color(153, 0, 0));

		this.tablero.getContentPane().add(this.imagenFondoTablero);
	}

	// el parametro de mano no esta de mas ????no, porque la idea es que le a??ada a
	// la mano del bot o del jugador, y el metodo funcione para ambos ahorrando
	// codigo

	public JPanel agregoCartaMano(JLabel labelCarta, JPanel mano) {
		JPanel cartaPanel = new JPanel();
		cartaPanel.setBounds(605, 593, 74, 96);
		cartaPanel.setBackground(new Color(102, 51, 102));
		cartaPanel.addMouseListener(new ControladorProyeccionCartas(tableroController));
		cartaPanel.add(labelCarta);
		cartaPanel.setFocusable(true);
		cartaPanel.requestFocus();
		mano.add(cartaPanel);

		mano.setFocusable(true);
		return cartaPanel;
	}

	public JPanel devuelvoPanelCampo(JLabel labelCarta) {

		JPanel cartaPanel = new JPanel();

		cartaPanel.setBounds(605, 593, 74, 96);
		cartaPanel.setBackground(new Color(153, 0, 0));
		cartaPanel.addMouseListener(new ControladorProyeccionCartas(tableroController));
		cartaPanel.add(labelCarta);
		cartaPanel.setFocusable(true);
		cartaPanel.requestFocus();
		return cartaPanel;

	}

	public void seteoPanelesCampo() {

		JPanel carta1CampoOponente = new JPanel();
		carta1CampoOponente.setBounds(402, 249, 135, 121);
		carta1CampoOponente.setBackground(Color.BLACK);
		tablero.getContentPane().add(carta1CampoOponente);

		JPanel carta2CampoOponente = new JPanel();
		carta2CampoOponente.setBounds(547, 253, 135, 117);
		carta2CampoOponente.setBackground(Color.BLACK);
		tablero.getContentPane().add(carta2CampoOponente);

		JPanel carta3CampoOponente = new JPanel();
		carta3CampoOponente.setBounds(692, 253, 135, 117);
		carta3CampoOponente.setBackground(Color.BLACK);

		tablero.getContentPane().add(carta3CampoOponente);
		this.panelesMonstruosCampoOponente.add(carta1CampoOponente);
		this.panelesMonstruosCampoOponente.add(carta2CampoOponente);
		this.panelesMonstruosCampoOponente.add(carta3CampoOponente);

		JPanel carta4CampoOponente = new JPanel();
		carta4CampoOponente.setBounds(402, 117, 135, 121);
		carta4CampoOponente.setBackground(Color.BLACK);
		tablero.getContentPane().add(carta4CampoOponente);

		JPanel carta5CampoOponente = new JPanel();
		carta5CampoOponente.setBounds(547, 117, 135, 121);
		carta5CampoOponente.setBackground(Color.BLACK);

		tablero.getContentPane().add(carta5CampoOponente);

		JPanel carta6CampoOponente = new JPanel();
		carta6CampoOponente.setBounds(692, 117, 135, 121);
		carta6CampoOponente.setBackground(Color.BLACK);

		tablero.getContentPane().add(carta6CampoOponente);
		this.panelesHechizosCampoOponente.add(carta4CampoOponente);
		this.panelesHechizosCampoOponente.add(carta5CampoOponente);
		this.panelesHechizosCampoOponente.add(carta6CampoOponente);

		/////
		this.carta1CampoJug = new JPanel();
		carta1CampoJug.setBounds(402, 383, 135, 121);
		this.carta1CampoJug.setBackground(Color.BLACK);

		tablero.getContentPane().add(this.carta1CampoJug);

		this.carta2CampoJug = new JPanel();
		carta2CampoJug.setBounds(547, 387, 135, 117);
		this.carta2CampoJug.setBackground(Color.BLACK);

		tablero.getContentPane().add(this.carta2CampoJug);

		this.carta3CampoJug = new JPanel();
		carta3CampoJug.setBounds(692, 387, 135, 117);
		this.carta3CampoJug.setBackground(Color.BLACK);

		tablero.getContentPane().add(this.carta3CampoJug);
		this.panelesMonstruosCampoJugador.add(this.carta1CampoJug);
		this.panelesMonstruosCampoJugador.add(this.carta2CampoJug);
		this.panelesMonstruosCampoJugador.add(this.carta3CampoJug);

		this.carta4CampoJug = new JPanel();
		carta4CampoJug.setBounds(402, 522, 135, 121);
		this.carta4CampoJug.setBackground(Color.BLACK);

		tablero.getContentPane().add(this.carta4CampoJug);

		this.carta5CampoJug = new JPanel();
		this.carta5CampoJug.setBounds(547, 522, 135, 121);
		this.carta5CampoJug.setBackground(Color.BLACK);

		tablero.getContentPane().add(this.carta5CampoJug);

		this.carta6CampoJug = new JPanel();
		carta6CampoJug.setBounds(692, 522, 135, 121);
		this.carta6CampoJug.setBackground(Color.BLACK);

		tablero.getContentPane().add(this.carta6CampoJug);
		this.panelesHechizosCampoJugador.add(this.carta4CampoJug);
		this.panelesHechizosCampoJugador.add(this.carta5CampoJug);
		this.panelesHechizosCampoJugador.add(this.carta6CampoJug);

	}

	public void informarUsuario(String mensaje) {
		
		int TIME_VISIBLE = 3000;
		JOptionPane pane = new JOptionPane(mensaje, JOptionPane.INFORMATION_MESSAGE);
		JDialog dialog = pane.createDialog(null, "Informacion de la Partida");
		dialog.setModal(false);
		dialog.setVisible(true);
		
		new Timer(TIME_VISIBLE, new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				try {
					Thread.sleep(1000);
				} catch (InterruptedException e1) {
					e1.printStackTrace();
				}
				dialog.setVisible(false);
			}
		}).start();
		
	}
	
	
	
	
	public void seteoTextoJugador(String texto) {
		this.contadorJug.setText(texto);
	}

	// Devuelvo la imagen de la carta, gracias a que el objeto carta tiene una ruta
	// de archivo(pathImagen)
	public JLabel generoImagenCarta(Carta carta) {

		JLabel jlabel = new JLabel();
		BufferedImage original = leoImagenCarta(carta);
		original = this.cambioTama??o(original, 155, 90);
		jlabel = new JLabel(new ImageIcon(original));

		return jlabel;
	}

	public BufferedImage leoImagenCarta(Carta carta) {
		BufferedImage original = null;
		try {
			original = ImageIO.read(getClass().getResource(carta.getPathImagen()));
		} catch (IOException e) {
			e.printStackTrace();
		}
		return original;

	}
	
	public BufferedImage leoImagen(String ruta) {
		BufferedImage original = null;
		try {
			original = ImageIO.read(getClass().getResource(ruta));
		} catch (IOException e) {
			e.printStackTrace();
		}
		return original;

	}


	public BufferedImage cambioTama??o(BufferedImage img, int altura, int anchura) {
		Image tmp = img.getScaledInstance(altura, anchura, Image.SCALE_SMOOTH);
		BufferedImage dimg = new BufferedImage(altura, anchura, BufferedImage.TYPE_INT_ARGB);

		Graphics2D g2d = dimg.createGraphics();
		g2d.drawImage(tmp, 0, 0, null);
		g2d.dispose();
		g2d.rotate(190, 10, 20);

		return dimg;
	}

	public BufferedImage rotarImagenGrados(BufferedImage img, double ang) {
		double rads = Math.toRadians(ang);
		double sin = Math.abs(Math.sin(rads)), cos = Math.abs(Math.cos(rads));
		int w = img.getWidth();
		int h = img.getHeight();
		int newAltura = (int) Math.floor(w * cos + h * sin);
		int newAnchura = (int) Math.floor(h * cos + w * sin);

		BufferedImage rotada = new BufferedImage(newAltura, newAnchura, BufferedImage.TYPE_INT_ARGB);
		Graphics2D g2d = rotada.createGraphics();
		AffineTransform at = new AffineTransform();
		at.translate((newAltura - w) / 2, (newAnchura - h) / 2);

		int x = w / 2;
		int y = h / 2;

		at.rotate(rads, x, y);
		g2d.setTransform(at);
		g2d.drawImage(img, 0, 0, this);

		g2d.setColor(Color.RED);
		g2d.drawRect(0, 0, newAltura - 1, newAnchura - 1);
		g2d.dispose();

		return rotada;
	}

	public JPanel generoBocaAbajoDefault() {
		JPanel panel = new JPanel();

		panel = new JPanel();
		panel.setForeground(new Color(153, 0, 0));
		panel.setBackground(new Color(102, 102, 0));
		java.net.URL url = getClass().getResource(this.pathCartaDefault); // imagen local relativa
																			// al projecto
		ImageIcon icon = new ImageIcon(new ImageIcon(url).getImage().getScaledInstance(120, 100, Image.SCALE_DEFAULT));
		JLabel img = new JLabel(icon);
		panel.add(img);
		panel.addMouseListener(new ControladorProyeccionCartas(tableroController));

		tablero.getContentPane().add(panel);

		return panel;
	}
	
	//proyecta texto en el textArea eliminando lo anterior 
	public void mostrarTextoProyeccion(String mensaje) {
		this.getTextArea().setText(mensaje);
	}
	
	//Proyecta texto en el textArea del Bot
	public void informarTurnoBot(String infoTurno) {
		this.getTextAreaBot().setText(infoTurno);
	}
	
	
	
	//Getters y Setters 
	
	public JButton getBtnTerminarTurno() {
		return btnTerminarTurno;
	}

	public JTextArea getTextAreaDescripcion() {
		return textAreaDescripcion;
	}

	public void setTextAreaDescripcion(JTextArea textAreaDescripcion) {
		this.textAreaDescripcion = textAreaDescripcion;
	}

	public JTextArea getTextAreaBot() {
		return textAreaBot;
	}

	public void setTextAreaBot(JTextArea textAreaBot) {
		this.textAreaBot = textAreaBot;
	}

	public void setBtnTerminarTurno(JButton btnTerminarTurno) {
		this.btnTerminarTurno = btnTerminarTurno;
	}

	public JButton getBtnBatalla() {
		return btnBatalla;
	}

	public void setBtnBatalla(JButton btnBatalla) {
		this.btnBatalla = btnBatalla;
	}

	public JTextArea getTextArea() {
		return textAreaDescripcion;
	}

	public void setTextArea(JTextArea textArea) {
		this.textAreaDescripcion = textArea;
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

	public void setManoJugador(JPanel manoJugador) {
		this.manoJugador = manoJugador;
	}

	public void setManoBot(JPanel manoBot) {
		this.manoBot = manoBot;
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

	public ArrayList<JPanel> getPanelesMonstruosCampoJugador() {
		return panelesMonstruosCampoJugador;
	}

	public void setPanelesMonstruosCampoJugador(ArrayList<JPanel> panelesMonstruosCampoJugador) {
		this.panelesMonstruosCampoJugador = panelesMonstruosCampoJugador;
	}

	public ArrayList<JPanel> getPanelesHechizosCampoJugador() {
		return panelesHechizosCampoJugador;
	}

	public void setPanelesHechizosCampoJugador(ArrayList<JPanel> panelesHechizosCampoJugador) {
		this.panelesHechizosCampoJugador = panelesHechizosCampoJugador;
	}

	public ArrayList<JPanel> getPanelesMonstruosCampoOponente() {
		return panelesMonstruosCampoOponente;
	}

	public void setPanelesMonstruosCampoOponente(ArrayList<JPanel> panelesMonstruosCampoOponente) {
		this.panelesMonstruosCampoOponente = panelesMonstruosCampoOponente;
	}

	public ArrayList<JPanel> getPanelesHechizosCampoOponente() {
		return panelesHechizosCampoOponente;
	}

	public void setPanelesHechizosCampoOponente(ArrayList<JPanel> panelesHechizosCampoOponente) {
		this.panelesHechizosCampoOponente = panelesHechizosCampoOponente;
	}

	public JLabel getContadorBot() {
		return contadorBot;
	}

	public void setContadorBot(JLabel contadorBot) {
		this.contadorBot = contadorBot;
	}

	public JLabel getContadorJug() {
		return contadorJug;
	}

	public void setContadorJug(JLabel contadorJug) {
		this.contadorJug = contadorJug;
	}

	public String getPathCartaDefault() {
		return pathCartaDefault;
	}

	@Override
	public boolean imageUpdate(Image img, int infoflags, int x, int y, int width, int height) {
		// TODO Auto-generated method stub
		return false;
	}

	public Carta getCartaDefault() {
		return cartaDefault;
	}

	public void setCartaDefault(Carta cartaDefault) {
		this.cartaDefault = cartaDefault;
	}
}