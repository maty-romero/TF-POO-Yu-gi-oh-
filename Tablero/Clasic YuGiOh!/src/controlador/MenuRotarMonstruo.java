package controlador;

import java.awt.Color;
import java.awt.Component;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

import modelo.Carta;
import modelo.CartaMonstruo;
import vista.VistaTablero;

public class MenuRotarMonstruo implements ActionListener {
	private MenuCartaInvocadaMonstruo mouse;

	public MenuRotarMonstruo(MenuCartaInvocadaMonstruo mouse) {
		this.mouse = mouse;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		mouse.getTc().getReferee().rotarCartaMonstruo(this.mouse.getPanelSeleccionado());
	}
}
