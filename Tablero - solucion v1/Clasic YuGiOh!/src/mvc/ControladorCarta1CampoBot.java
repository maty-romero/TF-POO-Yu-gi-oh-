package mvc;

import java.awt.Image;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.net.URL;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class ControladorCarta1CampoBot implements MouseListener {
	private Vista_tablero vista;
	private Modelo modelo;

	public ControladorCarta1CampoBot() {
		vista = new Vista_tablero(this);
		modelo = new Modelo();
		this.vista.mostrar();
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		 if (e.getSource() == vista.getCarta3CampoBot()) {
            System.out.println("3");

			vista.getCartaSeleccionada().removeAll();
			vista.mostrar();
			// vista.getCartaSeleccionada().setVisible(true);
			String StringCarta3CampoBot = this.vista.getStringCarta3CampoBot();
			java.net.URL url_cartaCampo3 = getClass().getResource(StringCarta3CampoBot); 
			ImageIcon iconCampo3_URL = new ImageIcon(
					new ImageIcon(url_cartaCampo3).getImage().getScaledInstance(400, 380, Image.SCALE_DEFAULT));
			JLabel imagenCartaCampo3Bot = new JLabel(iconCampo3_URL);
			vista.getCartaSeleccionada().add(imagenCartaCampo3Bot);
			vista.mostrar();
			vista.getCartaSeleccionada().setVisible(true);
		}
		
	}

	@Override
	public void mousePressed(MouseEvent e) {

	}

	@Override
	public void mouseReleased(MouseEvent e) {

	}

	@Override
	public void mouseEntered(MouseEvent e) {
		if (e.getSource() == vista.getCarta1CampoBot()) {
			System.out.println("1");

			vista.getCartaSeleccionada().removeAll();
			vista.mostrar();
//vista.getCartaSeleccionada().setVisible(true);
			String StringCarta3CampoBot = this.vista.getStringCarta1CampoBot();
			java.net.URL url_cartaCampo3 = getClass().getResource(StringCarta3CampoBot); 
			ImageIcon iconCampo3_URL = new ImageIcon(
					new ImageIcon(url_cartaCampo3).getImage().getScaledInstance(400, 380, Image.SCALE_DEFAULT));
			JLabel imagenCartaCampo3Bot = new JLabel(iconCampo3_URL);
//this.carta3CampoBot.add(imagenCartaCampo3Bot);
			vista.getCartaSeleccionada().add(imagenCartaCampo3Bot);
			vista.mostrar();
			vista.getCartaSeleccionada().setVisible(true);
		} else if (e.getSource() == vista.getCarta2CampoBot()) {
			System.out.println("2");

			vista.getCartaSeleccionada().removeAll();
			vista.mostrar();
			String StringCarta2CampoBot = this.vista.getStringCarta2CampoBot();
			java.net.URL url_cartaCampo2 = getClass().getResource(StringCarta2CampoBot); 
			ImageIcon iconCampo2_URL = new ImageIcon(
					new ImageIcon(url_cartaCampo2).getImage().getScaledInstance(400, 380, Image.SCALE_DEFAULT));
			JLabel imagenCartaCampo2Bot = new JLabel(iconCampo2_URL);
			vista.getCartaSeleccionada().add(imagenCartaCampo2Bot);
			vista.mostrar();
			vista.getCartaSeleccionada().setVisible(true);
		} else if (e.getSource() == vista.getCarta3CampoBot()){
			
			System.out.println("3");

			vista.getCartaSeleccionada().removeAll();
			vista.mostrar();
			String StringCarta3CampoBot = this.vista.getStringCarta3CampoBot();
			java.net.URL url_cartaCampo3 = getClass().getResource(StringCarta3CampoBot);
			ImageIcon iconCampo3_URL = new ImageIcon(
					new ImageIcon(url_cartaCampo3).getImage().getScaledInstance(400, 380, Image.SCALE_DEFAULT));
			JLabel imagenCartaCampo3Bot = new JLabel(iconCampo3_URL);
			vista.getCartaSeleccionada().add(imagenCartaCampo3Bot);
			vista.mostrar();
			vista.getCartaSeleccionada().setVisible(true);
		} else if (e.getSource() == vista.getCarta4CampoBot()) {
               System.out.println("4");
			vista.getCartaSeleccionada().removeAll();
			vista.mostrar();
			// vista.getCartaSeleccionada().setVisible(true);
			String StringCarta4CampoBot = this.vista.getStringCarta4CampoBot();
			java.net.URL url_cartaCampo4 = getClass().getResource(StringCarta4CampoBot); 
			ImageIcon iconCampo4_URL = new ImageIcon(
					new ImageIcon(url_cartaCampo4).getImage().getScaledInstance(400, 380, Image.SCALE_DEFAULT));
			JLabel imagenCartaCampo4Bot = new JLabel(iconCampo4_URL);
			vista.getCartaSeleccionada().add(imagenCartaCampo4Bot);

			System.out.println("hola");
			vista.mostrar();
			vista.getCartaSeleccionada().setVisible(true);
		} else if (e.getSource() == vista.getCarta5CampoBot()) {
            System.out.println("5");
			vista.getCartaSeleccionada().removeAll();
			vista.mostrar();
			// vista.getCartaSeleccionada().setVisible(true);
			String StringCarta5CampoBot = this.vista.getStringCarta5CampoBot();
			java.net.URL url_cartaCampo5 = getClass().getResource(StringCarta5CampoBot); 
			ImageIcon iconCampo5_URL = new ImageIcon(
					new ImageIcon(url_cartaCampo5).getImage().getScaledInstance(400, 380, Image.SCALE_DEFAULT));
			JLabel imagenCartaCampo5Bot = new JLabel(iconCampo5_URL);
			vista.getCartaSeleccionada().add(imagenCartaCampo5Bot);

			System.out.println("hola");
			vista.mostrar();
			vista.getCartaSeleccionada().setVisible(true);
		} else if (e.getSource() == vista.getCarta6CampoBot()) {
            System.out.println("6");

			vista.getCartaSeleccionada().removeAll();
			vista.mostrar();
			// vista.getCartaSeleccionada().setVisible(true);
			String StringCarta6CampoBot = this.vista.getStringCarta6CampoBot();
			java.net.URL url_cartaCampo6 = getClass().getResource(StringCarta6CampoBot); 
			ImageIcon iconCampo6_URL = new ImageIcon(
					new ImageIcon(url_cartaCampo6).getImage().getScaledInstance(400, 380, Image.SCALE_DEFAULT));
			JLabel imagenCartaCampo6Bot = new JLabel(iconCampo6_URL);
			vista.getCartaSeleccionada().add(imagenCartaCampo6Bot);

			System.out.println("hola");
			vista.mostrar();
			vista.getCartaSeleccionada().setVisible(true);
		}

	}

	@Override
	public void mouseExited(MouseEvent e) {

	}

}