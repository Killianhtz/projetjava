package view;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.net.URL;

import javax.imageio.ImageIO;
import javax.swing.JPanel;

public class ViewJPanel extends JPanel {
	
	private BufferedImage image;
	
	public ViewJPanel() {
	try {
		image = ImageIO.read(new File("C:\\Users\\Nicolas\\Desktop\\Nouveau dossier\\sprite\\sprite\\fireball_1.png"));
	} catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	}
	protected void paintComponent(Graphics g) {
	super.paintComponent(g);
	g.drawImage(image, 0, 0,32,32 ,null);
	g.drawImage(image, 32, 0,32,32 ,null);
	}
}
