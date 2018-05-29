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
	private BufferedImage image2;
	private BufferedImage image3;
	
	String map1[][] ={{"V","V","V","V","V","V","O","P","O","P","P","P","P","P","P","P","P","P","O","V"},
			{"V","V","V","O","P","P","O","V","V","V","V","V","V","V","V","V","V","V","O","O"},
			{"V","V","V","V","V","V","V","V","V","V","V","V","V","V","V","V","V","V","V","V"},
			{"V","V","V","V","V","V","V","V","V","V","V","V","V","V","V","V","V","V","V","V"},
			{"V","V","V","V","V","V","V","V","V","V","V","V","V","V","V","V","V","V","V","V"},
			{"V","V","V","V","V","V","V","V","V","V","V","V","V","V","V","V","V","V","V","V"},
			{"V","V","V","V","V","V","V","V","V","V","V","V","V","V","V","V","V","V","V","V"},
			{"V","V","V","V","V","V","V","O","V","V","V","V","V","V","V","V","V","V","V","V"},
			{"V","V","V","V","V","V","V","V","V","V","V","V","V","V","V","V","V","V","V","V"},
			{"V","V","V","V","V","V","V","V","V","V","V","V","V","V","V","V","V","V","V","V"},
			{"V","V","V","V","V","V","V","V","V","V","V","V","V","V","V","V","V","V","V","V"},
			{"V","V","V","V","V","V","V","V","V","V","V","V","V","V","V","V","V","V","V","V"},
			};
	
	public ViewJPanel() {
	try {
		image = ImageIO.read(new File("C:\\Users\\Nicolas\\Desktop\\Nouveau dossier\\sprite\\sprite\\bone.png"));
	} catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	
	try {
		image2 = ImageIO.read(new File("C:\\Users\\Nicolas\\Desktop\\Nouveau dossier\\sprite\\sprite\\horizontal_bone.png"));
	} catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	
	try {
		image3 = ImageIO.read(new File("C:\\Users\\Nicolas\\Desktop\\Nouveau dossier\\sprite\\sprite\\vide.png"));
	} catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	
	
}
	
	protected void paintComponent(Graphics g) {
	super.paintComponent(g);
	
	
	for (int y = 0; y <= 11; y++) {
        for (int x = 0; x <= 19; x++) {
        	switch(map1[y][x])
        	{
        	case "V":
        		g.drawImage(image3, 32 * x , 32 * y , 32 , 32 , null);
        		break;
        	case "O":
        		g.drawImage(image, 32 * x , 32 * y , 32 , 32 , null);
        		break;
        	case "P":
        		g.drawImage(image2, 32 * x , 32 * y , 32 , 32 , null);
        		break;
        	}
        	
        }
    }
	

	}
}
