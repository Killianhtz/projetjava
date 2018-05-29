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
	
	private BufferedImage imagebone;
	private BufferedImage imagehbone;
	private BufferedImage imagevide;
	private BufferedImage imagevbone;
	private BufferedImage imagebourse;
	private BufferedImage imagesortie;
	private BufferedImage imageboule;
	
	String map1[][] ={{"V","V","V","V","V","V","O","P","O","P","P","P","P","P","P","P","P","P","O","V"},
			{"V","V","V","O","P","P","O","V","H","V","V","V","V","V","V","V","V","V","O","O"},
			{"V","V","V","H","V","B","V","V","H","V","V","V","V","V","V","V","V","V","V","H"},
			{"O","P","P","O","V","V","V","V","H","V","V","V","V","B","V","V","V","V","V","H"},
			{"H","V","B","V","O","P","P","P","O","P","P","P","P","P","O","V","V","V","V","O"},
			{"H","B","V","V","B","V","V","V","V","V","V","V","E","V","V","V","V","V","V","S"},
			{"H","V","B","V","O","P","P","P","O","P","P","P","P","P","O","V","V","V","V","O"},
			{"O","P","P","O","V","V","V","O","H","V","V","V","V","B","V","V","V","V","V","H"},
			{"V","V","V","H","V","B","V","V","H","V","V","V","V","V","V","V","V","V","V","H"},
			{"V","V","V","O","P","P","O","B","H","V","V","V","V","V","V","V","V","V","V","V"},
			{"V","V","V","V","V","V","H","V","O","V","V","V","V","V","V","V","V","V","O","V"},
			{"V","V","V","V","V","V","O","V","V","V","V","P","P","P","P","P","P","P","O","B"},
			};
	
	public ViewJPanel() {
	try {
		imagebone = ImageIO.read(new File("C:\\Users\\Nicolas\\Desktop\\Nouveau dossier\\sprite\\sprite\\bone.png"));
		imagehbone = ImageIO.read(new File("C:\\Users\\Nicolas\\Desktop\\Nouveau dossier\\sprite\\sprite\\horizontal_bone.png"));
		imagevide = ImageIO.read(new File("C:\\Users\\Nicolas\\Desktop\\Nouveau dossier\\sprite\\sprite\\vide.png"));
		imagevbone = ImageIO.read(new File("C:\\Users\\Nicolas\\Desktop\\Nouveau dossier\\sprite\\sprite\\vertical_bone.png"));
		imagebourse = ImageIO.read(new File("C:\\Users\\Nicolas\\Desktop\\Nouveau dossier\\sprite\\sprite\\purse.png"));
		imagesortie = ImageIO.read(new File("C:\\Users\\Nicolas\\Desktop\\Nouveau dossier\\sprite\\sprite\\gate_open.png"));
		imageboule = ImageIO.read(new File("C:\\Users\\Nicolas\\Desktop\\Nouveau dossier\\sprite\\sprite\\crystal_ball.png"));
		
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
