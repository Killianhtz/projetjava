package view;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.net.URL;

import javax.imageio.ImageIO;
import javax.swing.JPanel;

import controller.IController;

public class ViewJPanel extends JPanel {
	
	private String[][] map;
	
	private IController controller;
	
	private BufferedImage imagebone;
	private BufferedImage imagehbone;
	private BufferedImage imagevide;
	private BufferedImage imagevbone;
	private BufferedImage imagebourse;
	private BufferedImage imagesortie;
	private BufferedImage imageboule;
	
	
	public ViewJPanel(String[][] map) {
	try {
		
		imagebone = ImageIO.read(new File("..\\model\\src\\main\\java\\model\\sprite\\bone.png"));
		imagehbone = ImageIO.read(new File("..\\model\\src\\main\\java\\model\\sprite\\horizontal_bone.png"));
		imagevide = ImageIO.read(new File("..\\model\\src\\main\\java\\model\\sprite\\void.png"));
		imagevbone = ImageIO.read(new File("..\\model\\src\\main\\java\\model\\sprite\\vertical_bone.png"));
		imagebourse = ImageIO.read(new File("..\\model\\src\\main\\java\\model\\sprite\\purse.png"));
		imagesortie = ImageIO.read(new File("..\\model\\src\\main\\java\\model\\sprite\\gate_open.png"));
		imageboule = ImageIO.read(new File("..\\model\\src\\main\\java\\model\\sprite\\crystal_ball.png"));
		
		this.map = map;
		
	} catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	
	
	
}
	
	protected void paintComponent(Graphics g) {
	super.paintComponent(g);
	
	for (int y = 0; y <= 11; y++) {
        for (int x = 0; x <= 19; x++) {
        	switch(map[y][x])
        	{
        	case "V":
        		g.drawImage(imagevide, 32 * x , 32 * y , 32 , 32 , null);
        		break;
        	case "O":
        		g.drawImage(imagebone, 32 * x , 32 * y , 32 , 32 , null);
        		break;
        	case "P":
        		g.drawImage(imagehbone, 32 * x , 32 * y , 32 , 32 , null);
        		break;
        	case "H":
        		g.drawImage(imagevbone, 32 * x , 32 * y , 32 , 32 , null);
        		break;
        	case "B":
        		g.drawImage(imagebourse, 32 * x , 32 * y , 32 , 32 , null);
        		break;
        	case "S":
        		g.drawImage(imagesortie, 32 * x , 32 * y , 32 , 32 , null);
        		break;
        	case "E":
        		g.drawImage(imageboule, 32 * x , 32 * y , 32 , 32 , null);
        		break;
        	}
        	
        }
    }
	

}
	

}